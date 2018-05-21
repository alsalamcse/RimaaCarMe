package agha.rimaa.rimaacarme;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

import agha.rimaa.rimaacarme.pkgData.Report;

public class AddToReportActivity extends AppCompatActivity
{
    private EditText etType;
    private EditText etPhone;
    private Button btnLocation;
    private Button btnSave;
    private EditText etLat;
    private EditText etLng;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_report);
        etLat=(EditText) findViewById(R.id.etLat);
        etLng=(EditText) findViewById(R.id.etLng);
        etType=(EditText) findViewById(R.id.etType);
        etPhone=(EditText) findViewById(R.id.etPhone);
        btnLocation=(Button) findViewById(R.id.btnLocation);
        btnLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(AddToReportActivity.this, MapsActivity.class);
                startActivity(i);
            }
        });
        btnSave=(Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataHandler();
            }
        });
    }


    public void dataHandler()
    {
        String stType=etType.getText().toString();
        String stPhone=etPhone.getText().toString();
        String stLat=etLat.getText().toString();
        String stLng=etLng.getText().toString();


        double lat=Double.parseDouble(stLat);
        double lng=Double.parseDouble(stLng);

        Report r=new Report();
        r.setType(stType);
        r.setPhone(stPhone);
        r.setLat(lat);
        r.setLng(lng);

        FirebaseAuth auth= FirebaseAuth.getInstance();
        FirebaseUser user=auth.getCurrentUser();
        String email=user.getEmail();
        email=email.replace('.','*');

        //6. building data refernce=data path=data address
        DatabaseReference reference;
        //** todo לקבלת קישור למסד הניתונים שלנו
        //** todo קישור הינו לשורש של המסד הניתונים
        reference= FirebaseDatabase.getInstance().getReference();
        //7. saving data on the firebase database
        String key=reference.child("reports").child("myList").push().getKey();
        r.setKeyId(key);
        r.setEmail(email);
        r.setTime(new Date());
        r.setStatus("Wait");

        reference.child("reports").child(key).setValue(r).addOnCompleteListener(this, new OnCompleteListener<Void>() {
            //*8
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful())
                {
                    Toast.makeText(AddToReportActivity.this, "Add report Succesful", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else
                {
                    Toast.makeText(AddToReportActivity.this, "Add Product Faild", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
