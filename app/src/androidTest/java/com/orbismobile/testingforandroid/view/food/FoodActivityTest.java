package com.orbismobile.testingforandroid.view.food;

import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.orbismobile.testingforandroid.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by carlosleonardocamilovargashuaman on 8/31/17.
 */
@RunWith(AndroidJUnit4.class)
public class FoodActivityTest {

    @Rule
    public ActivityTestRule<FoodActivity> foodActivityTestRule = new ActivityTestRule<FoodActivity>(FoodActivity.class);

//    @Test
//    public void validateSampleText(){
//        onView(withId(R.id.lblMessage)).check(matches(withText("NUEVO TEXTO")));
//    }
//
//    @Test
//    public void validateSampleText1(){
//        Espresso.registerIdlingResources(foodActivityTestRule.getActivity().countingIdlingResource);
//        onView(withId(R.id.lblMessage)).check(matches(withText("NUEVO TEXTO")));
//    }

    @Test
    public void validateSampleText2(){
        Espresso.registerIdlingResources(foodActivityTestRule.getActivity().countingIdlingResource);
        onView(withId(R.id.lblMessage)).check(matches(withText("sunt aut facere repellat provident occaecati excepturi optio reprehenderit")));
    }

}