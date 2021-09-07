package co.eco.sem3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textS1;
    private EditText nameInput;
    private Button nextBtn;
    private Button settBtn;

    private ConstraintLayout mainact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //referenciar
        textS1 = findViewById(R.id.textS1);
        nameInput = findViewById(R.id.nameInput);
        nextBtn = findViewById(R.id.nextBtn);
        settBtn = findViewById(R.id.settBtn);

        mainact = findViewById(R.id.mainact);


        settBtn.setOnClickListener(

                v->{
                    Intent i = new Intent(this, BgActivity.class);
                    startActivity(i);
                }
        );

        nextBtn.setOnClickListener(

                v->{

                    String userName = nameInput.getText().toString();


                    if(userName==null || userName.isEmpty()){

                        Toast.makeText(this,"No ha digitado su nombre",Toast.LENGTH_SHORT).show();
                    }else{

                        Intent i = new Intent(this, CalcActivity.class);
                        i.putExtra("nombre", userName);
                        startActivity(i);
                        nameInput.setText("");

                    }

                }
        );

    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences preferences = getSharedPreferences("color", MODE_PRIVATE);
        String bgColor = preferences.getString("color", "#FFFFFF");
        mainact.setBackgroundColor(Color.parseColor(bgColor));

    }
}