package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Fragment1.ISend,Fragment2.IUpdate {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction frg = getSupportFragmentManager().beginTransaction();
        frg.add(R.id.fragment1, new Fragment1());
        frg.add(R.id.fragment2, new Fragment2());
        frg.commit();
    }

    @Override
    public void SendData(String email) {
        Fragment2 frg2 = (Fragment2) getSupportFragmentManager().findFragmentById(R.id.fragment2);
        frg2.ConFimlData(email);
    }

    @Override
    public void updatedata(String email) {
        Fragment1 frg1 = (Fragment1) getSupportFragmentManager().findFragmentById(R.id.fragment1);
        frg1.ConFimlData(email);
    }
}