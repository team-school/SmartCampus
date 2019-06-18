/**
 * 
 */
package com.briup.apps.poll1.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll1.Service.IQuestionnaireService;
import com.briup.apps.poll1.bean.Questionnaire;
import com.briup.apps.poll1.bean.extend.QuestionnaireVM;
import com.briup.apps.poll1.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 @author： fu    @time：2018年6月28日 下午5:27:54 
 @说明： 一份耕耘，一份收获
**/
@Api(description="问卷相关接口(OK)")
@RestController
@RequestMapping("/questionnaire")
public class QuestionnaireVMController {
	@Autowired
	private IQuestionnaireService questionnaireService;

	
	@ApiOperation(value="保存或修改问卷信息")
	@PostMapping("/savaOrUpdateQuestinnaire")
	public MsgResponse  savaOrUpdateQuestinnaire(Questionnaire questionnaire,long[] questionIds){
		try {
			questionnaireService.saveOrUpdate(questionnaire, questionIds);
			return MsgResponse.success("success", questionnaire);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	
		
	}
	
	
	
@ApiOperation(value="查询相关问卷")
@GetMapping("findAllQuestionnaire")
public MsgResponse findAllQuestionnaire(){
	try {
		List<Questionnaire> list=questionnaireService.findAll();
		return MsgResponse.success("success",list);
	} catch (Exception e) {
		e.printStackTrace();
		return MsgResponse.error(e.getMessage());
	}
	
}
@ApiOperation(value="通过问卷Id查找问卷")
@GetMapping("findQuestionnaireVMById")
public MsgResponse findQuestionnaireVMById(long id){
	try {
		QuestionnaireVM qvm=questionnaireService.findById(id);
		return MsgResponse.success("success",qvm);
	} catch (Exception e) {
		return MsgResponse.error(e.getMessage());
	}
	
}
@ApiOperation(value="通过问卷Id删除问卷",notes="级联删除问卷和问题的关系")
@GetMapping("deleteQuestionnaireById")
public MsgResponse deleteQuestionnaireById(long id){
	try {
		questionnaireService.deleteById(id);
		return MsgResponse.success("删除成功",null);
	} catch (Exception e) {
		return MsgResponse.error(e.getMessage());
	}
	
}
}
