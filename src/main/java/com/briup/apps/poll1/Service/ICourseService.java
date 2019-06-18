/**
 * 
 */
package com.briup.apps.poll1.Service;

import java.util.List;

import com.briup.apps.poll1.bean.Course;

/**
 * @author： fu @time：2018年6月25日 上午10:25:53 @说明： 一份耕耘，一份收获
 **/
public interface ICourseService {
	List<Course> findAll() throws Exception;

	// 关键字查询
	List<Course> query(String keywords) throws Exception;

	void save(Course course) throws Exception;

	void update(Course course) throws Exception;

	void deleteById(Long id) throws Exception;

	// 批量删除
	void batchDelete(List<Long> ids) throws Exception;
	/**
	 * @说明：
	 */
}
