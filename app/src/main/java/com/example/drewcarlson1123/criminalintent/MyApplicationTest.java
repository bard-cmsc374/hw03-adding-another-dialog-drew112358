package com.example.drewcarlson1123.criminalintent;


import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.widget.DatePicker;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by drewcarlson1123 on 10/18/16.
 */

@RunWith(AndroidJUnit4.class)
public class MyApplicationTest {

    @Rule
    public ActivityTestRule<CrimeListActivity> mCrimeListActivityRule = new ActivityTestRule<>(CrimeListActivity.class);

    @Test
    public void ensureTextChangesWork() {
        //onView(withId(R.id.list_item_crime_title_text_view)).perform(click());
        //onView(withId(R.id.crime_date)).perform(click());
        //setDate(13, 05, 92);
    }

//    public static ViewAction setDate(final int day, final int month, final int year) {
//        return new ViewAction() {
//            @Override
//            public Matcher<View> getConstraints() {
//                return ViewMatchers.isAssignableFrom(DatePicker.class);
//            }
//
//            @Override
//            public String getDescription() {
//                return null;
//            }
//
//            @Override
//            public void perform(UiController uiController, View view) {
//                ((DatePicker)view).updateDate(year, month, day);
//            }
//        };
//    }
}
