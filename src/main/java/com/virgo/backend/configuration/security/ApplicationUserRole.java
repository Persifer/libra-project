package com.virgo.backend.configuration.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.virgo.backend.configuration.security.ApplicationUserPermission.*;


public enum ApplicationUserRole {
    UTENTE(Sets.newHashSet()),
    POST(Sets.newHashSet()),
    ADMIN(Sets.newHashSet( USER_READ, USER_WRITE, POST_READ, POST_WRITE)),
    ADMINTRAINEE(Sets.newHashSet( USER_READ, POST_READ)); // questo ruolo può solamente leggere tutto ciò che riguarda utenti e post

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions){
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthority(){
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());

        permissions.add(new SimpleGrantedAuthority("ROLE_"+this.name()));

        return permissions;
    }
}
