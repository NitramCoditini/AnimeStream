package com.example.animestream.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.animestream.Model2;
import com.example.animestream.R;
import com.example.animestream.RecyclerAdapter2;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {


    RecyclerView.Adapter recyclerAdapter2, recyclerAdapter3, recyclerAdapter4,recyclerAdapter5, recyclerAdapter6;

    DatabaseReference databaseReference;

    ArrayList<Model2> modelArrayList2, modelArrayList2Romance, modelArrayList2Fantasy, modelArrayList2Sports, modelArrayList2Comedy, modelArrayList2Action;

    RecyclerView recyclerViewCategoryList2, recyclerViewFantasy, recyclerViewDrama, recyclerViewComedy, recyclerViewAdventure;




    private static final String TAG = "LoginRequest";


    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_gallery, container, false);



        LinearLayoutManager linearLayoutManager1= new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        recyclerViewCategoryList2 = root.findViewById(R.id.actionsRecyclerView);
        recyclerViewCategoryList2.setLayoutManager(linearLayoutManager1);

        LinearLayoutManager linearLayoutManager2= new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        recyclerViewAdventure = root.findViewById(R.id.adventureRecyclerView);
        recyclerViewAdventure.setLayoutManager(linearLayoutManager2);

        LinearLayoutManager linearLayoutManager3= new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        recyclerViewFantasy = root.findViewById(R.id.fantasysRecyclerView);
        recyclerViewFantasy.setLayoutManager(linearLayoutManager3);

        LinearLayoutManager linearLayoutManager4= new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        recyclerViewDrama = root.findViewById(R.id.dramaRecyclerView);
        recyclerViewDrama.setLayoutManager(linearLayoutManager4);

        LinearLayoutManager linearLayoutManager5= new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        recyclerViewComedy = root.findViewById(R.id.comedyRecyclerView);
        recyclerViewComedy.setLayoutManager(linearLayoutManager5);



        databaseReference = FirebaseDatabase.getInstance().getReference();


        // Initialize ArrayLists separately for each data source
        modelArrayList2 = new ArrayList<>();
        modelArrayList2Action = new ArrayList<>();
        modelArrayList2Fantasy = new ArrayList<>();
        modelArrayList2Comedy = new ArrayList<>();
        modelArrayList2Sports = new ArrayList<>();
        modelArrayList2Romance = new ArrayList<>();



        // Call the appropriate getDataFromFirebase methods for each data source
        // For MovieDetails
        getDataFromFirebase3();


        // Clear data for each RecyclerView separately
        clearAll2(); // For MovieDetails







        return root;
    }
    private void getDataFromFirebase3() {
        databaseReference.child("MovieDetails").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                clearAll2();

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Model2 model2 = new Model2();
                    model2.setImageId(snapshot.child("imageId").getValue().toString());
                    model2.setDescription(snapshot.child("description").getValue().toString());
                    String genre = snapshot.child("genre").getValue().toString();

                    // Add the model to the appropriate ArrayList based on its genre
                    if ("Action".equals(genre)) {
                        modelArrayList2Action.add(model2);
                    } else if ("Sports".equals(genre)) {
                        modelArrayList2Sports.add(model2);
                    } else if ("Romance".equals(genre)) {
                        modelArrayList2Romance.add(model2);
                    } else if ("Fantasy".equals(genre)) {
                        modelArrayList2Fantasy.add(model2);
                    } else if ("Comedy".equals(genre)) {
                        modelArrayList2Comedy.add(model2);
                    }
                }

                // After processing all the data, set the adapters to the RecyclerViews
                recyclerAdapter2 = new RecyclerAdapter2(getActivity(), modelArrayList2Action);
                recyclerViewCategoryList2.setAdapter(recyclerAdapter2);
                recyclerAdapter6 = new RecyclerAdapter2(getActivity(), modelArrayList2Sports);
                recyclerViewAdventure.setAdapter(recyclerAdapter6);
                recyclerAdapter3 = new RecyclerAdapter2(getActivity(), modelArrayList2Romance);
                recyclerViewDrama.setAdapter(recyclerAdapter3);
                recyclerAdapter4 = new RecyclerAdapter2(getActivity(), modelArrayList2Fantasy);
                recyclerViewFantasy.setAdapter(recyclerAdapter4);
                recyclerAdapter5 = new RecyclerAdapter2(getActivity(), modelArrayList2Comedy);
                recyclerViewComedy.setAdapter(recyclerAdapter5);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle errors if needed
            }
        });
    }




    private void clearAll2() {

        if(modelArrayList2 !=null){
            modelArrayList2.clear();

            if (recyclerAdapter2 !=null){
                recyclerAdapter2.notifyDataSetChanged();
            }
        }
        modelArrayList2 = new ArrayList<>();

    }

}