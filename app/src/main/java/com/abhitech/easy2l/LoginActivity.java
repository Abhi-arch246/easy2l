package com.abhitech.easy2l;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class LoginActivity extends AppCompatActivity {
    EditText mob_number,otp;
    Button submit,submitotp;
    ImageButton imageButton;
    PhoneAuthProvider phoneAuthProvider;
    FirebaseAuth firebaseAuth;
    String manualotp,autootp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mob_number=findViewById(R.id.mob_number);
        firebaseAuth= FirebaseAuth.getInstance();
        submitotp=findViewById(R.id.submit_otp);
        otp=findViewById(R.id.otp);
        submit=findViewById(R.id.submit);
        imageButton=findViewById(R.id.imageButton);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento=new Intent(LoginActivity.this,FirstIntro.class);
                startActivity(intento);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                PhoneAuthProvider.getInstance().verifyPhoneNumber(
                        "+91"+mob_number.getText().toString(),
                        60,
                        TimeUnit.SECONDS,
                        TaskExecutors.MAIN_THREAD,
                        mcallbacks
                );



            }



            PhoneAuthProvider.OnVerificationStateChangedCallbacks mcallbacks=new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                @Override
                public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {

                    Toast.makeText(LoginActivity.this,"Verification sent successfully",Toast.LENGTH_LONG).show();
                    autootp=phoneAuthCredential.getSmsCode();
                    otp.setText(autootp);
                    PhoneAuthCredential credential= PhoneAuthProvider.getCredential(manualotp,autootp);
                    signin(credential);

                }

                @Override
                public void onVerificationFailed(FirebaseException e) {

                    Toast.makeText(LoginActivity.this,"Verification failed "+e,Toast.LENGTH_LONG).show();

                }

                @Override
                public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                    super.onCodeSent(s, forceResendingToken);
                    manualotp=s;
                    verify(manualotp);
                    Toast.makeText(LoginActivity.this,"Otp sent successfully",Toast.LENGTH_LONG).show();
                }
            };
        });



        submitotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                verify(otp.getText().toString());



            }
        });
    }

    private void verify(String code) {
        PhoneAuthCredential credential= PhoneAuthProvider.getCredential(manualotp,code);
        signin(credential);
    }


    private void signin(PhoneAuthCredential credential) {

        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                mob_number.setEnabled(false);
                if(task.isSuccessful())
                {
                    Toast.makeText(LoginActivity.this,"OTP verification Successfull",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(LoginActivity.this,SecondIntro.class);
                    startActivity(intent);
                }
                else
                    Toast.makeText(LoginActivity.this,"OTP verification failed",Toast.LENGTH_LONG).show();
            }
        });

    }
}
