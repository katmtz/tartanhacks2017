package edu.cmu.kat.tartanhacks2017;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;

import com.fitbit.authentication.AuthenticationConfiguration;
import com.fitbit.authentication.AuthenticationConfigurationBuilder;
import com.fitbit.authentication.AuthenticationManager;
import com.fitbit.authentication.ClientCredentials;
import com.fitbit.authentication.Scope;

/**
 * Created by kat on 2/10/17.
 */

public class FitbitAnxietyApplication extends Application {

    /**
     * Super secret API credentials.
     */
    private static final String CLIENT_ID = "2284NZ";
    private static final String CLIENT_SECRET = "77461f9e3eecc860a04bd6825b3ca894";
    private static final String REDIRECT_URL = "https://auth/fitbit";

    private static final ClientCredentials CREDENTIALS = new ClientCredentials(CLIENT_ID,CLIENT_SECRET,REDIRECT_URL);

    /**
     * LOLOL this aint that secure but uh... i dont care this is a hackathon project
     * */
    private static final String SECURE_KEY = "CVPdQNAT6fBI4rrPLEn9x0+UV84DoqLFiNHpKOPLRW0=";

    /**
     * This method sets up the authentication config needed for
     * successfully connecting to the Fitbit API. Here we include our client credentials,
     * requested scopes, and  where to return after login
     */
    public static AuthenticationConfiguration generateAuthenticationConfiguration(Context context, Class<? extends Activity> mainActivityClass) {

        return new AuthenticationConfigurationBuilder()

                .setClientCredentials(CREDENTIALS)
                .setEncryptionKey(SECURE_KEY)
                .setTokenExpiresIn(2592000L) // 30 days
                .setBeforeLoginActivity(new Intent(context, mainActivityClass))
                .addRequiredScopes(Scope.profile, Scope.settings)
                .addOptionalScopes(Scope.activity, Scope.heartrate)
                .setLogoutOnAuthFailure(true)

                .build();
    }

    /**
     * 1. When the application starts, load our keys and configure the AuthenticationManager
     */
    @Override
    public void onCreate() {
        super.onCreate();
        AuthenticationManager.configure(this, generateAuthenticationConfiguration(this, RootActivity.class));
    }
}
