package com.example.studentdatasave;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.studentdatasave.model.Student;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener {

    EditText id, first_name, last_name, email, password, final_password, pincode, phone;
    Spinner city, state, country;
    Button insert_button, update_button, delete_button, get_button, clear_button;
    ImageView imageview;
    int i = 0;
    Uri imageUri;
    Bitmap bitmap;
    byte[] data1;
    DataBaseHelper DB;
    Student student;
    Cursor res;
    String[] cityarray = {"Ahmedabad", "Surat", "Hariyana", "Patiyala", "Lae", "Arava", "Denpasar", "Singaraja"};
    String[] statearray = {"Gujarat", "Punjab", "Papua", "Bali"};
    String[] countryarray = {"India", "Indonesia"};
    String scountry, sstate, scity;
    String sid,sfname,slast,semail,spaswword,sfinalp,spincode,sphone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    public void initView() {

        id = findViewById(R.id.id);
        first_name = findViewById(R.id.first_name);
        last_name = findViewById(R.id.last_name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        final_password = findViewById(R.id.final_password);
        pincode = findViewById(R.id.pincode);
        phone = findViewById(R.id.phone);
        city = findViewById(R.id.city);
        state = findViewById(R.id.state);
        country = findViewById(R.id.country);
        insert_button = findViewById(R.id.insert_button);
        update_button = findViewById(R.id.update_button);
        delete_button = findViewById(R.id.delete_button);
        get_button = findViewById(R.id.get_button);
        clear_button = findViewById(R.id.clear_button);
        imageview=findViewById(R.id.imageview);
        DB = new DataBaseHelper(MainActivity.this);

        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gallery = new Intent(Intent.ACTION_GET_CONTENT);
                gallery.setType("image/*");
                startActivityForResult(gallery, i);
            }
        });

        insert_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String sid = id.getText().toString();
                String sfname = first_name.getText().toString();
                String slast = last_name.getText().toString();
                String semail = email.getText().toString();
                String spaswword =password.getText().toString();
                String sfinalp = final_password.getText().toString();
                String spincode = pincode.getText().toString();
                String sphone = phone.getText().toString();
                student = new Student(sid,sfname,slast,semail,spaswword,sfinalp,spincode,sphone,scountry,sstate,scity,data1);
                student.setId(sid);
                student.setName(sfname);
                student.setSurname(slast);
                student.setEmail(semail);
                student.setPassword(spaswword);
                student.setConfirm_password(sfinalp);
                student.setPin_code(spincode);
                student.setPhone_no(sphone);
                student.setCountry(scountry);
                student.setState(sstate);
                student.setCity(scity);
                student.setImage(data1);
                DB.insertData(student);
                Toast.makeText(getApplicationContext(),"data insert successfully",Toast.LENGTH_SHORT).show();
            }
        });
        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sid = id.getText().toString();
                String sfname = first_name.getText().toString();
                String slast = last_name.getText().toString();
                String semail = email.getText().toString();
                String spaswword =password.getText().toString();
                String sfinalp = final_password.getText().toString();
                String spincode = pincode.getText().toString();
                String sphone = phone.getText().toString();
                student = new Student(sid, sfname, slast, semail, spaswword, sfinalp, spincode, sphone,scountry,sstate,scity,data1);
                student.setId(sid);
                student.setName(sfname);
                student.setSurname(slast);
                student.setEmail(semail);
                student.setPassword(spaswword);
                student.setConfirm_password(sfinalp);
                student.setPin_code(spincode);
                student.setPhone_no(sphone);
                student.setCountry(scountry);
                student.setState(sstate);
                student.setCity(scity);
                student.setImage(data1);
                DB.updateData(student);
                Toast.makeText(getApplicationContext(),"data update successfully",Toast.LENGTH_SHORT).show();
            }
        });
        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sid = id.getText().toString();
                String sfname = first_name.getText().toString();
                String slast = last_name.getText().toString();
                String semail = email.getText().toString();
                String spaswword =password.getText().toString();
                String sfinalp = final_password.getText().toString();
                String spincode = pincode.getText().toString();
                String sphone = phone.getText().toString();
                student = new Student(sid, sfname, slast, semail, spaswword, sfinalp, spincode, sphone,scountry,sstate,scity,data1);
                student.setId(sid);
                student.setName(sfname);
                student.setSurname(slast);
                student.setEmail(semail);
                student.setPassword(spaswword);
                student.setConfirm_password(sfinalp);
                student.setPin_code(spincode);
                student.setPhone_no(sphone);
                student.setCountry(scountry);
                student.setState(sstate);
                student.setCity(scity);
                student.setImage(data1);
                DB.deleteData(student);
                Toast.makeText(getApplicationContext(),"data delete successfully",Toast.LENGTH_SHORT).show();
            }
        });

        get_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DB.getReadableDatabase();
                res=DB.fatchData();
                if(res.moveToFirst())
                {
                    do{
                        student = new Student(sid,sfname,slast,semail,spaswword,sfinalp,spincode,sphone,scountry,sstate,scity,data1);
                        id.setText(res.getString(0));
                        first_name.setText(res.getString(1));
                        last_name.setText(res.getString(2));
                        email.setText(res.getString(3));
                        password.setText(res.getString(4));
                        final_password.setText(res.getString(5));
                        scountry=res.getString(6);
                        sstate=res.getString(7);
                        scity=res.getString(8);
                        pincode.setText(res.getString(9));
                        phone.setText(res.getString(10));
//                        data1=res.getBlob(11);
//                        imageview.setImageBitmap(BitmapFactory.decodeByteArray(student.data,0,student.data.length));
//                        imageview.setImageBitmap(bitmap);
//                        data1=res.getBlob(res.getColumnIndex());
                    }while(res.moveToNext());
                }
            }
        });
        clear_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id.setText("");
                first_name.setText("");
                last_name.setText("");
                email.setText("");
                password.setText("");
                final_password.setText("");
                country.setSelection(0);
                state.setSelection(0);
                city.setSelection(0);
                pincode.setText("");
                phone.setText("");
                imageview.setImageBitmap(null);
            }
        });
        spinner();
    }

    public void spinner() {

        country.setOnItemSelectedListener(this);
        ArrayAdapter countryadapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, countryarray);
        countryadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        country.setAdapter(countryadapter);
        country.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                scountry = (String) country.getItemAtPosition(country.getSelectedItemPosition());
                Toast.makeText(MainActivity.this, "Selected Item " + scountry, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        state.setOnItemSelectedListener(this);
        ArrayAdapter stateadapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, statearray);
        stateadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        state.setAdapter(stateadapter);
        state.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sstate = (String) state.getItemAtPosition(state.getSelectedItemPosition());
                Toast.makeText(MainActivity.this, "Selected Item " + sstate, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        city.setOnItemSelectedListener(this);
        ArrayAdapter cityadapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, cityarray);
        cityadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        city.setAdapter(cityadapter);
        city.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                scity = (String) city.getItemAtPosition(city.getSelectedItemPosition());
                Toast.makeText(MainActivity.this, "Selected Item " + scity, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == i && resultCode == RESULT_OK){
            imageUri = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
                data1 = getBitmapAsByteArray(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
            imageview.setImageBitmap(bitmap);
        }
    }

    private byte[] getBitmapAsByteArray(Bitmap bitmap) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, outputStream);
        return outputStream.toByteArray();
    }
}
