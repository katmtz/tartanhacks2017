package com.fitbit.api.services;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.fitbit.api.APIUtils;
import com.fitbit.api.MissingScopesException;
import com.fitbit.api.ResourceLoadedHandler;
import com.fitbit.api.ResourceLoader;
import com.fitbit.api.TokenExpiredException;
import com.fitbit.api.models.HeartRate;
import com.fitbit.authentication.AuthenticationManager;
import com.fitbit.authentication.Scope;

/**
 * Created by kat on 2/11/17.
 * For intra-day heartrate service.
 */

public class HeartrateService {

    private final static String HEARTRATE_URL = "https://api.fitbit.com/1/user/-/activities/heart/date/today/1d/1sec/time/00:00/00:01.json";
    private static final ResourceLoader<HeartRate> HEART_RATE_LOADER = new ResourceLoader<>(HEARTRATE_URL, HeartRate.class);

    public static void getHeartRate(Activity activityContext, @NonNull final ResourceLoadedHandler<HeartRate> handler) throws MissingScopesException, TokenExpiredException {
        APIUtils.validateToken(activityContext, AuthenticationManager.getCurrentAccessToken(), Scope.activity);
        HEART_RATE_LOADER.loadResource(activityContext, handler);
    }

}
