package com.example.a2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FragmentInputListener , cancel{
    fragment_input f_in;
    fragment_output f_out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        f_in = new fragment_input();

        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, f_in)
                .commit();
    }


    @Override
    public void onApply(Bundle bundle) {
        f_out = new fragment_output();
        f_out.setArguments(bundle);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, f_out)
                .commit();
    }

    @Override
    public void onCancel() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, f_in)
                .commit();
    }
}