package com.example.ehnyn.taskjson.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ehnyn.taskjson.R;

import org.json.JSONArray;


public class GETFragment extends Fragment {

    public static final String LOG_TAG = "Log Tag";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_post, container, false);

        Button btnPOst = rootview.findViewById(R.id.btnPostEnd);


        final RequestQueue queue = Volley.newRequestQueue(getActivity());
        String url = "http://jsonplaceholder.typicode.com/posts";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try{
                    Log.e(LOG_TAG, "It got here");
                    JSONArray apiResponse = new JSONArray(response);
                    Log.e(LOG_TAG, "The api response is " + apiResponse);

                }catch (Exception e){
                    throw  new RuntimeException("An internal JSON Error occured, please try again");
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Toast.makeText((), "An error occured", Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(stringRequest);

        return  rootview;
    }

}
