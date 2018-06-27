package com.wm.demo.activiti.dxjumpTask;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.impl.ManagementServiceImpl;
import org.activiti.engine.impl.TaskServiceImpl;
import org.activiti.engine.impl.pvm.ReadOnlyProcessDefinition;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.junit.Test;

public class JumpProcessTest {

	 ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
	 //ProcessEngine processEngine = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml").buildProcessEngine();

	@Test
	public void jumpFun1() {
		Map<String, Object> vars = new HashMap<String, Object>();
		String[] v = { "shareniu1", "shareniu2", "shareniu3", "shareniu4" };
		vars.put("assigneeList", Arrays.asList(v));
		// 分享牛原创(尊重原创 转载对的时候第一行请注明，转载出处来自分享牛http://blog.csdn.net/qq_30739519)
		RepositoryService repositoryService = processEngine.getRepositoryService();
		ReadOnlyProcessDefinition processDefinitionEntity = (ReadOnlyProcessDefinition) repositoryService
				.getProcessDefinition("daling:1:12504");
		// 目标节点
		ActivityImpl destinationActivity = (ActivityImpl) processDefinitionEntity.findActivity("usertask5");
		// 当前节点
		ActivityImpl currentActivity = (ActivityImpl) processDefinitionEntity.findActivity("usertask4");
		final String executionId = "12601";
		
		//processEngine.getManagementService().executeCommand(new JDJumpTaskCmd(executionId, destinationActivity, vars, currentActivity);
	}

	@Test
	public void jumpFun2() {
		Map<String, Object> vars = new HashMap<String, Object>();
		String[] v = { "shareniu1", "shareniu2", "shareniu3", "shareniu4" };
		vars.put("assigneeList", Arrays.asList(v));
		// 分享牛原创(尊重原创 转载对的时候第一行请注明，转载出处来自分享牛http://blog.csdn.net/qq_30739519)

		// 目标节点
		RepositoryService repositoryService = processEngine.getRepositoryService();
		ReadOnlyProcessDefinition processDefinitionEntity = (ReadOnlyProcessDefinition) repositoryService
				.getProcessDefinition("daling:1:12504");
		ActivityImpl destinationActivity = (ActivityImpl) processDefinitionEntity.findActivity("usertask4");
		final String executionId = "12601";
		ActivityImpl currentActivity = (ActivityImpl) processDefinitionEntity.findActivity("usertask5");
		
		((TaskServiceImpl) processEngine.getTaskService()).getCommandExecutor().execute(new JDJumpTaskCmd(executionId, destinationActivity, vars, currentActivity));
		//((RuntimeServiceImpl) processEngine.getRuntimeService()).getCommandExecutor().execute(new JDJumpTaskCmd(executionId, destinationActivity, vars, currentActivity));
	}
	
}
