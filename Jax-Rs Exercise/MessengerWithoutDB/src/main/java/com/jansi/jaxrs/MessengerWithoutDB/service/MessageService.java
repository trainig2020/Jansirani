package com.jansi.jaxrs.MessengerWithoutDB.service;

import java.util.ArrayList;
import java.util.List;

import com.jansi.jaxrs.MessengerWithoutDB.model.Message;

public class MessageService {

	public List<Message> getAllMessages() {
		Message m1 = new Message(1, "Hello world", "jansi");
		Message m2 = new Message(2, "Welcome", "jenni");
		Message m3 = new Message(3, "Hello", "sri");
		List<Message> list = new ArrayList<Message>();
		list.add(m1);
		list.add(m2);
		list.add(m3);
		return list;
	}

}
