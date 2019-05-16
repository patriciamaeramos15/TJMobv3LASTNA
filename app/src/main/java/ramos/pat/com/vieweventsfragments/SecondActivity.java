package ramos.pat.com.vieweventsfragments;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baoyachi.stepview.HorizontalStepView;
import com.baoyachi.stepview.bean.StepBean;
import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import okhttp3.ConnectionSpec;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class SecondActivity extends AppCompatActivity {

    ImageView img_help;
    public ProgressDialog dialog;
    CardView eventId;
    CardView portId;
    CardView stream1;
    Button streambtn1;
    NestedScrollView scrollhelp;
    LinearLayout layouthelp;
    TextView txthelp, title_text1, title_text2, title_text3, title_text4, title_text5, title_text6,
            content_text1, content_text2, content_text3, content_text4, content_text5, content_text6;
    Dialog dialog_help;
    ImageView closeDialogHelp;
    public String[] eventtab = {"false","false","false"};
    public String url = "https://thomasianjourney.website/Register/checkEvents";

    TextView txtContent1, txtContent2, txtContent3, txtContent4, txtContent5, txtContent6;
    Animation animationUp, animationUp1, animationUp2, animationUp3, animationUp4,animationUp5, animationUp6;
    Animation animationDown, animationDown1, animationDown2, animationDown3, animationDown4, animationDown5, animationDown6 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        dialog = new ProgressDialog(this);
        TextView textViewDate = findViewById(R.id.date);
        textViewDate.setText("Today is " + currentDate);
        String collegeId = "1";
        String yearLevel = "1";
        String accountId = "1";
        OkHttpHandler okHttpHandler = new OkHttpHandler();
        //DITO PAPASOK YUNG ID NG EVENT SA VIEW EVENTS


        okHttpHandler.execute(url, collegeId, yearLevel, accountId);

        eventId = findViewById(R.id.eventId);

//        eventId.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(SecondActivity.this, MainActivity.class));
//            }
//        });

        portId = findViewById(R.id.portId);








//        portId.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(SecondActivity.this, Portfolio.class));
//            }
//        });

        // Event Stream

//        stream1 = findViewById(R.id.stream1);
//
//        stream1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(SecondActivity.this, EventDetails.class));
//            }
//        });

        streambtn1 = findViewById(R.id.streambtn1);

        streambtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SecondActivity.this, EventDetails.class));
            }
        });

        dialog_help = new Dialog(this);

        img_help = findViewById(R.id.img_help);
        img_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowDialogHelp();

            }
        });
    }
    public class OkHttpHandler extends AsyncTask<String, Void, String> {

        OkHttpClient client = new OkHttpClient.Builder()
                .connectionSpecs(Arrays.asList(ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS))
                .build();

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog.setMessage("Loading...");
            dialog.setCancelable(false);
            dialog.show();
        }

        @Override
        protected String doInBackground(String... params) {

            try {
                RequestBody requestBody = new MultipartBody.Builder()
                        .setType(MultipartBody.FORM)
                        .addFormDataPart("collegeId", params[1])
                        .addFormDataPart("yearLevel", params[2])
                        .addFormDataPart("accountId", params[3])
                        .build();

                Request.Builder builder = new Request.Builder();
                builder.url(params[0])
                        .post(requestBody);
                Request request = builder.build();

                Response response = client.newCall(request).execute();

                System.out.print("Response: " + response.code());

                if (response.isSuccessful()) {

                    return response.body().string();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        protected void onPostExecute(String s) {

//            if(dialog.isShowing()){
            dialog.dismiss();
//            }
//            textView.setText(s);
            insertList(s);
//            Toast.makeText(getContext(), ""+s, Toast.LENGTH_SHORT).show();

        }
    }

    public void ShowDialogHelp() {
        dialog_help.setContentView(R.layout.dialog_help);
        closeDialogHelp = (ImageView) dialog_help.findViewById(R.id.closeDialogHelp);
//        title_text1 = (TextView) dialog_help.findViewById(R.id.title_text1);
//        title_text2 = (TextView) dialog_help.findViewById(R.id.title_text2);
//        title_text3 = (TextView) dialog_help.findViewById(R.id.title_text3);
//        title_text4 = (TextView) dialog_help.findViewById(R.id.title_text4);
//        title_text5 = (TextView) dialog_help.findViewById(R.id.title_text5);
//        title_text6 = (TextView) dialog_help.findViewById(R.id.title_text6);
//        content_text1 = (TextView) dialog_help.findViewById(R.id.content_text1);
//        content_text2 = (TextView) dialog_help.findViewById(R.id.content_text2);
//        content_text3 = (TextView) dialog_help.findViewById(R.id.content_text3);
//        content_text4 = (TextView) dialog_help.findViewById(R.id.content_text4);
//        content_text5 = (TextView) dialog_help.findViewById(R.id.content_text5);
//        content_text6 = (TextView) dialog_help.findViewById(R.id.content_text6);
//        txthelp = (TextView) dialog_help.findViewById(R.id.txthelp);
//        scrollhelp = (NestedScrollView) dialog_help.findViewById(R.id.scrollhelp);
//        layouthelp = (LinearLayout) dialog_help.findViewById(R.id.layouthelp);
        txtContent1 = (TextView) dialog_help.findViewById(R.id.title_text1);
        TextView txtTitle1 = (TextView) dialog_help.findViewById(R.id.content_text1);
        txtContent1.setVisibility(View.GONE);

        animationUp1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
        animationDown1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down);

        txtTitle1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtContent1.isShown()){
                    txtContent1.setVisibility(View.GONE);
                    txtContent1.startAnimation(animationUp1);
                }
                else{
                    txtContent1.setVisibility(View.VISIBLE);
                    txtContent1.startAnimation(animationDown1);
                }
            }
        });

        // help 2
        txtContent2 = (TextView) dialog_help.findViewById(R.id.title_text2);
        TextView txtTitle2 = (TextView) dialog_help.findViewById(R.id.content_text2);
        txtContent2.setVisibility(View.GONE);

        animationUp2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
        animationDown2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down);

        txtTitle2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtContent2.isShown()){
                    txtContent2.setVisibility(View.GONE);
                    txtContent2.startAnimation(animationUp2);
                }
                else{
                    txtContent2.setVisibility(View.VISIBLE);
                    txtContent2.startAnimation(animationDown2);
                }
            }
        });

        // help 3
        txtContent3 = (TextView) dialog_help.findViewById(R.id.title_text3);
        TextView txtTitle3 = (TextView) dialog_help.findViewById(R.id.content_text3);
        txtContent3.setVisibility(View.GONE);

        animationUp3 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
        animationDown3 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down);

        txtTitle3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtContent3.isShown()){
                    txtContent3.setVisibility(View.GONE);
                    txtContent3.startAnimation(animationUp3);
                }
                else{
                    txtContent3.setVisibility(View.VISIBLE);
                    txtContent3.startAnimation(animationDown3);
                }
            }
        });

        // help 4
        txtContent4 = (TextView) dialog_help.findViewById(R.id.title_text4);
        TextView txtTitle4 = (TextView) dialog_help.findViewById(R.id.content_text4);
        txtContent4.setVisibility(View.GONE);

        animationUp4 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
        animationDown4 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down);

        txtTitle4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtContent4.isShown()){
                    txtContent4.setVisibility(View.GONE);
                    txtContent4.startAnimation(animationUp4);
                }
                else{
                    txtContent4.setVisibility(View.VISIBLE);
                    txtContent4.startAnimation(animationDown4);
                }
            }
        });

        // help 5
        txtContent5 = (TextView) dialog_help.findViewById(R.id.title_text5);
        TextView txtTitle5 = (TextView) dialog_help.findViewById(R.id.content_text5);
        txtContent5.setVisibility(View.GONE);

        animationUp5 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
        animationDown5 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down);

        txtTitle5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtContent5.isShown()){
                    txtContent5.setVisibility(View.GONE);
                    txtContent5.startAnimation(animationUp5);
                }
                else{
                    txtContent5.setVisibility(View.VISIBLE);
                    txtContent5.startAnimation(animationDown5);
                }
            }
        });

        // help 6
        txtContent6 = (TextView) dialog_help.findViewById(R.id.title_text6);
        TextView txtTitle6 = (TextView) dialog_help.findViewById(R.id.content_text6);
        txtContent6.setVisibility(View.GONE);

        animationUp6 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
        animationDown6 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down);

        txtTitle6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtContent6.isShown()){
                    txtContent6.setVisibility(View.GONE);
                    txtContent6.startAnimation(animationUp6);
                }
                else{
                    txtContent6.setVisibility(View.VISIBLE);
                    txtContent6.startAnimation(animationDown6);
                }
            }
        });

        closeDialogHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog_help.dismiss();
            }


        });

        dialog_help.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog_help.show();


    }

    public void EventsAnim(View view) {
        if (view == findViewById(R.id.eventId)) {
            //open viewevents
            Intent i = new Intent(this, MainActivity.class);
            i.putExtra("eventtab", eventtab);
            startActivity(i);
            //add animation

            Animatoo.animateCard(this);

        }
    }

    public void PortAnim(View view) {
        if (view == findViewById(R.id.portId)) {
            //open viewevents
            startActivity(new Intent(this, MenuPortfolio.class));
            //add animation
            Animatoo.animateCard(this);
        }
    }

    public void StreamAnim1(View view) {
        if (view == findViewById(R.id.stream1)) {
            //open viewevents
            startActivity(new Intent(this, EventDetails.class));
            //add animation
            Animatoo.animateCard(this);
        }

    }

    public void insertList(String s){
        dialog.dismiss();

        if(!TextUtils.isEmpty(s)){
            try{
                Gson gson = new Gson();

                JsonObject jsonObject = gson.fromJson(s, JsonObject.class);

                if  (jsonObject.has("data")) {
                    JsonArray dataArray = jsonObject.get("data").getAsJsonArray();
                    for (int i = 0 ; i < dataArray.size() ; i++){
                        eventtab[i] = dataArray.get(i).toString();
                    }
                }else{

                }

            }catch(Exception err){
//                mRecyclerView.setVisibility(View.GONE);
//                empty = getActivity().findViewById(R.id.empty);
//                empty.setVisibility(View.VISIBLE);
//                Toast.makeText(this, year1.length+"HELLO", Toast.LENGTH_SHORT).show();
            }
        }else{
        }
    }




}