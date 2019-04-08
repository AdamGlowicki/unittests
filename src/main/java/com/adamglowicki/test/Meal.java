package com.adamglowicki.test;

public class Meal {

    private int price;
    private String name;

    public Meal(int price, String name) {
        this.price = price;
        this.name = name;
    }

    public Meal(int price) {

    }

    public int getPrice() {
        return price;
    }

    public int getDiscountedPrice(int discount) {

        if(discountBiggerThanPrice(discount)) {
            throw new IllegalArgumentException("Discount can not be higher than price!");
        }

        return this.price - discount;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Meal meal = (Meal) o;

        if (price != meal.price) return false;
        return name != null ? name.equals(meal.name) : meal.name == null;
    }

    private boolean discountBiggerThanPrice(int discount) {
        return (discount > this.price);
    }

    @Override
    public int hashCode() {
        int result = price;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
