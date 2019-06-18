package com.briup.apps.poll1.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll1.Service.ISchoolService;
import com.briup.apps.poll1.bean.School;
import com.briup.apps.poll1.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="学校相关接口(OK)")
@RestController
@RequestMapping("/school")
public class SchoolController {

	@Autowired
	private ISchoolService schoolService;
	
	@ApiOperation(value="查询出所有的学校信息")
	@GetMapping("findAllSchool")
	public MsgResponse findAllSchool(){
		try {
			List<School> list = schoolService.findAll();
			return MsgResponse.success("查询成功", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="通过id删除学校信息")
	@PostMapping("deleteSchoolById")
	public MsgResponse deleteSchoolById(@RequestParam Long id){
		try {
			schoolService.deleteById(id);
			return MsgResponse.success("success", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="添加或修改学校信息",notes="如果学校id不为空，表示更新操作;如果id为空，表示保存操作")
	@PostMapping("saveOrUpdateSchool")
	public MsgResponse saveOrUpdateSchool(School school){
		try {
			if(school!=null&&school.getId()!=null){
				schoolService.update(school);
			}else{
				schoolService.save(school);
			}
			return MsgResponse.success("success", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

}
