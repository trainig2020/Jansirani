package com.securityjwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.BeanIds;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.securityjwt.models.AuthenticateRequest;
import com.securityjwt.service.MyUserDetailService;
import com.securityjwt.util.Util;

@RestController
public class HomeController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private MyUserDetailService userDetailService;
	
	@Autowired
	private Util util;
	
	 
	@RequestMapping("/hello")
	public String helloUser() {
		return "Hello User";
	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticateRequest authReq) throws Exception {

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authReq.getUsername(), authReq.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrectb username or password");
		}

		final UserDetails userDetails = userDetailService.loadUserByUsername(authReq.getUsername());
		final String jwt = util.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticateRequest(jwt));

	}

}
