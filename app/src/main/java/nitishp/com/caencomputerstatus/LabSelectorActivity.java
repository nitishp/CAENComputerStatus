package nitishp.com.caencomputerstatus;

import android.content.DialogInterface;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Hashtable;

import nitishp.com.caencomputerstatus.view.SlidingTabLayout;


public class LabSelectorActivity extends AppCompatActivity
{
    // building name to room name to lab data
    public static Hashtable<String, Hashtable<String, LabData>> buildingToLabData;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_selector);

        setTitle("Select CAEN Lab");

        // Set up the toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        //Set up adapter for the viewpager
        LabSelectorPagerAdapter adapter = new LabSelectorPagerAdapter(getSupportFragmentManager());
        ViewPager labSelectorPager = (ViewPager) findViewById(R.id.pager);
        labSelectorPager.setAdapter(adapter);

        SlidingTabLayout mSlidingTabLayout = (SlidingTabLayout) findViewById(R.id.sliding_tab_layout);
        mSlidingTabLayout.setDistributeEvenly(true);
        mSlidingTabLayout.setViewPager(labSelectorPager);

        String URL = "http://api-gw.it.umich.edu/CAEN/Labs/v2/computers.json?fields=in_use,location,class";
        String API_KEY = "c855127dfda5a71a9f7048ba7a3846b";
        CAENComputerStatus caenComputerStatus = new CAENComputerStatus(this, this);
        caenComputerStatus.execute(URL, API_KEY);
    }

    // Create the Action Bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_lab_selector, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void processData(JSONArray data)
    {
        buildingToLabData = new Hashtable<String, Hashtable<String, LabData>>();
        try {
            for (int i = 0; i < data.length(); ++i) {
                addToHashtable(data.getJSONObject(i));
            }
        } catch (Exception e) {
            // Internet connectivity issues
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
            alertDialog.setTitle("Internet Connectivity Issues");
            alertDialog.setIcon(android.R.drawable.ic_dialog_alert);
            alertDialog.setMessage("Unable to connect to the internet, please check your internet settings");
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

    private void addToHashtable(JSONObject computerData)
    {
        try
        {
            //get all the data
            boolean in_use = Boolean.valueOf(computerData.getString("in_use"));
            String computerType = computerData.getString("class");
            JSONObject location = computerData.getJSONObject("location");
            String building = location.getString("building");
            String room = location.getString("room");

            //if the hashtable has both the building and the room
            if(buildingToLabData.containsKey(building) && buildingToLabData.get(building).containsKey(room))
            {
                LabData labData = buildingToLabData.get(building).get(room);
                modifyLabData(in_use, computerType, labData);
            }
            //It just contains the building
            else if(buildingToLabData.containsKey(building))
            {
                LabData labData = new LabData(0, 0, 0, 0);
                modifyLabData(in_use, computerType, labData);
                Hashtable<String, LabData> roomToLabData = buildingToLabData.get(building);
                roomToLabData.put(room, labData);
            }
            //Contains neither
            else
            {
                Hashtable<String, LabData> roomToLabData = new Hashtable<String, LabData>();
                LabData labData = new LabData(0, 0, 0, 0);
                modifyLabData(in_use, computerType, labData);
                roomToLabData.put(room, labData);
                buildingToLabData.put(building, roomToLabData);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void modifyLabData(boolean in_use, String computerType, LabData labData)
    {
        if(computerType.equals("I"))
        {
            if (in_use)
            {
                (labData.takenInstructional)++;
            }
            (labData.totalInstructional)++;
        }
        else
        {
            if (in_use)
            {
                (labData.takenResearch)++;
            }
            (labData.totalResearch)++;
        }
    }

}