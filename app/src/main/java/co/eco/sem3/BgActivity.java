package co.eco.sem3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BgActivity extends AppCompatActivity {

    private Button blueBtn;
    private Button whiteBtn;
    private Button blackBtn;
    private TextView titleSett;
    private TextView descSett;

    private ConstraintLayout bgactivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bg);

        blueBtn = findViewById(R.id.blueBtn);
        whiteBtn = findViewById(R.id.whiteBtn);
        blackBtn = findViewById(R.id.blackBtn);
        titleSett = findViewById(R.id.titleSett);
        descSett = findViewById(R.id.descSett);

        bgactivity = findViewById(R.id.bgactivity);


        SharedPreferences preferences = getSharedPreferences("color", MODE_PRIVATE);

        blueBtn.setOnClickListener(

                v->{
                    String colorAzul = "#89CFF0";
                    preferences.edit().putString("color",colorAzul).apply();
                    finish();
                }
        );

        whiteBtn.setOnClickListener(
                v->{
                    String colorBlanco = "#FFFFFF";
                    preferences.edit().putString("color", colorBlanco).apply();
                    finish();
                }
        );

        blackBtn.setOnClickListener(
                v->{
                    String colorNegro = "#242425";
                    preferences.edit().putString("color", colorNegro).apply();
                    finish();
                }
        );


    }

    protected void onResume() {
        super.onResume();

        SharedPreferences preferences = getSharedPreferences("color", MODE_PRIVATE);
        String bgActual = preferences.getString("color", "#FFFFFF");
        bgactivity.setBackgroundColor(Color.parseColor(bgActual));

    }

}