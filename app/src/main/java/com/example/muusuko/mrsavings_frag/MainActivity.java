package com.example.muusuko.mrsavings_frag;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class MainActivity extends ActionBarActivity {
    private FragmentManager mFragmentManager;
    public static Integer myVOICE;
    public static float balance;
    static Calendar cal = Calendar.getInstance();
    public static String myfrmt = new SimpleDateFormat("MMMM").format(cal.getTime());
    public static String dayfrmt = new SimpleDateFormat("dd").format(cal.getTime());

    FileOutputStream fou;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            mFragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = mFragmentManager
                    .beginTransaction();
            SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode

            MainActivity.myVOICE = pref.getInt("VoiceValue", 0);
            MainActivity.balance = pref.getFloat("balanceValue", 0);
            //


            fragmentTransaction.add(R.id.container, new PlaceholderFragment()).addToBackStack("first");
            fragmentTransaction.commit();


        }
    }


    public void onBackPressed() {

        getFragmentManager().popBackStack();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        mFragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = mFragmentManager
                .beginTransaction();
        switch (item.getItemId()) {
            case R.id.deduct_money:
                fragmentTransaction.replace(R.id.container, new AddReciept()).addToBackStack("first");
                fragmentTransaction.commit();
                return true;

            case R.id.add_money:
                fragmentTransaction.replace(R.id.container, new AddMoney()).addToBackStack("first");
                fragmentTransaction.commit();
                return true;

            case R.id.action_settings:
                fragmentTransaction.replace(R.id.container, new Settings()).addToBackStack("first");
                fragmentTransaction.commit();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

}
    /**
     * A placeholder fragment containing a simple view.
     */
