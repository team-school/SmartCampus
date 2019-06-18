/**
 * 
 */
package com.briup.apps.poll1.Service.Impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll1.Service.ISurveyService;
import com.briup.apps.poll1.bean.Survey;
import com.briup.apps.poll1.bean.extend.SurveyVM;
import com.briup.apps.poll1.dao.SurveyMapper;
import com.briup.apps.poll1.dao.extend.SurveyVMMapper;

/**
 @author： fu    @time：2018年6月29日 上午8:31:56 
 @说明： 一份耕耘，一份收获
**/
@Service
public class SurveyServiceImpl  implements ISurveyService{
	@Autowired
	private SurveyMapper surveyMapper;
	@Autowired
	private SurveyVMMapper surveyVMMapper;
	@Override
	public void saveOrUpdate(Survey survey) throws Exception {
		if (survey.getId()!=null) {
			surveyMapper.updateByPrimaryKey(survey);
		}else{
			// TODO Auto-generated method stub
						//在保存之前先初始化课调信息
						survey.setStatus(Survey.STATUS_INIT);
						survey.setCode("");
						//日期处理
						Date surveyDate=new Date();
						SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						String str=	sdf.format(surveyDate);
						survey.setSurveydate(str);
						
						surveyMapper.insert(survey);
		}
		
		
	
	}
	@Override
	public List<SurveyVM> findAll() throws Exception {
		return surveyVMMapper.selectAll();
	}
	@Override
	public SurveyVM findById(long id) throws Exception {
		
		return surveyVMMapper.selectById(id);
	}
	/* (non-Javadoc)
	 * @see com.briup.apps.poll1.Service.ISurveyService#findSurveyById(long)
	 */
	@Override
	public Survey findSurveyById(long id) throws Exception {
		
		return surveyMapper.selectByPrimaryKey(id);
	}
	/* (non-Javadoc)
	 * @see com.briup.apps.poll1.Service.ISurveyService#findByStatus(java.lang.String)
	 */
	@Override
	public List<SurveyVM> findByStatus(String status) throws Exception {
		// TODO Auto-generated method stub
		return surveyVMMapper.selectByStatus(status);
	}

}
