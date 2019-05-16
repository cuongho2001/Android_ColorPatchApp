package edu.temple.fragapp;

import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    ColorFragment frag = new ColorFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();

        FragmentTransaction transaction = fm.beginTransaction().replace(R.id.container1, frag);

        transaction.commit();

        findViewById(R.id.newNum).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                frag.generateNewNumber();
            }
        });



        //getSupportFragmentManager().beginTransaction().add(R.id.container2, new ColorFragment()).commit();
    }

    public void buttonClicked(int i) {
        DisplayFrgment dFragment = DisplayFragment.newInstance(i);

        getSupportFragmentManager().beginTransaction().replace(R.id.container1, dFragment).addToBackStack(null).commit();
    }
}
