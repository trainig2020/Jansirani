package com.jansi.advanced.client;

import java.util.Date;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.jansi.advanced.model.Message;

public class RestApiClient {
	
	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		
		WebTarget baseTarget = client.target("http://localhost:8084/JaxRsClient/webapi/");
		WebTarget messagesTarget = baseTarget.path("messages");
		WebTarget singleMessageTarget = messagesTarget.path("{messageId}");
		Message message = singleMessageTarget 
				.resolveTemplate("messageId", 1)
				.request(MediaType.APPLICATION_JSON)
				.get(Message.class);
		Message message1 = singleMessageTarget 
				.resolveTemplate("messageId", 2)
				.request(MediaType.APPLICATION_JSON)
				.get(Message.class);
		//Message message = response.readEntity(Message.class);
		//System.out.println(message.getMessage());
		
		Message newMessage = new Message(3, "My new message from jax rs client",
				new Date(2019, 04, 12), "Jennifer");
		Response  postResponse = messagesTarget
		.request()
		.post(Entity.json(newMessage));
		if(postResponse.getStatus() != 201) {
			System.out.println("Error");
		}
		Message readEntity = postResponse.readEntity(Message.class);
		
		System.out.println(readEntity.getMessage());
		System.out.println(message.getMessage());
		System.out.println(message1.getMessage());
		
		
	}

}
