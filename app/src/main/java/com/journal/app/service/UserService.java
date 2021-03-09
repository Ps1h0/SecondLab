package com.journal.app.service;

import com.journal.app.models.Role;
import com.journal.app.models.User;
import com.journal.app.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.stream.Collectors;

/**Class service
 * @see UserDetailsService
 * @author Nikita Platonov
 */
@Service
public class UserService implements UserDetailsService {

    private UsersRepository usersRepository;

    @Autowired
    public void setUsersRepository(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    /** Method searches user in database
     * @param login - for search
     * @return usersRepository
     */
    public User findByLogin(String login){
        return usersRepository.findByLogin(login);
    }

    /**Method loads user from database by login
     * @param login - for search
     * @return user
     * if user doesn't exist
     * @throws UsernameNotFoundException - if data about user in database absent
     */
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = findByLogin(login);
        if (user == null){
            throw new UsernameNotFoundException(String.format("Пользователь %s не найден", login));
        }
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }

    /** Method to assign role to users
     * @param roles - list of roles
     * @see GrantedAuthority
     * @see SimpleGrantedAuthority
     * @return collection of roles
     */
    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream().map(r -> new SimpleGrantedAuthority(r.getName())).collect(Collectors.toList());
    }
}
