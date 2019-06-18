/**
 * 
 */
package com.briup.apps.poll1.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll1.Service.IUserService;
import com.briup.apps.poll1.bean.User;
import com.briup.apps.poll1.bean.UserExample;
import com.briup.apps.poll1.bean.extend.UserVM;
import com.briup.apps.poll1.dao.UserMapper;
import com.briup.apps.poll1.dao.extend.UserVMMapper;

/**
 @author： fu    @time：2018年6月25日 下午10:12:43 
 @说明： 一份耕耘，一份收获
**/
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserVMMapper userVMMapper;
	
	/* (non-Javadoc)
	 * @see com.briup.apps.poll1.Service.IUserService#findAll()
	 */
	@Override
	public List<User> findAll() throws Exception {
		// TODO Auto-generated method stub
		UserExample example=new UserExample();
		return userMapper.selectByExample(example);
	}

	/* (non-Javadoc)
	 * @see com.briup.apps.poll1.Service.IUserService#query(java.lang.String)
	 */
	@Override
	public List<User> query(String keywords) throws Exception {
		UserExample example=new UserExample();
		example.createCriteria().andNameLike(keywords);
		return userMapper.selectByExample(example);
	}

	/* (non-Javadoc)
	 * @see com.briup.apps.poll1.Service.IUserService#save(com.briup.apps.poll1.bean.User)
	 */
	@Override
	public void save(User user) throws Exception {
		userMapper.insert(user);
		
	}

	/* (non-Javadoc)
	 * @see com.briup.apps.poll1.Service.IUserService#update(com.briup.apps.poll1.bean.User)
	 */
	@Override
	public void update(User user) throws Exception {
		userMapper.updateByPrimaryKey(user);
		
	}

	/* (non-Javadoc)
	 * @see com.briup.apps.poll1.Service.IUserService#deleteById(java.lang.Long)
	 */
	@Override
	public void deleteById(Long id) throws Exception {
		userMapper.deleteByPrimaryKey(id);
		
	}

	/* (non-Javadoc)
	 * @see com.briup.apps.poll1.Service.IUserService#batchDelete(java.util.List)
	 */
	@Override
	public void batchDelete(List<Long> ids) throws Exception {
		for(Long id:ids){
			userMapper.deleteByPrimaryKey(id);
		}
		
	}

	/* (non-Javadoc)
	 * @see com.briup.apps.poll1.Service.IUserService#findAllUserVM()
	 */
	@Override
	public List<UserVM> findAllUserVM() throws Exception {
		// TODO Auto-generated method stub
		return userVMMapper.selectAll();
	}

}
