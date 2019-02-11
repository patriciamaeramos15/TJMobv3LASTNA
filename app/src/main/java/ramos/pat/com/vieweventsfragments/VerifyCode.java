package ramos.pat.com.vieweventsfragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class VerifyCode extends AppCompatActivity {
    private Button cancelbtn;
    private Button verifybtn;
    TextView resend;
    Dialog dialog_resend;
    Button okbtn;
    TextView titleResend, exResend;
    ImageView closeDialogResend, imageResend;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_code);

        dialog_resend = new Dialog(this);

        resend = findViewById(R.id.resend);
        resend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowDialogResend();
            }
        });

        cancelbtn = (Button) findViewById(R.id.cancelbtn);
        cancelbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMain2Activity();
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

    public void openMain2Activity() {
        Intent intent = new Intent(this,Main2Activity.class);
        startActivity(intent);
    }

    public void openConfirmCode() {
        Intent intent = new Intent(this,ConfirmCode.class);
        startActivity(intent);
    }

    public void ShowDialogResend() {
        dialog_resend.setContentView(R.layout.dialog_resend);
        closeDialogResend = (ImageView) dialog_resend.findViewById(R.id.closeDialogResend);
        imageResend = (ImageView) dialog_resend.findViewById(R.id.imageResend);
        okbtn = (Button) dialog_resend.findViewById(R.id.okbtn);
        titleResend = (TextView) dialog_resend.findViewById(R.id.titleResend);
        exResend = (TextView) dialog_resend.findViewById(R.id.exResend);

        closeDialogResend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog_resend.dismiss();
            }
        });

        dialog_resend.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog_resend.show();
    }
}
