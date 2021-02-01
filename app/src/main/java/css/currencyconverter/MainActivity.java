package css.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    //Declare Variables
    EditText editTextDollars;
    EditText editTextEuros;
    Button btnConvertDollars;
    Button btnConvertEuros;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Tie variables to widgets through their ids
        editTextDollars = findViewById(R.id.editTextDollars);
        editTextEuros = findViewById(R.id.editTextEuros);
        btnConvertDollars = findViewById(R.id.btnConvertDollars);
        btnConvertEuros = findViewById(R.id.btnConvertEuros);

        btnConvertEuros.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Button Click code-Dollars to Euros
                String dollarsString = editTextDollars.getText().toString();
                Double dollars = Double.parseDouble(dollarsString); // DEBT: should check if string is parsable first
                Double euros = dollars * 0.83; //DEPT: Should read this from a web service instead of hard coding
                editTextEuros.setText(NumberFormat.getCurrencyInstance().format(euros));
            }
        });
        btnConvertDollars.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Button Click code-Euros to Dollars
                String eurosString = editTextEuros.getText().toString();
                Double euros = Double.parseDouble(eurosString); // DEBT: should check if string is parsable first
                Double dollars = euros * 1.21; //DEPT: Should read this from a web service instead of hard coding
                editTextDollars.setText(NumberFormat.getCurrencyInstance().format(dollars));
            }
        });
    }
}