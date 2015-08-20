package nitishp.com.caencomputerstatus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nitish on 7/7/2015.
 */
public class CentralCampusFragment extends Fragment
{
    public void transition(String building)
    {
        Intent intent = new Intent(getActivity(), LabDisplayActivity.class);
        switch (building){
            case "Angell Hall":
                intent.putExtra("building", "AH");
                break;
            case "Mosher Jordan":
                intent.putExtra("building", "MO-JO");
                break;
            case "School of Education":
                intent.putExtra("building", "SEB");
                break;
            case "UGLi":
                intent.putExtra("building", "SHAPIRO");
                break;
        }
        startActivity(intent);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        List<LabAdapter.Item> items = new ArrayList<LabAdapter.Item>();
        items.add(new LabAdapter.Item("Angell Hall",            R.drawable.ah));
        items.add(new LabAdapter.Item("Mosher Jordan",          R.drawable.mojo));
        items.add(new LabAdapter.Item("School of Education",    R.drawable.seb));
        items.add(new LabAdapter.Item("UGLi",                   R.drawable.shapiro));

        View view =  inflater.inflate(R.layout.fragment_grid_labs, container, false);
        // Set up the recyclerview to be a gridview
        RecyclerView gridView = (RecyclerView) view.findViewById(R.id.gridview);
        gridView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        gridView.setAdapter(new LabAdapter(getActivity(), items, this, null));
        return view;
    }
}
