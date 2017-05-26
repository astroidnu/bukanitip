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
import dietbisabesok.com.bukanitip.data.Address;

/**
 * Created by ibnumuzzakkir on 5/25/17.
 */

public class HomeAdapterHorizontal extends RecyclerView.Adapter<HomeAdapterHorizontal.ViewHolder> {
    private List<Address> mAddressList = new ArrayList<>();
    private LayoutInflater mLayoutInflater;
    private Context mContext;

    public HomeAdapterHorizontal(Context context){
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    public void setDataList(List<Address> addressList){
        if(addressList != null){
            mAddressList = addressList;
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

    }

    @Override
    public int getItemCount() {
        return mAddressList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.item_section;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTitle;
        public ViewHolder(View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.trending_title);
        }
    }
}
