package com.jansi.jaxrs.MessengerWithoutDB.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jansi.jaxrs.MessengerWithoutDB.model.Message;
import com.jansi.jaxrs.MessengerWithoutDB.service.MessageService;

@Path("/messages")
public class MessageResource {

	MessageService msgService = new MessageService();

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessage() {
		return msgService.getAllMessages();
	}

}
