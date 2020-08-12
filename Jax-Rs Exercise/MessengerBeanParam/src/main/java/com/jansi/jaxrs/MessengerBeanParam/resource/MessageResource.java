package com.jansi.jaxrs.MessengerBeanParam.resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import com.jansi.jaxrs.MessengerBeanParam.model.Message;
import com.jansi.jaxrs.MessengerBeanParam.service.MessageService;




@Path("/messages")
public class MessageResource {

	MessageService msgService = new MessageService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessage() {
		return msgService.getAllMessages();
	}

	@GET
	public List<Message> getAllMessage(@BeanParam MessageFilterBean filterBean) {

		if (filterBean.getYear() > 0) {
			return msgService.getAllMessagesForYear(filterBean.getYear());
		}
		if (filterBean.getStart() >= 0 && filterBean.getSize() > 0) {
			return msgService.getAllMessagesPaginated(filterBean.getStart(), filterBean.getSize());
		}
		return msgService.getAllMessages();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)

	public Response addMessage(Message message,@Context UriInfo uriInfo) throws URISyntaxException {
		
		
		Message newMessage =  msgService.addMessage(message);
		String newId = String.valueOf(newMessage.getId());
		URI Uri= uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response.created(Uri)
				.entity(newMessage)
				.build();
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
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message testMethodUsingId(@PathParam("messageId") long msgId) {
		return msgService.getMessage(msgId);
	}
	
	
	
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource() {
		return new CommentResource();
		
	}
	
	
	
	
	
	

}
