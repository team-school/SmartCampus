/**
 * 
 */
package com.briup.apps.poll1.dao.extend;

import com.briup.apps.poll1.bean.extend.QuestionnaireVM;

/**
 @author： fu    @time：2018年6月28日 上午9:07:14 
 @说明： 一份耕耘，一份收获
**/
public interface QuestionnaireVMMapper {
	QuestionnaireVM selectById(Long id);//问卷的信息，问题的信息，选项的信息都能找到

}
