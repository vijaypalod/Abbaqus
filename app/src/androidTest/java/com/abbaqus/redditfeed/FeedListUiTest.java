package com.abbaqus.redditfeed;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import android.support.test.rule.ActivityTestRule;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

/**
 * Abbaqus
 * Created by Administrator on 23-07-2018.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class FeedListUiTest {

    private static final int ITEM_BELOW_THE_FOLD = 40;

    @Rule
    public ActivityTestRule<RedditFeedListActivity> mActivityRule = new ActivityTestRule<>(
            RedditFeedListActivity.class);

    @Test
    public void scrollToBottom() {
        // First scroll to the position that needs to be matched and click on it.
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //TODO:Update as per in API call.
        onView(withId(R.id.rvFeed))
                .perform(RecyclerViewActions.scrollToPosition(mActivityRule.getActivity().binding.appBar.contentView.rvFeed.getAdapter().getItemCount() - 1));
/*
        onData(allOf(is(instanceOf(Reddit.class))))
                .inAdapterView(withId(R.id.rvFeed))
                .perform(RecyclerViewActions.scrollToPosition(mActivityRule.getActivity().binding.appBar.contentView.rvFeed.getAdapter().getItemCount() - 1)); // Standard ViewAction
*/

        onView(withId(R.id.rvFeed)).perform(
                RecyclerViewActions.actionOnItemAtPosition(
                        mActivityRule.getActivity().binding.appBar.contentView.rvFeed.getAdapter().getItemCount() - 1, MyViewAction.clickChildViewWithId(R.id.imgFeed)));

    }

}
