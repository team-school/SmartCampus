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

import com.briup.apps.poll1.Service.IAnswersService;
import com.briup.apps.poll1.Service.ISurveyService;
import com.briup.apps.poll1.bean.Answers;
import com.briup.apps.poll1.bean.Survey;
import com.briup.apps.poll1.bean.extend.SurveyVM;
import com.briup.apps.poll1.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author： fu @time：2018年6月29日 上午8:25:36 @说明： 一份耕耘，一份收获
 **/
@Api(description = "课调相关接口（OK)")
@RestController
@RequestMapping("/survey")
public class SurveyController {

	@Autowired
	private ISurveyService surveyService;
	@Autowired
	private IAnswersService answersService;

	@ApiOperation(value = "去审核课调，求平均分", notes = "返回课调基本信息以及课调中的主观题答案")
	@GetMapping(value = "toCheckSurvey")
	public MsgResponse toCheckSurvey(long id) {
		try {
			// 1. 根据id查询课调信息
			SurveyVM surveyVM = surveyService.findById(id);
			// 2. 根据id查询该课调下所有的答卷
			List<Answers> answers = answersService.findAnswersBySurveyId(id);
			// 3. 根据答卷计算出平均分(单选题)
			double total = 0.0; // 所有学生平均分的总和
			for (Answers answer : answers) {
				// 5|4
				String selectStr = answer.getSelections();
				if (selectStr != null) {
					// arr = ["5","4"]
					String[] arr = selectStr.split("[|]");
					Double singleTotal = 0.0;
					for (String a : arr) {
						int select = Integer.parseInt(a);
						singleTotal += select;
					}
					double singleAverage = singleTotal / arr.length;
					total += singleAverage;
				}
			}
			double average = total / answers.size();
			// 4. 设置平均分
			surveyVM.setAverage(average);
			return MsgResponse.success("success", surveyVM);

		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@ApiOperation(value = "登录课调",notes="code表示课调编号")
	@PostMapping(value = "loginSurvey")
	public MsgResponse loginSurvey(long code) {
		try {
			// 通过ID查询课调信息
			SurveyVM surveyVM = surveyService.findById(code);
			// 1.判断课调是否还在进行

			if (surveyVM.getStatus().equals(Survey.STATUS_BEIGN)) {
				// 判断用户是否已经完成答辩操作（暂时不做)
				return MsgResponse.success("success", surveyVM);
			} else {
				return MsgResponse.error("课调状态不合法" + surveyVM.getStatus());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@ApiOperation(value = "通过状态查询课调")
	@PostMapping(value = "finSurveyByStatus")
	public MsgResponse finSurveyByStatus(String status) {
		try {
			List<SurveyVM> list = surveyService.findByStatus(status);
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@ApiOperation(value = "审核课调", notes = "id表示课调编号,status表示审核状态,0审核不通过,1审核通过")
	@GetMapping(value = "checkSurvey")
	public MsgResponse checkSurvey(long id, int status) {
		try {
			// 通过id查询课调
			Survey survey = surveyService.findSurveyById(id);
			String message = "";
			// 如果当前课调属于未审核状态，才可以对其进行审核
			if (survey.getStatus().equals(Survey.STATUS_NO_CHECK)) {
				if (status == 0) {
					message = "审核不通过";
					survey.setStatus(Survey.STATUS_CHECK_NOPASS);
				} else {
					message = "审核通过";
					survey.setStatus(Survey.STATUS_CHECK_PASS);
				}
				
				
			} else {
				message = "课调状态不合法！";
			}
			if (survey.getStatus().equals(Survey.STATUS_CHECK_PASS)) {
				if (status == 0) {
					message = "审核不通过";
					survey.setStatus(Survey.STATUS_CHECK_NOPASS);
				}
			}else {
				message = "课调状态不合法！";
			}
			if (survey.getStatus().equals(Survey.STATUS_CHECK_NOPASS)) {
				if (status == 1) {
					message = "审核通过";
					survey.setStatus(Survey.STATUS_CHECK_PASS);
				}
			}else {
				message = "课调状态不合法！";
			}
			surveyService.saveOrUpdate(survey);
			return MsgResponse.success(message, null);

		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}


	@ApiOperation(value = "关闭课调")
	@PostMapping(value = "stopSurvey")
	public MsgResponse stopSurvey(long id) {
		try {
			// 通过Id查询出课调信息
			Survey survey = surveyService.findSurveyById(id);
			// 当课调状态为未开启的时候，才能开启一个课调
			if (survey.getStatus().equals(Survey.STATUS_BEIGN)) {

				survey.setStatus(Survey.STATUS_NO_CHECK);
				survey.setCode("");
				surveyService.saveOrUpdate(survey);
				return MsgResponse.success("关闭成功", null);
			} else {
				return MsgResponse.error("课调状态不合法" + survey.getStatus());
			}
			// 修改课调对象
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@ApiOperation(value = "开启课调")
	@PostMapping(value = "startSurvey")
	public MsgResponse startSurvey(long id) {
		try {
			// 通过Id查询出课调信息
			Survey survey = surveyService.findSurveyById(id);
			// 修改课调对象
			survey.setStatus(Survey.STATUS_BEIGN);
			String code = survey.getId().toString();
			survey.setCode(code);
			surveyService.saveOrUpdate(survey);

			return MsgResponse.success("开启成功", null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@ApiOperation(value = "保存或更新课调", notes = "只需要输入courseId,userId,clazzId,quesitionnaireId")
	@PostMapping(value = "saveOrUpdateSurvey")
	public MsgResponse saveOrUpdateSurvey(Survey survey) {
		try {
			surveyService.saveOrUpdate(survey);
			return MsgResponse.success("保存或修改成功", null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@ApiOperation(value = "查询所有课调", notes = "级联查询出课调关联的课程，班级，讲师，问卷")
	@GetMapping(value = "findAllSurveyVM")
	public MsgResponse findAllSurveyVM() {
		try {
			List<SurveyVM> list = surveyService.findAll();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@ApiOperation(value = "通过Id查询课调", notes = "只需要输入courseId,userId,clazzId,quesitionnaireId")
	@GetMapping(value = "findSurveyById")
	public MsgResponse findSurveyById(long id) {
		try {
			SurveyVM surveyvm = surveyService.findById(id);
			return MsgResponse.success("success", surveyvm);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
}
