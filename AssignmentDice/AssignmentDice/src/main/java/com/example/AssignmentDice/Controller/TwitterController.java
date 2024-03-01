package com.example.AssignmentDice.Controller;

import com.example.AssignmentDice.Exception.CustomErrorException;
import com.example.AssignmentDice.Service.TwitterServicces;
import com.example.AssignmentDice.Service.WeatherAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/twitter")
public class TwitterController {

    @Autowired
    private Twitter twitter;
    @Autowired
    private final TwitterServicces twitterServicces;

    public TwitterController(TwitterServicces twitterServicces){
        this.twitterServicces = twitterServicces;
    }
    @GetMapping(value="/userProfile", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<TwitterProfile> userProfile(){

        TwitterProfile profile = twitterServicces.getUserProfile();

        if (profile != null) {
            return new ResponseEntity<>(profile, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value="{screenName}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<TwitterProfile> searchUser(@PathVariable final String screenName){

        TwitterProfile profile = twitterServicces.searchUserWithScreenName(screenName);

        if (profile != null) {
            return new ResponseEntity<>(profile, HttpStatus.OK);
        } else {
            //return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
           throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"User dont have access to this operation");

        }
    }

    @GetMapping(value="{screenName}/tweets", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Tweet>> searchTweets(@PathVariable final String screenName)throws NoSuchMethodError{

        List<Tweet> tweets = twitterServicces.searchUserTweets(screenName);

        if (tweets != null) {
            return new ResponseEntity<>(tweets, HttpStatus.OK);
        } else {
            throw new CustomErrorException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Access denied for user",
                    tweets
            );
        }
    }

}
