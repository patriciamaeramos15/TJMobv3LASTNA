package ramos.pat.com.vieweventsfragments;

import android.app.Activity;
import android.content.Intent;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import android.widget.ImageView;
import android.widget.TextView;

import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class VerLoginCredSuc extends AppCompatActivity {
    private Button contscanbtn;
    private LocationManager locationManager;
    private LocationListener locationListener;
    private LottieAnimationView LottieCheck;

    Dialog dialog_errorqr;
    Button okbtn;
    TextView titleErrorQR, exErrorRQ;
    ImageView closeDialogErrorQR, imageErrorQR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_login_cred_suc);

        //ANIMATION LOTTIE
        LottieCheck = findViewById(R.id.mainlottieCheck);

        LottieCheck.setScale(6f);
        LottieCheck.setVisibility(View.VISIBLE);
        LottieCheck.setAnimation(R.raw.check);
        LottieCheck.playAnimation();

        contscanbtn = (Button) findViewById(R.id.contscanbtn);
        final Activity activity = this;
//        locationManager = (LocationManager) this.getSystemService(LOCATION_SERVICE);
//        locationListener = new LocationListener() {
//            @Override
//            public void onLocationChanged(Location location) {
//                Log.d("Location: ", location.toString());
//
//            }
//
//            @Override
//            public void onStatusChanged(String provider, int status, Bundle extras) {
//
//            }
//
//            @Override
//            public void onProviderEnabled(String provider) {
//
//            }
//
//            @Override
//            public void onProviderDisabled(String provider) {
//
//            }
//        };
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

//            //    ActivityCompat#requestPermissions
//            // here to request the missing permissions, and then overriding
//            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//            //                                          int[] grantResults)
//            // to handle the case where the user grants the permission. See the documentation
//            // for ActivityCompat#requestPermissions for more details.
//            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, 1);
//
//        }else{
//            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
//
//        }
//        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
//

        contscanbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator integrator = new IntentIntegrator(activity);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("Scan");
                integrator.setCameraId(0);
                integrator.setCaptureActivity(CaptureActivityPortrait.class);
                integrator.setBeepEnabled(false);
                integrator.setBarcodeImageEnabled(false);
                integrator.initiateScan();

            }
        });
    }
    //Dito lalagay intent
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null){

            if(result.getContents()==null){
                Toast.makeText(this, "You cancelled the scanning", Toast.LENGTH_LONG).show();
            }
            else {

//                Toast.makeText(this, "Something was scanned", Toast.LENGTH_LONG).show();
                String contents = data.getStringExtra("SCAN_RESULT");
                String format = data.getStringExtra("SCAN_RESULT_FORMAT");


                String[]  info = contents.split(";");


                if(info[0].equals("sana") && info[1].equals("sana") && info[2].equals("hehe")){
                    Toast.makeText(this, contents,Toast.LENGTH_LONG).show();
                    Intent i = new Intent(VerLoginCredSuc.this, ScanSuccess.class);
                    startActivity(i);
                    finish();

                }else{

                    //BOSS DITO MO ILAGAY YUNG DIALOG BOX PAG DI NARERECOGNIZE YUNG QRCODE

                    dialog_errorqr = new Dialog(this);
                    ShowDialogErrorQR();


                }
//                Gson gson = new Gson();
//                JsonObject jsonObject = gson.fromJson(contents, JsonObject.class);
//                String activityName = "";
//                String description = "";
//                String eventVenue = "";
//
//                if(jsonObject.has("activityName") || jsonObject.has("description") || jsonObject.has("eventVenue")){
//                    activityName = jsonObject.get("activityName").getAsString();
//                    description = jsonObject.get("description").getAsString();
//                    eventVenue = jsonObject.get("eventVenue").getAsString();
//                    Toast.makeText(this, activityName, Toast.LENGTH_SHORT).show();
//
//                }

//                Intent i = new Intent(VerLoginCredSuc.this, ScanSuccess.class);
//                startActivity(i);
//                finish();
            }
        }
        else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }


    public void ShowDialogErrorQR() {
        dialog_errorqr.setContentView(R.layout.dialog_errorqr);

        closeDialogErrorQR = (ImageView) dialog_errorqr.findViewById(R.id.closeDialogErrorQR);
        imageErrorQR = (ImageView) dialog_errorqr.findViewById(R.id.imageErrorQR);
        okbtn = (Button) dialog_errorqr.findViewById(R.id.okbtn);
        titleErrorQR = (TextView) dialog_errorqr.findViewById(R.id.titleErrorQR);
        exErrorRQ = (TextView) dialog_errorqr.findViewById(R.id.exErrorRQ);

        final Activity activity = this;
        okbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator integrator = new IntentIntegrator(activity);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("Scan");
                integrator.setCameraId(0);
                integrator.setCaptureActivity(CaptureActivityPortrait.class);
                integrator.setBeepEnabled(false);
                integrator.setBarcodeImageEnabled(false);
                integrator.initiateScan();

            }
        });

        closeDialogErrorQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog_errorqr.dismiss();
            }
        });

        dialog_errorqr.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog_errorqr.show();
    }


//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//
//        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
//            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
//                == PackageManager.PERMISSION_GRANTED){
//
//            }
//        }
//    }

}
