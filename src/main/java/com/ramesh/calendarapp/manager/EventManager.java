package com.ramesh.calendarapp.manager;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Component;

import com.ramesh.calendarapp.dao.EventDao;
import com.ramesh.calendarapp.dbconfig.DBConfig;
import com.ramesh.calendarapp.dbconfig.DBConnection;
import com.ramesh.calendarapp.model.Event;

@Component
@AutoConfigureAfter(value = {DBConfig.class,DBConnection.class})
public class EventManager {

	protected final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	EventDao eventDao;
	
	public int saveEvent(Event event) {
		return eventDao.saveEvent(event);
	}
	
	public int getUniqueEventID() {
		return eventDao.getUniqueEventID();
	}
	
	public List<Event> listEvents() {
		return eventDao.listEvents();
	}

	public Event getEvent(int id) {
		return eventDao.getEvent(id);
	}
	
	public List<Event> getEvent(String value) {
		return eventDao.getEvent(value);
	}
	public List<Event> getEventsByGroup(String value) {
		return eventDao.getEventsByGroup(value);
	}

	public List<Event> getEventsByCreator(String value) {
		return eventDao.getEventsByCreator(value);
	}

	public Boolean healthCheck() throws Exception{
		return eventDao.healthCheck();
	}
	
}
