package com.example.drewcarlson1123.criminalintent;

import android.app.Activity;
import android.app.Application;
import android.content.pm.ActivityInfo;
import android.os.SystemClock;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.DataInteraction;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.runner.lifecycle.ActivityLifecycleMonitorRegistry;
import android.support.test.runner.lifecycle.Stage;
import android.test.ApplicationTestCase;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.security.KeyStore;
import java.util.Collection;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */

@RunWith(AndroidJUnit4.class)
public class ApplicationTest extends ApplicationTestCase<Application> {

    private String[] mDateStrings =  new String[1];

    public ApplicationTest() {
        super(Application.class);
    }

    @Rule
    public ActivityTestRule<CrimeListActivity> mCrimeListActivityTestRule = new ActivityTestRule<>(CrimeListActivity.class);

    @Rule
    public ActivityTestRule<CrimePagerActivity> mCrimePagerActivityTestRule = new ActivityTestRule<>(CrimePagerActivity.class);

    @Test
    public void testSetDate() {
        onView(withId(R.id.crime_recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(allOf(withId(R.id.crime_date), isCompletelyDisplayed())).perform(click());
        onView(withId(R.id.dialog_date_date_picker)).perform(setDate(13, 4, 1992));
        onView(withId(R.id.dialog_date_time_picker)).perform(setTime(1, 30));
        onView(withText(containsString("OK"))).perform(click());
        onView(allOf(withId(R.id.crime_date), isCompletelyDisplayed())).perform(getDateFromButton(mDateStrings));
        Espresso.pressBack();
        mCrimeListActivityTestRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        SystemClock.sleep(100);
        onView(withId(R.id.crime_recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(allOf(withId(R.id.crime_date), isCompletelyDisplayed())).check(matches(withText(containsString("Wed May 13 01:30:00 EDT 1992"))));
    }

    public static ViewAction setDate(final int day, final int month, final int year) {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return ViewMatchers.isAssignableFrom(DatePicker.class);
            }

            @Override
            public String getDescription() {
                return null;
            }

            @Override
            public void perform(UiController uiController, View view) {
                ((DatePicker)view).updateDate(year, month, day);
                //strings[0] = view.toString();
            }
        };
    }

    public static ViewAction getDateFromButton(final String[] strings) {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return ViewMatchers.isAssignableFrom(Button.class);
            }

            @Override
            public String getDescription() {
                return null;
            }

            @Override
            public void perform(UiController uiController, View view) {
                //strings[0];
            }
        };
    }

    public static ViewAction setTime(final int hour, final int minute) {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return ViewMatchers.isAssignableFrom(TimePicker.class);
            }

            @Override
            public String getDescription() {
                return null;
            }

            @Override
            public void perform(UiController uiController, View view) {
                ((TimePicker)view).setHour(hour);
                ((TimePicker)view).setMinute(minute);
            }
        };
    }
}