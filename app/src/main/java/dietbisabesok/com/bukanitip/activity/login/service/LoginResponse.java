package dietbisabesok.com.bukanitip.activity.login.service;

import com.google.gson.annotations.SerializedName;

import dietbisabesok.com.bukanitip.network.response.CommonResponse;

/**
 * Created by ibnumuzzakkir on 5/25/17.
 */

public class LoginResponse extends CommonResponse {
    @SerializedName("user_id")
    public long user_id;
    @SerializedName("user_name")
    public String user_name;
    @SerializedName("token")
    public String token;
    @SerializedName("email")
    public String email;
    @SerializedName("confirmed_phone")
    public String confirmed_phone;
    @SerializedName("omninkey")
    public String omni_key;
}
