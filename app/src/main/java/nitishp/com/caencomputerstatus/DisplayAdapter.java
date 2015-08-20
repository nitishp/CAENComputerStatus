package nitishp.com.caencomputerstatus;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Nitish on 7/17/2015.
 */
public class DisplayAdapter extends RecyclerView.Adapter<DisplayAdapter.ViewHolder>
{

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView mBuilding;
        TextView mNumResearch;
        TextView mNumInstructional;
        public ViewHolder(View v)
        {
            super(v);
            mBuilding = (TextView) v.findViewById(R.id.room);
            mNumInstructional = (TextView) v.findViewById(R.id.instructional_computers);
            mNumResearch = (TextView) v.findViewById(R.id.research_computers);
        }
    }

    private Context mContext;
    private ArrayList<LabData> mLabData;
    private ArrayList<String> mRooms;
    private String labBuilding;

    public DisplayAdapter(Context c, ArrayList<LabData> labData, ArrayList<String> rooms, String building)
    {
        mContext = c;
        mLabData = labData;
        mRooms = rooms;
        labBuilding = building;
    }

    @Override
    public DisplayAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_list_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        LabData data = getItem(position);
        holder.mBuilding.setText(mRooms.get(position) + " " + labBuilding);
        String researchText = Integer.toString(data.takenResearch) + " of " + Integer.toString(data.totalResearch);
        if(researchText == "0 of 0")
        {
            researchText = "-----";
        }
        holder.mNumResearch.setText(researchText);

        String instructionalText = Integer.toString(data.takenInstructional) + " of " + Integer.toString(data.totalInstructional);
        if(instructionalText == "0 of 0")
        {
            instructionalText = "-----";
        }
        holder.mNumInstructional.setText(instructionalText);
    }

    @Override
    public int getItemCount()
    {
        return mLabData.size();
    }

    public LabData getItem(int position)
    {
        return mLabData.get(position);
    }
}
