package com.orbismobile.testingforandroid;

import android.support.test.espresso.DataInteraction;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.orbismobile.testingforandroid.model.entities.ContactEntity;
import com.orbismobile.testingforandroid.view.contact.ContactActivity;
import com.orbismobile.testingforandroid.view.contact.ContactAdapter;
import com.orbismobile.testingforandroid.view.longlist.LongActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;


import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasLinks;
import static android.support.test.espresso.matcher.ViewMatchers.isChecked;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

/**
 * Created by carlosleonardocamilovargashuaman on 8/17/17.
 */


@RunWith(AndroidJUnit4.class)
public class ContactInstrumentedTest {

//    @Rule
//    public ActivityTestRule<ContactActivity> contactActivityTestRule = new ActivityTestRule<ContactActivity>(ContactActivity.class);
//
//    @Test
//    public void clickOnFirstItem() {
//        onData(allOf(is(instanceOf(ContactAdapter.class))));
//    }

    private static final String TEXT_ITEM_30 = "item: 30";

    private static final String TEXT_ITEM_30_SELECTED = "30";

    private static final String TEXT_ITEM_60 = "item: 60";

    // Match the last item by matching its text.
    private static final String LAST_ITEM_ID = "item: 99";
    private static final String SECOND_ITEM_ID = "item: 1";


    @Rule
    public ActivityTestRule<LongActivity> mActivityRule = new ActivityTestRule<>(
            LongActivity.class);


    /**
     * Test that the second item in the list is present, when the screen loads initially
     */
    @Test
    public void verify_secondItem_is_visible_initially(){
        onView(withText(SECOND_ITEM_ID)).check(matches(withText("item: 1")));
    }


    /**
     * Test that the list is long enough for this sample, the last item shouldn't appear.
     */
    @Test
    public void lastItem_NotDisplayed() {
        // Last item should not exist if the list wasn't scrolled down.
        onView(withText(LAST_ITEM_ID)).check(doesNotExist());
    }

    /**
     * Check that the item is created. onData() takes care of scrolling.
     */
//    @Test
//    public void list_Scrolls() {
//        //onRow(LAST_ITEM_ID).check(matches(isCompletelyDisplayed()));
//
////        onData(hasEntry(equalTo(LongActivity.ROW_TEXT), is(str)));
////
//        //onData(hasEntry("item: 30", "item: 99")).check(matches(isCompletelyDisplayed()));
//
//
//        onData(hasEntry(equalTo(LongActivity.ROW_TEXT), is("item: 99"))).check(matches(isCompletelyDisplayed()));
//        //onData(withText("item: 2")).check(matches(isCompletelyDisplayed()));
//        //onData(hasEntry(equalTo(LongActivity.ROW_TEXT), is(str)));
//
//    }

    /**
     * Clicks on a row and checks that the activity detected the click.
     */
    @Test
    public void row_Click() {
        // Click on one of the rows.
        onRow(TEXT_ITEM_30).onChildView(withId(R.id.rowContentTextView)).perform(click());

        // Check that the activity detected the click on the first column.
        onView(withId(R.id.selection_row_value))
                .check(matches(withText(TEXT_ITEM_30_SELECTED)));
    }

    /**
     * Checks that a toggle button is checked after clicking on it.
     */
    @Test
    public void toggle_Click() {
        // Click on a toggle button.
        onRow(TEXT_ITEM_30).onChildView(withId(R.id.rowToggleButton)).perform(click());

        // Check that the toggle button is checked.
        onRow(TEXT_ITEM_30).onChildView(withId(R.id.rowToggleButton)).check(matches(isChecked()));
    }

    /**
     * Make sure that clicking on the toggle button doesn't trigger a click on the row.
     */
    @Test
    public void toggle_ClickDoesntPropagate() {
        // Click on one of the rows.
        onRow(TEXT_ITEM_30).onChildView(withId(R.id.rowContentTextView)).perform(click());

        // Click on the toggle button, in a different row.
        onRow(TEXT_ITEM_60).onChildView(withId(R.id.rowToggleButton)).perform(click());

        // Check that the activity didn't detect the click on the first column.
        onView(ViewMatchers.withId(R.id.selection_row_value))
                .check(matches(withText(TEXT_ITEM_30_SELECTED)));
    }
//

    private static DataInteraction onRow(String str) {
        return onData(hasEntry(equalTo(LongActivity.ROW_TEXT), is(str)));
    }


}
