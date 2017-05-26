package dietbisabesok.com.bukanitip.fragment.home.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import dietbisabesok.com.bukanitip.R;
import dietbisabesok.com.bukanitip.data.Address;
import dietbisabesok.com.bukanitip.data.SectionDataModel;

/**
 * Created by ibnumuzzakkir on 5/26/17.
 */

public class ItemSectionAdapter extends RecyclerView.Adapter<ItemSectionAdapter.ItemSectionVH> {
    private List<SectionDataModel> mSectionDataModelList = new ArrayList<>();
    private LayoutInflater mLayoutInflater;
    private Context mContext;
    public ItemSectionAdapter(Context context){
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    public void setDataList(List<SectionDataModel> sectionDataModels){
        if(sectionDataModels != null){
            mSectionDataModelList = sectionDataModels;
        }
        notifyDataSetChanged();
    }
    @Override
    public ItemSectionVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.item_section, parent, false);
        return new ItemSectionVH(itemView);
    }

    @Override
    public void onBindViewHolder(ItemSectionVH holder, int position) {
        SectionDataModel sectionDataModel  = mSectionDataModelList.get(position);
        List<Address> mAddressList = mSectionDataModelList.get(position).getAllItemsInSection();
        HomeAdapterHorizontal mHomeAdapterHorizontal = new HomeAdapterHorizontal(mContext);
        mHomeAdapterHorizontal.setDataList(mAddressList);
        holder.mTitle.setText(sectionDataModel.getHeaderTitle());
        holder.mRecycleView.setLayoutManager(new GridLayoutManager(mContext,1, LinearLayoutManager.HORIZONTAL, false));
        holder.mRecycleView.setAdapter(mHomeAdapterHorizontal);
    }

    @Override
    public int getItemCount() {
        return mSectionDataModelList.size();
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
    }
}
