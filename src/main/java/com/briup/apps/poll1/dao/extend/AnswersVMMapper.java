package com.briup.apps.poll1.dao.extend;

import java.util.List;

import com.briup.apps.poll1.bean.extend.AnswersVM;

public interface AnswersVMMapper {
	List<AnswersVM> selectAll();
}
