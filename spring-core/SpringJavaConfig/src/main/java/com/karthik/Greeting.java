package com.karthik;

public class Greeting {

	private String message;

	public Greeting() {
	}

	public Greeting(String message) {
		this.message = message;
	}

	public String getMessage() {
		System.out.println(message);
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
