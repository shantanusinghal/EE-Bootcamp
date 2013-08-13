package com.thirdparty.security;

public enum Role {

    NONE,
    STUDENT,
    TEACHER;

    public boolean canAssume(Role role) {
        return this.ordinal() >= role.ordinal();
    }
}
