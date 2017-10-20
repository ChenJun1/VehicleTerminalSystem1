package com.cvnavi.app;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/**
 * Created by zww on 2016/7/20.
 */
public abstract class ActivityLifeCallback implements Application.ActivityLifecycleCallbacks {
    @Override
    public void onActivityStarted(Activity activity) {
    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }
}
