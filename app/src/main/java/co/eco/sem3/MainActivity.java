package co.eco.sem3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textS1;
    private EditText nameInput;
    private Button nextBtn;
    private Button settBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //referenciar
        textS1 = findViewById(R.id.textS1);
        nameInput = findViewById(R.id.nameInput);
        nextBtn = findViewById(R.id.nextBtn);
        settBtn = findViewById(R.id.settBtn);



    }


    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.settBtn:

                Intent i = new Intent(this, bgActivity.class);
                startActivity(i);

                break;

            case R.id.nextBtn:

                String name = nameInput.getText().toString();



                Intent e = new Intent(this, calcActivity.class);

                e.putExtra("nombre", name);


                startActivity(e);

                break;
        }

    }
}