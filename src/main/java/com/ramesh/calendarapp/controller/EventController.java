package com.ramesh.calendarapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ramesh.calendarapp.manager.EventManager;
import com.ramesh.calendarapp.manager.UserManager;
import com.ramesh.calendarapp.model.Event;

@RestController
@RequestMapping("/calendarapp")
public class EventController {
	
	@Autowired
	EventManager eventManager;
	
	@Autowired
	UserManager userManager;

	@RequestMapping(value = "/addevent", method = RequestMethod.GET)
	public  @ResponseBody Event addEmployees(
			@RequestParam(value = "userName", required = true) String userName,
			@RequestParam(value = "pwd", required = true) String pwd,
			@RequestParam(value = "sartTime", required = false) Long startTime,
			@RequestParam(value = "endTime", required = false) Long endTime,
			@RequestParam(value = "venue", required = false) String venue,
			@RequestParam(value = "eventName", required = false) String eventName,
			@RequestParam(value = "eventDis", required = false) String eventDis,
			@RequestParam(value = "groupName", required = false) String groupName
			) 
    {
		Event event=null;
		if(userManager.checkAdmin(userName,pwd)){	
			int eventID=eventManager.getUniqueEventID();
			event=new Event(eventID, eventName, eventDis, userName, startTime, endTime, venue,groupName);
			eventManager.saveEvent(event);
		}else{
			return null;
		}
		return event;
    }

	
	@RequestMapping(value = "/listbyid", method = RequestMethod.GET)
	public  @ResponseBody Event listEmployeesByEventID(
			@RequestParam(value = "value", required = false) String value
			)	{
		try{
			if(	value!=null && !value.isEmpty()){
					Integer id=Integer.valueOf(value.trim());
					if(id!=null)
						return eventManager.getEvent(id);
//					return eventManager.getEvent(value);
//					return eventManager.getEventsByGroup(value);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/listbyname", method = RequestMethod.GET)
	public  @ResponseBody List<Event> listEmployeesByEventName(
			@RequestParam(value = "value", required = false) String value
			)	{
		try{
			if(	value!=null && !value.isEmpty()){
					return eventManager.getEvent(value);
//					return eventManager.getEventsByGroup(value);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	
	@RequestMapping(value = "/listbycreator", method = RequestMethod.GET)
	public  @ResponseBody List<Event> listEmployeesByEventCreator(
			@RequestParam(value = "value", required = false) String value
			)	{
		try{
			if(	value!=null && !value.isEmpty()){
					return eventManager.getEventsByCreator(value);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/listbygroup", method = RequestMethod.GET)
	public  @ResponseBody List<Event> listEmployeesByGroup(
			@RequestParam(value = "value", required = false) String value
			)	{
		try{
			if(	value!=null && !value.isEmpty()){
					return eventManager.getEventsByGroup(value);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	
	@RequestMapping(value = "/listall", method = RequestMethod.GET)
	public  @ResponseBody List<Event> listAllEmployees()	{
		try{
			return eventManager.listEvents();
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	
	@RequestMapping(value = "/healthCheck", method = RequestMethod.GET)
	public  @ResponseBody String healthCheck()	{
		try{
			return String.valueOf(eventManager.healthCheck());
		}catch(Exception e){
			return e.getMessage();
		}
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public  @ResponseBody String app()	{
		try{
			return "Calendar Application is Running";
		}catch(Exception e){
			return e.getMessage();
		}
	}
	
	


}
