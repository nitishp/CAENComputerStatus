package nitishp.com.caencomputerstatus;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nitish on 7/9/2015.
 */
public class LabAdapter extends RecyclerView.Adapter<LabAdapter.ViewHolder>
{
    private Context mContext;
    private final List<Item> mItems;

    private CentralCampusFragment mCentral;
    private NorthCampusFragment mNorth;

    // Struct to hold the name and picture of the building
    public static class Item
    {
        public final String name; // Name of the building
        public final int id; // ID for picture

        public Item(String name, int id)
        {
            this.name = name;
            this.id = id;
        }
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // each data item is just a string in this case
        public TextView mTextView;
        public ImageView mImageView;

        private CentralCampusFragment central;
        private NorthCampusFragment north;
        public ViewHolder(View v, CentralCampusFragment centralIn, NorthCampusFragment northIn)
        {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.name);
            mImageView = (ImageView) v.findViewById(R.id.picture);
            central = centralIn;
            north = northIn;
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v)
        {
            if(central != null)
            {
                central.transition(mTextView.getText().toString());
            }
            else
            {
                north.transition((mTextView.getText().toString()));
            }
        }
    }

    public LabAdapter(Context context, List<Item> items, CentralCampusFragment central, NorthCampusFragment north)
    {
        mContext = context;
        mItems = items;
        mCentral = central;
        mNorth = north;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public LabAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_grid_item, parent, false);
        ViewHolder vh = new ViewHolder(v, mCentral, mNorth);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Item item = mItems.get(position);
        holder.mTextView.setText(item.name);
        Picasso.with(mContext).load(item.id).into(holder.mImageView);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mItems.size();
    }






}
