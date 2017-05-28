package dietbisabesok.com.bukanitip.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ibnumuzzakkir on 5/28/17.
 */

public class ListOfferingData  implements Parcelable{
    @SerializedName("id_offering")
    public long id_offering;
    @SerializedName("name")
    public String name;
    @SerializedName("price")
    public int price;
    @SerializedName("day_estimation")
    public int day_estimation;
    @SerializedName("description")
    public String description;
    @SerializedName("status_offering")
    public String status_offering;

    protected ListOfferingData(Parcel in) {
        id_offering = in.readLong();
        name = in.readString();
        price = in.readInt();
        day_estimation = in.readInt();
        description = in.readString();
        status_offering = in.readString();
    }

    public static final Creator<ListOfferingData> CREATOR = new Creator<ListOfferingData>() {
        @Override
        public ListOfferingData createFromParcel(Parcel in) {
            return new ListOfferingData(in);
        }

        @Override
        public ListOfferingData[] newArray(int size) {
            return new ListOfferingData[size];
        }
    };

    public long getId_offering() {
        return id_offering;
    }

    public void setId_offering(long id_offering) {
        this.id_offering = id_offering;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDay_estimation() {
        return day_estimation;
    }

    public void setDay_estimation(int day_estimation) {
        this.day_estimation = day_estimation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus_offering() {
        return status_offering;
    }

    public void setStatus_offering(String status_offering) {
        this.status_offering = status_offering;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id_offering);
        dest.writeString(name);
        dest.writeInt(price);
        dest.writeInt(day_estimation);
        dest.writeString(description);
        dest.writeString(status_offering);
    }
}
