package org.home.services;

import org.home.entity.Constants;
import org.home.entity.security.MongoUser;
import org.home.repositories.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MongoUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public MongoUserDetailsService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MongoUser user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(Constants.Messages.USER_NOT_FOUND);
        }

        List<SimpleGrantedAuthority> authorities =
                user.getRoles()
                        .stream()
                        .filter(Constants.Roles::exists)
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());

        return new User(user.getUsername(), user.getPassword(), authorities);
    }
}
