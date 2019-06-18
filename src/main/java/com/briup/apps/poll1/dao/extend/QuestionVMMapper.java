/**
 * 
 */
package com.briup.apps.poll1.dao.extend;

import java.util.List;

import com.briup.apps.poll1.bean.extend.QuestionVM;

/**
 @author： fu    @time：2018年6月26日 上午9:47:38 
 @说明： 一份耕耘，一份收获
**/
public interface QuestionVMMapper {
List<QuestionVM> selectAll();
List<QuestionVM> selectByQuestionnaireId(long id);

}
