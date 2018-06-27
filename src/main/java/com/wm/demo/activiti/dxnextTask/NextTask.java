package com.wm.demo.activiti.dxnextTask;

import java.util.List;

import javax.annotation.Resource;

import org.activiti.engine.impl.RepositoryServiceImpl;
import org.activiti.engine.impl.bpmn.behavior.UserTaskActivityBehavior;
import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.PvmActivity;
import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.impl.task.TaskDefinition;
import org.junit.Test;

public class NextTask {
	 @Resource
    private ProcessEngineConfigurationImpl processEngineConfiguration;
	
	 @Test
	public void nextTasks() throws Exception{
		String taskID = "1204";//10804
		String realPass = "0";
        TaskDefinition taskDefinition = getNextTaskInfoByTaskID(taskID,realPass);
        System.out.println("=============流程，下个节点："+taskDefinition.getNameExpression()+"        "+taskDefinition.getKey());
	}
	 
	/**
	* 获取下一个用户任务信息  
    * @param String taskid 任务id    
    * @param String pass 流程变量，控制  "1"/"0"
    * @return 下一个用户任务用户组信息  
    * @throws Exception 
    */  
    private TaskDefinition getNextTaskInfoByTaskID(String taskID,String pass) throws Exception { 

        ProcessDefinitionEntity processDefinitionEntity = null;  
        String id = null;  
        TaskDefinition task = null;  
        
        //获取流程实例Id信息   
        String processInstanceId = processEngineConfiguration.buildProcessEngine().getTaskService().createTaskQuery().taskId(taskID).singleResult().getProcessInstanceId();  

        //获取流程发布Id信息   
        String definitionId = processEngineConfiguration.buildProcessEngine().getRuntimeService().createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult().getProcessDefinitionId();  

        processDefinitionEntity = (ProcessDefinitionEntity) ((RepositoryServiceImpl) processEngineConfiguration.buildProcessEngine().getRepositoryService())  
                .getDeployedProcessDefinition(definitionId);  

        ExecutionEntity execution = (ExecutionEntity) processEngineConfiguration.buildProcessEngine().getRuntimeService().createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();  

        //当前流程节点Id信息   
        String activitiId = execution.getActivityId();    

        //获取流程所有节点信息   
        List<ActivityImpl> activitiList = processDefinitionEntity.getActivities();   

        //遍历所有节点信息   
        for(ActivityImpl activityImpl : activitiList){    
//     	   System.out.println(activityImpl);//任务id:task_def_key
            id = activityImpl.getId();     
            if (activitiId.equals(id)) {
                //获取下一个节点信息   
                task = nextTaskDefinition(activityImpl, activityImpl.getId(), pass, processInstanceId); 
                break;
            }
        }  
        return task;  
    } 
    
    /**  
     * 下一个任务节点信息,  
     * 如果下一个节点为用户任务则直接返回,  
     * 如果下一个节点为排他网关, 获取排他网关Id信息, 根据排他网关Id信息和execution获取流程实例排他网关Id为key的变量值,  
     * 根据变量值分别执行排他网关后线路中的el表达式, 并找到el表达式通过的线路后的用户任务
     * @param ActivityImpl activityImpl     流程节点信息  
     * @param String activityId             当前流程节点Id信息  
     * @param String elString               排他网关顺序流线段判断条件
     * @param String processInstanceId      流程实例Id信息  
     * @return  
     */    
    private TaskDefinition nextTaskDefinition(ActivityImpl activityImpl, String activityId, String elString, String processInstanceId){  
        PvmActivity ac = null;
        String s = null;

        // 如果遍历节点为用户任务并且节点不是当前节点信息
        if ("userTask".equals(activityImpl.getProperty("type")) && !activityId.equals(activityImpl.getId())) {
            // 获取该节点下一个节点信息
            TaskDefinition taskDefinition = ((UserTaskActivityBehavior) activityImpl.getActivityBehavior())
                    .getTaskDefinition();
            return taskDefinition;
        } else {
            // 获取节点所有流向线路信息
            List<PvmTransition> outTransitions = activityImpl.getOutgoingTransitions();
            List<PvmTransition> outTransitionsTemp = null;
            for (PvmTransition tr : outTransitions) {
         	  
                ac = tr.getDestination(); // 获取线路的终点节点
                // 如果流向线路为排他网关
                if ("exclusiveGateway".equals(ac.getProperty("type"))) {
             	   
                    outTransitionsTemp = ac.getOutgoingTransitions();
                   
                    // 如果排他网关只有一条线路信息
                    if (outTransitionsTemp.size() == 1) {
                        return nextTaskDefinition((ActivityImpl) outTransitionsTemp.get(0).getDestination(), activityId,elString, processInstanceId);
                    } else if (outTransitionsTemp.size() > 1) { // 如果排他网关有多条线路信息
                        for (PvmTransition tr1 : outTransitionsTemp) {
                            s = (String) tr1.getProperty("conditionText"); // 获取排他网关线路判断条件信息
                            s = s.substring(9,10);
                            if(elString.equals(s)){
                         	   PvmActivity pv = tr1.getDestination();
                         	   return ((UserTaskActivityBehavior) ((ActivityImpl) pv).getActivityBehavior()).getTaskDefinition();
                            }
                        }
                    }
                } else if ("userTask".equals(ac.getProperty("type"))) {
                    return ((UserTaskActivityBehavior) ((ActivityImpl) ac).getActivityBehavior()).getTaskDefinition();
                } else {
             	   //流程结束
             	   return null;
                }
            }
            return null;
        }
    }

}
