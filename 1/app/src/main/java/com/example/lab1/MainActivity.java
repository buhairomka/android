package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    RadioGroup radioGroup;
    RadioButton radioButton;
    Button buttonApply;
    Button buttonCancel;
    EditText editText;
    int fontSize = 10;
    String outputText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        textView.setText("Your input:");
        radioGroup = findViewById(R.id.radioGroup);
        buttonApply = findViewById(R.id.button_apply);
        buttonCancel = findViewById(R.id.button_cancel);
        editText = findViewById(R.id.editTextTextPersonName);

    }

    public void setButtonApply(View view) {
        final String editTextText = editText.getText().toString().trim();
        if (!editTextText.equals("")) {
            outputText = editTextText;
            textView.setTextSize(fontSize);
            textView.setText("Your input:\n"+outputText);
        } else {
            Toast.makeText(this, "type something...", Toast.LENGTH_SHORT).show();
        }
    }

    public void setButtonCancelValue(View view) {
        textView.setText("Your input:");
    }


    public void checkButton(View view) {
        int selectedId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(selectedId);
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
}