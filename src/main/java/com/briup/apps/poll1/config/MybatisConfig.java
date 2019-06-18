/**
 * 
 */
package com.briup.apps.poll1.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 @author： fu    @time：2018年6月25日 上午9:08:11 
 @说明： 一份耕耘，一份收获
**/
@Configuration
@MapperScan("com.briup.apps.poll1.dao")
public class MybatisConfig {

}
