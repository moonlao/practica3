package co.eco.sem3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class bgActivity extends AppCompatActivity {

    private Button blueBtn;
    private Button whiteBtn;
    private Button blackBtn;
    private TextView titleSett;
    private TextView descSett;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bg);

        blueBtn = findViewById(R.id.blueBtn);
        whiteBtn = findViewById(R.id.whiteBtn);
        blackBtn = findViewById(R.id.blackBtn);
        titleSett = findViewById(R.id.titleSett);
        descSett = findViewById(R.id.descSett);

        blueBtn.setOnClickListener(
                (view) -> {
                    // como hago que cambie de color aaaa
                    finish();
                }
        );

    }
}