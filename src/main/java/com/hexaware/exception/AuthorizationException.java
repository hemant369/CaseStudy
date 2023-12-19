package com.hexaware.exception;

public class AuthorizationException extends Exception {

	public AuthorizationException() {
		System.out.println("Wrong Aunthenctication Details");
	}
}