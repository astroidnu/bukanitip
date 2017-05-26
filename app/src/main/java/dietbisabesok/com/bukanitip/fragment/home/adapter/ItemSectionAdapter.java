package dietbisabesok.com.bukanitip.fragment.home.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import dietbisabesok.com.bukanitip.R;
import dietbisabesok.com.bukanitip.data.Address;
import dietbisabesok.com.bukanitip.data.Country;
import dietbisabesok.com.bukanitip.data.SectionDataModel;
import dietbisabesok.com.bukanitip.data.SectionSecondDataModel;

/**
 * Created by ibnumuzzakkir on 5/26/17.
 */

public class ItemSectionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<SectionDataModel> mSectionDataModelList = new ArrayList<>();
    private List<SectionSecondDataModel> sectionSecondDataModelList = new ArrayList<>();
    private LayoutInflater mLayoutInflater;
    private Context mContext;
    public ItemSectionAdapter(Context context){
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    public void setDataList(List<SectionDataModel> sectionDataModels,List<SectionSecondDataModel> secondDataModels ){
        if(sectionDataModels != null){
            mSectionDataModelList = sectionDataModels;
            sectionSecondDataModelList = secondDataModels;
        }
        notifyDataSetChanged();
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (viewType){
            case R.layout.item_section:
                view = mLayoutInflater.inflate(R.layout.item_section, parent, false);
                return new ItemSectionVH(view);
            case R.layout.item_section_second:
                view = mLayoutInflater.inflate(R.layout.item_section, parent, false);
                return new ItemSectionSecondVH(view);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof ItemSectionVH){
            SectionDataModel sectionDataModel  = mSectionDataModelList.get(position);
            List<Address> mAddressList = mSectionDataModelList.get(position).getAllItemsInSection();
            ((ItemSectionVH) holder).bind(sectionDataModel,mAddressList);
        }else{
            Log.d(getClass().getName(), String.valueOf(position  - (mSectionDataModelList.size() + sectionSecondDataModelList.size())) +"-" + String.valueOf(mSectionDataModelList.size() + sectionSecondDataModelList.size()));
            SectionSecondDataModel data  = sectionSecondDataModelList.get(position-mSectionDataModelList.size());
            List<Country> mAddressList = sectionSecondDataModelList.get(position-mSectionDataModelList.size()).getAllItemsInSection();
            ((ItemSectionSecondVH) holder).bind(data,mAddressList);
        }

    }

    @Override
    public int getItemCount() {
        return mSectionDataModelList.size()+ sectionSecondDataModelList.size();
    }


    @Override
    public int getItemViewType(int position) {
        if(position < mSectionDataModelList.size()){
            return R.layout.item_section;
        }else{
            return R.layout.item_section_second;
        }

    }


    public class ItemSectionVH extends RecyclerView.ViewHolder {
        TextView mTitle;
        TextView mShowAll;
        RecyclerView mRecycleView;
        public ItemSectionVH(View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.section_title);
            mShowAll = (TextView) itemView.findViewById(R.id.section_view_all);
            mRecycleView = (RecyclerView) itemView.findViewById(R.id.section_recycleview);
        }

        void bind(SectionDataModel data, List<Address> mAddressList) {
            HomeAdapterHorizontal mHomeAdapterHorizontal = new HomeAdapterHorizontal(mContext);
            mHomeAdapterHorizontal.setDataList(mAddressList);
            mTitle.setText(data.getHeaderTitle());
            mRecycleView.setLayoutManager(new GridLayoutManager(mContext,1, LinearLayoutManager.HORIZONTAL, false));
            mRecycleView.setAdapter(mHomeAdapterHorizontal);
        }
    }

    public class ItemSectionSecondVH extends RecyclerView.ViewHolder {
        TextView mTitle;
        TextView mShowAll;
        RecyclerView mRecycleView;
        public ItemSectionSecondVH(View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.section_title);
            mShowAll = (TextView) itemView.findViewById(R.id.section_view_all);
            mRecycleView = (RecyclerView) itemView.findViewById(R.id.section_recycleview);
        }

        void bind(SectionSecondDataModel data, List<Country> countryList) {
            HomeAdapterVertical mHomeAdapterVertical = new HomeAdapterVertical(mContext);
            mHomeAdapterVertical.setDataList(countryList);
            mTitle.setText(data.getHeaderTitle());
            mRecycleView.setLayoutManager(new GridLayoutManager(mContext,3, LinearLayoutManager.VERTICAL, false));
            mRecycleView.setAdapter(mHomeAdapterVertical);
        }
    }
}
