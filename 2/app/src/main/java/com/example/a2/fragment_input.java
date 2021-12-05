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
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

interface FragmentInputListener {
    void onApply(Bundle bundle);
}
public class fragment_input extends Fragment {
    FragmentInputListener listener;
    RadioGroup radioGroup;
    RadioButton radioButton;
    Button buttonApply;
    EditText editText;
    int fontSize = 10;
    Bundle bundle = new Bundle();
    String editTextText;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_input, container, false);
        radioGroup = v.findViewById(R.id.radioGroup);
        buttonApply = v.findViewById(R.id.button_apply);
        editText = v.findViewById(R.id.editTextTextPersonName);
        buttonApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextText = editText.getText().toString().trim();
                if (!editTextText.equals("")) {
                    bundle.putString("str", editTextText);
                    bundle.putInt("fontSize",fontSize);
                    listener.onApply(bundle);
                } else {
                    Toast.makeText(getContext(), "type something...", Toast.LENGTH_SHORT).show();
                }

            }
        });

        int count = radioGroup.getChildCount();
        for (int i = 0; i < count; i++) {
            View o = radioGroup.getChildAt(i);
            if (o instanceof RadioButton) {
                o.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int selectedId = radioGroup.getCheckedRadioButtonId();
                        radioButton = view.findViewById(selectedId);
                        String buttonText = (String) radioButton.getText();

                        switch (buttonText) {
                            case "10sp":
                                fontSize = 10;

                                break;

                            case "15sp":
                                fontSize = 15;

                                break;

                            case "25sp":
                                fontSize = 25;

                                break;
                        }

                    }
                });

            }
        }


        return v;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof FragmentInputListener) {
            listener = (FragmentInputListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement FragmentAListener");
        }
    }

}