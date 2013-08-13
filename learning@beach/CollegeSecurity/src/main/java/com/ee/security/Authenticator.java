package com.ee.security;

import com.college.security.DataStore;
import com.thirdparty.security.Role;

public class Authenticator {

    private final DataStore collegeDataStore;

    public Authenticator(DataStore collegeDataStore) {
        this.collegeDataStore = collegeDataStore;
    }

    public boolean authenticate(Role requestingRole, String id) {
        Role roleForId = collegeDataStore.getRoleForId(id);
        return requestingRole.canAssume(roleForId);
    }
}
