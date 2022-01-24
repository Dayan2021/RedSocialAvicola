package com.redsoc.redsocialavicola.retrofit;

import com.redsoc.redsocialavicola.models.FCMBody;
import com.redsoc.redsocialavicola.models.FCMResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface IFCMApi {

    @Headers({
            "Content-Type:application/json",
            "Authorization:key=AAAAJ7_lklg:APA91bGWvx7z3wu97n-yEpte6N4GcsHxHgixYdsk7bZWwWJETcA_gcD_ZcmVHqxXaal6dl1bfWKSqUEvAQOjmumKNHTGxBpPE8Lbd_pMVuMh57Sljh_sXBlPXHV3COJCAseD4gZsU5Hz"
    })


    @POST("fcm/send")
    Call<FCMResponse> send(@Body FCMBody body);
}
