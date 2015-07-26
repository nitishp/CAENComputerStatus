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
public class CentralCampusFragment extends Fragment
{
    private AdapterView.OnItemClickListener centralListener = new AdapterView.OnItemClickListener()
    {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id)
        {
            Intent intent = new Intent(getActivity(), LabDisplayActivity.class);
            switch (position){
                case 0:
                    intent.putExtra("building", "AH");
                    break;
                case 1:
                    intent.putExtra("building", "MO-JO");
                    break;
                case 2:
                    intent.putExtra("building", "SEB");
                    break;
                case 3:
                    intent.putExtra("building", "SHAPIRO");
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
        items.add(new LabAdapter.Item("Angell Hall",            R.drawable.ah));
        items.add(new LabAdapter.Item("Mosher Jordan",          R.drawable.mojo));
        items.add(new LabAdapter.Item("School of Education",    R.drawable.seb));
        items.add(new LabAdapter.Item("UGLi",                   R.drawable.shapiro));

        gridView.setAdapter(new LabAdapter(getActivity(), items));
        gridView.setOnItemClickListener(centralListener);
        return view;
    }
}
