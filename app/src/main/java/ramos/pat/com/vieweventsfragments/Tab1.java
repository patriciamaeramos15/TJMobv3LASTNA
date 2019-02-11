package ramos.pat.com.vieweventsfragments;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class Tab1 extends Fragment {

    ListView list;
    String dates [] = {"Jan 01", "Jan 02", "Jan 14", "Feb 03", "Feb 14", "Feb 30", "Mar 03", "Mar 05"};
    String titles[] = {"Title One", "Title Two", "Title Three", "Title Four","Title Five","Title Six","Title Seven","Title Eight"};
    String descriptions[] = {"Description One...", "Description Two...", "Description Three...", "Description Four...","Description Five...","Description Six...","Description Seven...","Description Eight..."};



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.tab1, container, false);
        list = rootView.findViewById(R.id.list1);


        return rootView;
    }

    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String myDates[];
        String myTitles[];
        String myDescriptions[];

        MyAdapter(Context c, String[] dates, String[] titles, String[] descriptions){
            super(c,R.layout.row, R.id.text1, titles);
            this.context=c;
            this.myDates=dates;
            this.myTitles=titles;
            this.myDescriptions=descriptions;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            Button myDate = row.findViewById(R.id.button1);
            TextView myTitle = row.findViewById(R.id.text1);
            TextView myDescription = row.findViewById(R.id.text2);
            myDate.setText(dates[position]);
            myTitle.setText(titles[position]);
            myDescription.setText(descriptions[position]);

            MyAdapter adapter = new MyAdapter(getContext(), dates, titles, descriptions);

            return row;

        }
    }
}
