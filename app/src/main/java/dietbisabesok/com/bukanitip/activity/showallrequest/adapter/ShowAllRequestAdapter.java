package dietbisabesok.com.bukanitip.activity.showallrequest.adapter;

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

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import dietbisabesok.com.bukanitip.R;
import dietbisabesok.com.bukanitip.activity.detailrequest.DetailRequestActivity;
import dietbisabesok.com.bukanitip.data.RequestData;
import dietbisabesok.com.bukanitip.data.RequestNitipData;
import dietbisabesok.com.bukanitip.helper.CurrencyHelper;

/**
 * Created by ibnumuzzakkir on 5/28/17.
 */

public class ShowAllRequestAdapter extends RecyclerView.Adapter<ShowAllRequestAdapter.ViewHolder> {
    private Context mContext;
    List<RequestData> requestDatas = new ArrayList<>();
    private LayoutInflater mLayoutInflater;

    public ShowAllRequestAdapter(Context context){
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    public void setData(List<RequestData> requestDatas){
        this.requestDatas = requestDatas;
        notifyDataSetChanged();
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = mLayoutInflater.inflate(R.layout.item_all_request, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        RequestData requestData = requestDatas.get(position);
        Glide.with(mContext)
                .load(requestData.img_url)
                .placeholder(R.drawable.borobudur)
                .into(holder.mImageView);
        holder.mBudget.setText(CurrencyHelper.CurrencyHelper(Long.valueOf(requestData.budget)));
        holder.mCountry.setText(requestData.country_name);
        holder.mTitle.setText(requestData.title);
        holder.mItem.setOnClickListener(new View.OnClickListener() {
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
        return requestDatas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mBudget;
        TextView mCountry;
        TextView mTitle;
        TextView mUsername;
        ImageView mImageView;
        CardView mItem;
        public ViewHolder(View itemView) {
            super(itemView);
            mBudget = (TextView)itemView.findViewById(R.id.all_request_budget);
            mCountry = (TextView)itemView.findViewById(R.id.all_request_country_name);
            mTitle = (TextView)itemView.findViewById(R.id.all_request_title);
            mUsername = (TextView)itemView.findViewById(R.id.all_request_username);
            mImageView = (ImageView) itemView.findViewById(R.id.all_request_imageview);
            mItem = (CardView) itemView.findViewById(R.id.all_request_item);
        }
    }
}
