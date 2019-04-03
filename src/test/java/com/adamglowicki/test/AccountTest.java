package com.adamglowicki.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void myTest() {
        Account account = new Account();

        assertFalse(account.isActive());
    }

    @Test
    @DisplayName("Check if user is becoming active")
    void checkIfUserIsActive() {
        Account account = new Account();
//        account.activate();
        assertTrue(account.isActive());
    }
}