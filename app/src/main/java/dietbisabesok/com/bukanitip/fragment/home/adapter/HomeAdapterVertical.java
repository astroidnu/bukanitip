package dietbisabesok.com.bukanitip.fragment.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import dietbisabesok.com.bukanitip.R;
import dietbisabesok.com.bukanitip.activity.detailcountry.DetailCountryActivity;
import dietbisabesok.com.bukanitip.data.Country;
import dietbisabesok.com.bukanitip.data.CountryData;

/**
 * Created by ibnumuzzakkir on 5/26/17.
 */

public class HomeAdapterVertical extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private List<CountryData> mListCountry = new ArrayList<>();
    private LayoutInflater mLayoutInflater;

    public HomeAdapterVertical(Context context){
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    public void setDataList(List<CountryData> countries){
        if(countries!= null){
            mListCountry = countries;
        }
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = mLayoutInflater.inflate(R.layout.item_trending_country, parent, false);
        return new CountryHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        CountryData countries = mListCountry.get(position);
        ((CountryHolder) holder).bind(countries);
    }

    @Override
    public int getItemCount() {
        return mListCountry.size();
    }


    public class CountryHolder extends RecyclerView.ViewHolder {
        TextView mTitle;
        ImageView mImageView;
        CardView mItem;
        public CountryHolder(View itemView) {
            super(itemView);
            mItem = (CardView) itemView.findViewById(R.id.country_item);
            mImageView = (ImageView) itemView.findViewById(R.id.country_thumbnail_imageview);
            mTitle = (TextView) itemView.findViewById(R.id.country_title);
        }

        void bind(CountryData data) {
            mItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, DetailCountryActivity.class);
                    intent.putExtra("data", data);
                    mContext.startActivity(intent);
                }
            });
            Glide.with(mContext)
                    .load(data.getBackground_image())
                    .placeholder(R.drawable.borobudur)
                    .fitCenter()
                    .into(mImageView);
            mTitle.setText(data.getName());
        }
    }
}
