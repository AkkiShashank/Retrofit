package com.test.mandap.retrofittest.network;

import com.test.mandap.retrofittest.model.Flower;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by Shashank Gupta on 16-Aug-15.
 */
public interface api {

    @GET("/feeds/flowers.json")
    public void getData(Callback<List<Flower>> response);


}
