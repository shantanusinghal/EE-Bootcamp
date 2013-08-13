package com.college.security;

import com.thirdparty.security.Role;

public interface DataStore {

    public Role getRoleForId(String id);
}
