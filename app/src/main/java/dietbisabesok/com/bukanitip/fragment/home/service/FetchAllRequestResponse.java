package dietbisabesok.com.bukanitip.fragment.home.service;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import dietbisabesok.com.bukanitip.data.RequestData;
import dietbisabesok.com.bukanitip.network.response.CommonResponse;

/**
 * Created by ibnumuzzakkir on 5/28/17.
 */

public class FetchAllRequestResponse extends CommonResponse {
    @SerializedName("list_iklan")
    public List<RequestData> mListRequestData;
}
