package com.codepath.apps.restclienttemplate.models;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TweetDao {
    //User.* = needed to include the attributes of an user

    @Query("SELECT Tweet.body As tweet_body, Tweet.createdAt AS tweet_createdAt, Tweet.id AS tweet_id, User.* " +
            "FROM Tweet INNER JOIN User ON Tweet.userId = User.id ORDER BY Tweet.createdAt DESC LIMIT 5")
    List<TweetWithUser> recentItems();  //get back sql query on tweet table

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertModel(Tweet... tweets);


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertModel(User... users);
}
