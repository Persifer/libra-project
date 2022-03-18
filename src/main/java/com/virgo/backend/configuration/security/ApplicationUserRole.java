package com.virgo.backend.configuration.security;

import com.google.common.collect.Sets;
import java.util.Set;
import static com.virgo.backend.configuration.security.ApplicationUserPermission.*;


public enum ApplicationUserRole {
    UTENTE(Sets.newHashSet()),
    POST(Sets.newHashSet()),
    ADMIN(Sets.newHashSet( USER_READ, USER_WRITE, POST_READ, POST_WRITE));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions){
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }
}
