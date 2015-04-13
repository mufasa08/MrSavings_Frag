package com.example.muusuko.mrsavings_frag;


import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddMoney extends Fragment {


    public AddMoney() {
        // Required empty public constructor
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

         final Animation animAlpha = AnimationUtils.loadAnimation(this.getActivity(), R.anim.anim_alpha);
        View view=inflater.inflate(R.layout.fragment_add_money, container,false);
        Button add = (Button) view.findViewById(R.id.button1);
        Button deduct = (Button) view.findViewById(R.id.button2);
        Button history = (Button) view.findViewById(R.id.button3);
            final TextView balance = (TextView) view.findViewById(R.id.textView1);
        final TextView deposit = (TextView) view.findViewById(R.id.editText1);
        float myfloatvariable=(float) MainActivity.balance;
        String mybalance=Float.toString(myfloatvariable);
        balance.setText(mybalance);

        add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                SharedPreferences pref = getActivity().getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                SharedPreferences.Editor editor = pref.edit();

                float myfloatvariable=(float) MainActivity.balance;
                try {


                    MainActivity.balance = myfloatvariable + Float.parseFloat(deposit.getText().toString());
                    myfloatvariable = (float) MainActivity.balance;
                    String mybalance = Float.toString(myfloatvariable);
                    balance.setText(mybalance);
                    editor.putFloat("balanceValue", MainActivity.balance);
                    editor.commit();
                    v.startAnimation(animAlpha);
                    deposit.setText("");

                }
                catch (NumberFormatException e){}
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

        history.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                FragmentTransaction t=getActivity().getFragmentManager().beginTransaction();
                //v.startAnimation(animAlpha);

                t.replace(R.id.container, new spending_history()).addToBackStack("nothing").commit();


            }
        });



        return view;
    }


}
