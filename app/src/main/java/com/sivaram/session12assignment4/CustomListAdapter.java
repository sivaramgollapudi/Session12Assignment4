package com.sivaram.session12assignment4;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by User on 05/10/2017.
 */

public class CustomListAdapter extends BaseAdapter {

    // Declare App Context and PersonInfo List Collection Object
    Context context;
    List<PersonInfo> personInfoList;

    // Constructor
    public CustomListAdapter(Context context, List<PersonInfo> personInfoList) {
        this.context = context;
        this.personInfoList = personInfoList;
    }

    // Override methods from Base Adapter
    @Override
    public int getCount() {
        return personInfoList.size();
    }

    @Override
    public Object getItem(int position) {
        return personInfoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    // Display View
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        // Inflate Custom Layout
        View customPersonInfoView= View.inflate(context,R.layout.person_details,null);

        // Find TextView By Inflated Layout and Typecast the objects to access
        TextView nameTextView = (TextView)customPersonInfoView.findViewById(R.id.nameTextView);
        TextView contactNumberTextView = (TextView) customPersonInfoView.findViewById(R.id.contactNumberTextView);
        TextView dateOfBirthTextView = (TextView) customPersonInfoView.findViewById(R.id.dateOfBirthTextView);

        // Assign Data To Type Casted Text Views from person Info Colleciton Object Position
        nameTextView.setText(personInfoList.get(position).getName());
        contactNumberTextView.setText(personInfoList.get(position).getContactNumber());
        dateOfBirthTextView.setText(personInfoList.get(position).getDateOfBirth());

        // Return Custom Layout
        return customPersonInfoView;
    }
}
