package com.ee.security;

import com.college.security.CollegeDataStore;
import com.college.security.DataStore;
import com.thirdparty.security.Role;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AuthenticatorSpecs {

    DataStore collegeDataStore;
    Authenticator authenticator;

    @Before
    public void setUp() throws Exception {
        collegeDataStore = mock(CollegeDataStore.class);
        authenticator = new Authenticator(collegeDataStore);
    }

    @Test
    public void itWillAuthenticateStudentToOpenStudentDoor() {
        //Given
        String idValue = "1234";
        when(collegeDataStore.getRoleForId(idValue)).thenReturn(Role.STUDENT);
        //When
        boolean result = authenticator.authenticate(Role.STUDENT, idValue);
        //Then
        verify(collegeDataStore).getRoleForId(idValue);
        Assert.assertTrue(result);
    }

    @Test
    public void itWillAuthenticateTeacherToOpenStudentDoor() {
        //Given
        String idValue = "1234";
        when(collegeDataStore.getRoleForId(idValue)).thenReturn(Role.STUDENT);
        //When
        boolean result = authenticator.authenticate(Role.TEACHER, idValue);
        //Then
        verify(collegeDataStore).getRoleForId(idValue);
        Assert.assertTrue(result);
    }

    @Test
    public void itWillNotAuthenticateStudentToOpenTeacherDoor() {
        //Given
        String idValue = "1234";
        when(collegeDataStore.getRoleForId(idValue)).thenReturn(Role.TEACHER);
        //When
        boolean result = authenticator.authenticate(Role.STUDENT, idValue);
        //Then
        verify(collegeDataStore).getRoleForId(idValue);
        Assert.assertTrue(result);
    }




}
