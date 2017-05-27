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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBugdet() {
        return bugdet;
    }

    public void setBugdet(String bugdet) {
        this.bugdet = bugdet;
    }

    public String getCountry_id() {
        return country_id;
    }

    public void setCountry_id(String country_id) {
        this.country_id = country_id;
    }
}
