package dietbisabesok.com.bukanitip.activity.showallcountry.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import dietbisabesok.com.bukanitip.R;
import dietbisabesok.com.bukanitip.data.CountryData;

/**
 * Created by ibnumuzzakkir on 5/27/17.
 */

public class ShowAllCountriesAdapter extends RecyclerView.Adapter<ShowAllCountriesAdapter.ViewHolder> {
    private Context mContext;
    List<CountryData> mCountryDataList = new ArrayList<>();
    private LayoutInflater mLayoutInflater;

    public ShowAllCountriesAdapter(Context context){
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    public void setData(List<CountryData> countryDatas){
        mCountryDataList = countryDatas;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.item_all_countries, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CountryData countryData = mCountryDataList.get(position);
        holder.mTitle.setText(countryData.getName());
        holder.mAllCountriesFrame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,countryData.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mCountryDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTitle;
        ImageView mImageView;
        TextView mDiasporaCount;
        TextView mRequestCount;
        RelativeLayout mAllCountriesFrame;
        public ViewHolder(View itemView) {
            super(itemView);
            mAllCountriesFrame = (RelativeLayout) itemView.findViewById(R.id.all_countries_frame);
            mImageView = (ImageView) itemView.findViewById(R.id.all_countries_image);
            mTitle = (TextView) itemView.findViewById(R.id.all_countries_title);
            mDiasporaCount = (TextView) itemView.findViewById(R.id.all_countries_request_count);
            mRequestCount = (TextView) itemView.findViewById(R.id.all_countries_diaspora_count);
        }
    }
}
