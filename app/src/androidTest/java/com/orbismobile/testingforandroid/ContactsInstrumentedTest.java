package com.orbismobile.testingforandroid;

import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;

import com.orbismobile.testingforandroid.view.contact.ContactsActivity;
import com.orbismobile.testingforandroid.view.contact.ContactsAdapter;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

/**
 * Created by Carlos Leonardo Camilo Vargas Huamán on 8/27/17.
 */
@RunWith(AndroidJUnit4.class)
public class ContactsInstrumentedTest {

    @Rule
    public ActivityTestRule<ContactsActivity> activityTestRule =
            new ActivityTestRule<ContactsActivity>(ContactsActivity.class);


    @Test
    public void scrollToTheLastPosition_and_tapOnIt() {
        onView(withId(R.id.rcvContact)).perform(RecyclerViewActions.actionOnItemAtPosition(3, click()));
        onView(withId(R.id.lblContact)).check(matches(withText("Contact 3")));
    }

    @Test
    public void initially_eight_item_should_not_be_shown(){
        onView(withText("Contact 9")).check(doesNotExist());
    }

    @Test
    public void scrollToAnyItem_and_check_if_ContainsTheExpectedText() {
        onView(withId(R.id.rcvContact)).perform(RecyclerViewActions.scrollToPosition(50));
        onView(withText("Contact 50")).check(matches(isDisplayed()));

        onView(withId(R.id.rcvContact)).perform(RecyclerViewActions.scrollToPosition(30));
        onView(withText("Contact 30")).check(matches(isDisplayed()));

        onView(withId(R.id.rcvContact)).perform(RecyclerViewActions.scrollToPosition(80));
        onView(withText("Contact 80")).check(matches(isDisplayed()));

        onView(withId(R.id.rcvContact)).perform(RecyclerViewActions.scrollToPosition(6));
        onView(withText("Get hands-on with")).check(matches(isDisplayed()));

        onView(withId(R.id.rcvContact)).perform(RecyclerViewActions.scrollToPosition(99));
        onView(withText("Contact 99")).check(matches(isDisplayed()));
    }


    @Test
    public void scrollToSpecificMatcher() {
        onView(withId(R.id.rcvContact)).perform(RecyclerViewActions.scrollTo(hasDescendant(withText("Contact 80"))));
        onView(withText("Contact 80")).perform(click());
        onView(withId(R.id.lblContact)).check(matches(withText("Contact 80")));
    }

    /**
     * In this case my holder has to be special, or at least has to be different from the other,
     * because if all your holder are the same, it would not make sense
     */
    @Test
    public void scrollToSpecificViewHolder_that_is_differentFromTheOthers() {
        onView(withId(R.id.rcvContact)).perform(RecyclerViewActions.scrollToHolder(isItemViewActivated()));
    }

    @Test
    public void tapOnButtonAtSecondPosition() {
        //onView(allOf(withId(R.id.btnFake), withParentIndex(5))).perform(ContactViewActions.clickChildViewWithId());

        onView(withId(R.id.rcvContact)).perform(RecyclerViewActions.actionOnItemAtPosition(0, clickChildViewWithId()));

        //onView(allOf(withId(R.id.btnFake), withParentIndex(0
        //))).perform(RecyclerViewActions.actionOnItemAtPosition(0, scrollTo()));

//        onView(allOf(withParent(withId(R.id.rcvContact)), withId(R.id.btnFake)))
//                .perform(click());
        //onView(withId(R.id.rcvContact)).perform(RecyclerViewActions.actionOnItemAtPosition(3, click()));

        //onView(withId(R.id.lblContact)).check(matches(withText("Contact 3")));

    }


    /**
     * Custom ViewAction that perform click on specific button inside the itemView
     *
     * @return
     */
    public static ViewAction clickChildViewWithId() {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return null;
            }

            @Override
            public String getDescription() {
                return "Click on a child view with specified id.";
            }

            @Override
            public void perform(UiController uiController, View view) {
                View v = view.findViewById(R.id.btnFake);
                v.performClick();
            }
        };
    }

    public static Matcher<ContactsAdapter.ContactItemViewHolder> isItemViewActivated() {
        return new TypeSafeMatcher<ContactsAdapter.ContactItemViewHolder>() {
            @Override
            protected boolean matchesSafely(ContactsAdapter.ContactItemViewHolder item) {
                return item.itemView.isActivated();
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("ContactViewHolder's itemView activated");
            }
        };
    }
}
