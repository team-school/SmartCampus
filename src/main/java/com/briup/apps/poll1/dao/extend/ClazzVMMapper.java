/**
 * 
 */
package com.briup.apps.poll1.dao.extend;

import java.util.List;

import com.briup.apps.poll1.bean.extend.ClazzVM;

/**
 @author： fu    @time：2018年6月26日 上午9:47:49 
 @说明： 一份耕耘，一份收获
**/
public interface ClazzVMMapper {

	List<ClazzVM> selectAll();

	/**
	 * @说明：
	 */
	void insert(ClazzVM clazzVM);
	void update(ClazzVM clazzVM);
	ClazzVM selectById();
}
