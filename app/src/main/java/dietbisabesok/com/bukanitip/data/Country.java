package dietbisabesok.com.bukanitip.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ibnumuzzakkir on 26/05/2017.
 * Android Developer
 * Garena Indonesia
 */

public class Country {
    @SerializedName("country_id")
    @Expose
    private String country_id;
    @SerializedName("country_name")
    @Expose
    private String country_name;
}
