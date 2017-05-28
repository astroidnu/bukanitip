package dietbisabesok.com.bukanitip.activity.listoffering.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import dietbisabesok.com.bukanitip.activity.listoffering.ListOfferingView;

/**
 * Created by ibnumuzzakkir on 5/28/17.
 */

public class ListOfferingAdapter extends RecyclerView.Adapter<ListOfferingAdapter.ViewHolder> {
    private Context mContext;
    public ListOfferingAdapter(Context context){
        mContext = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    public void setData(){

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
