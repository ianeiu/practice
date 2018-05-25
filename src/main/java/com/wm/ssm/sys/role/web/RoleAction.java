package com.wm.ssm.sys.role.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wm.ssm.common.util.IDUtils;
import com.wm.ssm.sys.role.model.TbSysRole;
import com.wm.ssm.sys.role.service.IRoleService;

@Controller
@RequestMapping("/role")
public class RoleAction {
	
	@Resource
	private IRoleService roleService;
	
	@RequestMapping(value = "/addRole", method = RequestMethod.GET)
	private String searchUserInfoById(@RequestParam(value="roleName",required = true) String roleName,@RequestParam(value="roleDesc",required = true) String roleDesc, Model model) {
		TbSysRole rs = new TbSysRole();
		rs.setId(IDUtils.getUUID());
		rs.setRoleName(roleName);
		rs.setRoleDesc(roleDesc);
		roleService.addRole(rs);
		
		model.addAttribute("role", rs);
		return "addRoleResult";
	}
}
