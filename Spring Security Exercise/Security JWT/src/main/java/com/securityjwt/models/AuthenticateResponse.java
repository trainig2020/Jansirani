package com.securityjwt.models;

import java.io.Serializable;

public class AuthenticateResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private final String jwt;

	public AuthenticateResponse(String jwt) {
		this.jwt = jwt;
	}

	public String getJwt() {
		return jwt;
	}

}
