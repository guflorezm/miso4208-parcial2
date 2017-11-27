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
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MyMutant164Test {

    private static final String NEW_ACCOUNT_NAME = "A New Account";
    private static final String EDIT_ACCOUNT_TEXT = "Edit Account";

    @Rule
    public ActivityTestRule<AccountsActivity> mActivityTestRule = new ActivityTestRule<>(AccountsActivity.class);

    @Test
    public void myMutant164Test() {

        ViewInteraction textView1 = onView(
                allOf(withParent(withId(R.id.toolbar)), withText("Accounts"),
                        isDisplayed()));
        textView1.check(matches(withText("Accounts")));

        ViewInteraction actionMenuItemView1 = onView(
                allOf(withId(R.id.menu_search), withContentDescription("Search"), isDisplayed()));
        actionMenuItemView1.perform(click());

        sleep(1000);

        ViewInteraction searchEditText = onView(
                allOf(withParent(withId(R.id.search_plate)), withId(R.id.search_src_text)));
        searchEditText.perform(replaceText(NEW_ACCOUNT_NAME), closeSoftKeyboard());

        ViewInteraction gridResultFound = onView(allOf(withId(R.id.primary_text), withText(NEW_ACCOUNT_NAME)));
        gridResultFound.check(matches(isDisplayed()));
        gridResultFound.perform(click());

        ViewInteraction actionMenuOptions = onView(allOf(withContentDescription("More options"), isDisplayed()));
        actionMenuOptions.perform(click());

        ViewInteraction actionMenuItem = onView(allOf(withId(R.id.title), withText(EDIT_ACCOUNT_TEXT), isDisplayed()));
        actionMenuItem.perform(click());

        ViewInteraction textView2 = onView(
                allOf(withParent(withId(R.id.toolbar)), withText(EDIT_ACCOUNT_TEXT),
                        isDisplayed()));
        textView2.check(matches(withText(EDIT_ACCOUNT_TEXT)));

        ViewInteraction appCompatEditText2 = onView(
                withId(R.id.input_account_description));
        appCompatEditText2.perform(scrollTo(), replaceText("This is an edited test account"), closeSoftKeyboard());

        ViewInteraction actionMenuItemView = onView(
                allOf(withId(R.id.menu_save), withText("Save"), withContentDescription("Save"), isDisplayed()));
        actionMenuItemView.perform(click());

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
