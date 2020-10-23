package com.ibm.loginservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.loginservice.model.AuthenticationRequest;
import com.ibm.loginservice.model.AuthenticationResponse;
import com.ibm.loginservice.service.LoginUserDetailsService;
import com.ibm.loginservice.util.JwtUtil;

@RestController
public class LoginController {

	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private LoginUserDetailsService loginService;
	
	@Autowired
	private JwtUtil jwtTokenUtil;
	
	@GetMapping("/hello")
	public String home() {
		return ("<h1>Welcome</h1>");
	}
	
	@GetMapping("/order")
	public ResponseEntity<?> createOrder(@RequestHeader("Authorization") String authorization, @RequestParam(value = "id") Long id){
		
		return loginService.createOrder(authorization, id);
				
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authRequest) throws Exception{
		try {
			authManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}
		
		final UserDetails userDetails = loginService.loadUserByUsername(authRequest.getUsername());
		
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
}
