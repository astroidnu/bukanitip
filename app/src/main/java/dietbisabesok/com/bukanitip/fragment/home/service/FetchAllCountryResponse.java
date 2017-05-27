package dietbisabesok.com.bukanitip.fragment.home.service;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import dietbisabesok.com.bukanitip.data.CountryData;
import dietbisabesok.com.bukanitip.network.response.CommonResponse;

/**
 * Created by ibnumuzzakkir on 5/27/17.
 */

public class FetchAllCountryResponse extends CommonResponse {
    @SerializedName("list_country")
    public List<CountryData> mListCountryData;
}
