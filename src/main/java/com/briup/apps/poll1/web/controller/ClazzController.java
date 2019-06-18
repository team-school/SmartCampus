/**
 * 
 */
package com.briup.apps.poll1.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll1.Service.IClazzService;
import com.briup.apps.poll1.bean.Clazz;
import com.briup.apps.poll1.bean.extend.ClazzVM;
import com.briup.apps.poll1.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 @author： fu    @time：2018年6月26日 上午9:29:33 
 @说明： 一份耕耘，一份收获
**/
@Api(description="班级相关接口(OK)")
@RestController
@RequestMapping("/clazz")
public class ClazzController {
	@Autowired
	private IClazzService clazzService;
	@ApiOperation("查询所有的班级信息")
	@GetMapping("findAllClazz")
	public MsgResponse findAllClazz(){
		try{
			List<Clazz> list=clazzService.findAll();
			return MsgResponse.success("查询成功", list);
		}catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}	
	}
	
	@ApiOperation(value="保存或更新课程信息",
			notes="如果参数中包含了id,说明这是一个更新操作。如果参数中没有包含id，说明这是一个保存操作")
	@PostMapping("saveOrUpdateClazz")
	public MsgResponse saveOrUpdateClazz(Clazz clazz){
		try{
			if(clazz!=null&&clazz.getId()!=null){
				clazzService.update(clazz);
			}else{
				clazzService.save(clazz);
			}
			return MsgResponse.success("保存或更新成功", null);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation("批量删除班级信息")
	@PostMapping("batchDelete")
	public MsgResponse batchDelete(long[] ids){
		try{
			List<Long> idList=new ArrayList<>();
			for(long id:ids){
				idList.add(id);
			}
			clazzService.batchDelete(idList);
			return MsgResponse.success("批量删除成功", null);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	@ApiOperation(value="查询所有的班级信息",notes="每个班级信息中包含班级所属年级和班级所属的班主任的信息")
	@GetMapping("findAllClazzVM")
	public MsgResponse findAllClazzVM(){
		try{
			List<ClazzVM> list=clazzService.findAllClazzVM();
			return MsgResponse.success("查询成功", list);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	

}
