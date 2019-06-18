/**
 * 
 */
package com.briup.apps.poll1.Service;

import java.util.List;

import com.briup.apps.poll1.bean.Clazz;
import com.briup.apps.poll1.bean.extend.ClazzVM;

/**
 @author： fu    @time：2018年6月26日 上午9:26:46 
 @说明： 一份耕耘，一份收获
**/
public interface IClazzService {

	List<Clazz> findAll() throws Exception;
	//关键字查询
		List<Clazz> query(String keywords) throws Exception;
		void save(Clazz clazz) throws Exception;
		void update(Clazz clazz) throws Exception;
		void deleteById(Long id)throws Exception;
		//批量删除
	void batchDelete(List<Long> ids) throws Exception;
	
	List<ClazzVM> findAllClazzVM() throws Exception;
	void save(ClazzVM clazzVM) throws Exception;
	void update(ClazzVM clazzVM) throws Exception;
	
}
