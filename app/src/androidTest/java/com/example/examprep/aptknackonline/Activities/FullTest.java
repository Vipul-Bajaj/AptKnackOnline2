package com.example.examprep.aptknackonline.Activities;


import android.support.test.espresso.DataInteraction;
import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.example.examprep.aptknackonline.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class FullTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void fullTest() {
        ViewInteraction appCompatImageButton = onView(
                allOf(withId(R.id.testImageButton),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction appCompatImageButton2 = onView(
                allOf(withId(R.id.aptituteTestImageButton),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        appCompatImageButton2.perform(click());

        DataInteraction relativeLayout = onData(anything())
                .inAdapterView(allOf(withId(R.id.lstMockTest),
                        childAtPosition(
                                withClassName(is("android.widget.RelativeLayout")),
                                0)))
                .atPosition(1);
        relativeLayout.perform(click());

        ViewInteraction appCompatRadioButton = onView(
                allOf(withId(R.id.optionARadioButton), withText("A"),
                        childAtPosition(
                                allOf(withId(R.id.optionRadioGroup),
                                        childAtPosition(
                                                withClassName(is("android.widget.RelativeLayout")),
                                                5)),
                                0),
                        isDisplayed()));
        appCompatRadioButton.perform(click());

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.nextButton), withText("Next"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                7),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction appCompatRadioButton2 = onView(
                allOf(withId(R.id.optionDRadioButton), withText("D"),
                        childAtPosition(
                                allOf(withId(R.id.optionRadioGroup),
                                        childAtPosition(
                                                withClassName(is("android.widget.RelativeLayout")),
                                                5)),
                                3),
                        isDisplayed()));
        appCompatRadioButton2.perform(click());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.nextButton), withText("Next"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                7),
                        isDisplayed()));
        appCompatButton2.perform(click());

        ViewInteraction appCompatRadioButton3 = onView(
                allOf(withId(R.id.optionBRadioButton), withText("B"),
                        childAtPosition(
                                allOf(withId(R.id.optionRadioGroup),
                                        childAtPosition(
                                                withClassName(is("android.widget.RelativeLayout")),
                                                5)),
                                1),
                        isDisplayed()));
        appCompatRadioButton3.perform(click());

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.nextButton), withText("Next"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                7),
                        isDisplayed()));
        appCompatButton3.perform(click());

        ViewInteraction appCompatRadioButton4 = onView(
                allOf(withId(R.id.optionCradioButton), withText("C"),
                        childAtPosition(
                                allOf(withId(R.id.optionRadioGroup),
                                        childAtPosition(
                                                withClassName(is("android.widget.RelativeLayout")),
                                                5)),
                                2),
                        isDisplayed()));
        appCompatRadioButton4.perform(click());

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.nextButton), withText("Next"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                7),
                        isDisplayed()));
        appCompatButton4.perform(click());

        ViewInteraction appCompatButton5 = onView(
                allOf(withId(android.R.id.button1), withText("OK"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                3)));
        appCompatButton5.perform(scrollTo(), click());

        pressBack();

        ViewInteraction appCompatImageButton3 = onView(
                allOf(withId(R.id.verbalTestImageButton),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatImageButton3.perform(click());

        DataInteraction relativeLayout2 = onData(anything())
                .inAdapterView(allOf(withId(R.id.lstMockTest),
                        childAtPosition(
                                withClassName(is("android.widget.RelativeLayout")),
                                0)))
                .atPosition(0);
        relativeLayout2.perform(click());

        ViewInteraction appCompatRadioButton5 = onView(
                allOf(withId(R.id.optionDRadioButton), withText("D"),
                        childAtPosition(
                                allOf(withId(R.id.optionRadioGroup),
                                        childAtPosition(
                                                withClassName(is("android.widget.RelativeLayout")),
                                                5)),
                                3),
                        isDisplayed()));
        appCompatRadioButton5.perform(click());

        ViewInteraction appCompatButton6 = onView(
                allOf(withId(R.id.nextButton), withText("Next"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                7),
                        isDisplayed()));
        appCompatButton6.perform(click());

        ViewInteraction appCompatRadioButton6 = onView(
                allOf(withId(R.id.optionBRadioButton), withText("B"),
                        childAtPosition(
                                allOf(withId(R.id.optionRadioGroup),
                                        childAtPosition(
                                                withClassName(is("android.widget.RelativeLayout")),
                                                5)),
                                1),
                        isDisplayed()));
        appCompatRadioButton6.perform(click());

        ViewInteraction appCompatButton7 = onView(
                allOf(withId(R.id.nextButton), withText("Next"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                7),
                        isDisplayed()));
        appCompatButton7.perform(click());

        ViewInteraction appCompatRadioButton7 = onView(
                allOf(withId(R.id.optionARadioButton), withText("A"),
                        childAtPosition(
                                allOf(withId(R.id.optionRadioGroup),
                                        childAtPosition(
                                                withClassName(is("android.widget.RelativeLayout")),
                                                5)),
                                0),
                        isDisplayed()));
        appCompatRadioButton7.perform(click());

        ViewInteraction appCompatButton8 = onView(
                allOf(withId(R.id.nextButton), withText("Next"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                7),
                        isDisplayed()));
        appCompatButton8.perform(click());

        ViewInteraction appCompatRadioButton8 = onView(
                allOf(withId(R.id.optionDRadioButton), withText("D"),
                        childAtPosition(
                                allOf(withId(R.id.optionRadioGroup),
                                        childAtPosition(
                                                withClassName(is("android.widget.RelativeLayout")),
                                                5)),
                                3),
                        isDisplayed()));
        appCompatRadioButton8.perform(click());

        ViewInteraction appCompatButton9 = onView(
                allOf(withId(R.id.nextButton), withText("Next"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                7),
                        isDisplayed()));
        appCompatButton9.perform(click());

        ViewInteraction appCompatRadioButton9 = onView(
                allOf(withId(R.id.optionARadioButton), withText("A"),
                        childAtPosition(
                                allOf(withId(R.id.optionRadioGroup),
                                        childAtPosition(
                                                withClassName(is("android.widget.RelativeLayout")),
                                                5)),
                                0),
                        isDisplayed()));
        appCompatRadioButton9.perform(click());

        ViewInteraction appCompatButton10 = onView(
                allOf(withId(R.id.nextButton), withText("Next"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                7),
                        isDisplayed()));
        appCompatButton10.perform(click());

        ViewInteraction appCompatRadioButton10 = onView(
                allOf(withId(R.id.optionCradioButton), withText("C"),
                        childAtPosition(
                                allOf(withId(R.id.optionRadioGroup),
                                        childAtPosition(
                                                withClassName(is("android.widget.RelativeLayout")),
                                                5)),
                                2),
                        isDisplayed()));
        appCompatRadioButton10.perform(click());

        ViewInteraction appCompatButton11 = onView(
                allOf(withId(R.id.nextButton), withText("Next"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                7),
                        isDisplayed()));
        appCompatButton11.perform(click());

        ViewInteraction appCompatRadioButton11 = onView(
                allOf(withId(R.id.optionDRadioButton), withText("D"),
                        childAtPosition(
                                allOf(withId(R.id.optionRadioGroup),
                                        childAtPosition(
                                                withClassName(is("android.widget.RelativeLayout")),
                                                5)),
                                3),
                        isDisplayed()));
        appCompatRadioButton11.perform(click());

        ViewInteraction appCompatButton12 = onView(
                allOf(withId(R.id.nextButton), withText("Next"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                7),
                        isDisplayed()));
        appCompatButton12.perform(click());

        ViewInteraction appCompatRadioButton12 = onView(
                allOf(withId(R.id.optionBRadioButton), withText("B"),
                        childAtPosition(
                                allOf(withId(R.id.optionRadioGroup),
                                        childAtPosition(
                                                withClassName(is("android.widget.RelativeLayout")),
                                                5)),
                                1),
                        isDisplayed()));
        appCompatRadioButton12.perform(click());

        ViewInteraction appCompatButton13 = onView(
                allOf(withId(R.id.nextButton), withText("Next"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                7),
                        isDisplayed()));
        appCompatButton13.perform(click());

        ViewInteraction appCompatRadioButton13 = onView(
                allOf(withId(R.id.optionARadioButton), withText("A"),
                        childAtPosition(
                                allOf(withId(R.id.optionRadioGroup),
                                        childAtPosition(
                                                withClassName(is("android.widget.RelativeLayout")),
                                                5)),
                                0),
                        isDisplayed()));
        appCompatRadioButton13.perform(click());

        ViewInteraction appCompatButton14 = onView(
                allOf(withId(R.id.nextButton), withText("Next"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                7),
                        isDisplayed()));
        appCompatButton14.perform(click());

        ViewInteraction appCompatRadioButton14 = onView(
                allOf(withId(R.id.optionDRadioButton), withText("D"),
                        childAtPosition(
                                allOf(withId(R.id.optionRadioGroup),
                                        childAtPosition(
                                                withClassName(is("android.widget.RelativeLayout")),
                                                5)),
                                3),
                        isDisplayed()));
        appCompatRadioButton14.perform(click());

        ViewInteraction appCompatButton15 = onView(
                allOf(withId(R.id.nextButton), withText("Next"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                7),
                        isDisplayed()));
        appCompatButton15.perform(click());

        ViewInteraction appCompatButton16 = onView(
                allOf(withId(android.R.id.button1), withText("OK"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                3)));
        appCompatButton16.perform(scrollTo(), click());

        pressBack();

        ViewInteraction appCompatImageButton4 = onView(
                allOf(withId(R.id.selfAssesmentImageButton),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        appCompatImageButton4.perform(click());

        pressBack();

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
}
