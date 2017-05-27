package dietbisabesok.com.bukanitip.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Unique;

/**
 * Created by ibnumuzzakkir on 5/27/17.
 */
@Entity
public class CountryData implements Parcelable{
    @Unique
    @Id
    @SerializedName("id")
    public long id;
    @SerializedName("name")
    public String name;
    @SerializedName("icon_image")
    public String icon_image;
    @SerializedName("background_image")
    public String background_image;
    @SerializedName("jumlah_titipan")
    public long jumlah_titipan;
    @SerializedName("jumlah_diaspora")
    public long jumlah_diaspora;
    @SerializedName("favorite")
    public int favorite;


    protected CountryData(Parcel in) {
        id = in.readLong();
        name = in.readString();
        icon_image = in.readString();
        background_image = in.readString();
        jumlah_titipan = in.readLong();
        jumlah_diaspora = in.readLong();
        favorite = in.readInt();
    }

    @Generated(hash = 284297235)
    public CountryData(long id, String name, String icon_image,
            String background_image, long jumlah_titipan, long jumlah_diaspora,
            int favorite) {
        this.id = id;
        this.name = name;
        this.icon_image = icon_image;
        this.background_image = background_image;
        this.jumlah_titipan = jumlah_titipan;
        this.jumlah_diaspora = jumlah_diaspora;
        this.favorite = favorite;
    }

    @Generated(hash = 477039901)
    public CountryData() {
    }

    public static final Creator<CountryData> CREATOR = new Creator<CountryData>() {
        @Override
        public CountryData createFromParcel(Parcel in) {
            return new CountryData(in);
        }

        @Override
        public CountryData[] newArray(int size) {
            return new CountryData[size];
        }
    };

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

    public String getIcon_image() {
        return icon_image;
    }

    public void setIcon_image(String icon_image) {
        this.icon_image = icon_image;
    }

    public String getBackground_image() {
        return background_image;
    }

    public void setBackground_image(String background_image) {
        this.background_image = background_image;
    }

    public long getJumlah_titipan() {
        return jumlah_titipan;
    }

    public void setJumlah_titipan(long jumlah_titipan) {
        this.jumlah_titipan = jumlah_titipan;
    }

    public long getJumlah_diaspora() {
        return jumlah_diaspora;
    }

    public void setJumlah_diaspora(long jumlah_diaspora) {
        this.jumlah_diaspora = jumlah_diaspora;
    }

    public int getFavorite() {
        return favorite;
    }

    public void setFavorite(int favorite) {
        this.favorite = favorite;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(name);
        dest.writeString(icon_image);
        dest.writeString(background_image);
        dest.writeLong(jumlah_titipan);
        dest.writeLong(jumlah_diaspora);
        dest.writeInt(favorite);
    }
}
