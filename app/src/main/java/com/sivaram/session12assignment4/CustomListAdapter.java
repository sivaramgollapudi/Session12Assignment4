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

    Context context;
    List<PersonInfo> personInfoList;

    public CustomListAdapter(Context context, List<PersonInfo> personInfoList) {
        this.context = context;
        this.personInfoList = personInfoList;
    }

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

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View customPersonInfoView= View.inflate(context,R.layout.person_details,null);
        TextView nameTextView = (TextView)customPersonInfoView.findViewById(R.id.nameTextView);
        TextView contactNumberTextView = (TextView) customPersonInfoView.findViewById(R.id.contactNumberTextView);
        TextView dateOfBirthTextView = (TextView) customPersonInfoView.findViewById(R.id.dateOfBirthTextView);

        nameTextView.setText(personInfoList.get(position).getName());
        contactNumberTextView.setText(personInfoList.get(position).getContactNumber());
        dateOfBirthTextView.setText(personInfoList.get(position).getDateOfBirth());

        return customPersonInfoView;
    }
}
