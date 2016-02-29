package huji.ac.il.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.app.AlertDialog;

public class MainActivity extends AppCompatActivity {
    private final static double TIP_MULTIPLIER = 0.12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final CheckBox chkRound = (CheckBox)findViewById(R.id.chkRound);
        Button btnCalculate = (Button)findViewById(R.id.btnCalculate);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!((EditText)findViewById(R.id.edtBillAmount)).getText().toString().isEmpty()) {
                    Double tipAmount = Double.parseDouble(((EditText)findViewById(R.id.edtBillAmount))
                            .getText().toString()) * TIP_MULTIPLIER;
                    if (chkRound.isChecked()) {
                        ((TextView)findViewById(R.id.txtTipResult)).setText("Tip: " + Math.ceil(tipAmount) + "$");
                    } else {
                        ((TextView)findViewById(R.id.txtTipResult)).setText("Tip: " + tipAmount + "$");
                    }
                } else {
                    new AlertDialog.Builder(huji.ac.il.tipcalculator.MainActivity.this).setTitle("Error")
                            .setMessage("Please enter a bill amount").setNeutralButton("Close", null).show();
                }
            }
        });
//
    }
}
