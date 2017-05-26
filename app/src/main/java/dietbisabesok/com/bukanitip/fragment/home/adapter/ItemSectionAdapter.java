package dietbisabesok.com.bukanitip.fragment.home.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ibnumuzzakkir on 5/26/17.
 */

public class ItemSectionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public class ItemSectionVH extends RecyclerView.ViewHolder {
        public ItemSectionVH(View itemView) {
            super(itemView);
        }
    }
}
