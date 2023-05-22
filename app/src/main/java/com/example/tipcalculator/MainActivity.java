package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText costOfServiceText;
    private Button calcButton;
    private RadioGroup radioGroup;
    private Switch roundUpSwitch;
    private TextView tipAmountText;
    private double tipAmount;
    private double tipPercent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        costOfServiceText = findViewById(R.id.costOfService);
        calcButton = findViewById(R.id.calculateButton);
        radioGroup = findViewById(R.id.radioGroup);
        roundUpSwitch = findViewById(R.id.roundUpSwitch);
        tipAmountText = findViewById(R.id.tipAmountText);

        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cost = costOfServiceText.getText().toString();
                double costAmount = Double.parseDouble(cost);
                int checkedRadioButton = radioGroup.getCheckedRadioButtonId();

                switch (checkedRadioButton){
                    case R.id.amazingRadioButton:
                        tipPercent = 0.2;
                        break;
                    case R.id.goodRadioButton:
                        tipPercent = 0.18;
                        break;
                    case R.id.okRadioButton:
                        tipPercent = 0.15;
                        break;
                    default:
                        tipPercent = 0.00;
                        break;
                }

                tipAmount = costAmount * tipPercent;
                if(roundUpSwitch.isChecked()){
                    tipAmount = Math.round(tipAmount);
                }
                tipAmountText.setText(""+tipAmount);
            }
        });
    }
}