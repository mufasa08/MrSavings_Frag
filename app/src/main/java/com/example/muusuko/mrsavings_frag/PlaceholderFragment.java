package com.example.muusuko.mrsavings_frag;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
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


public class PlaceholderFragment extends Fragment {

    Button add;
    private Toolbar toolbar;

    public PlaceholderFragment() {
        // Required empty public constructor
    }


        @TargetApi(Build.VERSION_CODES.LOLLIPOP)
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            SharedPreferences pref = getActivity().getSharedPreferences("MyPref", 0); // 0 - for private mode
            MainActivity.myVOICE = pref.getInt("VoiceValue", 0);
            MainActivity.balance = pref.getFloat("balanceValue", 0);

            final Animation animAlpha = AnimationUtils.loadAnimation(this.getActivity(), R.anim.anim_alpha);
            View view=inflater.inflate(R.layout.startpagefragment_main, container,false);
            add=(Button) view.findViewById(R.id.button);




            add.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub

                    FragmentTransaction t=getActivity().getFragmentManager().beginTransaction();
                    v.startAnimation(animAlpha);
                    if(MainActivity.myVOICE==0) {
                        t.replace(R.id.container, new Voice()).addToBackStack("nothing").commit();
                    }
                    else{
                        t.replace(R.id.container, new AddPage()).addToBackStack("nothing").commit();
                    }

                }
            });

            return view;
        }

}



