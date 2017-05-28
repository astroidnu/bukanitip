package dietbisabesok.com.bukanitip.fragment.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import dietbisabesok.com.bukanitip.R;
import dietbisabesok.com.bukanitip.data.Address;
import dietbisabesok.com.bukanitip.data.RequestData;

/**
 * Created by ibnumuzzakkir on 5/25/17.
 */

public class HomeAdapterHorizontal extends RecyclerView.Adapter<HomeAdapterHorizontal.ViewHolder> {
    private List<RequestData> mRequestDataList = new ArrayList<>();
    private LayoutInflater mLayoutInflater;
    private Context mContext;

    public HomeAdapterHorizontal(Context context){
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    public void setDataList(List<RequestData> requestDatas){
        if(requestDatas != null){
            mRequestDataList = requestDatas;
        }
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.item_trending_request, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        RequestData requestData= mRequestDataList.get(position);
        holder.mCountry.setText(requestData.country_name);
        holder.mTitle.setText(requestData.title);
        Glide.with(mContext)
                .load(requestData.img_url)
                .placeholder(R.drawable.borobudur)
                .into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return mRequestDataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.item_section;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTitle;
        ImageView mImageView;
        TextView mCountry;
        public ViewHolder(View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.trending_request_title);
            mCountry = (TextView) itemView.findViewById(R.id.trending_request_country);
            mImageView = (ImageView) itemView.findViewById(R.id.trending_request_imageview);

        }
    }
}
