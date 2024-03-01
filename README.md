# DiceAssignment
backend-task-dice

Clone the repository :
git clone https://github.com/rajesh25502/DiceAssignment.git

set up project jdk to openJDK version 17.0.9

Edit ->  application.properties 

> create a developer account in https://developer.twitter.com/
> generate Consumer Keys and Authentication Tokens
> copy those Tokens and SecreteKeys in application.properties

spring.social.twitter.appId={}
spring.social.twitter.appSecret={}
twitter.access.token={}
twitter.access.token.secret={}

Run the Server->

API end points for Twitter API 

-> To get User Profile
http://localhost:8080/twitter/userProfile

-> To search for user ( add the screenName you want to search for )
http://localhost:8080/twitter/{screenName}

-> To get user tweets ( add the screenName you want to search for )
http://localhost:8080/twitter/{screenName}/tweets


API end points for Weather API 

-> To get weather data of perticular city using openweather API
http://localhost:8080/weather/{city}

-> To get hourly weather data of perticular city using openweather API
http://localhost:8080/weather/{city}/hourly

-> To get hourly weather data of perticular city using rapid API (add --header 'X-RapidAPI-Key: {APIKey}' )
http://localhost:8080/weather/rapid/{city}

-> To get hourly weather data of perticular city using rapid API (add --header 'X-RapidAPI-Key: {APIKey}' )
http://localhost:8080/weather/rapid/{city}/hourly







