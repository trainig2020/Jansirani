package com.jansi.jaxrs.Messenger3.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.jansi.jaxrs.Messenger3.model.Message;
import com.jansi.jaxrs.Messenger3.model.MessageService;

@Path("/messages")
public class MessageResource {

	MessageService msgService = new MessageService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessage() {
		return msgService.getAllMessages();
	}

	@GET
	public List<Message> getAllMessage(@QueryParam("year") int year, @QueryParam("start") int start,
			@QueryParam("size") int size) {

		if (year > 0) {
			return msgService.getAllMessagesForYear(year);
		}
		if (start >= 0 && size > 0) {
			return msgService.getAllMessagesPaginated(start, size);
		}
		return msgService.getAllMessages();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)

	public Message addMessage(Message message) {
		return msgService.addMessage(message);
	}

	@PUT
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)

	public Message updateMessage(@PathParam("messageId") long id, Message message) {
		message.setId(id);
		return msgService.updateMessage(message);
	}

	@DELETE
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public void removeMessage(@PathParam("messageId") long msgId) {
		msgService.removeMessage(msgId);
	}

	@GET
	@Path("/id/{msgId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message testMethodUsingId(@PathParam("msgId") long msgId) {
		return msgService.getMessage(msgId);
	}

}
