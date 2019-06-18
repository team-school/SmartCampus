/**
 * 
 */
package com.briup.apps.poll1.Service;

import java.util.List;

import com.briup.apps.poll1.bean.Survey;
import com.briup.apps.poll1.bean.extend.SurveyVM;

/**
 @author： fu    @time：2018年6月29日 上午8:30:46 
 @说明： 一份耕耘，一份收获
**/
public interface ISurveyService {
void saveOrUpdate(Survey survey) throws Exception;
List<SurveyVM> findAll() throws Exception;
SurveyVM findById(long id)throws Exception;
Survey findSurveyById(long id )throws Exception;
List<SurveyVM> findByStatus(String status)throws Exception;
}
