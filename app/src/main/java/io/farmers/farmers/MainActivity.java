package io.farmers.farmers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void farmersSection(View view) {
      startActivity(new Intent(this, FarmersActivity.class));
    }

    public void agrodealerSection(View view) {
      startActivity(new Intent(this,AgroDealerActivity.class));
    }
}
