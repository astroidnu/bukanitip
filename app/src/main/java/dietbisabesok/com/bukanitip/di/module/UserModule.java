package dietbisabesok.com.bukanitip.di.module;

import dagger.Module;
import dagger.Provides;
import dietbisabesok.com.bukanitip.session.LoginSession;

/**
 * Created by ibnumuzzakkir on 5/24/17.
 */
@Module
public class UserModule {
    private LoginSession mSession;

    /**
     * Constructor for injection only
     *
     * @param session
     */
    public UserModule(LoginSession session) {
        mSession = session;
    }

    public UserModule() {
        mSession = new LoginSession();
    }

    @Provides
    LoginSession getLoginSession() {
        return mSession;
    }
}
