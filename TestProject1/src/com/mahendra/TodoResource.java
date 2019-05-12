package com.mahendra;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.xml.bind.JAXBElement;

public class TodoResource {
    @Context
 private   UriInfo uriInfo;
    @Context
    private Request request;
   private String id;
    public TodoResource(UriInfo uriInfo, Request request, String id) {
        this.uriInfo = uriInfo;
        this.request = request;
        this.id = id;
    }

    //Application integration
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Todo getTodo() {
        Todo todo = TodoItemType.instance.getModel().get(id);
        if(todo==null)
            throw new RuntimeException("Get: Todo with " + id +  " not found");
        return todo;
    }

 // for the browser
    @GET
    @Produces(MediaType.TEXT_XML)
    public Todo getTodoHTML() {
        Todo todo = TodoItemType.instance.getModel().get(id);
        if(todo==null)
            throw new RuntimeException("Get: Todo with " + id +  " not found");
        return todo;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public Response putTodo(JAXBElement<Todo> todo) {
        Todo c = todo.getValue();
        return putAndGetResponse(c);
    }

    @DELETE
    public void deleteTodo() {
        Todo c = TodoItemType.instance.getModel().remove(id);
        if(c==null)
            throw new RuntimeException("Delete: Todo with " + id +  " not found");
    }

    private Response putAndGetResponse(Todo todo) {
        Response res;
        if(TodoItemType.instance.getModel().containsKey(todo.getId())) {
            res = Response.noContent().build();
        } else {
            res = Response.created(uriInfo.getAbsolutePath()).build();
        }
        TodoItemType.instance.getModel().put(todo.getId(), todo);
        return res;
    }


}