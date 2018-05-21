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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LogInActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etEmail;
    private EditText etPassw;
    private Button btnForget;
    private Button btnUp;
    private Button btnIn;
    private FirebaseUser firebaseUser;
    private FirebaseAuth auth;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassw = (EditText) findViewById(R.id.etPassw);
        btnForget = (Button) findViewById(R.id.btnForget);
        btnUp=(Button) findViewById(R.id.btnUp);
        btnUp.setOnClickListener(this);
        btnIn=(Button) findViewById(R.id.btnIn);
        btnIn.setOnClickListener(this);
        auth= FirebaseAuth.getInstance();
        firebaseUser= auth.getCurrentUser();
        if (firebaseUser!=null&&firebaseUser.getEmail()!=null&&firebaseUser.getEmail().length()>0)
        {
            Intent i=new Intent(this, MainActivity.class);
            startActivity(i);
            finish();
        }

    }

    private void signIn(String email, String passw)
    {
        auth.signInWithEmailAndPassword(email, passw).addOnCompleteListener(LogInActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task)
            {
                if (task.isSuccessful()) {
                    Toast.makeText(LogInActivity.this, "signIn Successful.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LogInActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(LogInActivity.this,"signIn failed."+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();
                }

            }
        });

    }
    private void dataHandler()
    {
        String stEmail= etEmail.getText().toString();
        String stPassw= etPassw.getText().toString();
        boolean isOk=true;
        if (stEmail.length()==0 || stEmail.indexOf("@")<1)
        {
            etEmail.setError("Wrong Email.");
            isOk=false;
        }
        if (stPassw.length()<8)
        {
            etPassw.setError("Wrong Password.");
            isOk=false;
        }
        if (isOk)
            signIn(stEmail,stPassw);
    }

    @Override
    public void onClick(View view)
    {
        if (view==btnUp)
        {
            Intent i= new Intent(this, Signup.class);
            startActivity(i);
        }
        if (view==btnIn)
        {
            Intent i=new Intent(this, ReportStatusActivity.class);
            dataHandler();
        }

    }
}


