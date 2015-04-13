package com.example.muusuko.mrsavings_frag;


import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailedSpending extends Fragment {


    public DetailedSpending() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // final Animation animAlpha = AnimationUtils.loadAnimation(this.getActivity(), R.anim.anim_alpha);
        View view=inflater.inflate(R.layout.fragment_detailed_spending, container,false);
        Button addCurr = (Button) view.findViewById(R.id.button1);
        Button deduct = (Button) view.findViewById(R.id.button2);
        Button othermonths = (Button) view.findViewById(R.id.button4);
        final TextView spending_output = (TextView) view.findViewById(R.id.textView10);
        final TextView month = (TextView) view.findViewById(R.id.textView4);
        SharedPreferences pref = getActivity().getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode


        spending_output.setText(pref.getString(MainActivity.myfrmt, String.valueOf(0)));
        month.setText(MainActivity.myfrmt);

        addCurr.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                FragmentTransaction t=getActivity().getFragmentManager().beginTransaction();
                //v.startAnimation(animAlpha);

                t.replace(R.id.container, new AddMoney()).addToBackStack("nothing").commit();


            }
        });


        deduct.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                FragmentTransaction t = getActivity().getFragmentManager().beginTransaction();
                //v.startAnimation(animAlpha);

                t.replace(R.id.container, new AddReciept()).addToBackStack("nothing").commit();


            }
        });



        othermonths.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                FragmentTransaction t=getActivity().getFragmentManager().beginTransaction();
                //v.startAnimation(animAlpha);

                t.replace(R.id.container, new MonthSelection()).addToBackStack("nothing").commit();


            }
        });



        return view;
    }


}