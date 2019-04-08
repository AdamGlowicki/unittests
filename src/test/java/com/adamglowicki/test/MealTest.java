package com.adamglowicki.test;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class MealTest {

    @Test
    void shouldReturnDiscountedPrice() {
        //given
        Meal meal = new Meal(35);

        //when
        int discountedPrice = meal.getDiscountedPrice(7);

        //then
        assertEquals(28, discountedPrice);
        assertThat(discountedPrice, equalTo(28));
    }

    @Test
    void referencesToTheSameObjectsShouldBeEqual() {
        //given
        Meal meal = new Meal(10);
        Meal meal2 = meal;

        assertSame(meal, meal2);
        assertThat(meal, sameInstance(meal2));
    }

    @Test
    void referencesDiffrentObjectsShouldNotBeEqual() {
        //given
        Meal meal = new Meal(10);
        Meal meal2 = new Meal(2);

        assertNotSame(meal, meal2);
        assertThat(meal, not(sameInstance(meal2)));
    }

    @Test
    void twoMealsShouldBeEqualWhenPriceAndNameAreTheSame() {

        //given
        Meal meal1 = new Meal(10, "pikca");
        Meal meal2 = new Meal(10, "pikca");

        //then
        assertEquals(meal1, meal2);
    }

    @Test
    void  exceptionShouldBeThrownIdDiscountIsHigherThanPrice() {
        //given
        final Meal meal = new Meal(13, "Chips");

        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> meal.getDiscountedPrice(40));


    }
}