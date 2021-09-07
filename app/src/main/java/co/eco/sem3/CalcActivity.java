package co.eco.sem3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalcActivity extends AppCompatActivity {


    private TextView titleCalc;
    private EditText nota1;
    private EditText nota2;
    private EditText nota3;
    private EditText nota4;
    private EditText nota5;
    private Button goCalc;


    private ConstraintLayout calcact;
    private double average;
    private String userName;
    private boolean verification;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        verification = true;

        titleCalc = findViewById(R.id.titleCalc);
        nota1 = findViewById(R.id.nota1);
        nota2 = findViewById(R.id.nota2);
        nota3 = findViewById(R.id.nota3);
        nota4 = findViewById(R.id.nota4);
        nota5 = findViewById(R.id.nota5);
        goCalc = findViewById(R.id.goCalc);

        calcact = findViewById(R.id.calcact);

        userName = getIntent().getExtras().getString("nombre");

        goCalc.setOnClickListener(

                v -> {

                    verification=true;
                    averageCalc();
                    if (verification) {

                        Intent i = new Intent(this, ResActivity.class);
                        i.putExtra("nombre", userName);
                        String prom = String.valueOf(average);
                        i.putExtra("promedio", prom);
                        startActivity(i);
                        finish();

                    }
                }

        );



    }


    protected void onResume() {
        super.onResume();

        SharedPreferences preferences = getSharedPreferences("color", MODE_PRIVATE);
        String colorPantalla = preferences.getString("color", "#FFFFFF");
        calcact.setBackgroundColor(Color.parseColor(colorPantalla));

    }


    public void averageCalc() {

        String pro1 = nota1.getText().toString();
        String pro2 = nota2.getText().toString();
        String q = nota3.getText().toString();
        String p1 = nota4.getText().toString();
        String p2 = nota5.getText().toString();

        double score1, score2, score3, score4, score5;
        score1 = 0;
        score2 = 0;
        score3 = 0;
        score4 = 0;
        score5 = 0;


        String[] scoreList = new String[]{
                pro1,
                pro2,
                q,
                p1,
                p2
        };

        if (verification) {

            for (int i = 0; i < scoreList.length; i++) {

                if (scoreList[i] == null || scoreList[i].isEmpty()) {
                    Toast.makeText(this, "Input all values", Toast.LENGTH_SHORT).show();
                    verification = false;
                } else {

                    double scoreNum = Double.parseDouble(scoreList[i]);
                    if (scoreNum > 5) {
                        Toast.makeText(this, "Grading scale 1 to 5", Toast.LENGTH_SHORT).show();
                        verification = false;
                    } else {

                        if (i == 0) {
                            score1 = scoreNum;


                        } else if (i == 1) {
                            score2 = scoreNum;


                        } else if (i == 2) {
                            score3 = scoreNum;


                        } else if (i == 3) {
                            score4 = scoreNum;


                        } else if (i == 4) {
                            score5 = scoreNum;


                        }

                    }

                    double prom = ((score1 * 0.25) + (score2 * 0.25) + (score3 * 0.20) + (score4 * 0.15) + (score5 * 0.15));


                    average = Math.round(prom * 100.0) / 100.0;

                    Log.e(">>>", "" + average);

                }
            }

        }

    }

}