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
public class NorthCampusFragment extends Fragment
{
    public void transition(String building)
    {
        Intent intent = new Intent(getActivity(), LabDisplayActivity.class);
        switch (building){
            case "Baits":
                intent.putExtra("building", "BAITS");
                break;
            case "Beyster":
                intent.putExtra("building", "BEYSTER");
                break;
            case "Bursley":
                intent.putExtra("building", "BURSLEY");
                break;
            case "Cooley":
                intent.putExtra("building", "COOLEY");
                break;
            case "Duderstadt":
                intent.putExtra("building", "DC");
                break;
            case "EECS":
                intent.putExtra("building", "EECS");
                break;
            case "FXB":
                intent.putExtra("building", "FXB");
                break;
            case "GG Brown":
                intent.putExtra("building", "GGBL");
                break;
            case "IOE":
                intent.putExtra("building", "IOE");
                break;
            case "LBME":
                intent.putExtra("building", "LBME");
                break;
            case "NAME":
                intent.putExtra("building", "NAME");
                break;
            case "Pierpont":
                intent.putExtra("building", "PIERPONT");
                break;
            case "SRB":
                intent.putExtra("building", "SRB");
                break;
        }
        startActivity(intent);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        List<LabAdapter.Item> items = new ArrayList<LabAdapter.Item>();
        items.add(new LabAdapter.Item("Baits",            R.drawable.baits));
        items.add(new LabAdapter.Item("Beyster",          R.drawable.beyster));
        items.add(new LabAdapter.Item("Bursley",          R.drawable.bursley));
        items.add(new LabAdapter.Item("Cooley",           R.drawable.cooley));
        items.add(new LabAdapter.Item("Duderstadt",       R.drawable.duderstadt));
        items.add(new LabAdapter.Item("EECS",             R.drawable.eecs));
        items.add(new LabAdapter.Item("FXB",              R.drawable.fxb));
        items.add(new LabAdapter.Item("GG Brown",         R.drawable.ggbl));
        items.add(new LabAdapter.Item("IOE",              R.drawable.ioe));
        items.add(new LabAdapter.Item("LBME",             R.drawable.lbme));
        items.add(new LabAdapter.Item("NAME",             R.drawable.name));
        items.add(new LabAdapter.Item("Pierpont",         R.drawable.pierpont));
        items.add(new LabAdapter.Item("SRB",           R.drawable.srb));


        View view =  inflater.inflate(R.layout.fragment_grid_labs, container, false);
        RecyclerView gridView = (RecyclerView) view.findViewById(R.id.gridview);
        gridView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        gridView.setAdapter(new LabAdapter(getActivity(), items, null, this));
        return view;
    }
}
