package com.example.muusuko.mrsavings_frag;


import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
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
public class AddReciept extends Fragment {


    public AddReciept() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final Animation animAlpha = AnimationUtils.loadAnimation(this.getActivity(), R.anim.anim_alpha);
        View view = inflater.inflate(R.layout.fragment_add_reciept, container, false);
        Button add = (Button) view.findViewById(R.id.button5);
        final Button deduct = (Button) view.findViewById(R.id.button1);
        Button history = (Button) view.findViewById(R.id.button3);
        final TextView balance = (TextView) view.findViewById(R.id.textView1);
        final TextView used_on = (TextView) view.findViewById(R.id.editText);
        final TextView deposit = (TextView) view.findViewById(R.id.editText1);


        balance.setText(Float.toString((float) MainActivity.balance));

        deduct.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                new AlertDialog.Builder(getActivity())
                        .setTitle("Deduct Reciept")
                        .setMessage("Are you sure this information is correct? Amount: $" + deposit.getText().toString() + " used for " + used_on.getText().toString())
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                if (used_on.getText().toString().length()>=1&&Integer.parseInt(deposit.getText().toString())>0) {
                                    float myfloatvariable = (float) MainActivity.balance;
                                    MainActivity.balance = myfloatvariable - Float.parseFloat(deposit.getText().toString());
                                    myfloatvariable = (float) MainActivity.balance;
                                    String mybalance = Float.toString(myfloatvariable);
                                    SharedPreferences pref = getActivity().getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                                    SharedPreferences.Editor editor = pref.edit();
                                    balance.setText(mybalance);
                                    String spent_on = pref.getString(MainActivity.myfrmt, String.valueOf(0));
                                    spent_on = spent_on + "\n" + used_on.getText().toString() + "  $" + deposit.getText().toString();
                                    editor.putFloat("balanceValue", MainActivity.balance);
                                    //Store Spent
                                    editor.putString(MainActivity.myfrmt, spent_on);
                                    editor.commit();
                                    deposit.setText("");
                                    used_on.setText("");


                                    deposit.setText("");
                                    used_on.setText("");
                                }
                            }
                        })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();



                         /*   try {
            } catch (NumberFormatException e) {
                }*/

            }
        });


        add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                FragmentTransaction t = getActivity().getFragmentManager().beginTransaction();
                //v.startAnimation(animAlpha);

                t.replace(R.id.container, new AddMoney()).addToBackStack("nothing").commit();


            }
        });

        history.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                FragmentTransaction t = getActivity().getFragmentManager().beginTransaction();
                //v.startAnimation(animAlpha);

                t.replace(R.id.container, new spending_history()).addToBackStack("nothing").commit();


            }
        });


        return view;
    }


}