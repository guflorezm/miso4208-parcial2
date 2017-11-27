package org.gnucash.android.ui.account;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.gnucash.android.R;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MyMutant429Test {

    @Rule
    public ActivityTestRule<AccountsActivity> mActivityTestRule = new ActivityTestRule<>(AccountsActivity.class);

    @Test
    public void myMutant429Test() {

        ViewInteraction menuButton = onView( allOf(withParent(withId(R.id.toolbar)), withContentDescription("Navigation drawer opened"), isDisplayed()));
        menuButton.perform(click());

        ViewInteraction reportsText = onView(allOf(withId(R.id.design_menu_item_text), withText("Reports")));
        reportsText.check(matches(isDisplayed()));
        reportsText.perform(click());

        ViewInteraction sheetButton = onView( allOf(withId(R.id.btn_balance_sheet), withText("Sheet"), isDisplayed()));
        sheetButton.perform(click());

        ViewInteraction balanceSheetText = onView(allOf(withText("Balance Sheet"), isDisplayed()));
        balanceSheetText.check(matches(withText("Balance Sheet")));

        ViewInteraction netWorthText = onView(allOf(withText("Net Worth"), isDisplayed()));
        netWorthText.check(matches(withText("Net Worth")));

    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }

    private static void sleep(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
