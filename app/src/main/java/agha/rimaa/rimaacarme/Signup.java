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

public class Signup extends AppCompatActivity implements View.OnClickListener
{
    private EditText etEmail;
    private EditText etPassword;
    private Button btnSave;
    private FirebaseAuth auth;
    private FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnSave = (Button) findViewById(R.id.btnSave);
        auth = FirebaseAuth.getInstance();
        firebaseUser = auth.getCurrentUser();
        btnSave.setOnClickListener(this);
    }


            private void dataHandler() {
                String stEmail = etEmail.getText().toString();
                String stPassword = etPassword.getText().toString();
                boolean isOk = true;
                if (stEmail.length() == 0 || stEmail.indexOf("@") < 1) {
                    etEmail.setError("Wrong Email.");
                    isOk = false;
                }
                if (stPassword.length() < 8) {
                    etPassword.setError("Bad Password.");
                    isOk = false;
                }
                if (isOk)
                    createAcount(stEmail, stPassword);

            }

            private void createAcount(String stEmail, String stPassword) {
                auth.createUserWithEmailAndPassword(stEmail, stPassword).addOnCompleteListener(Signup.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Signup.this, "Authentication Successful.", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(Signup.this, "Authentication Failed." + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            task.getException().printStackTrace();
                        }
                    }

                });
            }

    @Override
    public void onClick(View view) {
        if (view==btnSave) {
            Intent i = new Intent(this, ProfileActivity.class);
            startActivity(i);
        }
            dataHandler();
        }

    }

