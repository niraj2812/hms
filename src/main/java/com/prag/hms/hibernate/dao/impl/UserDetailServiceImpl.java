/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prag.hms.hibernate.dao.impl;

import com.prag.hms.hibernate.dao.UserAccessDao;
import com.prag.hms.hibernate.pojo.Roles;
import com.prag.hms.hibernate.pojo.UserAccess;
import java.util.ArrayList;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author niraj
 */
public class UserDetailServiceImpl implements UserDetailsService {

    private UserAccessDao userAccessDao;

    public UserAccessDao getUserAccessDao() {
        return userAccessDao;
    }

    public void setUserAccessDao(UserAccessDao userAccessDao) {
        this.userAccessDao = userAccessDao;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserAccess user = userAccessDao.findUserByName(username);
        if (user != null) {
            String password = user.getPassword();
            boolean enabled = user.getEntityStatus().equals("ACTIVE");
            boolean accountNotExpired = user.getEntityStatus().equals("ACTIVE");
            boolean credentialsNotExpired = user.getEntityStatus().equals("ACTIVE");
            boolean accountNonLocker = user.getEntityStatus().equals("ACTIVE");
            Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            for (Roles role : user.getRoleses()) {
                authorities.add(new SimpleGrantedAuthority(role.getRoleId()));
            }

            org.springframework.security.core.userdetails.User securityUser = new org.springframework.security.core.userdetails.User(username, password, enabled, accountNotExpired, credentialsNotExpired, accountNonLocker, authorities);
            return securityUser;
        } else {
            throw new UsernameNotFoundException("User does not exists");
        }
    }
}
