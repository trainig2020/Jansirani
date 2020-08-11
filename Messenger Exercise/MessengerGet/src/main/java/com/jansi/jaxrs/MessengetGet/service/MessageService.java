package com.jansi.jaxrs.MessengetGet.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.jansi.jaxrs.MessengetGet.database.DatabaseClass;
import com.jansi.jaxrs.MessengetGet.model.Message;


public class MessageService {

	private static Map<Long, Message> messages = DatabaseClass.getMessages();
	
	
	public MessageService() {
		messages.put(1L, new Message(1, "Hello world", "jansi"));
		messages.put(2L, new Message(2, "Welcome", "sri"));
	}

	public List<Message> getAllMessages() {
		return new ArrayList<Message>(messages.values());
	}

	public Message getMessage(long id) {
		return messages.get(id);
	}

	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;

	}

	public Message updateMessage(Message message) {
		if (message.getId() <= 0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}

	public Message removeMessage(long id) {
		return messages.remove(id);
	}

}
