package ramos.pat.com.vieweventsfragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class VerifyCode extends AppCompatActivity {
    private Button cancelbtn;
    private Button verifybtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_code);

        cancelbtn = (Button) findViewById(R.id.cancelbtn);
        cancelbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });

        verifybtn = (Button) findViewById(R.id.verifybtn);
        verifybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openConfirmCode();
            }
        });
    }

    public void openMainActivity() {
        Intent intent = new Intent(this,Main2Activity.class);
        startActivity(intent);
    }

    public void openConfirmCode() {
        Intent intent = new Intent(this,ConfirmCode.class);
        startActivity(intent);
    }

}
