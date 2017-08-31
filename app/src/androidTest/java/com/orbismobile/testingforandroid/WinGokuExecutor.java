package com.orbismobile.testingforandroid;

import android.support.test.espresso.IdlingResource;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by carlosleonardocamilovargashuaman on 8/31/17.
 */

public class WinGokuExecutor extends ThreadPoolExecutor implements IdlingResource{

    private boolean idleStateChanged = true;
    private boolean mIsIdle = true;
    private IdlingResource.ResourceCallback mResourceCallback;

    public WinGokuExecutor() {
        super(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
    }

    public IdlingResource.ResourceCallback getResourceCallback() {
        return mResourceCallback;
    }

    public void setIdleState(boolean idle) {
        idleStateChanged = (mIsIdle == idle);
        mIsIdle = idle;
    }

    @Override
    public String getName() {
        return "WingokuExecutor";
    }

    @Override
    public boolean isIdleNow() {

        if (mIsIdle && mResourceCallback != null) {
            mResourceCallback.onTransitionToIdle();
        }

        return mIsIdle;
    }

    @Override
    public void registerIdleTransitionCallback(IdlingResource.ResourceCallback callback) {
        mResourceCallback = callback;
    }
}
