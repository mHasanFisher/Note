package memorizeappwithdbflow.fisher.com.memorizeappwithdbflow;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

/**
 * Created by Mohammad Hasan on 6/16/2017.
 */
class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    List<String> mDataset;
    List<Organization> orgList;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder

    static class ViewHolder extends RecyclerView.ViewHolder {

        // each data item is just a string in this case
        View mView;

        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    MyAdapter(List<Organization> organList) {

//        mDataset = myDataset;
        orgList = organList;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {

        // create a new view
        View v = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_text, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);

        return vh;

    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        View v = (View) holder.mView.findViewById(R.id.card_view);

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.mView.getContext(), "All View", Toast.LENGTH_SHORT).show();
            }
        });

        TextView view = (TextView) holder.mView.findViewById(R.id.info_text);
        TextView viewText = (TextView) holder.mView.findViewById(R.id.your_text);
        view.setText(orgList.get(position).name);
        viewText.setText(orgList.get(position).texts);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.mView.getContext(), "clicked : " + (holder.getAdapterPosition() + 1), Toast.LENGTH_SHORT).show();
            }
        });

        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(holder.mView.getContext(), "Long Clicked : " + (holder.getAdapterPosition() + 1), Toast.LENGTH_SHORT).show();

                orgList.get(position).delete();

                orgList = SQLite.select().
                        from(Organization.class).queryList();

                notifyItemRemoved(position);
                notifyItemRangeChanged(position, orgList.size());

                notifyDataSetChanged();

                return false;
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {

//        return mDataset.size();
        return orgList.size();
    }
}
