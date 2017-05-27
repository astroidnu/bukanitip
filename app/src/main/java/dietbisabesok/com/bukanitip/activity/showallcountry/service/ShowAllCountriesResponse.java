package dietbisabesok.com.bukanitip.activity.showallcountry.service;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import dietbisabesok.com.bukanitip.data.CountryData;
import dietbisabesok.com.bukanitip.network.response.CommonResponse;

/**
 * Created by ibnumuzzakkir on 5/27/17.
 */

public class ShowAllCountriesResponse extends CommonResponse {
    @SerializedName("list_iklan")
    List<CountryData> countryDataList;
}
