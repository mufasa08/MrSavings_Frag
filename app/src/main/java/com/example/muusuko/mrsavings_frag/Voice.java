package com.example.muusuko.mrsavings_frag;


import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class Voice extends Fragment {

    Button b;
    Button b1;
    Button b2;
    Button b3;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final  MediaPlayer mp=MediaPlayer.create(this.getActivity(), R.raw.dontfail);
        final  MediaPlayer mp2=MediaPlayer.create(this.getActivity(), R.raw.pika);
        final  MediaPlayer mp3=MediaPlayer.create(this.getActivity(), R.raw.sexy);
        final Animation animAlpha = AnimationUtils.loadAnimation(this.getActivity(), R.anim.anim_alpha);
                View view = inflater.inflate(R.layout.fragment_voice, container, false);
        b = (Button) view.findViewById(R.id.button);
        b1 = (Button) view.findViewById(R.id.button2);
        b2 = (Button) view.findViewById(R.id.button3);
        b3 = (Button) view.findViewById(R.id.button4);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
               // FragmentTransaction t = getActivity().getFragmentManager().beginTransaction();
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
                mp3.start();
                MainActivity.myVOICE=3;
                v.startAnimation(animAlpha);
                //  t.replace(R.id.container, new Voice()).addToBackStack("nothing").commit();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                 FragmentTransaction t = getActivity().getFragmentManager().beginTransaction();
                SharedPreferences pref = getActivity().getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                SharedPreferences.Editor editor = pref.edit();
                editor.putInt("VoiceValue", MainActivity.myVOICE);
                editor.commit();
                v.startAnimation(animAlpha);
                  t.replace(R.id.container, new AddPage()).addToBackStack("stack3").commit();

            }
        });

        return view;

}
}
