package dietbisabesok.com.bukanitip.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ibnumuzzakkir on 5/27/17.
 */

public class CountryData {
    @SerializedName("id")
    public long id;
    @SerializedName("name")
    public String name;
    @SerializedName("image_url")
    public String image_url;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
