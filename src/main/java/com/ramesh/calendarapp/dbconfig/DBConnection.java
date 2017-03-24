package com.ramesh.calendarapp.dbconfig;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Component;

@Component
@AutoConfigureAfter(value = {DBConfig.class})
public class DBConnection {
    @Autowired(required=true)
    DBConfig dbCon;
	
	protected final Logger log = LoggerFactory.getLogger(getClass());	

	/**
	 * Static method that returns the instance for the singleton
	 *
	 * @return {Connection} connection
	 **/
	
	
	public  Connection getConnection() {
		Connection connection=null;
		try {
			Class.forName(dbCon.getDRIVER());			
				connection = DriverManager.getConnection(dbCon.getURL(), dbCon.getUSER(), dbCon.getPASSWORD());			 
		} catch (ClassNotFoundException e) {
			log.error("ClassNotFoundException at getConnection",e);
		}catch (SQLException e) {
			log.error("SQL Exception at getConnection",e);
		}		
		return connection;
	}	
	
	public void closeConnection(Connection connection){
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				log.error("SQL Exception at closeConnection",e);
				
			}
		}
	}
	
}
