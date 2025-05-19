package web.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LoginServiceUnitTest {
    @Test public void validCredentials() {
        assertTrue(LoginService.login("ahsan", "ahsan_pass", "1995-08-30"));
    }
    @Test public void invalidUsername() {
        assertFalse(LoginService.login("eve", "password123", "2000-01-01"));
    }
    @Test public void invalidPassword() {
        assertFalse(LoginService.login("alice", "wrongpass", "2000-01-01"));
    }
    @Test public void invalidDobFormat() {
        assertFalse(LoginService.login("alice", "password123", "01-01-2000"));
    }
    @Test public void wrongDobValue() {
        assertFalse(LoginService.login("alice", "password123", "2001-01-01"));
    }
    @Test public void nullParameters() {
        assertFalse(LoginService.login(null, "x", "2000-01-01"));
        assertFalse(LoginService.login("alice", null, "2000-01-01"));
        assertFalse(LoginService.login("alice", "password123", null));
    }
    @Test public void emptyStrings() {
        assertFalse(LoginService.login("", "", ""));
    }
}
