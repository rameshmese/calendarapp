package com.ramesh.calendarapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Component;

import com.ramesh.calendarapp.dbconfig.DBConfig;
import com.ramesh.calendarapp.dbconfig.DBConnection;
import com.ramesh.calendarapp.model.Event;


@Component
@AutoConfigureAfter(value = {DBConfig.class,DBConnection.class})
public class EventDao {
	protected final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	DBConnection dbConnection ;
	
	public int saveEvent(Event event) {
		Connection connection = null;
		int eventId;
		try {
			connection = dbConnection.getConnection();			
			PreparedStatement p = connection.prepareStatement("Insert into event values (?,?,?,?,?,?,?,?)");
			eventId=event.getId();
			p.setInt(1, eventId);
			p.setString(2, event.getEventName());
			p.setString(3, event.getEventDis());
			p.setString(4, event.getUser());
			p.setLong(5,  event.getStartTime());
			p.setLong(6,  event.getEndTime());
			p.setString(7, event.getVenue());
			p.setString(8, event.getGroupName());
			p.executeQuery();
			
		} catch (SQLException e) {
			log.error("Exception at saveUserSessionToken", e);
			return -1;
		} finally {
			dbConnection.closeConnection(connection);
		}
		return eventId;
		
	}
	
	public int getUniqueEventID() {
		int id=0;
		Connection connection = null;
		try{
			connection = dbConnection.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select NVL(max(EventID), 0 ) from event");
			while (rs.next()) {
				id=rs.getInt(1);
				break;
			}
		} catch (SQLException e) {
			log.error("Exception at saveUserSessionToken", e);
			return -1;
		} finally {
			dbConnection.closeConnection(connection);
		}
		return id+1;

	}
	
	public List<Event> listEvents() {
		List<Event> list=new ArrayList<Event>();
		Connection connection = null;
		try{
			connection = dbConnection.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from event");
			while (rs.next()) {
				list.add(new Event(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getLong(5),
						rs.getLong(6),
						rs.getString(7),
						rs.getString(8)
						));
			}
		} catch (SQLException e) {
			log.error("Exception at saveUserSessionToken", e);
			return null;
		} finally {
			dbConnection.closeConnection(connection);
		}
		
		return list;
	}

	public Event getEvent(int id) {
		Connection connection = null;
		Event event=null;
		try{
			connection = dbConnection.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from event where EventID = "+id);
			while (rs.next()) {
				event=new Event(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getLong(5),
						rs.getLong(6),
						rs.getString(7),
						rs.getString(8)
						);
				break;
			}
		} catch (SQLException e) {
			log.error("Exception at saveUserSessionToken", e);
			return null;
		} finally {
			dbConnection.closeConnection(connection);
		}
		
		return event;
	}
	
	public List<Event> getEvent(String name) {
		List<Event> list=new ArrayList<Event>();
		Connection connection = null;
		try{
			connection = dbConnection.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from event where EventName = '"+name+"'");
			while (rs.next()) {
				list.add(new Event(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getLong(5),
						rs.getLong(6),
						rs.getString(7),
						rs.getString(8)
						));
			}
		} catch (SQLException e) {
			log.error("Exception at saveUserSessionToken", e);
			return null;
		} finally {
			dbConnection.closeConnection(connection);
		}
		
		return list;
	}
	
	
	public List<Event> getEventsByGroup(String group) {
		List<Event> list=new ArrayList<Event>();
		Connection connection = null;
		try{
			connection = dbConnection.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from event where groupName = '"+group+"'");
			while (rs.next()) {
				list.add(new Event(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getLong(5),
						rs.getLong(6),
						rs.getString(7),
						rs.getString(8)
						));
			}
		} catch (SQLException e) {
			log.error("Exception at saveUserSessionToken", e);
			return null;
		} finally {
			dbConnection.closeConnection(connection);
		}
		
		return list;
	}
	
	public List<Event> getEventsByCreator(String group) {
		List<Event> list=new ArrayList<Event>();
		Connection connection = null;
		try{
			connection = dbConnection.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from event where owner = '"+group+"'");
			while (rs.next()) {
				list.add(new Event(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getLong(5),
						rs.getLong(6),
						rs.getString(7),
						rs.getString(8)
						));
			}
		} catch (SQLException e) {
			log.error("Exception at saveUserSessionToken", e);
			return null;
		} finally {
			dbConnection.closeConnection(connection);
		}
		
		return list;
	}

	public Boolean healthCheck() throws Exception{
		Connection connection = null;
		try{
			connection = dbConnection.getConnection();
			Statement stmt = connection.createStatement();
			stmt.executeQuery("select * from dual");
		} catch (SQLException e) {
			throw new Exception("DB Connection not Success",e);
		} finally {
			dbConnection.closeConnection(connection);
		}
		
		return true;
	}

}
