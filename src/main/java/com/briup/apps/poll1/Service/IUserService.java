/**
 * 
 */
package com.briup.apps.poll1.Service;

import java.util.List;

import com.briup.apps.poll1.bean.User;
import com.briup.apps.poll1.bean.extend.UserVM;

/**
 @author： fu    @time：2018年6月25日 下午9:56:28 
 @说明： 一份耕耘，一份收获
**/
public interface IUserService {

	List<User> findAll() throws Exception;
	List<User> query(String keywords) throws Exception;
	void save(User user) throws Exception;
	void update(User user) throws Exception;
	void deleteById(Long id) throws Exception;
	void batchDelete(List<Long> ids) throws Exception;
	
	List<UserVM> findAllUserVM() throws Exception;
}
