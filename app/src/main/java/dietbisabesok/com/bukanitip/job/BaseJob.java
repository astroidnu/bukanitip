package dietbisabesok.com.bukanitip.job;

import android.support.annotation.IntDef;

import com.path.android.jobqueue.Job;
import com.path.android.jobqueue.Params;
import com.path.android.jobqueue.RetryConstraint;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import dietbisabesok.com.bukanitip.di.component.AppComponent;
import dietbisabesok.com.bukanitip.network.NetworkError;
import dietbisabesok.com.bukanitip.task.exception.NetworkException;

/**
 * Created by ibnumuzzakkir on 5/24/17.
 */

abstract public class BaseJob extends Job {

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({UI_HIGH, BACKGROUND})
    public @interface Priority {

    }

    public static final int UI_HIGH = 10;
    public static final int BACKGROUND = 1;

    protected Throwable mThrowable = null;

    public BaseJob(Params params) {
        super(params);
    }

    protected boolean shouldRetry(Throwable throwable) {
        if (throwable instanceof NetworkException) {
            NetworkException exception = (NetworkException) throwable;
            return exception.shouldRetry();
        }
        return true;
    }

    public void inject(AppComponent appComponent) {
    }

    @Override
    protected RetryConstraint shouldReRunOnThrowable(Throwable throwable, int runCount,
                                                     int maxRunCount) {
        mThrowable = throwable;
        return RetryConstraint.CANCEL;
    }

}
