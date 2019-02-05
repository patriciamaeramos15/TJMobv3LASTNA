package ramos.pat.com.vieweventsfragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class VerifySuccess extends AppCompatActivity {
    private Button contbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_success);

        contbtn = (Button) findViewById(R.id.contbtn);
        contbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSecondActivity();
            }
        });
    }

    public void openSecondActivity() {
        Intent intent = new Intent(this,SecondActivity.class);
        startActivity(intent);
    }
}
