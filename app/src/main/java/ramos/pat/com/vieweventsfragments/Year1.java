package ramos.pat.com.vieweventsfragments;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Year1 extends Fragment {
    private RecyclerView mRecyclerView;
    //    private List<> mList;
    RecyclerView list;
    private RecyclerViewAdapterPort mRecyclerViewAdapter;
    String dates [] = {"Jan 01", "Jan 02", "Jan 14", "Feb 03", "Feb 14", "Feb 30", "Mar 03", "Mar 05"};
    String titles[] = {"Title One", "Title Two", "Title Three", "Title Four","Title Five","Title Six","Title Seven","Title Eight"};
    String descriptions[] = {"Description One...", "Description Two...", "Description Three...", "Description Four...","Description Five...","Description Six...","Description Seven...","Description Eight..."};

    private List<Contact> listContact;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.activity_year1, container, false);
        list = rootView.findViewById(R.id.list2);
        mRecyclerView = rootView.findViewById(R.id.list2);

        mRecyclerViewAdapter = new RecyclerViewAdapterPort(getContext(),listContact);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mRecyclerViewAdapter);

        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listContact = new ArrayList<>();

        for (int i = 0 ; i < dates.length ; i++){
            listContact.add(new Contact(titles[i], descriptions[i], dates[i]));
        }



    }


}
