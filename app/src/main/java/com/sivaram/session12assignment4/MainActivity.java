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

    // Create Objects of ListView, PersonsInfo List Array, Custom List Adapter
    ListView personDetailsListView;
    List<PersonInfo> personsInfoList = new ArrayList();
    CustomListAdapter customListAdapter;

    // Create Alert Dialog.
    AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Type Cast ListView to Java Object
        personDetailsListView = (ListView)findViewById(R.id.personDetailsListView);


        // Initialize Custom List Adapter, along with person Info Collection Object.
        customListAdapter = new CustomListAdapter(getApplicationContext(), personsInfoList);

        // Set Adapter to Custom List
        personDetailsListView.setAdapter(customListAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Add Menu Item To Options Menu
        menu.add("Add");
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // On Click of Add Menu Items. Initialize Alert Dialog
        // which consits of Custom Layout as View.
        dialog = new AlertDialog.Builder(MainActivity.this).setView(R.layout.add_new_person).create();

        // Set Alert Dialog Title.
        dialog.setTitle("Enter the Details");

        // Show Alert Dialog
        dialog.show();

        // Type Cast Buttons of Save and Cancel which are available in Custom View, which shows in Alert Dialog.
        Button dialogSaveButton = (Button)dialog.findViewById(R.id.saveButton);
        Button dialogCancelButton = (Button) dialog.findViewById(R.id.cancelButton);

        // SEt On Click Listener For Save Button which is in Alert Dialog
        dialogSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                savePersonDetailsAndUpdateList();
                Toast.makeText(MainActivity.this, "Save Button Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        // Set On Click Listener For Cance Button
        dialogCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        return true;
    }

    private void savePersonDetailsAndUpdateList(){

        // Type Cast Edit Text Views to Java OBject, which are available in Alert Dialog Layout.
        EditText nameEditText = (EditText) dialog.findViewById(R.id.nameEditText);
        EditText contactNumberEditText = (EditText) dialog.findViewById(R.id.contactNumberEditText);
        EditText dateOfBirthEditText = (EditText) dialog.findViewById(R.id.dateOfBirthEditText);

        // Validate Entry
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

        // Add New Value to Person List Collection Object.
        personsInfoList.add(new PersonInfo(nameEditText.getText().toString(),
                                            contactNumberEditText.getText().toString(),
                                            dateOfBirthEditText.getText().toString()));


        // Notify Custom Adapter Update. Which will refresh the screen
        customListAdapter.notifyDataSetChanged();

        // Close Alert Dialog upon successful creation
        dialog.dismiss();


        // Show Toast of newly added item and refresh screen.
        Toast.makeText(this, nameEditText.getText().toString() + " " +
                             contactNumberEditText.getText().toString() + " " +
                             dateOfBirthEditText.getText().toString(), Toast.LENGTH_SHORT).show();
    }
}
