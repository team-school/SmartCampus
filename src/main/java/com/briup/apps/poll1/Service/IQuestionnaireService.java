/**
 * 
 */
package com.briup.apps.poll1.Service;

import java.util.List;

import com.briup.apps.poll1.bean.Questionnaire;
import com.briup.apps.poll1.bean.extend.QuestionnaireVM;

/**
 @author： fu    @time：2018年6月28日 上午9:38:14 
 @说明： 一份耕耘，一份收获
**/
public interface IQuestionnaireService {
QuestionnaireVM findById(long id)throws Exception;
List<Questionnaire> findAll() throws Exception;
void deleteById(long id)throws Exception;
void saveOrUpdate(Questionnaire questionnaire,long[] ids) throws Exception;
}
