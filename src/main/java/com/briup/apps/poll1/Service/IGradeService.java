package com.briup.apps.poll1.Service;

import java.util.List;

import com.briup.apps.poll1.bean.Grade;
import com.briup.apps.poll1.bean.extend.GradeVM;

public interface IGradeService {
	List<Grade> findAll() throws Exception;
	
	List<GradeVM> findAllGradeVM() throws Exception;
	
	List<Grade> query(String keywords) throws Exception;
	
	void saveOrUpdate(Grade grade) throws Exception;
	
	void deleteById(long id) throws Exception;
	
	void batchDelete(long[] ids) throws Exception;

}
