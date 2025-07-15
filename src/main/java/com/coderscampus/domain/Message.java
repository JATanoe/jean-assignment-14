package com.coderscampus.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Message {

	private Long id;
	private Long channelId;
	private User user;
	private String text;
	private String timestamp;

	public Message() {
		this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("hh:mm a"));
	}

	public Message(Long channelId, User user, String text) {
		this.channelId = channelId;
		this.user = user;
		this.text = text;
		this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("hh:mm a"));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getChannelId() {
		return channelId;
	}

	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp.format(DateTimeFormatter.ofPattern("hh:mm a"));
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", channelId=" + channelId + ", user=" + user +
				", text=" + text + ", timestamp=" + timestamp + "]";
	}
}
