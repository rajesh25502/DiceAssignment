package com.example.AssignmentDice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TwitterServicces {
    @Autowired
    private Twitter twitter;

    public TwitterProfile getUserProfile() {
        TwitterProfile twitterProfile = twitter.userOperations().getUserProfile();
        if (twitterProfile!=null) {
            return twitterProfile;
        } else {
            return null;
        }
    }
    public TwitterProfile searchUserWithScreenName(String screenName) {
        TwitterProfile profile = twitter.userOperations().getUserProfile(screenName);
        if (profile!=null) {
            return profile;
        } else {
            return null;
        }
    }

    public List<Tweet> searchUserTweets(String screenName) {
        List<Tweet> tweets = twitter.timelineOperations().getUserTimeline(screenName);
        if (tweets!=null) {
            return tweets;
        } else {
            return null;
        }
    }
}
