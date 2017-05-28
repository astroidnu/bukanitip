package dietbisabesok.com.bukanitip.activity.showallrequest.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import dietbisabesok.com.bukanitip.data.RequestNitipData;

/**
 * Created by ibnumuzzakkir on 5/28/17.
 */

public class ShowAllRequestAdapter extends RecyclerView.Adapter<ShowAllRequestAdapter.ViewHolder> {
    private Context mContext;
    List<RequestNitipData> mRequestNitipDataList = new ArrayList<>();
    private LayoutInflater mLayoutInflater;

    public ShowAllRequestAdapter(Context context){
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    public void setData(List<RequestNitipData> requestNitipDatas){
        mRequestNitipDataList = requestNitipDatas;
        notifyDataSetChanged();
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mRequestNitipDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
