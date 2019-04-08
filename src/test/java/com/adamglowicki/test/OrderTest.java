package com.adamglowicki.test;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void testAssertArrayEqyals() {
        //when
        int[] ints1 = {1, 2, 3};
        int[] ints2 = {1, 2, 3};

        //then
        assertArrayEquals(ints1, ints2);
    }

    @Test
    void mealListShouldBeEmptyAfterCreationOrder() {
        //given
        Order order = new Order();

        //then
        assertThat(order.getMeals(), empty());
        assertThat(order.getMeals().size(), equalTo(0));
        assertThat(order.getMeals(), hasSize(0));
        assertThat(order.getMeals(), emptyCollectionOf(Meal.class));
    }

    @Test
    void addingMealToOrderShouldIncreaseOrderSize() {
        //given
        Order order = new Order();
        Meal meal = new Meal(25, "Sandwiches");

        //when
        order.addMeal(meal);

        //then

        assertThat(order.getMeals(), not(empty()));
        assertThat(order.getMeals(), hasItem(meal));
        assertThat(order.getMeals(), contains(meal));

        assertThat(order.getMeals().get(0).getPrice(), equalTo(15));
    }

    @Test
    void removingMealFromOrderShouldDecreseOrderSize() {
        //given
        Order order = new Order();
        Meal meal = new Meal(25, "Sandwiches");

        //when
        order.addMeal(meal);
        order.removeMeal(meal);

        //then
        assertThat(order.getMeals(), hasSize(0));
        assertThat(order.getMeals(), not(contains(meal)));
    }

    @Test
    void mealsShouldBeInCorrectOrderAfterAddingThemToOrder() {
        //given
        Order order = new Order();
        Meal meal = new Meal(25, "Sandwiches");
        Meal meal2 = new Meal(5, "Sandwiches");

        //when
        order.addMeal(meal);
        order.addMeal(meal2);

        //then
        assertThat(order.getMeals(), contains(meal, meal2));
        assertThat(order.getMeals(), containsInAnyOrder(meal2, meal));
    }

    @Test
    void testIfTwoMealAreTheSame() {
        //given
        Order order = new Order();
        Meal meal = new Meal(25, "Sandwiches");
        Meal meal2 = new Meal(5, "Sandwiches");
        Meal meal3 = new Meal(12, "Kebab");

        List<Meal> meals = Arrays.asList(meal, meal2);
        List<Meal> meals2 = Arrays.asList(meal, meal2);

        //then
        assertThat(meals, is(meals2));
    }

}