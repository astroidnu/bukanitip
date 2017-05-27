package dietbisabesok.com.bukanitip.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ibnumuzzakkir on 5/28/17.
 */

public class MyRequestData {
    @SerializedName("id")
    public long id;
    @SerializedName("title")
    public String title;
    @SerializedName("description")
    public String description;
    @SerializedName("budget")
    public String budget;
    @SerializedName("status")
    public int status;
    @SerializedName("country_id")
    public int country_id;
    @SerializedName("img_url")
    public String img_url;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }
}
