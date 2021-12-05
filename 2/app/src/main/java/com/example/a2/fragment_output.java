package com.example.a2;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

interface cancel{
    public void onCancel();
}
public class fragment_output extends Fragment {

    private cancel listener;
    TextView textView;
    Button cancel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_output, container, false);
        textView = v.findViewById(R.id.textView);
        System.out.println("textView");
        System.out.println(textView);
        textView.setTextSize(getArguments().getInt("fontSize"));
        textView.setText(getArguments().getString("str"));
        cancel = v.findViewById(R.id.button_cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onCancel();
            }
        });
        return v;
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof FragmentInputListener) {
            listener = (cancel) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement FragmentAListener");
        }
    }
}