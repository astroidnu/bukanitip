package dietbisabesok.com.bukanitip.network;


import android.net.Credentials;

import java.util.HashMap;
import java.util.Map;

import dietbisabesok.com.bukanitip.activity.home.service.FetchDetailUserResponse;
import dietbisabesok.com.bukanitip.activity.login.service.LoginResponse;
import dietbisabesok.com.bukanitip.network.response.CommonResponse;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Url;
import rx.Observable;
import rx.Observer;

/**
 * Created by ibnumuzzakkir on 5/25/17.
 */

public interface NetworkService {
    @POST("authenticate.json")
    Observable<LoginResponse> userLogin(@Header("Authorization") String credential);
    @GET("users/{user_id}/profile.json")
    Observable<FetchDetailUserResponse> userInfo(@Path("user_id") String userId);
    @POST
    @FormUrlEncoded
    Observable<CommonResponse>updateUserInfo(@Url String url, @FieldMap HashMap<String, String> data);
}
