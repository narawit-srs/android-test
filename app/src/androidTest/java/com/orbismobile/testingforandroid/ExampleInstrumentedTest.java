package com.orbismobile.testingforandroid;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.orbismobile.testingforandroid.view.login.LoginActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityTestRule<LoginActivity> loginActivityTestRule = new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void clickLoginButton() {
        String email = "carlos@gmail.com";
        String password = "password";

        //type in email
        onView(withId(R.id.txtEmail)).perform(typeText(email), closeSoftKeyboard());

        //type in password
        onView(withId(R.id.txtPassword)).perform(typeText(password), closeSoftKeyboard());

        //click on login button
        onView(withId(R.id.btnLogin)).perform(click());

        //verify that succes screen shows
        String successString = "You're welcome! carlos@gmail.com";
        onView(withText(successString)).check(matches(isDisplayed()));
    }

}
