package com.softron.domain;

import com.softron.entity.UserEntity;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

/**
 * 
 * Custom User object for holding user details in authentication context.
 *
 * @author Anil Jaglan
 * @version 1.0
 */
public class CustomUser extends User implements UserDetails {

    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = -7221307130153289097L;

    private String userName;

    private String fullName;

    private String email;

    private String password;

    private String govtId;

    private String mobile;

    private List<Long> orgIds;

    private Long moduleId;

    /**
     * User information last updated time.
     */
    private LocalDate lastUpdatedOn;

    /**
     * 
     * Constructor.
     *
     * @param username
     * @param password
     * @param enabled
     * @param accountNonExpired
     * @param credentialsNonExpired
     * @param accountNonLocked
     * @param authorities
     */
    public CustomUser(final String username, final String password, final boolean enabled, final boolean accountNonExpired, final boolean credentialsNonExpired,
            final boolean accountNonLocked, final Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    /**
     * 
     * Constructor.
     *
     * @param username
     * @param password
     * @param authorities
     * @param firstName
     * @param lastName
     * @param email
     * @param realm
     */
    public CustomUser(final String username, final String password, final Collection<? extends GrantedAuthority> authorities, final String fullName, final String email) {
        super(username, password, authorities);
        this.fullName = fullName;
        this.email = email;
    }

    /**
     * 
     * Constructor.
     *
     * @param user
     * @param authorities
     */
    public CustomUser(final UserEntity user, final Collection<? extends GrantedAuthority> authorities) {
        super(user.getUserName(), user.getPassword(), user.isEnabled(), user.isAccountNonExpired(), user.isCredentialsNonExpired(), user.isAccountNonLocked(), authorities);
        this.fullName = user.getFullName();
        this.email = user.getEmail();
        this.govtId = user.getGovtId();
        this.mobile = user.getMobile();
        this.moduleId = user.getAssignedModule();
        this.orgIds = toIds(user.getOrganizations());
        this.lastUpdatedOn = user.getLastUpdatedOn();
    }

    private List<Long> toIds(String str) {
        if (StringUtils.isEmpty(str)) {
            return Collections.emptyList();
        }
        return Stream.of(str.split(",")).map(Long::parseLong).collect(Collectors.toList());
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGovtId() {
        return govtId;
    }

    public void setGovtId(String govtId) {
        this.govtId = govtId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public List<Long> getOrgIds() {
        return orgIds;
    }

    public void setOrgIds(List<Long> orgId) {
        this.orgIds = orgId;
    }

    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    public LocalDate getLastUpdatedOn() {
        return lastUpdatedOn;
    }

    public void setLastUpdatedOn(LocalDate lastUpdatedOn) {
        this.lastUpdatedOn = lastUpdatedOn;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((userName == null) ? 0 : userName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        CustomUser other = (CustomUser) obj;
        if (userName == null) {
            if (other.userName != null)
                return false;
        } else if (!userName.equals(other.userName))
            return false;
        return true;
    }
    
    

}
