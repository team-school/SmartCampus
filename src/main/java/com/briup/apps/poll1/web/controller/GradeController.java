package com.briup.apps.poll1.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll1.Service.IGradeService;
import com.briup.apps.poll1.bean.Grade;
import com.briup.apps.poll1.bean.extend.GradeVM;
import com.briup.apps.poll1.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(description = "年级相关接口(OK)")
@RestController
@RequestMapping("/grade")
public class GradeController {
	/**
	 * @return
	 */
	@Autowired
	private IGradeService gradeService;
	
	@ApiOperation(value="查询所有年级")
	@GetMapping("findAllGrade")
	public MsgResponse findAllGrade(){
		try {
			List<Grade> list = gradeService.findAll();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="查询所有年级",notes="每个年级信息中包含所属学校的信息")
	@GetMapping("findAllGradeVM")
	public MsgResponse findAllGradeVM(){
		try {
			List<GradeVM> list = gradeService.findAllGradeVM();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="按关键字查询年级信息",notes="如果年级id不为空，表示更新操作;如果年级id为空，表示保存操作")
	@GetMapping("queryGrade")
	public MsgResponse queryGrade(String keywords){
		try {
			List<Grade> list=gradeService.query(keywords);
			return MsgResponse.success("success", list);
		} catch (Exception e) {		
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}	
	}
	
	@ApiOperation(value="保存或更新年级信息",notes="参数中id不为空表示插入，否则表示更新")
	@PostMapping(value="saveOrUpdate")
	public MsgResponse saveOrUpdate(@ModelAttribute Grade grade) {
		try {
			gradeService.saveOrUpdate(grade);
			return MsgResponse.success("保存或更新成功", null);
		} catch (Exception e) {
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="通过ID删除年级")
	@GetMapping("deleteByIdGrade")
	public MsgResponse deleteByIdGrade(long id){
		try {
			gradeService.deleteById(id);
			return MsgResponse.success("success", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}			
	}
	
	@ApiOperation(value="批量删除")
	@GetMapping("batchDeleteGrade")
	public MsgResponse batchDeleteGrade(long[] ids){
		try {
			gradeService.batchDelete(ids);
			return MsgResponse.success("success", null);
		} catch (Exception e) {			
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}			
	}
	
}