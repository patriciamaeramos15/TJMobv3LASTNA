package ramos.pat.com.vieweventsfragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import java.util.List;




import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context mContext;
    List<Contact> mData;
<<<<<<< Updated upstream
=======
    String id;
>>>>>>> Stashed changes

    public RecyclerViewAdapter(Context context, List<Contact> data) {
        mContext = context;
        mData = data;

    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v;


        v = LayoutInflater.from(mContext).inflate(R.layout.row, viewGroup, false);
        final MyViewHolder vHolder = new MyViewHolder(v);
        vHolder.item_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //INSERT HERE CODE FOR EVENT DETAILS
<<<<<<< Updated upstream
                Toast.makeText(mContext, "Hello", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(mContext, EventDetails.class);
=======

                String id = vHolder.activityId.getText().toString().trim();
                Intent i = new Intent(mContext, EventDetails.class);
                i.putExtra("activityId", id);
//                Toast.makeText(mContext, ""+id, Toast.LENGTH_SHORT).show();
>>>>>>> Stashed changes
                mContext.startActivity(i);

            }
        });
        vHolder.date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
<<<<<<< Updated upstream
                Toast.makeText(mContext, "Hello", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(mContext, EventDetails.class);
=======
                String id = vHolder.activityId.getText().toString().trim();
                Intent i = new Intent(mContext, EventDetails.class);
                i.putExtra("activityId", id);
>>>>>>> Stashed changes
                mContext.startActivity(i);

            }
        });





        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        String dateTime = mData.get(i).getDate();
        String date = dateTime.split(" ")[0];
        String month = date.split("-")[1];
        String year = date.split("-")[0];
        String day = date.split("-")[2];
        String status = "";
        try{
            status = mData.get(i).getStatus();
        }catch (Exception e){

        }
        switch(month){
            case "01":
                month = "Jan";
                break;
            case "02":
                month = "Feb";
                break;
            case "03":
                month = "Mar";
                break;
            case "04":
                month = "April";
                break;
            case "05":
                month = "May";
                break;
            case "06":
                month = "Jun";
                break;
            case "07":
                month = "Jul";
                break;
            case "08":
                month = "Aug";
                break;
            case "09":
                month = "Sep";
                break;
            case "10":
                month = "Oct";
                break;
            case "11":
                month = "Nov";
                break;
            case "12":
                month = "Dec";
                break;

            default:
                month = "";
                break;
        }
        myViewHolder.tv_name.setText(mData.get(i).getTitle());
        myViewHolder.tv_desc.setText(mData.get(i).getDescription());
        myViewHolder.tv_date.setText(month+ " " + day + " " + year );

        myViewHolder.activityId.setText(mData.get(i).getId());

        if(status.equals("absent")){
            myViewHolder.attended.setText("Not Attended");
            myViewHolder.item_contact.setClickable(false);
            myViewHolder.date.setClickable(false);
            myViewHolder.item_contact.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "Event no longer available", Toast.LENGTH_LONG).show();
                }
            });
            myViewHolder.date.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "Event no longer available", Toast.LENGTH_LONG).show();
                }
            });

        }else{
            myViewHolder.attended.setText("Attend event");
            //Dito mo fix yung color
            myViewHolder.attended.setTextColor(Color.parseColor("#008000"));
        }


    }

    @Override
    public int getItemCount() {
        return mData.size();
     }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private LinearLayout item_contact;
        private TextView tv_name;
        private TextView tv_desc;
        private TextView tv_date;
        private ImageView img;
        private Button date;
<<<<<<< Updated upstream
=======
        private TextView activityId;
        private TextView attended;
>>>>>>> Stashed changes


        public MyViewHolder(View itemView){
            super(itemView);
            activityId = itemView.findViewById(R.id.activityId);
            item_contact = itemView.findViewById(R.id.contact_item_id);
            date = itemView.findViewById(R.id.date);
            tv_name = itemView.findViewById(R.id.name_title);
            tv_desc = itemView.findViewById(R.id.desc);
            tv_date = itemView.findViewById(R.id.date);
<<<<<<< Updated upstream
=======
            attended = itemView.findViewById(R.id.attended);
>>>>>>> Stashed changes

        }
    }

}


