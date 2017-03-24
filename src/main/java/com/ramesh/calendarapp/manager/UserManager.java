package com.ramesh.calendarapp.manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Component;

import com.ramesh.calendarapp.dao.UserDao;
import com.ramesh.calendarapp.dbconfig.DBConfig;
import com.ramesh.calendarapp.dbconfig.DBConnection;

@Component
@AutoConfigureAfter(value = {DBConfig.class,DBConnection.class})
public class UserManager {
	protected final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	UserDao userDao;
	
	public Boolean checkAdmin(String userName,String password){
		return userDao.checkAdmin(userName, password);
	}

}
