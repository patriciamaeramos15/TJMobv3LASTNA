package ramos.pat.com.vieweventsfragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {
    private Button contbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);

        contbutton = (Button) findViewById(R.id.contbutton);
        contbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openVerifyCode();
            }
        });
    }

    public void openVerifyCode() {
        Intent intent = new Intent(this,VerifyCode.class);
        startActivity(intent);
    }
}
