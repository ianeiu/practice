package com.wm.activiti.d1;

import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

public class CProcessInstance {
	ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
	
	/**查询当前人的个人任务*/
	@Test
	public void findMyPersonalTask(){
		String assignee = "张三";
		List<Task> list = processEngine.getTaskService()//与正在执行的任务管理相关的Service
						.createTaskQuery()//创建任务查询对象
						/**查询条件（where部分）*/
						.taskAssignee(assignee)//指定个人任务查询，指定办理人
//						.taskCandidateUser(candidateUser)//组任务的办理人查询
//						.processDefinitionId(processDefinitionId)//使用流程定义ID查询
//						.processInstanceId(processInstanceId)//使用流程实例ID查询
//						.executionId(executionId)//使用执行对象ID查询
						/**排序*/
						.orderByTaskCreateTime().asc()//使用创建时间的升序排列
						/**返回结果集*/
//						.singleResult()//返回惟一结果集
//						.count()//返回结果集的数量
//						.listPage(firstResult, maxResults);//分页查询
						.list();//返回列表
		if(list!=null && list.size()>0){
			for(Task task:list){
				System.out.println("任务ID:"+task.getId());//104
				System.out.println("任务名称:"+task.getName());//提交申请
				System.out.println("任务的创建时间:"+task.getCreateTime());
				System.out.println("任务的办理人:"+task.getAssignee());//张三
				System.out.println("流程实例ID："+task.getProcessInstanceId());//101
				System.out.println("执行对象ID:"+task.getExecutionId());//101
				System.out.println("流程定义ID:"+task.getProcessDefinitionId());//helloworld:1:4
				System.out.println("########################################################");
			}
		}
	}
	
	/**完成我的任务*/
	@Test
	public void completeMyPersonalTask(){
		//任务ID
		String taskId = "104";
		processEngine.getTaskService()//与正在执行的任务管理相关的Service
					.complete(taskId);
		System.out.println("完成任务：任务ID："+taskId);
	}
	
	/**查询流程状态（判断流程正在执行，还是结束）*/
	@Test
	public void isProcessEnd(){
		String processInstanceId = "101";
		ProcessInstance pi = processEngine.getRuntimeService()//表示正在执行的流程实例和执行对象
						.createProcessInstanceQuery()//创建流程实例查询
						.processInstanceId(processInstanceId)//使用流程实例ID查询
						.singleResult();
		if(pi==null){
			System.out.println("流程已经结束");
		}
		else{
			System.out.println("流程没有结束");
		}
	}
	
	/**查询历史任务（后面讲）*/
	@Test
	public void findHistoryTask(){
		String taskAssignee = "张三";
		List<HistoricTaskInstance> list = processEngine.getHistoryService()//与历史数据（历史表）相关的Service
						.createHistoricTaskInstanceQuery()//创建历史任务实例查询
						//.processInstanceId("601")
						.taskAssignee(taskAssignee)//指定历史任务的办理人
						.list();
		if(list!=null && list.size()>0){
			for(HistoricTaskInstance hti:list){
				System.out.println(hti.getId()+"    "+hti.getName()+"    "+hti.getProcessInstanceId()+"   "+hti.getStartTime()+"   "+hti.getEndTime()+"   "+hti.getDurationInMillis());
				System.out.println("################################");
			}
		}
	}
	
	/**查询历史流程实例（后面讲）*/
	@Test
	public void findHistoryProcessInstance(){
		String processInstanceId = "101";
		HistoricProcessInstance hpi = processEngine.getHistoryService()//与历史数据（历史表）相关的Service
						.createHistoricProcessInstanceQuery()//创建历史流程实例查询
						.processInstanceId(processInstanceId)//使用流程实例ID查询
						.singleResult();
		System.out.println(hpi.getId()+"    "+hpi.getProcessDefinitionId()+"    "+hpi.getStartTime()+"    "+hpi.getEndTime()+"     "+hpi.getDurationInMillis());
	}
}
