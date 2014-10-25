package ncirl.project.giggidymobileapp.main;

import java.util.ArrayList;

import ncirl.project.giggidymobileapp.R;
import ncirl.project.giggidymobileapp.model.GigsModel;
import ncirl.project.giggidymobileapp.volley.VolleySingleton;

import org.json.JSONObject;

import android.app.Activity;
import android.app.DownloadManager.Request;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;


public class GigsActivity extends Activity {
	
	private String TAG = this.getClass().getSimpleName();
    private ListView lstView;
    private ArrayList<GigsModel> gigsArr ;
    private LayoutInflater lInflater;
    private VolleyAdapter vAdapter;
    private ProgressDialog pDialog;
    
    String lastfm_url = "http://ws.audioscrobbler.com/2.0/?method=geo.getevents&limit=100&" +
    		"api_key=91ef7088f6ad4ef274c2a9453165106d&format=json&location=boston";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gigs);
        lInflater = LayoutInflater.from(this);
        
        gigsArr = new ArrayList<GigsModel>();
        vAdapter = new VolleyAdapter();
        
        lstView = (ListView) findViewById(R.id.gigListView);
        lstView.setAdapter(vAdapter);
        
        pDialog = ProgressDialog.show(this,"Synchronizing...\n", "Please wait..");
        
        
        //Volley Request
        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Method.GET, lastfm_url, null, new Response.Listener<JSONObject>() {

            //If successful do this..
            @Override
            public void onResponse(JSONObject response) {
               
            }
            
            //If unsuccessful, do this..
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });

        // Access the RequestQueue through your singleton class.
        VolleySingleton.getInstance().addToRequestQueue(jsObjRequest);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.gigs, menu);
        return true;
    }
    
    
    
    
    class VolleyAdapter extends BaseAdapter{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			return null;
		}
    	
    	
    }

    
}
