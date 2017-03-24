package com.ramesh.calendarapp.model;

public class Event {
	
	int id;
	String eventName;
	String eventDis;
	String user;
	long startTime;
	long endTime;
	String venue;
	String groupName;
	
	
	
	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Event() {
	}
	
	public Event(int id, String eventName, String eventDis, String user, long startTime, long endTime, String venue,String groupName) {
		this.id=id;
		this.eventName=eventName;
		this.eventDis=eventDis;
		this.user=user;
		this.startTime=startTime;
		this.endTime=endTime;
		this.venue=venue;
		this.groupName=groupName;
	}
	
	
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getEventDis() {
		return eventDis;
	}
	public void setEventDis(String eventDis) {
		this.eventDis = eventDis;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public long getStartTime() {
		return startTime;
	}
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	public long getEndTime() {
		return endTime;
	}
	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}

}
