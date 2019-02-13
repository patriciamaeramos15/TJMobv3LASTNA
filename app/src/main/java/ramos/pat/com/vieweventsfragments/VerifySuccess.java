package ramos.pat.com.vieweventsfragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.baoyachi.stepview.HorizontalStepView;
import com.baoyachi.stepview.bean.StepBean;

import java.util.ArrayList;
import java.util.List;

public class VerifySuccess extends AppCompatActivity {
    private Button contbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_success);

        //STEPVIEW

        HorizontalStepView stepview = (HorizontalStepView) findViewById(R.id.step_view);

        List<StepBean> stepsBeanList = new ArrayList<>();
        StepBean stepBean0 = new StepBean("",1);
        StepBean stepBean1 = new StepBean("",1);
        StepBean stepBean2 = new StepBean("",1);
        stepsBeanList.add(stepBean0);
        stepsBeanList.add(stepBean1);
        stepsBeanList.add(stepBean2);

        stepview
                .setStepViewTexts(stepsBeanList)//总步骤
                .setTextSize(12)//set textSize
                .setStepsViewIndicatorCompletedLineColor(ContextCompat.getColor(VerifySuccess.this, android.R.color.black))
                .setStepsViewIndicatorUnCompletedLineColor(ContextCompat.getColor(VerifySuccess.this, R.color.uncompleted_text_color))
                .setStepViewComplectedTextColor(ContextCompat.getColor(VerifySuccess.this, android.R.color.black))
                .setStepViewUnComplectedTextColor(ContextCompat.getColor(VerifySuccess.this, R.color.uncompleted_text_color))
                .setStepsViewIndicatorCompleteIcon(ContextCompat.getDrawable(VerifySuccess.this, R.drawable.ic_check_black))
                .setStepsViewIndicatorDefaultIcon(ContextCompat.getDrawable(VerifySuccess.this, R.drawable.ic_radio))
                .setStepsViewIndicatorAttentionIcon(ContextCompat.getDrawable(VerifySuccess.this, R.drawable.tiger_rar));

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
