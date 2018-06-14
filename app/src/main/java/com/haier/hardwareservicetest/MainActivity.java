package com.haier.hardwareservicetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private boolean ledon = false;
    private Button button = null;
    private CheckBox checkBoxLed1 = null;
    private CheckBox checkBoxLed2 = null;

    class MyButtonListener implements View.OnClickListener {//方法二
        @Override
        public void onClick(View v) {
            ledon = !ledon;
            if (ledon) {
                button.setText("ALL OFF");
                checkBoxLed1.setChecked(true);
                checkBoxLed2.setChecked(true);
            }
            else {
                button.setText("ALL ON");
                checkBoxLed1.setChecked(false);
                checkBoxLed2.setChecked(false);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBoxLed1 = (CheckBox) findViewById(R.id.checkBoxLed1);
        checkBoxLed2 = (CheckBox) findViewById(R.id.checkBoxLed2);

        button = (Button) findViewById(R.id.button1);

        button.setOnClickListener(new MyButtonListener());//方法二

/*        button.setOnClickListener(new View.OnClickListener() {//方法一
            public void onClick(View v) {
                ledon = !ledon;
                if (ledon)
                    button.setText("ALL OFF");
                else
                    button.setText("ALL ON");
            }
        });*/

    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkBoxLed1:
                if (checked)
                    Toast.makeText(getApplicationContext(), "LED1 ON", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getApplicationContext(), "LED1 OFF", Toast.LENGTH_LONG).show();
                break;
            case R.id.checkBoxLed2:
                if (checked)
                    Toast.makeText(getApplicationContext(), "LED2 ON", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getApplicationContext(), "LED2 OFF", Toast.LENGTH_LONG).show();
                break;
            // TODO: Veggie sandwich
        }
    }
}
