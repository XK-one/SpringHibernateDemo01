package com.wyk.sh.manager.impl;

import java.util.Date;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.wyk.sh.entity.Log;
import com.wyk.sh.entity.User;
import com.wyk.sh.manager.LogManager;
import com.wyk.sh.manager.UserManager;

public class UserManagerImpl extends HibernateDaoSupport implements UserManager {

	private LogManager logManager;
	
	public void setLogManager(LogManager logManager){
		this.logManager = logManager;
	}

	@Override
	public void addUser(User user) {
		
		this.getHibernateTemplate().save(user);
		
		Log log = new Log();  
        log.setType("操作日志");  
        log.setTime(new Date());  
        log.setDetail("xxx"); 
        
        logManager.addLog(log); 
		
	}
	
	
	
}
