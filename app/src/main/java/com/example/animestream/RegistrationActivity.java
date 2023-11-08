package com.example.animestream;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.HashMap;
import java.util.Map;

public class RegistrationActivity extends AppCompatActivity {

    Button RegUser;
    EditText userPass,conPass,uEmail,uName;
    FirebaseAuth firebaseAuth;
    public static final int GALLERY_REQUEST_CODE = 105;
    FirebaseFirestore fstore;
    FirebaseStorage storage;
    StorageReference storageReference;
    TextView profdes;
    ImageButton profilePhoto;
    Uri uriImg;

    ProgressBar pgb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        RegUser = findViewById(R.id.userReg);
        uEmail = findViewById(R.id.userEmail);
        uName = findViewById(R.id.userName);
        profdes = findViewById(R.id.prof);
        profilePhoto = findViewById(R.id.imageWor);
        userPass = findViewById(R.id.cusPassword1);
        conPass = findViewById(R.id.ConPassword);
        pgb = findViewById(R.id.progressBar);

        firebaseAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();




        profilePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pickImageIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(pickImageIntent, GALLERY_REQUEST_CODE);
            }
        });





        RegUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable drawable = profilePhoto.getDrawable();
                String name = uName.getText().toString().trim();
                String pass = userPass.getText().toString().trim();
                String email = uEmail.getText().toString().trim();
                String conPin = conPass.getText().toString().trim();


                if (drawable == null) {
                    Toast.makeText(RegistrationActivity.this, "Please select an image", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(name)) {
                    uName.setError("Name is required!");
                    return;
                }
                if (TextUtils.isEmpty(email)) {
                    uEmail.setError("Email is required!");
                    return;
                }


                if (TextUtils.isEmpty(pass)) {
                    userPass.setError("Password is required!");
                    return;
                }
                if (TextUtils.isEmpty(conPin)) {
                    conPass.setError("Confirm password is required");
                    return;
                }
                if (pass.length() < 7) {
                    userPass.setError("Password must be greater than 7 numbers");
                    return;
                }
                if (!pass.equals(conPin)) {
                    conPass.setError("Password does not match");
                    return;
                }
                if (!pass.matches(".*[0-9].*")) {
                    userPass.setError("Password must have numbers");
                    return;
                }
                if (!pass.matches(".*[a-z].*")) {
                    userPass.setError("Password must have small letters");
                    return;
                }
                if (!pass.matches(".*[A-Z].*")) {
                    userPass.setError("Password must have capital letters");
                    return;
                }
                if (!pass.matches("^(?=.*[_.()$@?#]).*$")) {
                    userPass.setError("Password must have special characters such as ?.#");
                    return;
                }


                pgb.setVisibility(View.VISIBLE);



                firebaseAuth.createUserWithEmailAndPassword(email,pass).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {


                        FirebaseUser fuser = firebaseAuth.getCurrentUser();
                        fuser.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                pgb.setVisibility(View.GONE);
                                Toast.makeText(RegistrationActivity.this, "Verification email has been sent", Toast.LENGTH_SHORT).show();
                                uploadImageFirebase(uriImg);
                                startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
                                finish();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                pgb.setVisibility(View.GONE);
                                Log.d(TAG, "onFailure: Email not sent" + e.getMessage());
                            }
                        });









                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        pgb.setVisibility(View.GONE);
                        Toast.makeText(RegistrationActivity.this, "Failed ensure you are connected to the internet", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GALLERY_REQUEST_CODE) {

            if (resultCode == Activity.RESULT_OK) {

                uriImg = data.getData();
                profilePhoto.setImageURI(uriImg);




            }
        }

    }
    private void uploadImageFirebase(Uri contentUri) {


        StorageReference image = storageReference.child(" User profile photos/" + System.currentTimeMillis() + "." + getFileExt(contentUri));
        image.putFile(contentUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                image.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        String name = uName.getText().toString().trim();
                        String email = uEmail.getText().toString().trim();
                        Toast.makeText(RegistrationActivity.this, "User created", Toast.LENGTH_SHORT).show();
                        DocumentReference documentReference = fstore.collection("Animeworld Users").document(firebaseAuth.getCurrentUser().getUid());
                        Map<String, Object> myMap = new HashMap<String, Object>();
                        myMap.put("Profile pic", uri.toString());
                        myMap.put("Full name", name);
                        myMap.put("Email address", email);
                        documentReference.set(myMap).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Log.d(TAG, "onSuccess: User account created");

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                pgb.setVisibility(View.GONE);
                                Log.d(TAG, "onFailure: " + e.getMessage());

                            }
                        });
                        Toast.makeText(RegistrationActivity.this, "Image is uploaded", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "onSuccess: Uploaded Image url is: " + uri.toString());
                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(RegistrationActivity.this, "Upload Failed", Toast.LENGTH_SHORT).show();

            }
        });
    }
    private String getFileExt(Uri contentUri) {
        //allow all support types of gallery
        ContentResolver c = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return  mime.getExtensionFromMimeType(c.getType(contentUri));
    }

}