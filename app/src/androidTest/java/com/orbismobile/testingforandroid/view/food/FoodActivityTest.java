package com.orbismobile.testingforandroid.view.food;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.IdlingPolicies;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.orbismobile.testingforandroid.R;
import com.orbismobile.testingforandroid.WinGokuExecutor;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by carlosleonardocamilovargashuaman on 8/31/17.
 */
@RunWith(AndroidJUnit4.class)
public class FoodActivityTest {

    WinGokuExecutor mExecutor;

    @Rule
    public ActivityTestRule<FoodActivity> foodActivityTestRule = new ActivityTestRule<FoodActivity>(FoodActivity.class);

    @Test
    public void validateSampleText(){
        onView(withId(R.id.lblMessage)).check(matches(withText("NUEVO TEXTO")));
    }

    @Test
    public void validateSampleText1(){
        Espresso.registerIdlingResources(foodActivityTestRule.getActivity().countingIdlingResource);
        onView(withId(R.id.lblMessage)).check(matches(withText("NUEVO TEXTO")));
    }

    @Test
    public void validateSampleText2(){
        Espresso.registerIdlingResources(foodActivityTestRule.getActivity().countingIdlingResource);
        onView(withId(R.id.lblMessage)).check(matches(withText("sunt aut facere repellat provident occaecati excepturi optio reprehenderit")));
    }

    @Test
    public void testIfDataLoadedIsPrintedOnScreen(){
//        System.out.println("TESTING STARTED");
//
//        // changing idling timeout
//        IdlingPolicies.setMasterPolicyTimeout(
//                60000 * 2, TimeUnit.MILLISECONDS);
//        IdlingPolicies.setIdlingResourceTimeout(
//                60000 * 2, TimeUnit.MILLISECONDS);
//
//        mExecutor = new WinGokuExecutor();
//        mExecutor.setIdleState(true);
//        foodActivityTestRule.getActivity().setCountingIdlingResource(mExecutor);
//
//        // registering IdlingResource with Espresso
//        Espresso.registerIdlingResources(mExecutor);
//
//        //checkIfEditTextsAndButtonsExist();
//        //checkIfProcessingDialogAppears();
//
//        mExecutor.setIdleState(false);
//        //checkIfLoginSnackbarAppears();
//
//        validateCurrenTextViewh();


    }

    private void validateCurrenTextViewh(){
        Espresso.registerIdlingResources(foodActivityTestRule.getActivity().countingIdlingResource);
        onView(withId(R.id.lblMessage)).check(matches(isDisplayed()));
    }

//    private void checkIfEditTextsAndButtonsExist() {
//        onView(withId(R.id.input_email)).check(matches(isDisplayed()));
//        onView(withId(R.id.input_password)).check(matches(isDisplayed()));
//        onView(withId(R.id.button_login)).check(matches(isDisplayed()));
//
//        //todo remove this INJECT method
//        injectDataForDummyTesting();
//        checkIfEditTextFieldsArentEmpty();
//        onView(withId(R.id.button_login)).perform(click());
//    }
//
//
//    private void checkIfEditTextFieldsArentEmpty() {
//        onView(withId(R.id.input_email)).check(matches(not(withText(R.string.empty_string))));
//        onView(withId(R.id.input_password)).check(matches(not(withText(R.string.empty_string))));
//    }
//
//    private void checkIfProcessingDialogAppears() {
//        onView(withText(R.string.description_login_progress_dialog)).check(matches(isDisplayed()));
//    }
//
//    private void checkIfLoginSnackbarAppears() {
//        onView(withText(R.string.login_success)).check(matches(isDisplayed()));
//
//        //unregistering the IdlingResource
//        Espresso.unregisterIdlingResources(mExecutor);
//    }
//
//    private void injectDataForDummyTesting() {
//        onView(withId(R.id.input_email)).perform(typeText("abcdefg"), ViewActions.closeSoftKeyboard());
//        onView(withId(R.id.input_password)).perform(typeText("abcdefghidj"), ViewActions.closeSoftKeyboard());
//    }




}