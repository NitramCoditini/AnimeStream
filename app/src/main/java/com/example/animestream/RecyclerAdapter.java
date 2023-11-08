package com.example.animestream;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.animestream.Seriespages.MainEpisodePage;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.viewHolder> {

    private static final String Tag = "RecyclerView";
    private Context mcontext;
    private ArrayList<Model> modelArrayList;

    public RecyclerAdapter(Context mcontext, ArrayList<Model> modelArrayList) {
        this.mcontext = mcontext;
        this.modelArrayList = modelArrayList;
    }

    @NonNull
    @Override
    public RecyclerAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_card, parent, false);



        return new viewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.textView2.setText(modelArrayList.get(position).getDescription());


        //image view: Glide library
        Glide.with(mcontext)
                .load(modelArrayList.get(position).getImageId())
                .into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String description = modelArrayList.get(position).getDescription();
                Intent intent = new Intent(v.getContext(), MainEpisodePage.class);
                intent.putExtra("Descrip", description);
                intent.putExtra("foodImg", modelArrayList.get(position).getImageId());
                v.getContext().startActivity(intent);


            }
        });




    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView2;


        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.moviePoster);
            textView2 = itemView.findViewById(R.id.movieTitle);

        }
    }
}
