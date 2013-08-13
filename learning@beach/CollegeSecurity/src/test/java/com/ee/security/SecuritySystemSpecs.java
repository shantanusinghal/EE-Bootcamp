package com.ee.security;

import com.thirdparty.security.IdReader;
import com.thirdparty.security.ReaderResponse;
import com.thirdparty.security.Role;
import com.thirdparty.security.ThumbIdReader;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class SecuritySystemSpecs {

    String validId;
    String invalidId;
    Role roleValue;

    IdReader thumbReader;
    ReaderResponse response;
    Authenticator authenticator;
    SecuritySystem securitySystem;

    @Before
    public void setUp() {
        validId = "124";
        invalidId = "124";
        roleValue = Role.STUDENT;

        response = new ReaderResponse();
        thumbReader = mock(ThumbIdReader.class);
        authenticator = mock(Authenticator.class);
        securitySystem = new SecuritySystem(thumbReader, authenticator);
    }

    @Test
    public void itShouldOpenTheDoorForValidUser() {
        //Given
        response.setId(validId);
        response.setRole(roleValue);
        when(thumbReader.read()).thenReturn(response);
        when(authenticator.authenticate(response.getRole(), response.getId())).thenReturn(true);
        when(thumbReader.open()).thenReturn(true);

        //When
        boolean result = securitySystem.processScan();

        //Then
        verify(thumbReader).read();
        verify(authenticator).authenticate(roleValue, validId);
        verify(thumbReader).open();
        Assert.assertTrue(result);
    }

    @Test
    public void itShouldNotOpenTheDoorForInvalidUser() {
        //Given
        response.setId(invalidId);
        response.setRole(roleValue);
        when(thumbReader.read()).thenReturn(response);
        when(authenticator.authenticate(response.getRole(), response.getId())).thenReturn(false);
        when(thumbReader.open()).thenReturn(false);

        //When
        boolean result = securitySystem.processScan();

        //Then
        verify(thumbReader).read();
        verify(authenticator).authenticate(roleValue, invalidId);
        verify(thumbReader, times(0)).open();
        Assert.assertFalse(result);
    }
}
