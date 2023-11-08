package com.example.animestream;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
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
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class AdminActivity2 extends AppCompatActivity {

    public static final String TAG = "TAG";
    public static final int GALLERY_REQUEST_CODE = 105;

    ImageButton imageButton;
    TextView tv18;
    Button update , delete;
    Uri imguri;
    EditText desc,gen;
    FirebaseStorage storage;
    StorageReference storageReference;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin2);


        imageButton = findViewById(R.id.image_upload);
        tv18 = findViewById(R.id.textView22);
        desc = findViewById(R.id.description);
        delete  = findViewById(R.id.Deletedish);
        update = findViewById(R.id.Updatedish);
        gen = findViewById(R.id.genre);


        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();
        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = firebaseDatabase.getInstance().getReference("MovieDetails");



        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv18.setVisibility(View.GONE);
                Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                gallery.setType("image/*");
                startActivityForResult(gallery, GALLERY_REQUEST_CODE);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                desc.setText("");
                imageButton.setImageURI(null);
                tv18.setVisibility(View.VISIBLE);
                gen.setText("");

            }
        });




        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String description = desc.getText().toString().trim();
                String genre = gen.getText().toString().trim();




                if (TextUtils.isEmpty(description)) {
                    desc.setError("Description is required!");
                    return;
                }
                if (TextUtils.isEmpty(genre)) {
                    gen.setError("Genre is required!");
                    return;
                }


                uploadImageFirebase(imguri);





            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GALLERY_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK){
                imguri = data.getData();
                imageButton.setImageURI(imguri);



            }
        }


    }

    private void uploadImageFirebase(Uri contentUri) {


        StorageReference image = storageReference.child(" image movies1/" + System.currentTimeMillis() + "." + getFileExt(contentUri));
        image.putFile(contentUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                image.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        Toast.makeText(AdminActivity2.this, "Image is uploaded", Toast.LENGTH_SHORT).show();
                        String description = desc.getText().toString().trim();
                        String genre = gen.getText().toString().trim();



                        MovieDetail2 foodDetail = new MovieDetail2(uri.toString(),description,genre);
                        String imageId = databaseReference.push().getKey();
                        databaseReference.child(imageId).setValue(foodDetail);
                        Toast.makeText(AdminActivity2.this, "Data inserted", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "onSuccess: Uploaded Image url is: " + uri.toString());
                        desc.setText("");
                        imageButton.setImageURI(null);
                        tv18.setVisibility(View.VISIBLE);
                        gen.setText("");
                    }
                });


            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(AdminActivity2.this, "Upload Failed", Toast.LENGTH_SHORT).show();

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