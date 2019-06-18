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

import com.briup.apps.poll1.Service.ICourseService;
import com.briup.apps.poll1.bean.Course;
import com.briup.apps.poll1.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author： fu @time：2018年6月25日 下午2:45:17 @说明： 一份耕耘，一份收获
 **/
@RestController
@RequestMapping("/course")
@Api(description="课程相关接口(ok)")
public class CourseController {
	@Autowired
	private ICourseService courseService;

	// 批量删除
	@ApiOperation("批量删除课程信息")
	@PostMapping("batchDelete")
	public MsgResponse batchDelete(long[] ids) {
		try {
			List<Long> idList = new ArrayList<>();
			for (Long id : ids) {
				idList.add(id);
			}
			courseService.batchDelete(idList);
			return MsgResponse.success("批量删除成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	// 全部查询
	@GetMapping("findAllCourse")
	@ApiOperation("查看全部课程信息")
	public MsgResponse findAllCourse() {
		List<Course> list;
		try {
			list = courseService.findAll();
			return MsgResponse.success("查询成功", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	// 关键字查询
	@ApiOperation("根据关键字查看课程信息")
	@GetMapping("/queryByKeyWords")
	public MsgResponse query(String keywords) {
		try {
			List<Course> list = courseService.query(keywords);
			return MsgResponse.success("成功", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	@ApiOperation("修改课程信息")
	@GetMapping("/update")
	public MsgResponse update(Course course) {
		try {
			courseService.update(course);
			return MsgResponse.success("成功", null);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
		
	}

}
