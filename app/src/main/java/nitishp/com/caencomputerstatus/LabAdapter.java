package nitishp.com.caencomputerstatus;

import android.content.Context;
import android.graphics.drawable.Drawable;
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
public class LabAdapter extends BaseAdapter
{
    private Context mContext;

    private final List<Item> mItems;

    public LabAdapter(Context c, List<Item> items)
    {
        mContext = c;
        mItems = items;
    }

    @Override
    public int getCount()
    {
        return mItems.size();
    }

    @Override
    public Item getItem(int position)
    {
        return mItems.get(position);
    }

    public long getItemId(int position)
    {
        return mItems.get(position).id;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup viewGroup)
    {
        View v = convertView;
        ImageView picture;
        TextView name;

        if(v == null)
        {
            v = LayoutInflater.from(mContext).inflate(R.layout.fragment_grid_item, viewGroup, false);
            v.setTag(R.id.picture, v.findViewById(R.id.picture));
            v.setTag(R.id.name, v.findViewById(R.id.name));
        }

        picture = (ImageView) v.getTag(R.id.picture);
        name = (TextView) v.getTag(R.id.name);

        Item item = getItem(position);

        name.setText(item.name);
        Picasso.with(mContext).load(item.id).placeholder(R.drawable.loading).into(picture);
        return v;
    }


    /*
    Struct to hold the name of the lab and a picture of it
     */
    public static class Item
    {
        public final String name;
        public final int id;

        public Item(String name, int id)
        {
            this.name = name;
            this.id = id;
        }
    }

}
