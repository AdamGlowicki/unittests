package com.adamglowicki.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void newlyCreatedAccountShouldNotBeActive() {
        Account account = new Account();

        assertFalse(account.isActive());
        assertThat(account.isActive(), equalTo(false));
        assertThat(account.isActive(), is(false));
    }

    @Test
    @DisplayName("Check if user is becoming active")
    void checkIfUserIsActive() {
        //given
        Account account = new Account();
        //when
        account.activate();
        //then
        assertTrue(account.isActive());
        assertThat(account.isActive(), equalTo(true));
        assertThat(account.isActive(), is(true));
    }

    @Test
    void newnyCreatedAccountShouldNotHaveDefaultDeliveryAddressSet() {
        //given
        Account account = new Account();

         //when
        Address address = account.getDefoultDeliveryAdress();

        //then
        assertNull(address);
        assertThat(address, nullValue());
    }

    @Test
    void defaultdeliveryAdressShouldBeNullAfrerBeSet() {
        //given
        Address address = new Address("Podwawelska", "221s");
        Account account = new Account();
        account.setDefoultDeliveryAdress(address);

        //when
        Address defaultAdress = account.getDefoultDeliveryAdress();

        //then
        assertNotNull(defaultAdress);
        assertThat(defaultAdress, notNullValue());
    }
}