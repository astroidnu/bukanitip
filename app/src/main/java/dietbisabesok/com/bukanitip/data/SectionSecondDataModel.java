package dietbisabesok.com.bukanitip.data;

import java.util.ArrayList;

/**
 * Created by ibnumuzzakkir on 26/05/2017.
 * Android Developer
 * Garena Indonesia
 */

public class SectionSecondDataModel {
    private String headerTitle;
    private ArrayList<Country> allItemsInSection;


    public SectionSecondDataModel() {

    }
    public SectionSecondDataModel(String headerTitle, ArrayList<Country> allItemsInSection) {
        this.headerTitle = headerTitle;
        this.allItemsInSection = allItemsInSection;
    }



    public String getHeaderTitle() {
        return headerTitle;
    }

    public void setHeaderTitle(String headerTitle) {
        this.headerTitle = headerTitle;
    }

    public ArrayList<Country> getAllItemsInSection() {
        return allItemsInSection;
    }

    public void setAllItemsInSection(ArrayList<Country> allItemsInSection) {
        this.allItemsInSection = allItemsInSection;
    }

}
