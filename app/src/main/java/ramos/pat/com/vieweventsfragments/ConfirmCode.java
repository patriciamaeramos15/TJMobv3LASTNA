package ramos.pat.com.vieweventsfragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.baoyachi.stepview.HorizontalStepView;
import com.baoyachi.stepview.bean.StepBean;

import java.util.ArrayList;
import java.util.List;

public class ConfirmCode extends AppCompatActivity {
    private TextView tvone ;
    private TextView tvtwo ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_code);

        //STEPVIEW

        HorizontalStepView stepview = (HorizontalStepView) findViewById(R.id.step_view);

        List<StepBean> stepsBeanList = new ArrayList<>();
        StepBean stepBean0 = new StepBean("",1);
        StepBean stepBean1 = new StepBean("",1);
        StepBean stepBean2 = new StepBean("",0);
        stepsBeanList.add(stepBean0);
        stepsBeanList.add(stepBean1);
        stepsBeanList.add(stepBean2);

        stepview
                .setStepViewTexts(stepsBeanList)//总步骤
                .setTextSize(12)//set textSize
                .setStepsViewIndicatorCompletedLineColor(ContextCompat.getColor(ConfirmCode.this, android.R.color.black))
                .setStepsViewIndicatorUnCompletedLineColor(ContextCompat.getColor(ConfirmCode.this, R.color.uncompleted_text_color))
                .setStepViewComplectedTextColor(ContextCompat.getColor(ConfirmCode.this, android.R.color.black))
                .setStepViewUnComplectedTextColor(ContextCompat.getColor(ConfirmCode.this, R.color.uncompleted_text_color))
                .setStepsViewIndicatorCompleteIcon(ContextCompat.getDrawable(ConfirmCode.this, R.drawable.ic_check_black))
                .setStepsViewIndicatorDefaultIcon(ContextCompat.getDrawable(ConfirmCode.this, R.drawable.ic_radio))
                .setStepsViewIndicatorAttentionIcon(ContextCompat.getDrawable(ConfirmCode.this, R.drawable.tiger_rar));


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
