package nitishp.com.caencomputerstatus;

/**
 * Created by Nitish on 7/11/2015.
 */
public class LabData
{
    public int takenResearch;
    public int takenInstructional;
    public int totalResearch;
    public int totalInstructional;

    public LabData(int takenInstructional, int takenResearch, int totalResearch, int totalInstructional)
    {
        this.takenInstructional = takenInstructional;
        this.takenResearch = takenResearch;
        this.totalResearch = totalResearch;
        this.totalInstructional = totalInstructional;
    }
}
