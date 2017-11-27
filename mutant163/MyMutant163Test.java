package org.gnucash.android.ui.account;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.gnucash.android.R;
import org.gnucash.android.db.adapter.AccountsDbAdapter;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.BeforeClass;
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
public class MyMutant163Test {

    private static final String NEW_ACCOUNT_NAME = "A New Account";

    @Rule
    public ActivityTestRule<AccountsActivity> mActivityTestRule = new ActivityTestRule<>(AccountsActivity.class);

    @Test
    public void myMutant163Test() {
        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.btn_save), withText("Next"), isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.btn_save), withText("Next"), isDisplayed()));
        appCompatButton2.perform(click());

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.btn_save), withText("Next"), isDisplayed()));
        appCompatButton3.perform(click());

        ViewInteraction appCompatCheckedTextView = onView(
                allOf(withId(android.R.id.text1), withText("Disable crash reports"),
                        childAtPosition(
                                withId(android.R.id.list),
                                1),
                        isDisplayed()));
        appCompatCheckedTextView.perform(click());

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.btn_save), withText("Next"), isDisplayed()));
        appCompatButton4.perform(click());

        ViewInteraction appCompatButton5 = onView(
                allOf(withId(R.id.btn_save), withText("Done"), isDisplayed()));
        appCompatButton5.perform(click());

        sleep(1000);

        ViewInteraction appCompatButton6 = onView(
                allOf(withId(android.R.id.button1), withText("Dismiss")));
        appCompatButton6.perform(scrollTo(), click());

        ViewInteraction textView1 = onView(
                allOf(withParent(withId(R.id.toolbar)), withText("Accounts"),
                        isDisplayed()));
        textView1.check(matches(withText("Accounts")));

        ViewInteraction floatingActionButton = onView(
                allOf(withId(R.id.fab_create_account),
                        withParent(allOf(withId(R.id.coordinatorLayout),
                                withParent(withId(R.id.drawer_layout)))),
                        isDisplayed()));
        floatingActionButton.perform(click());

        ViewInteraction textView2 = onView(
                allOf(withParent(withId(R.id.toolbar)), withText("Create Account"),
                        isDisplayed()));
        textView2.check(matches(withText("Create Account")));

        ViewInteraction appCompatEditText = onView(
                withId(R.id.input_account_name));
        appCompatEditText.perform(scrollTo(), replaceText(NEW_ACCOUNT_NAME), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                withId(R.id.input_account_description));
        appCompatEditText2.perform(scrollTo(), replaceText("This is a new test account"), closeSoftKeyboard());

        ViewInteraction appCompatCheckBox = onView(
                allOf(withId(R.id.checkbox_placeholder_account), withText("Placeholder account"),
                        withParent(withId(R.id.fragment_account_form))));
        appCompatCheckBox.perform(scrollTo(), click());

        ViewInteraction appCompatCheckBox2 = onView(
                allOf(withId(R.id.checkbox_parent_account),
                        withParent(allOf(withId(R.id.layout_parent_account),
                                withParent(withId(R.id.fragment_account_form))))));
        appCompatCheckBox2.perform(scrollTo(), click());

        ViewInteraction appCompatCheckBox3 = onView(
                allOf(withId(R.id.checkbox_default_transfer_account),
                        withParent(allOf(withId(R.id.layout_default_transfer_account),
                                withParent(withId(R.id.fragment_account_form))))));
        appCompatCheckBox3.perform(scrollTo(), click());

        ViewInteraction actionMenuItemView = onView(
                allOf(withId(R.id.menu_save), withText("Save"), withContentDescription("Save"), isDisplayed()));
        actionMenuItemView.perform(click());

        sleep(1000);

        ViewInteraction actionMenuItemView1 = onView(
                allOf(withId(R.id.menu_search), withContentDescription("Search"), isDisplayed()));
        actionMenuItemView1.perform(click());

        sleep(1000);

        ViewInteraction appCompatEditText3 = onView(
                allOf(withParent(withId(R.id.search_plate)), withId(R.id.search_src_text)));
        appCompatEditText3.perform(replaceText(NEW_ACCOUNT_NAME), closeSoftKeyboard());

        onView(allOf(withId(R.id.primary_text), withText(NEW_ACCOUNT_NAME), isDisplayed())).check(matches(isDisplayed()));

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
