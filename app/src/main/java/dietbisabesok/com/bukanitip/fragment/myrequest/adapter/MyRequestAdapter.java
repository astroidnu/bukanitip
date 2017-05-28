package dietbisabesok.com.bukanitip.fragment.myrequest.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
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
import dietbisabesok.com.bukanitip.activity.detailrequest.DetailRequestActivity;
import dietbisabesok.com.bukanitip.data.RequestData;
import dietbisabesok.com.bukanitip.helper.CurrencyHelper;

/**
 * Created by ibnumuzzakkir on 5/28/17.
 */

public class MyRequestAdapter extends RecyclerView.Adapter<MyRequestAdapter.ViewHolder> {
    private Context mContext;
    private List<RequestData> mRequestDataList = new ArrayList<>();
    private LayoutInflater mLayoutInflater;

    public MyRequestAdapter(Context context){
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    public void setData(List<RequestData> dataList){
        mRequestDataList = dataList;
        notifyDataSetChanged();
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = mLayoutInflater.inflate(R.layout.item_my_request, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        RequestData requestData = mRequestDataList.get(position);
        holder.mTitle.setText(requestData.title);
        Glide.with(mContext)
                .load(requestData.img_url)
                .placeholder(R.drawable.borobudur)
                .into(holder.mImageView);
        holder.mBudget.setText(CurrencyHelper.CurrencyHelper(Long.valueOf(requestData.budget)));
        holder.mCountry.setText(requestData.country_name);
        holder.mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, DetailRequestActivity.class);
                intent.putExtra("data", requestData);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mRequestDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageView;
        TextView mTitle;
        TextView mCountry;
        TextView mBudget;
        CardView mItemView;
        public ViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.my_request_imageview);
            mItemView = (CardView) itemView.findViewById(R.id.my_request_item);
            mTitle = (TextView) itemView.findViewById(R.id.my_request_title);
            mCountry = (TextView) itemView.findViewById(R.id.my_request_country_name);
            mBudget = (TextView) itemView.findViewById(R.id.my_request_budget);
        }
    }
}
