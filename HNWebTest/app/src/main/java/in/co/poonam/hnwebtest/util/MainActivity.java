package in.co.poonam.hnwebtest.util;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import in.co.poonam.hnwebtest.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FrameLayout layoutCandidates = findViewById(R.id.layoutCandidates);
        FrameLayout layoutOrganization = findViewById(R.id.layoutOrganization);
        FrameLayout layoutIdeas = findViewById(R.id.layoutIdeas);
        LinearLayout layoutCharities = findViewById(R.id.layoutCharities);
        layoutCharities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (new CommonMethods().isInternetConnection(MainActivity.this)) {
                    Intent i = new Intent(MainActivity.this, EventListActivity.class);
                    startActivity(i);
                }else{
                    Toast.makeText(MainActivity.this, "Please check internet connection.", Toast.LENGTH_SHORT).show();

                }
            }
        });
        layoutIdeas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (new CommonMethods().isInternetConnection(MainActivity.this)) {
                    Intent i = new Intent(MainActivity.this, EventListActivity.class);
                    startActivity(i);
                }else{
                    Toast.makeText(MainActivity.this, "Please check internet connection.", Toast.LENGTH_SHORT).show();

                }
            }
        });
        layoutOrganization.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (new CommonMethods().isInternetConnection(MainActivity.this)) {
                    Intent i = new Intent(MainActivity.this, EventListActivity.class);
                    startActivity(i);
                }else{
                    Toast.makeText(MainActivity.this, "Please check internet connection.", Toast.LENGTH_SHORT).show();

                }
            }
        });
        layoutCandidates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (new CommonMethods().isInternetConnection(MainActivity.this)) {
                    Intent i = new Intent(MainActivity.this, EventListActivity.class);
                    startActivity(i);
                }else{
                    Toast.makeText(MainActivity.this, "Please check internet connection.", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
