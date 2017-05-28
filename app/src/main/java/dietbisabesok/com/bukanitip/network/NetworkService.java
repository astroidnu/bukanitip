package dietbisabesok.com.bukanitip.network;


import java.util.HashMap;

import dietbisabesok.com.bukanitip.activity.addnewrequest.service.AddNewRequestResponse;
import dietbisabesok.com.bukanitip.activity.addnewrequest.service.AddNewRequestService;
import dietbisabesok.com.bukanitip.fragment.home.service.FetchAllCountryResponse;
import dietbisabesok.com.bukanitip.activity.home.service.FetchDetailUserResponse;
import dietbisabesok.com.bukanitip.activity.login.service.LoginResponse;
import dietbisabesok.com.bukanitip.fragment.home.service.FetchAllRequestListService;
import dietbisabesok.com.bukanitip.fragment.home.service.FetchAllRequestResponse;
import dietbisabesok.com.bukanitip.fragment.myrequest.service.MyRequestServiceResponse;
import dietbisabesok.com.bukanitip.network.response.CommonResponse;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by ibnumuzzakkir on 5/25/17.
 */

public interface NetworkService {
    /*Bukalapak API*/
    @POST("authenticate.json")
    Observable<LoginResponse> userLogin(@Header("Authorization") String credential);

    @GET("users/{user_id}/profile.json")
    Observable<FetchDetailUserResponse> userInfo(@Path("user_id") String userId);
    /*Local API*/
    @POST
    @FormUrlEncoded
    Observable<CommonResponse>updateUserInfo(@Url String url, @FieldMap HashMap<String, String> data);

    @POST
    @FormUrlEncoded
    Observable<FetchAllRequestResponse>getAllRequest(@Url String url, @FieldMap HashMap<String, String> data);

    @POST
    @FormUrlEncoded
    Observable<MyRequestServiceResponse>getAllMyRequest(@Url String url, @FieldMap HashMap<String, String> data);

    @POST
    @FormUrlEncoded
    Observable<CommonResponse>getDetailRequest(@Url String url, @FieldMap HashMap<String, String> data);

    @POST
    @FormUrlEncoded
    Observable<FetchAllCountryResponse>getCountries(@Url String url, @FieldMap HashMap<String, String> data);

    @POST
    @FormUrlEncoded
    Observable<CommonResponse>postUserPosition(@Url String url, @FieldMap HashMap<String, String> data);

    @POST
    @FormUrlEncoded
    Observable<CommonResponse>getListMyOffering(@Url String url, @FieldMap HashMap<String, String> data);

    @POST
    @FormUrlEncoded
    Observable<AddNewRequestResponse>postUserRequest(@Url String url, @FieldMap HashMap<String, String> data);


}

