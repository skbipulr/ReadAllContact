package com.etl.readallcontact;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.tomash.androidcontacts.contactgetter.entity.ContactData;
import com.tomash.androidcontacts.contactgetter.main.ContactDataFactory;
import com.tomash.androidcontacts.contactgetter.main.FieldType;
import com.tomash.androidcontacts.contactgetter.main.contactsGetter.ContactsGetterBuilder;
import com.tomash.androidcontacts.contactgetter.main.contactsSaver.ContactsSaverBuilder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 1;
    private ContactsGetterBuilder contactData;
    private RecyclerViewAdapter adapter;
    private List<Contacts> contactsList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.my_recycler_view);


        int permissionCheck = ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.READ_CONTACTS);


        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){

            if (permissionCheck == PackageManager.PERMISSION_GRANTED){

                List<ContactData> contactDatas  = new ContactsGetterBuilder(this)
                        .onlyWithPhones().buildList();

              /*  adapter = new RecyclerViewAdapter(MainActivity.this,contactDatas);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                recyclerView.setAdapter(adapter);

                adapter.notifyDataSetChanged();*/


                //  Toast.makeText(this, ""+contactData, Toast.LENGTH_LONG).show();
                Log.d("key","contact1: ");
                String phone = contactDatas.get(0).getPhoneList().get(0).getMainData();
                String name = contactDatas.get(0).getCompositeName().toString();

                Toast.makeText(this, ""+name+":" +phone, Toast.LENGTH_SHORT).show();

               // arrayAdapter = new ArrayAdapter<ContactData>(this,android.R.layout.simple_list_item_1, (List<ContactData>) contactData);
                Log.d("key","contact2");
                //listView.setAdapter((ListAdapter) arrayAdapter);
            }else {
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.READ_CONTACTS},
                        MY_PERMISSIONS_REQUEST_READ_CONTACTS);
            }
        }





    }


}
