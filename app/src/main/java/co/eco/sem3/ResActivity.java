package co.eco.sem3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class ResActivity extends AppCompatActivity {


    private TextView nameR, respuesta, textView2;
    private Button goCalc2;
    private ConstraintLayout resact;
    private String userName, average;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res);

        nameR = findViewById(R.id.nameR);
        respuesta = findViewById(R.id.respuesta);
        goCalc2 = findViewById(R.id.goCalc2);
        resact = findViewById(R.id.resact);

        userName = getIntent().getExtras().getString("nombre");
        average = getIntent().getExtras().getString("promedio");
        Log.e(">>>", "" + average);

        nameR.setText(userName);
        respuesta.setText(average);

        goCalc2.setOnClickListener(

                v->{

                    finish();

                }
        );


    }

    protected void onResume() {
        super.onResume();

        SharedPreferences preferences = getSharedPreferences("color", MODE_PRIVATE);
        String colorPantalla = preferences.getString("color", "#FFFFFF");
        resact.setBackgroundColor(Color.parseColor(colorPantalla));

    }
}