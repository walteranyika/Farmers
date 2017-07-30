package io.farmers.farmers;

import android.*;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import io.farmers.farmers.models.Farmer;

public class FarmersActivity extends AppCompatActivity {
    EditText edtNames, edtPhone, edtLocation, edtProffession;
    DatabaseReference farmersRef;
    private FusedLocationProviderClient mFusedLocationClient;
    double lat = 0.0;
    double lon = 0.0;
    ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmers);
        edtNames = (EditText) findViewById(R.id.edtNames);
        edtPhone = (EditText) findViewById(R.id.edtPhoneNumber);
        edtLocation = (EditText) findViewById(R.id.edtLocation);
        edtProffession = (EditText) findViewById(R.id.edtProfession);
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setMessage("Saving your Info.....");
        getLocation();
    }

    private void getLocation() {
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{android.Manifest.permission.ACCESS_COARSE_LOCATION, android.Manifest.permission.ACCESS_FINE_LOCATION}, 101);
            }
            return;
        }
        mFusedLocationClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null) {
                    lat = location.getLatitude();
                    lon = location.getLongitude();
                }
            }
        });
    }

    public void register(View view) {
        String names = edtNames.getText().toString().trim();
        String phone = edtPhone.getText().toString().trim();
        String location = edtLocation.getText().toString().trim();
        String profession = edtProffession.getText().toString().trim();
        validate(names, edtNames);
        validate(phone, edtPhone);
        validate(location, edtLocation);
        validate(profession, edtProffession);
        farmersRef = FirebaseDatabase.getInstance().getReference().child("farmers/" + phone + "/basic");
        Farmer farmer = new Farmer(names, phone, location, profession, lat, lon);
        mProgressDialog.show();
        farmersRef.setValue(farmer).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Snackbar.make(edtNames, "Basic Info Was Added Successfully", Snackbar.LENGTH_LONG).show();

                edtNames.setText("");
                edtPhone.setText("");
                edtLocation.setText("");
                edtProffession.setText("");
                mProgressDialog.dismiss();
            }
        });


    }

    private void validate(String text, EditText editText) {
        if (text.isEmpty()) {
            editText.setError("Empty Field!");
            return;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 101:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.d("POINT", "GPS PERMISSION WAS FINALLY GRANTED");
                }
                break;
        }
    }


}
