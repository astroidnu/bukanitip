package dietbisabesok.com.bukanitip.network;


import android.net.Credentials;

import dietbisabesok.com.bukanitip.activity.login.service.LoginResponse;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by ibnumuzzakkir on 5/25/17.
 */

public interface NetworkService {
    @POST("authenticate.json")
    Observable<LoginResponse> userLogin(@Header("Authorization") String credential);
}
