package com.myproject.booksapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zaag;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public class Intro_Activity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {

    TextView textview;
    Button button;
    private GoogleApiClient googleApiClient;
    private GoogleSignInOptions gso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        textview = findViewById(R.id.username);
        button = findViewById(R.id.btn_getstarted);
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        googleApiClient=new GoogleApiClient.Builder(this).enableAutoManage(this,this)
                .addApi(Auth.GOOGLE_SIGN_IN_API,gso).build();
      button=findViewById(R.id.btn_getstarted);
      button.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent i=new Intent(Intro_Activity.this,MainActivity.class);
              startActivity(i);
          }
      });


    }
    @Override
    public void onConnectionFailed (@NonNull ConnectionResult connectionResult){

    }

    @Override
    protected void onStart() {
        super.onStart();
        OptionalPendingResult<GoogleSignInResult>opr=Auth.GoogleSignInApi.silentSignIn(googleApiClient);
        if (opr.isDone()){
            GoogleSignInResult result=opr.get();
            signinresult(result);
        }else {
            opr.setResultCallback(new ResultCallback<GoogleSignInResult>() {
                @Override
                public void onResult(@NonNull GoogleSignInResult result) {
                    signinresult(result);
                }
            });
        }
    }

    private void signinresult(GoogleSignInResult result){
        if (result.isSuccess()){
            GoogleSignInAccount account=result.getSignInAccount();
            textview.setText(account.getDisplayName());
        }

    }

   
}