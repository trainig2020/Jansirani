package com.jansi.jaxrs.MessengetGet.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jansi.jaxrs.MessengetGet.model.Message;
import com.jansi.jaxrs.MessengetGet.service.MessageService;


@Path("/messages")
public class MessageResource {

	MessageService msgService = new MessageService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessage() {
		return msgService.getAllMessages();
	}
	
	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		return "Testing a method";
	}
	
	
	@GET
	@Path("/{number}")
	@Produces(MediaType.TEXT_PLAIN)
	public String testMethod() {
		return "Testing";
	}
	

	@GET
	@Path("/test/{messageId}")
	@Produces(MediaType.TEXT_PLAIN)
	public String testMethodUsingVariable(@PathParam("messageId") String messageId) {
		return "Got path param :" +messageId;
	}
	

	@GET
	@Path("/id/{msgId}")
	@Produces(MediaType.APPLICATION_XML)
	public Message testMethodUsingId(@PathParam("msgId") long msgId) {
		return msgService.getMessage(msgId);
	}



}
