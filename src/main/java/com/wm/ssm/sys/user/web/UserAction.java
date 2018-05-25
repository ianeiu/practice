package com.wm.ssm.sys.user.web;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wm.ssm.common.vo.Result;
import com.wm.ssm.sys.user.model.TbSysUser;
import com.wm.ssm.sys.user.service.IUserService;
import com.wm.ssm.sys.user.vo.UserVO;

@Controller
@RequestMapping("/user")
public class UserAction {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource
	private IUserService userService;


	@RequestMapping(value = "/searchUserVOById/{userId}", method = RequestMethod.GET)
	private String searchUserVOById(@PathVariable("userId") String userId, Model model) {
		UserVO user = userService.searchUserVOById(userId);
		if(user==null){
			return "forward:/user/searchUserList";
		}
		logger.info("searchUserInfoById:"+user.getUserName()+"---"+user.getRole().getRoleName());
		model.addAttribute("user", user);
		return "userVO";
	}
	
	@RequestMapping(value = "/searchUserInfoById/{userId}", method = RequestMethod.GET)
	private String searchUserInfoById(@PathVariable("userId") String userId, Model model) {
		if (userId == null) {
			return "redirect:/user/searchUserList";
		}
		TbSysUser user = userService.getById(userId);
		if (user == null) {
			return "forward:/user/searchUserList";
		}
		logger.info("searchUserInfoById:"+user.getUserName());
		model.addAttribute("user", user);
		return "userDetail";
	}
	
	@RequestMapping(value = "/searchUserList", method = RequestMethod.GET)
	private String searchUserList(Model model) {
		List<TbSysUser> list = userService.getList();
		model.addAttribute("list", list);
		// list.jsp + model = ModelAndView
		return "userList";// WEB-INF/jsp/"list".jsp
	}


	// ajax json
	@RequestMapping(value = "/updateUserStatus/{id}", method = RequestMethod.POST, produces = {
			"application/json; charset=utf-8" })
	@ResponseBody
	private Result<TbSysUser> updateUserStatus(@PathVariable("id") String id, @RequestParam(value="userId",required = false) String userId) {
		if (id == null || "".equals(id)) {
			return new Result<>("1001", "用户名不得为空");
		}
		userService.updateUserStatus(id);
		TbSysUser user = userService.getById(id);
		return new Result<TbSysUser>("0", "查询成功",user);
	}
}
