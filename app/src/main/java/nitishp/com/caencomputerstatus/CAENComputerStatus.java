package nitishp.com.caencomputerstatus;

import android.content.Context;
import android.os.AsyncTask;

import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Nitish on 7/10/2015.
 */
public class CAENComputerStatus extends AsyncTask<String, String, JSONArray>
{
    private LabSelectorActivity mCallingActivity;
    private Context mContext;
    public CAENComputerStatus(LabSelectorActivity activity, Context context)
    {
        mCallingActivity = activity;
        mContext = context;
    }

    @Override
    public JSONArray doInBackground(String... params)
    {
        HttpURLConnection urlConnection = null;
        StringBuilder out = null;
        try
        {
            URL url = new URL(params[0]);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestProperty("Authorization", "Bearer " + params[1]);
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setRequestMethod("GET");
            urlConnection.setDoInput(true);
            urlConnection.connect();

            InputStream is = urlConnection.getInputStream();
            String result = readStream(is);
            return new JSONArray(result);
        }
        catch (Exception e)
        {
            return null;
        }
        finally
        {
            if(urlConnection != null)
            {
                urlConnection.disconnect();
            }
        }
    }

    private String readStream(InputStream is)
    {
        BufferedReader reader = null;
        StringBuffer response = new StringBuffer();
        try
        {
            reader = new BufferedReader(new InputStreamReader(is));
            String line = "";
            while ((line = reader.readLine()) != null)
            {
                response.append(line);
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
            if (reader != null)
            {
                try
                {
                    reader.close();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
        return response.toString();
    }

    @Override
    public void onPostExecute(JSONArray result)
    {
        mCallingActivity.processData(result);
    }

}
