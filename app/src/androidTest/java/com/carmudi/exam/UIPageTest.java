package com.carmudi.exam;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static java.lang.Thread.sleep;
import static org.hamcrest.core.IsAnything.anything;

/**
 * Created by cicciolina on 5/19/18.
 */

@RunWith(AndroidJUnit4.class)
public class UIPageTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule= new ActivityTestRule<>(MainActivity.class);

    @Test
    public void viewCarDetail() throws InterruptedException {
        sleep(5000);
        onView(withId(R.id.spinner_sort_list)).check(matches(isDisplayed()));
        onData(anything()).inAdapterView(withId(R.id.list_car_item)).atPosition(0).perform(click());
        onView(withId(R.id.imgSwitcher)).check(matches(isDisplayed()));
    }

}
