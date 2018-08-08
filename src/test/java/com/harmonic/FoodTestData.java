package com.harmonic;

import com.harmonic.model.Food;
import org.assertj.core.api.Assertions;

import java.util.Arrays;

public class FoodTestData {

    public static final Food FOOD_1 = new Food(1, "food_1");
    public static final Food FOOD_2 = new Food(2, "food_2");
    public static final Food FOOD_3 = new Food(3, "food_3");

    public static Food getCreated() {
        return new Food("new created food");
    }

    public static void assertMatch(Food actual, Food expected) {
        Assertions.assertThat(actual).isEqualToComparingFieldByField(expected);
    }

    public static void assertMatch(Iterable<Food> actual, Food... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<Food> actual, Iterable<Food> expected) {
        Assertions.assertThat(actual).usingFieldByFieldElementComparator().isEqualTo(expected);
    }

}
