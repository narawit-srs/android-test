package com.orbismobile.testingforandroid;

import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.orbismobile.testingforandroid.view.pet.PetAdapter;
import com.orbismobile.testingforandroid.view.pet.PetSectionsActivity;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withTagKey;

/**
 * Created by Carlos Leonardo Camilo Vargas Huamán on 8/30/17.
 */
@RunWith(AndroidJUnit4.class)
public class PetSectionsInstrumentedTest {

    @Rule
    public ActivityTestRule<PetSectionsActivity> petSectionsActivityTestRule =
            new ActivityTestRule<PetSectionsActivity>(PetSectionsActivity.class);

    @Test
    public void clickOnAnyItem(){
        onView(withId(R.id.rcvPetSections)).perform(RecyclerViewActions.actionOnItemAtPosition(10, clickChildViewWithId()));

    }

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
                RecyclerView rcvHorizontal = view.findViewById(R.id.rcvHorizontal);
                rcvHorizontal.findViewHolderForAdapterPosition(2).itemView.performClick();
            }
        };
    }
}
