package com.example.bucketlist;

import androidx.annotation.DrawableRes;

public class BucketListEntry {

    String heading;
    String description;
    int image;
    float rating;

    public BucketListEntry(String heading, String description, @DrawableRes int image, float rating) {
        this.heading = heading;
        this.description = description;
        this.image = image;
        this.rating = rating;
    }

    /* @DrawableRes - This annotation indicates that the integer parameter is a reference to a drawable resource.
        and the user cannot pass an arbitrary integer value, but must use a valid drawable resource ID defined in the app's resources.
        This helps catch errors at compile time if an invalid resource ID is used. */


}
