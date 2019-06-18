package com.briup.apps.poll1.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll1.Service.IGradeService;
import com.briup.apps.poll1.bean.Grade;
import com.briup.apps.poll1.bean.GradeExample;
import com.briup.apps.poll1.bean.extend.GradeVM;
import com.briup.apps.poll1.dao.GradeMapper;
import com.briup.apps.poll1.dao.extend.GradeVMMapper;


@Service

public class GradeServiceImpl implements IGradeService{
	@Autowired
	private GradeMapper gradeMapper;
	@Autowired
	private GradeVMMapper gradeVMMapper;

	@Override
	public List<Grade> findAll() throws Exception {
		
		GradeExample example = new GradeExample();
		
		return gradeMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public List<GradeVM> findAllGradeVM() throws Exception {
		return gradeVMMapper.selectAll();
	}
	
	@Override
	public List<Grade> query(String keywords) throws Exception {
		
		GradeExample example = new GradeExample();
		example.createCriteria().andNameLike("%"+keywords+"%");
		return gradeMapper.selectByExampleWithBLOBs(example);
	}

	

	@Override
	public void deleteById(long id) throws Exception {
		gradeMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public void batchDelete(long[] ids) throws Exception {
		for(long id : ids){
			gradeMapper.deleteByPrimaryKey(id);
		}
	}

	/* (non-Javadoc)
	 * @see com.briup.apps.poll1.Service.IGradeService#saveOrUpdate(com.briup.apps.poll1.bean.Grade)
	 */
	@Override
	public void saveOrUpdate(Grade grade) throws Exception {
		// TODO Auto-generated method stub
		if(grade.getId()!=null) {
			gradeMapper.updateByPrimaryKey(grade);
		} else {
			gradeMapper.insert(grade);
		}
	}


}
