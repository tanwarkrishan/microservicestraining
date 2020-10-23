package com.ibm.loginservice.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ibm.loginservice.model.User;
import com.ibm.loginservice.repository.LoginRepository;
import com.ibm.loginservice.restClient.OrderClient;

@Service
public class LoginUserDetailsService implements UserDetailsService {

	final OrderClient orderClient;
	
	@Autowired
	public LoginUserDetailsService(OrderClient orderClient) {
		this.orderClient = orderClient;
	}
	
	@Autowired
	LoginRepository loginRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = loginRepo.findByUsername(username);
		
		UserDetails userdetails = new UserDetails() {
			
			@Override
			public boolean isEnabled() {
				// TODO Auto-generated method stub
				if(null != user) {
					return true;
				} else {
					return false;	
				}
			}
			
			@Override
			public boolean isCredentialsNonExpired() {
				// TODO Auto-generated method stub
				if(null != user) {
					return true;
				} else {
					return false;	
				}
			}
			
			@Override
			public boolean isAccountNonLocked() {
				// TODO Auto-generated method stub
				if(null != user) {
					return true;
				} else {
					return false;	
				}
			}
			
			@Override
			public boolean isAccountNonExpired() {
				// TODO Auto-generated method stub
				if(null != user) {
					return true;
				} else {
					return false;	
				}
			}
			
			@Override
			public String getUsername() {
				// TODO Auto-generated method stub
				return user.getUsername();
			}
			
			@Override
			public String getPassword() {
				// TODO Auto-generated method stub
				return user.getPassword();
			}
			
			@Override
			public Collection<? extends GrantedAuthority> getAuthorities() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		return userdetails;
	}
	
	public ResponseEntity<?> createOrder(String authorization, Long id){
		return ResponseEntity.ok().body(orderClient.createOrder(authorization, id));
	}

}
