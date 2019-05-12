package com.mahendra;

import java.util.HashMap;
import java.util.Map;

public enum TodoItemType {
	instance;
	
	 private Map<String, Todo> contentProvider = new HashMap<>();

	    private TodoItemType(){

	        Todo todo = new Todo("1", "Learn REST");
	        todo.setDescription("Read the official REST & JAXRS Documentation");
	        contentProvider.put("1", todo);
	        todo = new Todo("2", "Do something");
	        todo.setDescription("Visit Synergetics-live.com for online courses");
	        contentProvider.put("2", todo);

	    }

	    public Map<String, Todo> getModel(){
	        return contentProvider;
	    }


}
