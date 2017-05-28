package dietbisabesok.com.bukanitip.activity.detailrequest.service;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import dietbisabesok.com.bukanitip.data.ListOfferingData;
import dietbisabesok.com.bukanitip.data.RequestData;
import dietbisabesok.com.bukanitip.network.response.CommonResponse;

/**
 * Created by ibnumuzzakkir on 5/28/17.
 */

public class DetailRequestResponse extends CommonResponse{
    @SerializedName("list_offering")
    public List<ListOfferingData> mListOfferingDataList;
}
