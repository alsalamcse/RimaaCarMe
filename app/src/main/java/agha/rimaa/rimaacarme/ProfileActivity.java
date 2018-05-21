package agha.rimaa.rimaacarme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener
{
    private EditText etName;
    private EditText etPhone;
    private EditText etAge;
    private EditText etLocation;
    private Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        etName= (EditText) findViewById(R.id.etName);
        etPhone=(EditText) findViewById(R.id.etPhone);
        etAge= (EditText) findViewById(R.id.etAge);
        etLocation=(EditText) findViewById(R.id.etLocation);
        btnAdd=(Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener((View.OnClickListener) this);
    }

public void onClick(View view) {
    if (view == btnAdd) {
        Intent i = new Intent(this, ReportStatusActivity.class);
        startActivity(i);
    }
}};



