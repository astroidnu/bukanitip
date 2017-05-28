package dietbisabesok.com.bukanitip.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pratap.kesaboyina on 30-11-2015.
 */
public class SectionDataModel {
    private String headerTitle;
    private List<RequestData> allItemsInSection;


    public SectionDataModel() {

    }
    public SectionDataModel(String headerTitle, ArrayList<RequestData> allItemsInSection) {
        this.headerTitle = headerTitle;
        this.allItemsInSection = allItemsInSection;
    }



    public String getHeaderTitle() {
        return headerTitle;
    }

    public void setHeaderTitle(String headerTitle) {
        this.headerTitle = headerTitle;
    }

    public List<RequestData> getAllItemsInSection() {
        return allItemsInSection;
    }

    public void setAllItemsInSection(List<RequestData> allItemsInSection) {
        this.allItemsInSection = allItemsInSection;
    }


}
