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
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.not;

@RunWith(AndroidJUnit4.class)
public class DetailActivityTest {

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
    public void checkNullSATscores() {
        //If SAT scores are null or "N/A"
        //School does not have SAT data available
        //Opens the Detail Activity
        onView(withId(R.id.school_list_recycler))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        onView(withId(R.id.critical_reading_score))
                .check(matches(withText("N/A")));

        onView(withId(R.id.math_score))
                .check(matches(withText("N/A")));

        onView(withId(R.id.writing_score))
                .check(matches(withText("N/A")));
    }

    @Test
    public void checkSATScores() {
        //Checking if SAT scores are not N/A
        //If not N/A, there is an associated average with the school
        onView(withId(R.id.school_list_recycler))
                .perform(RecyclerViewActions.actionOnItemAtPosition(2, click()));

        onView(withId(R.id.number_of_test_takers))
                .check(matches(not(matches(withText("N/A")))));

        onView(withId(R.id.critical_reading_score))
                .check(matches(not(matches(withText("N/A")))));

        onView(withId(R.id.math_score))
                .check(matches(not(matches(withText("N/A")))));

        onView(withId(R.id.writing_score))
                .check(matches(not(matches(withText("N/A")))));
    }
}
