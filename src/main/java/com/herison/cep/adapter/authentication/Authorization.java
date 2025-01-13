package com.herison.cep.adapter.authentication;

import com.herison.cep.adapter.outbound.repository.authentication.GetUser;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Authorization implements UserDetailsService {

    private final GetUser getUser;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return getUser.findByLogin(username);
    }
}
