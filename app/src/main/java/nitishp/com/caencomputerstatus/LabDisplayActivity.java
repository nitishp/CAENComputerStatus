package nitishp.com.caencomputerstatus;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Created by Nitish on 7/14/2015.
 */
public class LabDisplayActivity extends AppCompatActivity
{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_display);

        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        String building = intent.getStringExtra("building");

        Hashtable<String, LabData> data = LabSelectorActivity.buildingToLabData.get(building);
        if(data != null)
        {
            // Add each room to buildingData
            ArrayList<LabData> buildingData = new ArrayList<>();
            ArrayList<String> keys = new ArrayList<>();
            for (String room : data.keySet()) {
                buildingData.add(data.get(room));
                keys.add(room);
            }

            ListView listView = (ListView) findViewById(R.id.list_view);
            listView.setAdapter(new DisplayAdapter(this, buildingData, keys, building));
        }
        else
        {
            // Internet connectivity issues
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
            alertDialog.setMessage("Building does not seem to have any CAEN computers");
            alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // Do nothing
                    return;
                }
            });
            alertDialog.show();
        }
    }

    // Create the Action Bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_lab_selector, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
