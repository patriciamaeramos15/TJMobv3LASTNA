package ramos.pat.com.vieweventsfragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class ConfirmCode extends AppCompatActivity {
    private TextView tvone ;
    private TextView tvtwo ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_code);
        tvone = (TextView) findViewById(R.id.tvone);
        tvtwo = (TextView) findViewById(R.id.tvtwo);
        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.mytransition);
        tvone.startAnimation(myanim);
        tvtwo.startAnimation(myanim);

        final Intent i = new Intent(this,VerifySuccess.class);
        Thread timer = new Thread() {
            public void run () {
                try {
                    sleep(5000) ;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    startActivity(i);
                    finish();
                }
            }
        };
        timer.start();
    }
}
