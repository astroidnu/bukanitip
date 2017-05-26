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
import dietbisabesok.com.bukanitip.data.Country;

/**
 * Created by ibnumuzzakkir on 5/26/17.
 */

public class HomeAdapterVertical extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private List<Country> mListCountry = new ArrayList<>();
    private LayoutInflater mLayoutInflater;

    public HomeAdapterVertical(Context context){
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    public void setDataList(List<Country> countries){
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
        Country countries = mListCountry.get(position);
        ((CountryHolder) holder).bind(countries);
    }

    @Override
    public int getItemCount() {
        return mListCountry.size();
    }


    public class CountryHolder extends RecyclerView.ViewHolder {
        TextView mTitle;
        public CountryHolder(View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.country_title);
        }

        void bind(Country data) {
            mTitle.setText(data.getCountry_name());
        }
    }
}
