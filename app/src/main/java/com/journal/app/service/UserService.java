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

/** Класс сервис пользователя приложения
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

    /** Метод поиска пользователя в базе данных
     * @param login - для поиска
     * @return usersRepository
     */
    public User findByLogin(String login){
        return usersRepository.findByLogin(login);
    }

    /** Метод загружает пользователя из базе данных по логину
     * @param login - для поиска
     * @return user
     * Если пользователь не существует, то
     * @throws UsernameNotFoundException - в случае отсутствия данных о пользователе в базе
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

    /** Метод для присвоения роли пользователю
     * @param roles - список ролей
     * @see GrantedAuthority
     * @see SimpleGrantedAuthority
     */
    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream().map(r -> new SimpleGrantedAuthority(r.getName())).collect(Collectors.toList());
    }
}
