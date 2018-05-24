package com.wyk.sh.manager.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.wyk.sh.entity.Log;
import com.wyk.sh.manager.LogManager;

public class LogManagerImpl extends HibernateDaoSupport implements LogManager {

	@Override
	public void addLog(Log log) {
		this.getHibernateTemplate().save(log);
	}


}
