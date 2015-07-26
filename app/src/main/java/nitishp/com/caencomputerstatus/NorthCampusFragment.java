package nitishp.com.caencomputerstatus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
    private AdapterView.OnItemClickListener northListener = new AdapterView.OnItemClickListener()
    {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id)
        {
            Intent intent = new Intent(getActivity(), LabDisplayActivity.class);
            switch (position){
                case 0:
                    intent.putExtra("building", "BAITS_");
                    break;
                case 1:
                    intent.putExtra("building", "BEYSTER");
                    break;
                case 2:
                    intent.putExtra("building", "BURSLEY");
                    break;
                case 3:
                    intent.putExtra("building", "COOLEY");
                    break;
                case 4:
                    intent.putExtra("building", "DC");
                    break;
                case 5:
                    intent.putExtra("building", "EECS");
                    break;
                case 6:
                    intent.putExtra("building", "FXB");
                    break;
                case 7:
                    intent.putExtra("building", "GGBL");
                    break;
                case 8:
                    intent.putExtra("building", "IOE");
                    break;
                case 9:
                    intent.putExtra("building", "LBME");
                    break;
                case 10:
                    intent.putExtra("building", "NAME");
                    break;
                case 11:
                    intent.putExtra("building", "PIERPONT");
                    break;
                case 12:
                    intent.putExtra("building", "SRB");
                    break;
            }
            startActivity(intent);
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view =  inflater.inflate(R.layout.fragment_grid_labs, container, false);
        GridView gridView = (GridView) view.findViewById(R.id.gridview);

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

        gridView.setAdapter(new LabAdapter(getActivity(), items));
        gridView.setOnItemClickListener(northListener);
        return view;
    }
}
