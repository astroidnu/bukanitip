package dietbisabesok.com.bukanitip.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ibnumuzzakkir on 5/27/17.
 */

public class RequestNitipData {
    @SerializedName("title")
    public String title;
    @SerializedName("description")
    public String description;
    @SerializedName("budget")
    public String bugdet;
    @SerializedName("country_id")
    public String country_id;
}
