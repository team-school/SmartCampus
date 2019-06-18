/**
 * 
 */
package com.briup.apps.poll1.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll1.Service.ICourseService;
import com.briup.apps.poll1.bean.Course;
import com.briup.apps.poll1.bean.CourseExample;
import com.briup.apps.poll1.dao.CourseMapper;

/**
 @author： fu    @time：2018年6月25日 下午3:48:11 
 @说明： 一份耕耘，一份收获
**/
@Service
public class CourseServiceImpl implements ICourseService {
	@Autowired
	private CourseMapper courseMapper;
	@Override
	public List<Course> findAll() throws Exception {
		//创建空模板
		CourseExample example=new CourseExample();
	//调用QBE查询，并且将查询结果返回
		return courseMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public List<Course> query(String keywords) throws Exception {
		CourseExample example=new CourseExample();
		//创建一个模板
		example.createCriteria().andNameLike("%"+keywords+"%");
		return courseMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public void save(Course course) throws Exception {
		courseMapper.insert(course);
	}

	@Override
	public void update(Course course) throws Exception {
		courseMapper.updateByPrimaryKey(course);
	}

	@Override
	public void deleteById(Long id) throws Exception {
		courseMapper.deleteByPrimaryKey(id);
	}

	//批量删除
	@Override
	public void batchDelete(List<Long> ids) throws Exception {
		for (Long id : ids) {
			courseMapper.deleteByPrimaryKey(id);
		}
	}

}
