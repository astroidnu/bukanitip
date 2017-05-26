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
import dietbisabesok.com.bukanitip.data.SectionDataModel;

/**
 * Created by ibnumuzzakkir on 5/25/17.
 */

public class HomeAdapterHorizontal extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<SectionDataModel> mSectionDataModelList = new ArrayList<>();
    private LayoutInflater mLayoutInflater;
    private Context mContext;

    public HomeAdapterHorizontal(Context context){
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    public void setDataList(List<SectionDataModel> sectionDataModels){
        if(sectionDataModels != null){
            mSectionDataModelList.addAll(sectionDataModels);
            notifyDataSetChanged();
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.item_trending_request, parent, false);
        return new TrendingRequestVH(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mSectionDataModelList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.item_section;
    }


    public class TrendingRequestVH extends RecyclerView.ViewHolder {
        TextView mTitle;
        public TrendingRequestVH(View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.trending_title);
        }
    }
}
