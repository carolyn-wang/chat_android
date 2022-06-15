package com.example.simplechat;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.livequery.ParseLiveQueryClient;
import com.parse.livequery.SubscriptionHandling;

import java.net.URISyntaxException;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public class ChatApplication extends Application {
    private final String applicationId = "BgMeRhXN4Mfsr4iu7cg2PJPITPJgn9T4meopyWPG";
    private final String clientKey = "r6fZMD0BL8dZx0pVlYemVJbHwqaBtIRqO19SX40c";
    private final String server = "https://parseapi.back4app.com/";

    @Override
    public void onCreate() {
        super.onCreate();
        ParseObject.registerSubclass(Message.class);
        // Use for monitoring Parse network traffic
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        // Can be Level.BASIC, Level.HEADERS, or Level.BODY
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        // any network interceptors must be added with the Configuration Builder given this syntax
        builder.networkInterceptors().add(httpLoggingInterceptor);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId(applicationId) // provided in Lab instructions
                .clientKey(clientKey) // provided in Lab instructions
                .clientBuilder(builder)
                .server(server).build());  // provided in Lab instructions

    }
}
