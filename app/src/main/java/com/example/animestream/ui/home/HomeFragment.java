package com.example.animestream.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.animestream.Model;
import com.example.animestream.R;
import com.example.animestream.RecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    RecyclerView.Adapter recyclerAdapter, recyclerAdapter2, recyclerAdapter3, recyclerAdapter4,recyclerAdapter5;

    DatabaseReference databaseReference;

    ArrayList<Model> modelArrayList, modelArrayListAction1,modelArrayListFantasy1, modelArrayListDrama1, modelArrayListComedy1, modelArrayListAdventure1;

    RecyclerView recyclerViewCategoryList, recyclerViewFantasy, recyclerViewDrama, recyclerViewComedy, recyclerViewAdventure;






    private static final String TAG = "LoginRequest";

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);



        recyclerViewCategoryList = root.findViewById(R.id.actionsRecyclerView);
        recyclerViewAdventure = root.findViewById(R.id.adventureRecyclerView);
        recyclerViewComedy = root.findViewById(R.id.comedyRecyclerView);

        recyclerViewFantasy = root.findViewById(R.id.fantasysRecyclerView);

        recyclerViewDrama = root.findViewById(R.id.dramaRecyclerView);

        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        LinearLayoutManager linearLayoutManager2= new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        recyclerViewAdventure.setLayoutManager(linearLayoutManager2);

        LinearLayoutManager linearLayoutManager3= new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        recyclerViewFantasy.setLayoutManager(linearLayoutManager3);

        LinearLayoutManager linearLayoutManager4= new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        recyclerViewDrama.setLayoutManager(linearLayoutManager4);

        LinearLayoutManager linearLayoutManager5= new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        recyclerViewComedy.setLayoutManager(linearLayoutManager5);



        databaseReference = FirebaseDatabase.getInstance().getReference();

        // Initialize ArrayLists separately for each data source
        modelArrayList = new ArrayList<>();
        modelArrayListAction1 = new ArrayList<>();
        modelArrayListAdventure1 = new ArrayList<>();
        modelArrayListFantasy1 = new ArrayList<>();
        modelArrayListComedy1 = new ArrayList<>();
        modelArrayListDrama1 = new ArrayList<>();



        // Call getDataFromFirebase with the specified genre
        getDataFromFirebase();


        // Call the appropriate getDataFromFirebase methods for each data source



        // Clear data for each RecyclerView separately
        clearAll(); // For FoodDetails








        return root;


    }

    private void getDataFromFirebase() {
        Query query = databaseReference.child("FoodDetails");

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                clearAll();
                for (DataSnapshot snapshot : datasnapshot.getChildren()) {
                    Model model = new Model();

                    model.setImageId(snapshot.child("imageId").getValue().toString());
                    model.setDescription(snapshot.child("description").getValue().toString());
                    String genre = snapshot.child("genre").getValue().toString();

                    // Add the model to the appropriate ArrayList based on its genre
                    if ("Action".equals(genre)) {
                        modelArrayListAction1.add(model);
                    } else if ("Adventure".equals(genre)) {
                        modelArrayListAdventure1.add(model);
                    } else if ("Drama".equals(genre)) {
                        modelArrayListDrama1.add(model);
                    } else if ("Fantasy".equals(genre)) {
                        modelArrayListFantasy1.add(model);
                    } else if ("Comedy".equals(genre)) {
                        modelArrayListComedy1.add(model);
                    }
                }

                // After processing all the data, set the adapters to the RecyclerViews
                recyclerAdapter = new RecyclerAdapter(getActivity(), modelArrayListAction1);
                recyclerViewCategoryList.setAdapter(recyclerAdapter);
                recyclerAdapter2 = new RecyclerAdapter(getActivity(), modelArrayListAdventure1);
                recyclerViewAdventure.setAdapter(recyclerAdapter2);
                recyclerAdapter3 = new RecyclerAdapter(getActivity(), modelArrayListDrama1);
                recyclerViewDrama.setAdapter(recyclerAdapter3);
                recyclerAdapter4 = new RecyclerAdapter(getActivity(), modelArrayListFantasy1);
                recyclerViewFantasy.setAdapter(recyclerAdapter4);
                recyclerAdapter5 = new RecyclerAdapter(getActivity(), modelArrayListComedy1);
                recyclerViewComedy.setAdapter(recyclerAdapter5);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle errors if needed
            }
        });
    }
    private  void clearAll(){
        if(modelArrayList !=null){
            modelArrayList.clear();

            if (recyclerAdapter !=null){
                recyclerAdapter.notifyDataSetChanged();
            }
        }
        modelArrayList = new ArrayList<>();
    }


}