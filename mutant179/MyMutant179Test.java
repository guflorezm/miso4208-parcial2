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
public class MyMutant179Test {

    private static final String ACCOUNTS_TEXT = "Accounts";
    private static final String NEW_TRANSACTION_TEXT = "New transaction";
    private static final String SALARY_DEPOSIT_TEXT = "Salary deposit";

    @Rule
    public ActivityTestRule<AccountsActivity> mActivityTestRule = new ActivityTestRule<>(AccountsActivity.class);

    @Test
    public void myMutant179Test() {

        ViewInteraction accountsText = onView( allOf(withParent(withId(R.id.toolbar)), withText(ACCOUNTS_TEXT), isDisplayed()));
        accountsText.check(matches(withText(ACCOUNTS_TEXT)));

        ViewInteraction gridAssetsText = onView(allOf(withId(R.id.primary_text), withText("Assets")));
        gridAssetsText.check(matches(isDisplayed()));
        gridAssetsText.perform(click());

        ViewInteraction gridCurrentAssetsText = onView(allOf(withId(R.id.primary_text), withText("Current Assets")));
        gridCurrentAssetsText.check(matches(isDisplayed()));
        gridCurrentAssetsText.perform(click());

        ViewInteraction gridSavingsAccountText = onView(allOf(withId(R.id.primary_text), withText("Savings Account")));
        gridSavingsAccountText.check(matches(isDisplayed()));
        gridSavingsAccountText.perform(click());

        ViewInteraction floatingActionButton = onView( allOf(withId(R.id.fab_create_transaction), isDisplayed()));
        floatingActionButton.perform(click());

        ViewInteraction newTransactionText = onView( allOf(withParent(withId(R.id.toolbar)), withText(NEW_TRANSACTION_TEXT), isDisplayed()));
        newTransactionText.check(matches(withText(NEW_TRANSACTION_TEXT)));

        ViewInteraction descriptionEditText = onView(withId(R.id.input_transaction_name));
        descriptionEditText.perform(scrollTo(), replaceText(SALARY_DEPOSIT_TEXT), closeSoftKeyboard());

        ViewInteraction amountEditText = onView(withId(R.id.input_transaction_amount));
        amountEditText.perform(scrollTo(), replaceText("2000"), closeSoftKeyboard());

        ViewInteraction noteEditText = onView(withId(R.id.input_description));
        noteEditText.perform(scrollTo(), replaceText("This is the salary of the month"), closeSoftKeyboard());

        ViewInteraction actionMenuSave = onView(allOf(withId(R.id.menu_save), withText("Save"), withContentDescription("Save"), isDisplayed()));
        actionMenuSave.perform(click());

        ViewInteraction gridSalaryText = onView(allOf(withId(R.id.primary_text), withText(SALARY_DEPOSIT_TEXT)));
        gridSalaryText.check(matches(withText(SALARY_DEPOSIT_TEXT)));

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
