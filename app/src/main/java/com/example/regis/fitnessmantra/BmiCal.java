package com.example.regis.fitnessmantra;

import android.os.Bundle;
import android.renderscript.Double2;
import android.support.annotation.InterpolatorRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;


public class BmiCal extends AppCompatActivity implements OnClickListener {
    EditText eheight_ft,eweight,eheight_inch;
    BigDecimal dg,bmi1;
    Button bsubmit;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmicalculator);
        eheight_ft=(EditText)findViewById(R.id.UserHeight);
        eweight=(EditText)findViewById(R.id.UserWeight);
        eheight_inch=(EditText)findViewById(R.id.HeightInch) ;
        bsubmit=(Button)findViewById(R.id.Submit);
        bsubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        try
        {int  height_ft=Integer.parseInt(eheight_ft.getText().toString());
            int height_inch= Integer.parseInt(eheight_inch.getText().toString());
            int height=height_ft*12 + height_inch;
            int  weight  = Integer.parseInt(eweight.getText().toString());
            float pounds= (float) (weight*2.20462);
            float bmi= ( pounds / ( height *height ) ) * 703;
            dg=new BigDecimal(bmi);
            bmi1 = dg.setScale(2,BigDecimal.ROUND_FLOOR);

            if(bmi1.floatValue()<18.5)
                {
                    ((TextView)findViewById(R.id.textView)).setText("Your Bmi:"+bmi1.floatValue()+"\nYour Underweight");
                }
            if(bmi1.floatValue()>=18.5 && bmi1.floatValue()<=24.9)
            {
                ((TextView)findViewById(R.id.textView)).setText("Your Bmi:"+bmi1.floatValue()+"\nYour Weight Is Normal");
            }
            if(bmi1.floatValue()>=25 && bmi1.floatValue()<=29.9)
            {
                ((TextView)findViewById(R.id.textView)).setText("Your Bmi:"+bmi1.floatValue()+"\nYour Overweight");
            }
            if(bmi1.floatValue()>=30)
            {
                ((TextView)findViewById(R.id.textView)).setText("Your Bmi:"+bmi1.floatValue()+"\nYour Obese "+"\n Stop eating fat ass");
            }



        }
        catch (NumberFormatException e)
        {
            eheight_ft.setText("");
            eweight.setText("");
            Toast.makeText(getApplicationContext(),"Enter proper values",Toast.LENGTH_LONG).show();
        }

    }
}
