package com.briup.apps.poll1.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll1.Service.IAnswersService;
import com.briup.apps.poll1.bean.Answers;
import com.briup.apps.poll1.bean.extend.AnswersVM;
import com.briup.apps.poll1.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "学生答卷相关接口(ok)")
@RestController
@RequestMapping("/answers")
public class AnswersController {
	@Autowired
	private IAnswersService answersService;

	@ApiOperation(value = "提交答卷，每个学生提交一份")
	@PostMapping("submitAnswer")
	public MsgResponse submitAnwer(Answers answers) {
		try {

			// 判断用户是否具有答卷的权限（是否提交过）

			// 保存答卷信息
			answersService.saveorUpdate(answers);
			return MsgResponse.success("提交成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}

	}

	@ApiOperation(value = "查询答卷", notes = "答卷对应的课调信息")
	@GetMapping("findAllAnswersVM")
	public MsgResponse findAllAnswersVM() {
		try {
			List<AnswersVM> list = answersService.findAllAnswersVM();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	/*
	@ApiOperation(value = "查询答卷")
	@GetMapping("findAllAnswers")
	public MsgResponse findAllAnswers() {
		try {
			List<Answers> list = answersService.findAll();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@ApiOperation("根据关键字查询答卷")
	@GetMapping("queryAnswers")
	public MsgResponse queryAnswers(String keywords) {
		try {
			List<Answers> list = answersService.query(keywords);
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@ApiOperation("删除答卷")
	@GetMapping("deleteAnswers")
	public MsgResponse deleteAnswers(long id) {
		try {
			answersService.delete(id);
			return MsgResponse.success("success", id);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@ApiOperation("批量删除答卷")
	@GetMapping("batchDelete")
	public MsgResponse batchDelete(long[] ids) {
		try {
			List<Long> idList = new ArrayList<>();
			for (Long id : ids) {
				idList.add(id);
				answersService.delete(id);
			}
			return MsgResponse.success("删除成功", ids);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}*/
}
