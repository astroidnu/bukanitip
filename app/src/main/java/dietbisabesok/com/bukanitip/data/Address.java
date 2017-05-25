package dietbisabesok.com.bukanitip.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ibnumuzzakkir on 5/25/17.
 */

public class Address {
    @SerializedName("province")
    @Expose
    private String province;
    @SerializedName("city")
    @Expose
    private String city;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
