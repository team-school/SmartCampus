/**
 * 
 */
package com.briup.apps.poll1.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll1.Service.IQuestionService;
import com.briup.apps.poll1.bean.Options;
import com.briup.apps.poll1.bean.OptionsExample;
import com.briup.apps.poll1.bean.Question;
import com.briup.apps.poll1.bean.QuestionExample;
import com.briup.apps.poll1.bean.extend.QuestionVM;
import com.briup.apps.poll1.dao.OptionsMapper;
import com.briup.apps.poll1.dao.QuestionMapper;
import com.briup.apps.poll1.dao.extend.QuestionVMMapper;

/**
 @author： fu    @time：2018年6月26日 上午9:27:34 
 @说明： 一份耕耘，一份收获
**/


@Service
public class QuestionServiceImpl implements IQuestionService {
	@Autowired
private QuestionMapper	questionMapper;
	@Autowired
private QuestionVMMapper questionVMMapper;
	
	@Autowired 
	private OptionsMapper optionsMapper;
	@Override
	public List<Question> findAll() throws Exception {
		QuestionExample example=new QuestionExample();
		return questionMapper.selectByExample(example);
	}
	@Override
	public List<QuestionVM> findAllQuestionVM() throws Exception {
		return questionVMMapper.selectAll();
	}
	@Override
	public void saveOrUpdate(QuestionVM questionVM) throws Exception {
		//修改操作,从questionVM中拆分出 question options
		Question question=new Question();
		question.setId(questionVM.getId());
		question.setName(questionVM.getName());//题目名称
		question.setQuestiontype(questionVM.getQuestionType());//题目类型
		List<Options> options=questionVM.getOptions();//题目选项
		if (questionVM.getId()!=null) {
			//修改作业
		//	2.1.1.修改题目信息
			questionMapper.updateByPrimaryKey(question);
			//修改题目下选项的信息，通过question_id删除选项的信息
			OptionsExample example=new OptionsExample();
			example.createCriteria().andQuestionIdEqualTo(question.getId());//给example添加一种约束外键=question.getId()
			optionsMapper.deleteByExample(example);
			//把新接收到的options数据插入到数据库
			long id = question.getId();
			for (Options option : options) {
				option.setQuestionId(id);
				optionsMapper.insert(option);
			}
		}else {
			if (question.getQuestiontype()=="简答题") {
				//2.2.1. 保存问题信息,简答题只需要保存题目的信息
				questionMapper.insert(question);
			} else {
				//保存操作 
				//1，保存问题信息
				questionMapper.insert(question);
				//保存完之后需要知道题目的Id，所以去QuestionMapper.xml中更改<insert  
				//获取问题的主键
				long id = question.getId();
				//2,保存选项
				for (Options option : options) {
					option.setQuestionId(id);//给外键设置Id
					optionsMapper.insert(option);
				}
			}
		}
	}
	
	
	
	
	@Override
	public void  deleteById(Long id) throws Exception {
		questionMapper.deleteByPrimaryKey(id);
	
	}
	/* (non-Javadoc)
	 * @see com.briup.apps.poll1.Service.IQuestionService#batchDelete(java.util.List)
	 */
	@Override
	public void batchDelete(List<Long> ids) {
		for (Long id : ids) {
			questionMapper.deleteByPrimaryKey(id);
		}
		
	}
	/* (non-Javadoc)
	 * @see com.briup.apps.poll1.Service.IQuestionService#query(java.lang.String)
	 */
	@Override
	public List<Question> query(String keywords) {
		QuestionExample	 example=new QuestionExample();
		//创建一个模板
		example.createCriteria().andNameLike("%"+keywords+"%");
		return questionMapper.selectByExample(example);
	}

	
	
	

}
