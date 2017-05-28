package dietbisabesok.com.bukanitip.activity.listoffering.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import dietbisabesok.com.bukanitip.R;
import dietbisabesok.com.bukanitip.activity.listoffering.ListOfferingView;
import dietbisabesok.com.bukanitip.data.ListOfferingData;
import dietbisabesok.com.bukanitip.helper.CurrencyHelper;

/**
 * Created by ibnumuzzakkir on 5/28/17.
 */

public class ListOfferingAdapter extends RecyclerView.Adapter<ListOfferingAdapter.ViewHolder> {
    private Context mContext;
    private List<ListOfferingData> mListOfferingData;
    private LayoutInflater mLayoutInflater;
    public ListOfferingAdapter(Context context){
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);

    }

    public void setData( List<ListOfferingData> mData){
        mListOfferingData  = mData;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.item_offering_list, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ListOfferingData listOfferingData = mListOfferingData.get(position);
        holder.mOfferListBudget.setText(CurrencyHelper.CurrencyHelper(Long.valueOf(listOfferingData.getPrice())));
        holder.mOfferListName.setText(listOfferingData.getName());
        holder.mOfferListDescription.setText(listOfferingData.getDescription());
        holder.mOfferListDayEstimation.setText(listOfferingData.getDay_estimation() + " Days");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "hello", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mListOfferingData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mOfferListName;
        TextView mOfferListBudget;
        TextView mOfferListDescription;
        TextView mOfferListDayEstimation;
        CardView mOfferItem;
        public ViewHolder(View itemView) {
            super(itemView);
            mOfferListBudget = (TextView) itemView.findViewById(R.id.offering_list_price);
            mOfferListName = (TextView) itemView.findViewById(R.id.offering_list_name);
            mOfferListDescription = (TextView) itemView.findViewById(R.id.offering_lit_description);
            mOfferListDayEstimation = (TextView) itemView.findViewById(R.id.offering_list_day_estimation);
            mOfferItem = (CardView) itemView.findViewById(R.id.offering_list_item);
        }
    }
}
