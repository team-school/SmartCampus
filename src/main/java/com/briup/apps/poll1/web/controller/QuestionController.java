/**
 * 
 */
package com.briup.apps.poll1.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll1.Service.IQuestionService;
import com.briup.apps.poll1.bean.Question;
import com.briup.apps.poll1.bean.extend.QuestionVM;
import com.briup.apps.poll1.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author： wangying @time：2018年6月25日 下午2:45:17 @说明： 一份耕耘，一份收获
 **/
@Api(description = "题目模块相关接口(OK)")
@RestController
@RequestMapping("/question")
public class QuestionController {
	@Autowired
	private IQuestionService iQuestionService;

	@GetMapping("findAllQuestionVM")
	@ApiOperation(value = "查询所有的信息", notes = "每个题目信息下包含该题目")
	public MsgResponse findAllQuestionVM() {
		List<QuestionVM> list;
		try {
			list = iQuestionService.findAllQuestionVM();
			return MsgResponse.success("查询成功", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	// 批量删除
		@ApiOperation("批量删除课程question信息")
		@PostMapping("batchDelete")
		public MsgResponse batchDelete(long[] ids) {
			try {
				List<Long> idList = new ArrayList<>();
				for (Long id : ids) {
					idList.add(id);
				}
				iQuestionService.batchDelete(idList);
				return MsgResponse.success("批量删除成功", null);
			} catch (Exception e) {
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
		}
		
		
		// 关键字查询
		@ApiOperation("根据关键字查看question信息")
		@GetMapping("/queryByKeyWords")
		public MsgResponse query(String keywords) {
			try {
				List<Question> list = iQuestionService.query(keywords);
				return MsgResponse.success("成功", list);
			} catch (Exception e) {
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
		}
	@ApiOperation(value = "保存或修改题目信息", notes = "如果题目id不为空表示更新操作，如果题目id为空表示插入操作，保存或者更新题目的时候级联保存或者更新选项")
	@PostMapping("/saveOrUpdateQuestion")
	public MsgResponse saveOrUpdateQuestion(QuestionVM question) {
		try {
			iQuestionService.saveOrUpdate(question);
			return MsgResponse.success("success", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}

	}
	@ApiOperation(value = "通过问题ID删除题目信息", notes = "删除问题的同时删除选项")
	@GetMapping("/deleteQuestionById")
	public MsgResponse deleteQuestionById(Long	id) {
		try {
			iQuestionService.deleteById(id);
			return MsgResponse.success("删除成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}

	}
}
