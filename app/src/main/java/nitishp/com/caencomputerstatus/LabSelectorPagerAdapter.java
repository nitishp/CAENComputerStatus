package nitishp.com.caencomputerstatus;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Nitish on 7/7/2015.
 */
public class LabSelectorPagerAdapter extends FragmentPagerAdapter
{
    private final int NUM_CAMPUS = 2;
    public LabSelectorPagerAdapter(FragmentManager manager)
    {
        super(manager);
    }

    @Override
    public int getCount()
    {
        return NUM_CAMPUS;
    }

    @Override
    public Fragment getItem(int position)
    {
        if(position == 0)
        {
            Fragment centralLabs = new CentralCampusFragment();
            Bundle args = new Bundle();
            centralLabs.setArguments(args);
            return centralLabs;
        }
        else
        {
            Fragment northLabs = new NorthCampusFragment();
            Bundle args = new Bundle();
            northLabs.setArguments(args);
            return northLabs;
        }
    }

    @Override
    public CharSequence getPageTitle(int position)
    {
        if(position == 0)
        {
            return "CENTRAL";
        }
        else
        {
            return "NORTH";
        }
    }

}

