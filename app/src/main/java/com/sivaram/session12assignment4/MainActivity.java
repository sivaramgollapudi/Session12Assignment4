package com.sivaram.session12assignment4;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView personDetailsListView;
    List<PersonInfo> personsInfoList = new ArrayList();
    CustomListAdapter customListAdapter;
    AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        personDetailsListView = (ListView)findViewById(R.id.personDetailsListView);
        //personsInfoList = new ArrayList();

        //for(int i=1;i<=10;i++){
        //    personsInfoList.add(new PersonInfo("Name" + i ,"Contact Number " + i,new Date().toString()));
        //}

        customListAdapter = new CustomListAdapter(getApplicationContext(), personsInfoList);
        personDetailsListView.setAdapter(customListAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Add");
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        dialog = new AlertDialog.Builder(MainActivity.this).setView(R.layout.add_new_person).create();

        dialog.setTitle("Enter the Details");
        dialog.show();

        Button dialogSaveButton = (Button)dialog.findViewById(R.id.saveButton);
        Button dialogCancelButton = (Button) dialog.findViewById(R.id.cancelButton);


        dialogSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                savePersonDetailsAndUpdateList();
                Toast.makeText(MainActivity.this, "Save Button Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        dialogCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        return true;
    }

    private void savePersonDetailsAndUpdateList(){
        EditText nameEditText = (EditText) dialog.findViewById(R.id.nameEditText);
        EditText contactNumberEditText = (EditText) dialog.findViewById(R.id.contactNumberEditText);
        EditText dateOfBirthEditText = (EditText) dialog.findViewById(R.id.dateOfBirthEditText);

        String validationFailed = "";
        if (nameEditText.getText().toString().isEmpty())
            validationFailed = "Name filed can't be empty \n";

        if (contactNumberEditText.getText().toString().isEmpty())
            validationFailed = validationFailed  + "Contact Number is required \n";

        if (dateOfBirthEditText.getText().toString().isEmpty())
            validationFailed += "Date of birth is required";

        if (!validationFailed.isEmpty()) {
            Toast.makeText(this, validationFailed, Toast.LENGTH_SHORT).show();
            return;
        }
        personsInfoList.add(new PersonInfo(nameEditText.getText().toString(),
                                            contactNumberEditText.getText().toString(),
                                            dateOfBirthEditText.getText().toString()));

        customListAdapter.notifyDataSetChanged();

        dialog.dismiss();

        Toast.makeText(this, nameEditText.getText().toString() + " " +
                             contactNumberEditText.getText().toString() + " " +
                             dateOfBirthEditText.getText().toString(), Toast.LENGTH_SHORT).show();
    }
}
