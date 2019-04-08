package com.adamglowicki.test;

public class Account {

    private boolean active;
    private Address defoultDeliveryAdress;

    public Account() {
        this.active = false;
    }

    public void activate() {
        this.active = true;
    }

    public boolean isActive() {
        return this.active;
    }

    public Address getDefoultDeliveryAdress() {
        return defoultDeliveryAdress;
    }

    public void setDefoultDeliveryAdress(Address defoultDeliveryAdress) {
        this.defoultDeliveryAdress = defoultDeliveryAdress;
    }
}
