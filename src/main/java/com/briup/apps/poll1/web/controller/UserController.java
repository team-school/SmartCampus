package com.briup.apps.poll1.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll1.Service.IUserService;
import com.briup.apps.poll1.bean.User;
import com.briup.apps.poll1.bean.extend.UserVM;
import com.briup.apps.poll1.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="用户相关接口(OK)")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private  IUserService userService;
	
	@ApiOperation("查询所有的用户信息")
	@GetMapping("findAllUser")
	public MsgResponse findAllUser(){
		List<User> list;
		try{
			list=userService.findAll();
			return MsgResponse.success("查询成功", list);
		}catch(Exception e){
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="查询所有的班级信息",notes="每个班级信息中包含班级所属年级和班级所属的班主任的信息")
	@GetMapping("findAllUserVM")
	public MsgResponse findAllUserVM(){
		try{
			List<UserVM> list=userService.findAllUserVM();
			return MsgResponse.success("查询成功", list);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}		
	}
	
	@ApiOperation(value="保存或更新课程信息",
			notes="如果参数中包含了id,说明这是一个更新操作。如果参数中没有包含id，说明这是一个保存操作")
	@PostMapping("saveOrUpdateUser")
	public MsgResponse saveOrUpdateUser(User user){
		try{
			if(user!=null&&user.getId()!=null){
				userService.update(user);
			}else{
				userService.save(user);
			}
			return MsgResponse.success("保存或更新成功", null);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());	
		}	
	}
	
	@ApiOperation("批量删除用户信息")
	@PostMapping("batchDelete")
	public MsgResponse batachDelete(long[] ids){
		try{
			List<Long> idList=new ArrayList<>();
			for(long id:ids){
				idList.add(id);
			}
			userService.batchDelete(idList);
			return MsgResponse.success("批量删除成功", null);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}
