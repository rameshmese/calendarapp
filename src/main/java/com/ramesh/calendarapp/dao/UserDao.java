package com.ramesh.calendarapp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Component;

import com.ramesh.calendarapp.dbconfig.DBConfig;
import com.ramesh.calendarapp.dbconfig.DBConnection;

@Component
@AutoConfigureAfter(value = {DBConfig.class,DBConnection.class})
public class UserDao {

	protected final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	DBConnection dbConnection ;
	
	public Boolean checkAdmin(String userName,String password){
		Connection connection = null;
		try{
			connection = dbConnection.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs=stmt.executeQuery("select * from users where userName=' "+userName+" ' and pwd =' " + password +"'");
			while (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			return false;
		} finally {
			dbConnection.closeConnection(connection);
		}
		
		return true;
	}
}
