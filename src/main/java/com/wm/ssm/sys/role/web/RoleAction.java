package com.wm.ssm.sys.role.web;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wm.ssm.common.vo.ResultVO;
import com.wm.ssm.sys.role.model.TbSysRole;
import com.wm.ssm.sys.role.service.IRoleService;

@RestController
@RequestMapping("/role")
public class RoleAction {
	
	@Resource
	private IRoleService roleService;
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	private ResultVO<String> searchUserInfoById(@RequestParam String roleName,@RequestParam(value="roleDesc",required = false) String roleDesc){
		TbSysRole rs = new TbSysRole();
		rs.setId("123132");
		rs.setRoleName(roleName);
		rs.setRoleDesc(roleDesc);
		roleService.addRole(rs);
		return ResultVO.createBySuccess();
	}
}
