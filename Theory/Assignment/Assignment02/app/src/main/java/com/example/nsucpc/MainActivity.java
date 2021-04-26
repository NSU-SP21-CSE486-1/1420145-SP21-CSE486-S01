package com.example.nsucpc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nsucpc.db.StudentDatabase;
import com.example.nsucpc.models.Student;

public class MainActivity extends AppCompatActivity /*implements AdapterView.OnItemSelectedListener*/ {
    private EditText emailET,passwordET,birthdayET,phoneET,nidET,presentAddET,permanentAddET,
            nameET,idET,deptET;
    /*private TextView deptTV;*/
    /*private Button btn;*/
   /* public static final String EMAIL="jubair.ovi@northsouth.edu";
    public static final String PAAS="1234";*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameET=findViewById(R.id.nameinput);
        emailET=findViewById(R.id.emailinputET);
        idET=findViewById(R.id.idinputET);
        passwordET=findViewById(R.id.passwoedinput);
        /*btn=findViewById(R.id.login_Button);*/
        deptET=findViewById(R.id.dept_name_imput);
        birthdayET=findViewById(R.id.birthday_input);
        phoneET=findViewById(R.id.phone_input);
        nidET=findViewById(R.id.nid_input);
        presentAddET=findViewById(R.id.present_address_input);
        permanentAddET=findViewById(R.id.permanent_address_input);

        /*Spinner dspinner =findViewById(R.id.dept_spinner);
        dspinner.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.dept_items, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        dspinner.setAdapter(adapter);*/
    }

    /*public void Login(View view) {
        String email = emailET.getText().toString();
        String pass = passwordET.getText().toString();
        if (email.equals(EMAIL) && pass.equals(PAAS)){
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
        }
        if (email.isEmpty() && pass.isEmpty()){
            Toast.makeText(this, "There isn't any email and pass  ", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "wrong email or password ", Toast.LENGTH_SHORT).show();
        }
    }*/

    /*@Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
    }*/

    /*@Override
    public void onNothingSelected(AdapterView<?> parent) {

    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.student_reg,menu);
        return true;
        /*return super.onCreateOptionsMenu(menu);*/
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.item_save:
                saveStudentoDatabase();
                break;
            case R.id.item_show:
                startActivity(new Intent(MainActivity.this,
                        StudentListActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void saveStudentoDatabase() {
        String name=nameET.getText().toString();
        String email=emailET.getText().toString();
        String pass=passwordET.getText().toString();
        String id=idET.getText().toString();
        String dept=deptET.getText().toString();
        String birthday=birthdayET.getText().toString();
        String nid=nidET.getText().toString();
        String phone=phoneET.getText().toString();
        String presentAddress=presentAddET.getText().toString();
        String permanentAddress=permanentAddET.getText().toString();

        Student student=new Student(name,email,pass,id,dept,birthday,nid,phone,presentAddress,
                permanentAddress);
        final long intsertedRowID= StudentDatabase.getInstance(this).getStudentDao()
                .insertNewStudent(student);
        if (intsertedRowID >0){
            Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
            resetViews();
            startActivity(new Intent(MainActivity.this,StudentListActivity.class));
        }
        else {
            Toast.makeText(this, "Faield to save", Toast.LENGTH_SHORT).show();
        }
    }

    private void resetViews() {
        nameET.setText("");
        emailET.setText("");
        passwordET.setText("");
        idET.setText("");
        deptET.setText("");
        birthdayET.setText("");
        nidET.setText("");
        phoneET.setText("");
        presentAddET.setText("");
        permanentAddET.setText("");
        nidET.requestFocus();
    }
}
