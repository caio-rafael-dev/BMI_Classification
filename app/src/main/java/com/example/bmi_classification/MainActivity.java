package com.example.bmi_classification;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView tvBMI, tvClassification;
    EditText edtWeight, edtHeight;
    Button btnClassifyBMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        tvBMI = (TextView) findViewById(R.id.lblBMI);
        tvClassification = (TextView) findViewById(R.id.lblClassification);
        edtWeight = (EditText) findViewById(R.id.txtWeight);
        edtHeight = (EditText) findViewById(R.id.txtHeight);
        btnClassifyBMI = (Button) findViewById(R.id.cmdClassify);
        btnClassifyBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //declaration
                Double weight, height, result;

                weight = Double.parseDouble(edtWeight.getText().toString());
                height = Double.parseDouble(edtHeight.getText().toString());
                result = (weight / (height * height));

                String BMI = Double.toString(result);
                String BMIClassification="";

                try {
                    if(result < 18.5){
                        BMIClassification = "Under weight";
                    } else if((result > 18.5)&&(result < 24.9)){
                        BMIClassification = "Ideal weight";
                    }else if((result > 24.9)&&(result < 29.9)){
                        BMIClassification = "Overweight";
                    } else if(result > 30){
                        BMIClassification = "Obese";
                    }

                    tvBMI.setText(BMI); ;
                    tvClassification.setText(BMIClassification); ;

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}