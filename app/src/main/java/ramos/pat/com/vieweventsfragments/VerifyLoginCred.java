package ramos.pat.com.vieweventsfragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class VerifyLoginCred extends AppCompatActivity {

    private TextView vtvone ;
    private TextView vtvtwo ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_login_cred);
        vtvone = (TextView) findViewById(R.id.vtvone);
        vtvtwo = (TextView) findViewById(R.id.vtvtwo);
        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.mytransition);
        vtvone.startAnimation(myanim);
        vtvtwo.startAnimation(myanim);

        final Intent i = new Intent(this,VerLoginCredSuc.class);
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
