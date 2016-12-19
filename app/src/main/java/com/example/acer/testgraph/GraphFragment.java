package com.example.acer.testgraph;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class GraphFragment extends Fragment {

    View thisview;
    MyGraph newView;


    public GraphFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        String strtext = getArguments().getString("testing");
        System.out.println(strtext);
        // Inflate the layout for this fragment

        thisview = inflater.inflate(R.layout.fragment_graph, container, false);
        newView = new MyGraph(this);
        LinearLayout pagelay = (LinearLayout) thisview.findViewById(R.id.pagelayout);
        newView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        (pagelay).addView(newView);

        return thisview;

    }

}
