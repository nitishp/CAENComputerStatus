package nitishp.com.caencomputerstatus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Nitish on 7/17/2015.
 */
public class DisplayAdapter extends BaseAdapter
{
    private Context mContext;
    private ArrayList<LabData> mLabData;
    private ArrayList<String> mRooms;

    public DisplayAdapter(Context c, ArrayList<LabData> labData, ArrayList<String> rooms)
    {
        mContext = c;
        mLabData = labData;
        mRooms = rooms;
    }

    @Override
    public int getCount()
    {
        return mLabData.size();
    }

    @Override
    public LabData getItem(int position)
    {
        return mLabData.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup viewGroup)
    {
        View v = convertView;
        TextView building;
        TextView numResearch;
        TextView numInstructional;
        TextView numTotal;

        if(v == null)
        {
            v = LayoutInflater.from(mContext).inflate(R.layout.fragment_list_item, viewGroup, false);
            v.setTag(R.id.room, v.findViewById(R.id.room));
            v.setTag(R.id.research_computers, v.findViewById(R.id.research_computers));
            v.setTag(R.id.instructional_computers, v.findViewById(R.id.instructional_computers));
        }

        LabData data = getItem(position);
        building = (TextView) v.getTag(R.id.room);
        numResearch = (TextView) v.getTag(R.id.research_computers);
        numInstructional = (TextView) v.getTag(R.id.instructional_computers);

        building.setText(mRooms.get(position));
        numResearch.setText(Integer.toString(data.takenResearch) + " of " + Integer.toString(data.totalResearch));
        numInstructional.setText(Integer.toString(data.takenInstructional) + " of " + Integer.toString(data.totalInstructional));

        return v;
    }







}
