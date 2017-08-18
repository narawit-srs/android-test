package com.orbismobile.testingforandroid;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;

import com.orbismobile.testingforandroid.view.contact.ContactActivity;
import com.orbismobile.testingforandroid.view.contact.ContactAdapter;

import org.hamcrest.CustomMatcher;
import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


/**
 * Created by carlosleonardocamilovargashuaman on 8/18/17.
 */

@RunWith(AndroidJUnit4.class)
public class ContactListInstrumentedTest {

    @Rule
    public ActivityTestRule<ContactActivity> contactActivityTestRule = new ActivityTestRule<>(ContactActivity.class);

    @Test
    public void scrollToItemBelow(){

        onView(withId(R.id.rcvContact)).perform(RecyclerViewActions.actionOnItemAtPosition(50, click()));

//        contactActivityTestRule.getActivity().getResources().get
//
        onView(withText("item 50")).check(matches(isDisplayed()));

//        Matcher<ContactAdapter.ContactItemViewHolder> matcher = CustomMatcher.withTitle("A");
    }

    @Test
    public void scrollToItemBelowFold(){
        onView(withId(R.id.rcvContact)).perform(RecyclerViewActions.scrollToPosition(500));
    }


    @Test
    public void itemInMiddleOfList_hasSpecialText(){
        onView(withId(R.id.rcvContact)).perform(RecyclerViewActions.scrollToHolder(new ContactAdapter.ContactItemViewHolder()).atPosition());
    }

}
