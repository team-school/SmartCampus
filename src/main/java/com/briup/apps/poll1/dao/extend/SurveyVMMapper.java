/**
 * 
 */
package com.briup.apps.poll1.dao.extend;

import java.util.List;

import com.briup.apps.poll1.bean.extend.SurveyVM;

/**
 @author： fu    @time：2018年6月29日 上午9:14:38 
 @说明： 一份耕耘，一份收获
**/
public interface SurveyVMMapper {
List<SurveyVM> selectAll();

SurveyVM selectById(Long id);
List<SurveyVM> selectByStatus(String status);

}
