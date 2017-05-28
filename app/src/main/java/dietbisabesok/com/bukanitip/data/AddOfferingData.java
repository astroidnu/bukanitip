package dietbisabesok.com.bukanitip.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ibnumuzzakkir on 5/28/17.
 */

public class AddOfferingData {
    @SerializedName("price")
    public int price;
    @SerializedName("description")
    public String description;
    @SerializedName("day_estimation")
    public int day_estimation;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDay_estimation() {
        return day_estimation;
    }

    public void setDay_estimation(int day_estimation) {
        this.day_estimation = day_estimation;
    }
}
