package com.example.animestream;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    TextView sign,Resend, forget, admin;
    EditText edEmail, edPassword;
    Button log;


    FirebaseAuth firebaseAuth;
    ProgressBar pgb1;
    boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sign = findViewById(R.id.CusRegister);
        edEmail = findViewById(R.id.loginEmail);
        Resend = findViewById(R.id.resend);
        forget = findViewById(R.id.Forgot);
        edPassword = findViewById(R.id.loginPassword);
        log = findViewById(R.id.userLogin);
        pgb1 = findViewById(R.id.progressBar1);
        admin = findViewById(R.id.AdminRegister);

        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();


        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(i);
            }
        });

        Resend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseUser fuser = firebaseAuth.getCurrentUser();
                fuser.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(LoginActivity.this, "Verification code sent to " + fuser.getEmail(), Toast.LENGTH_SHORT).show();

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(LoginActivity.this, "Unable to send verification email", Toast.LENGTH_SHORT).show();


                    }
                });

            }
        });

        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this , AdminLogin.class);
                startActivity(intent);
            }
        });





        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText resetMail = new EditText(v.getContext());
                AlertDialog.Builder passwordresetDialog = new AlertDialog.Builder(v.getContext());
                passwordresetDialog.setTitle("Reset Password");
                passwordresetDialog.setMessage("Enter your email to receive reset link");
                passwordresetDialog.setView(resetMail);

                passwordresetDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String mail  = resetMail.getText().toString();
                        firebaseAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(LoginActivity.this, "Reset link has been sent", Toast.LENGTH_SHORT).show();

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(LoginActivity.this, "Error reset link is not sent" + e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });

                    }
                });

                passwordresetDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                passwordresetDialog.create().show();

            }
        });


        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mEmail = edEmail.getText().toString().trim();
                String mPassword = edPassword.getText().toString();

                if (TextUtils.isEmpty(mPassword)) {
                    edPassword.setError("Registered Password is required!");
                    return;
                }


                if (TextUtils.isEmpty(mEmail)) {
                    edEmail.setError("Register email is required!");
                    return;
                }
                pgb1.setVisibility(View.VISIBLE);


                firebaseAuth.signInWithEmailAndPassword(mEmail, mPassword).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {

                        if(firebaseAuth.getCurrentUser().isEmailVerified()){
                            if (!flag) {
                                flag = true;
                                Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(LoginActivity.this, ServicesActivity.class));
                                pgb1.setVisibility(View.GONE);
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        flag = false;
                                    }
                                },500);
                                finish();
                            }


                        }else{
                            pgb1.setVisibility(View.GONE);
                            Toast.makeText(LoginActivity.this, "Please verify your email", Toast.LENGTH_SHORT).show();
                            Toast.makeText(LoginActivity.this, "Verification code can be in spam if not use resend code", Toast.LENGTH_SHORT).show();
                        }

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        pgb1.setVisibility(View.GONE);
                        Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                        Toast.makeText(LoginActivity.this, "Ensure email and password are correct", Toast.LENGTH_SHORT).show();
                        Toast.makeText(LoginActivity.this, "Ensure you are connected to the internet", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });






    }

}