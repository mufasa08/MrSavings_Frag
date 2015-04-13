package com.example.muusuko.mrsavings_frag;


import android.app.FragmentTransaction;
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
public class spending_history extends Fragment {


    public spending_history() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // final Animation animAlpha = AnimationUtils.loadAnimation(this.getActivity(), R.anim.anim_alpha);
        View view=inflater.inflate(R.layout.fragment_spending_history, container,false);
        Button addCurr = (Button) view.findViewById(R.id.button1);
        Button deduct = (Button) view.findViewById(R.id.button2);
        Button detailed = (Button) view.findViewById(R.id.button3);
        Button othermonths = (Button) view.findViewById(R.id.button4);
        final TextView balance = (TextView) view.findViewById(R.id.textView5);
        final TextView month = (TextView) view.findViewById(R.id.textView4);
        final TextView saved_lost = (TextView) view.findViewById(R.id.textView7);
        float myfloatvariable=(float) MainActivity.balance;
        String mybalance=Float.toString(myfloatvariable);

        if(myfloatvariable<0)
          saved_lost.setText("You've Lost");
        else
         saved_lost.setText("You've Saved");

        balance.setText(mybalance+"$");
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

        detailed.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                FragmentTransaction t=getActivity().getFragmentManager().beginTransaction();
                //v.startAnimation(animAlpha);

                t.replace(R.id.container, new DetailedSpending()).addToBackStack("nothing").commit();


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
