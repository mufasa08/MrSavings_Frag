package com.example.muusuko.mrsavings_frag;


import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class Settings extends Fragment {


    public Settings() {
        // Required empty public constructor
    }
        Button b,b1,b2,reset;


        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            final Animation animAlpha = AnimationUtils.loadAnimation(this.getActivity(), R.anim.anim_alpha);
            View view=inflater.inflate(R.layout.fragment_settings, container,false);


            b = (Button) view.findViewById(R.id.button);
            b1 = (Button) view.findViewById(R.id.button2);
            b2 = (Button) view.findViewById(R.id.button3);
            reset=(Button) view.findViewById(R.id.button4);
            final MediaPlayer mp=MediaPlayer.create(this.getActivity(), R.raw.dontfail);
            final  MediaPlayer mp2=MediaPlayer.create(this.getActivity(), R.raw.pika);
            final  MediaPlayer mp3=MediaPlayer.create(this.getActivity(), R.raw.sexy);

            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    // FragmentTransaction t = getActivity().getFragmentManager().beginTransaction();
                    SharedPreferences pref = getActivity().getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putInt("VoiceValue", MainActivity.myVOICE);
                    editor.commit();
                    mp.start();
                    v.startAnimation(animAlpha);
                    MainActivity.myVOICE=1;
                    //  t.replace(R.id.container, new Voice()).addToBackStack("nothing").commit();
                }
            });
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    // FragmentTransaction t = getActivity().getFragmentManager().beginTransaction();
                    SharedPreferences pref = getActivity().getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putInt("VoiceValue", MainActivity.myVOICE);
                    editor.commit();
                    mp2.start();
                    MainActivity.myVOICE=2;
                    v.startAnimation(animAlpha);

                    //  t.replace(R.id.container, new Voice()).addToBackStack("nothing").commit();
                }
            });
            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    // FragmentTransaction t = getActivity().getFragmentManager().beginTransaction();
                    SharedPreferences pref = getActivity().getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putInt("VoiceValue", MainActivity.myVOICE);
                    editor.commit();
                    mp3.start();
                    MainActivity.myVOICE=3;
                    v.startAnimation(animAlpha);
                    //  t.replace(R.id.container, new Voice()).addToBackStack("nothing").commit();
                }
            });

            reset.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    // FragmentTransaction t = getActivity().getFragmentManager().beginTransaction();
                    SharedPreferences pref = getActivity().getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putInt("VoiceValue", 0);
                    editor.putFloat("balanceValue", 0);
                    editor.putString(MainActivity.myfrmt,"");
                    MainActivity.myVOICE = pref.getInt("VoiceValue", 0);
                    MainActivity.balance = pref.getFloat("balanceValue", 0);
                    editor.commit();
                    new AlertDialog.Builder(getActivity())
                            .setTitle("Factory Reset")
                            .setMessage("Are you sure you want to delete all saving history and settings?")
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {

                                    FragmentTransaction t = getActivity().getFragmentManager().beginTransaction();
                                    getFragmentManager().popBackStack();
                                    getFragmentManager().popBackStack();
                                    getFragmentManager().popBackStack();

                                    t.replace(R.id.container, new PlaceholderFragment()).addToBackStack("nothing2").commit();

                                }
                            })
                            .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // do nothing
                                }
                            })
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();



                }
            });



            return view;
        }

    }



