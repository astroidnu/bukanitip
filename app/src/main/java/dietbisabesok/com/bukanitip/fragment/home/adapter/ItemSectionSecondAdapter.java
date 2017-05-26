package dietbisabesok.com.bukanitip.fragment.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import dietbisabesok.com.bukanitip.R;
import dietbisabesok.com.bukanitip.data.SectionSecondDataModel;

/**
 * Created by ibnumuzzakkir on 26/05/2017.
 * Android Developer
 * Garena Indonesia
 */

public class ItemSectionSecondAdapter extends RecyclerView.Adapter<ItemSectionSecondAdapter.ViewHolder> {
    private List<SectionSecondDataModel> sectionSecondDataModelList = new ArrayList<>();
    private LayoutInflater mLayoutInflater;
    private Context mContext;
    public ItemSectionSecondAdapter(Context context){
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    public void setDataList(List<SectionSecondDataModel> sectionDataModels){
        if(sectionDataModels != null){
            sectionSecondDataModelList = sectionDataModels;
        }
        notifyDataSetChanged();
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.item_section, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SectionSecondDataModel data = sectionSecondDataModelList.get(position);
        holder.mTitle.setText(data.getHeaderTitle());
    }

    @Override
    public int getItemCount() {
        return sectionSecondDataModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTitle;
        TextView mShowAll;
        RecyclerView mRecycleView;
        public ViewHolder(View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.section_title);
            mShowAll = (TextView) itemView.findViewById(R.id.section_view_all);
            mRecycleView = (RecyclerView) itemView.findViewById(R.id.section_recycleview);
        }
    }
}
