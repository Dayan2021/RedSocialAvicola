package com.redsoc.redsocialavicola.providers;

import com.redsoc.redsocialavicola.models.FCMBody;
import com.redsoc.redsocialavicola.models.FCMResponse;
import com.redsoc.redsocialavicola.retrofit.IFCMApi;
import com.redsoc.redsocialavicola.retrofit.RetrofitClient;

import retrofit2.Call;

public class NotificationProvider {

    private String url = "https://fcm.googleapis.com";

    public NotificationProvider() {

    }

    public Call<FCMResponse> sendNotification(FCMBody body) {
        return RetrofitClient.getClient(url).create(IFCMApi.class).send(body);
    }
}
