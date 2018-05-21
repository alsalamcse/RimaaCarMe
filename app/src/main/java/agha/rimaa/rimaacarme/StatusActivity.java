package agha.rimaa.rimaacarme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class StatusActivity extends AppCompatActivity
{
    private EditText etProblem;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);
        etProblem=(EditText) findViewById(R.id.etProblem);

    }
}
