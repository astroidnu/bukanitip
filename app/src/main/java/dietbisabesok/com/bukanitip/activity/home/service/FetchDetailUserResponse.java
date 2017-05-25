package dietbisabesok.com.bukanitip.activity.home.service;

import com.google.gson.annotations.SerializedName;

import dietbisabesok.com.bukanitip.data.User;
import dietbisabesok.com.bukanitip.network.response.CommonResponse;

/**
 * Created by ibnumuzzakkir on 5/25/17.
 */

public class FetchDetailUserResponse extends CommonResponse {
    @SerializedName("user")
    public User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
