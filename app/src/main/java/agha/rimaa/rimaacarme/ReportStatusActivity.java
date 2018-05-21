package agha.rimaa.rimaacarme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ReportStatusActivity extends AppCompatActivity implements View.OnClickListener
{
    private Button btnStatus;
    private Button btnMap;
    private ImageButton imDelek;
    private ImageButton imbanshar;
    private ImageButton imHot;
    private  ImageButton imStop;
    private ImageButton imAccedent;
    private ImageButton imHealthy;
    private ImageButton imLost;
    private ImageButton imOther;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reportstatus);
        btnStatus = (Button) findViewById(R.id.btnStatus);
        btnStatus.setOnClickListener(this);
        imDelek=(ImageButton) findViewById(R.id.imDelek);
        imbanshar=(ImageButton) findViewById(R.id.imbanshar);
        imHot=(ImageButton) findViewById(R.id.imHot);
        imStop=(ImageButton) findViewById(R.id.imStop);
        imAccedent=(ImageButton) findViewById(R.id.imAccedent);
        imHealthy=(ImageButton) findViewById(R.id.imHealthy);
        imLost=(ImageButton) findViewById(R.id.imLost);
        imOther=(ImageButton) findViewById(R.id.imOther);
        btnMap=(Button) findViewById(R.id.btnMap);
        btnMap.setOnClickListener( this);
    }
    public void onClick(View view)
    {
        if (view==btnStatus)
        {
            Intent i= new Intent(this, StatusActivity.class);
            startActivity(i);
        }

        if (view==btnMap)
        {
            Intent i=new Intent(this, MapsActivity.class);
            startActivity(i);
        }

    }
}
