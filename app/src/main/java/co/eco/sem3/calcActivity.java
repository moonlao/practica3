package co.eco.sem3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class calcActivity extends AppCompatActivity {


    private TextView titleCalc;
    private EditText nota1;
    private EditText nota2;
    private EditText nota3;
    private EditText nota4;
    private EditText nota5;
    private Button goCalc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        titleCalc = findViewById(R.id.titleCalc);
        nota1 = findViewById(R.id.nota1);
        nota2 = findViewById(R.id.nota2);
        nota3 = findViewById(R.id.nota3);
        nota4 = findViewById(R.id.nota4);
        nota5 = findViewById(R.id.nota5);
        goCalc = findViewById(R.id.goCalc);



    }
}