package com.coderscampus.domain;

import java.util.ArrayList;
import java.util.List;

public class Channel {

	private Long id;
	private String name;
	private List<Message> messages = new ArrayList<>();

	public Channel() {
	}

	public Channel(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void addMessage(Message message) {
		messages.add(message);
	}

	@Override
	public String toString() {
		return "Channel [id=" + id + ", name=" + name + ", messages=" + messages + "]";
	}

}
