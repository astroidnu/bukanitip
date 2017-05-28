package dietbisabesok.com.bukanitip.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by ibnumuzzakkir on 5/28/17.
 */
@Entity
public class RequestData implements Parcelable {
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
    @SerializedName("jumlah_offering")
    public int jumlah_offering;
    @SerializedName("trending")
    public int trending;

    protected RequestData(Parcel in) {
        id = in.readLong();
        title = in.readString();
        description = in.readString();
        budget = in.readString();
        status = in.readInt();
        country_id = in.readInt();
        img_url = in.readString();
        jumlah_offering = in.readInt();
        trending = in.readInt();
    }

    @Generated(hash = 1093821916)
    public RequestData(long id, String title, String description, String budget,
            int status, int country_id, String img_url, int jumlah_offering,
            int trending) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.budget = budget;
        this.status = status;
        this.country_id = country_id;
        this.img_url = img_url;
        this.jumlah_offering = jumlah_offering;
        this.trending = trending;
    }

    @Generated(hash = 1553600173)
    public RequestData() {
    }

    public static final Creator<RequestData> CREATOR = new Creator<RequestData>() {
        @Override
        public RequestData createFromParcel(Parcel in) {
            return new RequestData(in);
        }

        @Override
        public RequestData[] newArray(int size) {
            return new RequestData[size];
        }
    };

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

    public int getJumlah_offering() {
        return jumlah_offering;
    }

    public void setJumlah_offering(int jumlah_offering) {
        this.jumlah_offering = jumlah_offering;
    }

    public int getTrending() {
        return trending;
    }

    public void setTrending(int trending) {
        this.trending = trending;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(title);
        dest.writeString(description);
        dest.writeString(budget);
        dest.writeInt(status);
        dest.writeInt(country_id);
        dest.writeString(img_url);
        dest.writeInt(jumlah_offering);
        dest.writeInt(trending);
    }
}
