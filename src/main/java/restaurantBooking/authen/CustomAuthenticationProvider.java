package restaurantBooking.authen;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import restaurantBooking.dao.HomeDao;
import restaurantBooking.entity.User;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	HomeDao dao;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		UsernamePasswordAuthenticationToken authenticationToken = null;
		String username = authentication.getName();
		System.out.println("Get username" + username);
		String password = authentication.getCredentials().toString();
		System.out.println("Get password" + password);

		User user = dao.findByUser(username);

		if (user != null) {
			if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
				Collection<GrantedAuthority> grantedAuthorities = getGrantedAuthority(user);
				authenticationToken = new UsernamePasswordAuthenticationToken(
						new org.springframework.security.core.userdetails.User(username, password, grantedAuthorities),
						password, grantedAuthorities);
			}
		} else {
			throw new UsernameNotFoundException("Username " + username + " not found!");
		}
		return authenticationToken;
	}

	private Collection<GrantedAuthority> getGrantedAuthority(User user) {
		Collection<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		if (user.getRole().equals("ADMIN")) {
			grantedAuthorities.add(new SimpleGrantedAuthority("ADMIN"));
		}
		grantedAuthorities.add(new SimpleGrantedAuthority("USER"));
		return grantedAuthorities;
	}
	
	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}