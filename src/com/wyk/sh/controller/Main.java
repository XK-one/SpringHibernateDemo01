package com.wyk.sh.controller;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wyk.sh.entity.User;
import com.wyk.sh.manager.UserManager;

public class Main {

	/**
	 * applicationContext-common 主要体现Spring 的AOP编程，将事务开启等以切面方式(动态代理)动态插进代码里
	 * applicationContext-beans  主要体现Spring 的IOC核心，将类对象通过文件配置的方式(实际是反射技术)进行关联，使得代码解耦
	 */
	@Test
	public void test() {
		/**
		 * 无法找到applicationContext-* 所匹配的文件，只能以下面全名的方式来匹配
		   BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext-*.xml");
		*/
		BeanFactory factory = new ClassPathXmlApplicationContext(new String[]{"applicationContext-beans.xml","applicationContext-common.xml"});
		
		UserManager userManager = (UserManager)factory.getBean("userManager");
		
		User user = new User();
		user.setName("夏一天");
		try{
			userManager.addUser(user);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
