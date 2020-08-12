package com.jansi.jaxrs.MessengerBeanParam.resource;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.jansi.jaxrs.MessengerBeanParam.model.Comment;
import com.jansi.jaxrs.MessengerBeanParam.service.CommentService;

@Path("/")
public class CommentResource {

	private CommentService commService = new CommentService();

	@GET
	public List<Comment> getAllcomments(@PathParam("messageId") long messageId) {
		return commService.getAllComments(messageId);

	}

	@POST
	public Comment addMessage(@PathParam("messageId") long messageId, Comment comment) {
		return commService.addComment(messageId, comment);
	}

	@PUT
	@Path("/{commentId}")
	public Comment updateComment(@PathParam("messageId") long messageId, @PathParam("commentId") long id,
			Comment comment) {
		comment.setId(id);
		return commService.updateComment(messageId, comment);
	}

	@DELETE
	@Path("/{commentId}")
	public void removeComment(@PathParam("messageId") long messageId, @PathParam("commentId") long id) {
		commService.removeComment(messageId, id);
	}

	@GET
	@Path("/{commentId}")
	public Comment getMessage(@PathParam("messageId") long messageId, @PathParam("commentId") long id) {
		return commService.getComment(messageId, id);
	}

}
