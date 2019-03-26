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
                Toast.makeText(mContext, "Hello", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(mContext, EventDetails.class);
                mContext.startActivity(i);

            }
        });
        vHolder.date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Hello", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(mContext, EventDetails.class);
                mContext.startActivity(i);

            }
        });





        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.tv_name.setText(mData.get(i).getTitle());
        myViewHolder.tv_desc.setText(mData.get(i).getDescription());
        myViewHolder.tv_date.setText(mData.get(i).getDate());


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


        public MyViewHolder(View itemView){
            super(itemView);
            item_contact = itemView.findViewById(R.id.contact_item_id);
            date = itemView.findViewById(R.id.date);
            tv_name = itemView.findViewById(R.id.name_title);
            tv_desc = itemView.findViewById(R.id.desc);
            tv_date = itemView.findViewById(R.id.date);

        }
    }

}


