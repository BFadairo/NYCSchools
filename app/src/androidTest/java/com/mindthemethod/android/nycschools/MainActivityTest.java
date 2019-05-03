package com.mindthemethod.android.nycschools;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.mindthemethod.android.nycschools.view.MainActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    private static final int currentSchool = 0;

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule
            = new ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void waitForLoad() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void fragmentIsDisplayed() {
        onView(withId(R.id.fragment_container))
                .check(matches(isDisplayed()));
    }

    @Test
    public void recyclerviewIsLoaded() {
        onView(withId(R.id.school_list_recycler))
                .perform(RecyclerViewActions.actionOnItemAtPosition(100, scrollTo()));

        onView(withId(R.id.school_list_recycler))
                .check(matches(hasDescendant(withText("Academy of Finance and Enterprise"))));
    }

    @Test
    public void canClickOnSchool() {
        //This action should click on the associated school
        //item at position 0
        //Should then open up the detail activity
        onView(withId(R.id.school_list_recycler))
                .perform(RecyclerViewActions.actionOnItemAtPosition(currentSchool, click()));
    }
}
