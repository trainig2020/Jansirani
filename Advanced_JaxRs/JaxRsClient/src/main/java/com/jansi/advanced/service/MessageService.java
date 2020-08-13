package com.jansi.advanced.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.jansi.advanced.database.DatabaseClass;
import com.jansi.advanced.exception.DataNotFoundException;
import com.jansi.advanced.model.Message;



public class MessageService {

	private static Map<Long, Message> messages = DatabaseClass.getMessages();

	public MessageService() {
		messages.put(1L, new Message(1, "Hello jansirani", new Date(), "jansi"));
		messages.put(2L, new Message(2, "Welcome srikanth",new Date(), "sri"));
	}

	public List<Message> getAllMessages() {
		return new ArrayList<Message>(messages.values());
	}

	public List<Message> getAllMessagesForYear(int year) {
		List<Message> msgYear = new ArrayList<Message>();
		Calendar cal = Calendar.getInstance();
		for (Message message : messages.values()) {
			cal.setTime(message.getCreated());
			if (cal.get(Calendar.YEAR) == year) {
				msgYear.add(message);
			}
		}
		return msgYear;
	}

	public Message getMessage(long id) {
		Message message = messages.get(id);
		if(message == null ) {
			throw new DataNotFoundException("Message with id :" + id + "  not found" );
		}
		return message;
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

	public List<Message> getAllMessagesPaginated(int start, int size) {
		// TODO Auto-generated method stub
		return null;
	}

}
