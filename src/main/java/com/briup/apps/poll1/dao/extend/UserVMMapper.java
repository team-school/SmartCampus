/**
 * 
 */
package com.briup.apps.poll1.dao.extend;

import java.util.List;

import com.briup.apps.poll1.bean.extend.UserVM;

/**
 @author： fu    @time：2018年6月26日 下午9:23:34 
 @说明： 一份耕耘，一份收获
**/
public interface UserVMMapper {

	List<UserVM> selectAll();
}
