package com.example.animestream;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;

public class RecyclerAdapter2 extends RecyclerView.Adapter<RecyclerAdapter2.viewHolder> {

    private static final String Tag = "RecyclerView";
    private Context mcontext;
    private ArrayList<Model2> modelArrayList2;

    public RecyclerAdapter2(Context mcontext, ArrayList<Model2> modelArrayList2) {
        this.mcontext = mcontext;
        this.modelArrayList2 = modelArrayList2;
    }

    @NonNull
    @Override
    public RecyclerAdapter2.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_card, parent, false);



        return new viewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.textView2.setText(modelArrayList2.get(position).getDescription());


        //image view: Glide library
        Glide.with(mcontext)
                .load(modelArrayList2.get(position).getImageId())
                .into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String description = modelArrayList2.get(position).getDescription();
                String videoUrlBlackClover = "https://firebasestorage.googleapis.com/v0/b/animestream-fa009.appspot.com/o/Black%20clover%2FBlack_Clover_Sword_of_the_wizard_King_720pMulti%40Animeloversdual.mkv?alt=media&token=722cc1f4-5ce4-444a-9fb5-8d80a89b1744";
                String videoUrlWethering = "https://firebasestorage.googleapis.com/v0/b/animestream-fa009.appspot.com/o/Black%20clover%2Fvideo_2023-10-22_23-37-01.mp4?alt=media&token=05f77477-7d3d-4fb0-9304-c0d2e8fb735a";
                String videoUrlSlime = "https://firebasestorage.googleapis.com/v0/b/animestream-fa009.appspot.com/o/Black%20clover%2FThat_Time_I_Got_Reincarnated_as_a_Slime_Movie_Official_Trailer__.mp4?alt=media&token=8540a53c-6098-4809-bccb-cf25ccf83f63";
                String videoUrlDragon = "https://firebasestorage.googleapis.com/v0/b/animestream-fa009.appspot.com/o/Black%20clover%2Fy2mate.com%20-%20Dragon%20Ball%20Super%20Super%20Hero%20New%20Trailer%20%20Battle%20Now%202022_720p.mp4?alt=media&token=407872d4-0576-4ee7-bd37-937e960ef070";
                String videoUrlKuroko = "https://firebasestorage.googleapis.com/v0/b/animestream-fa009.appspot.com/o/Black%20clover%2FKUROKO'S%20BASKET_%20THE%20LAST%20GAME%20-%20Official%20Trailer%20(In%20Cinemas%204%20May%202017).mp4?alt=media&token=33d0dc53-bd9e-4104-8faf-c8dd6917f688";
                String videoUrlFairy =  "https://firebasestorage.googleapis.com/v0/b/animestream-fa009.appspot.com/o/Black%20clover%2Fy2mate.com%20-%20Fairy%20Tail%20Dragon%20Cry%20%20Official%20Trailer_1080p.mp4?alt=media&token=20ba78dc-31bb-4d85-8839-40b985750e9f";
                String videoUrlSeven = "https://firebasestorage.googleapis.com/v0/b/animestream-fa009.appspot.com/o/Black%20clover%2Fy2mate.com%20-%20The%20Seven%20Deadly%20Sins%20Cursed%20by%20Light%20%20Official%20Trailer%20%20Netflix%20Anime_1080p.mp4?alt=media&token=984a3a17-addd-44b4-8b60-e1ba64e5e25c";
                String videoUrlWhisker = "https://firebasestorage.googleapis.com/v0/b/animestream-fa009.appspot.com/o/Black%20clover%2Fy2mate.com%20-%20A%20Whisker%20Away%20Trailer%20%20English%20Dub_1080p.mp4?alt=media&token=50f1bb0f-92f7-454d-b381-a7f46e22cfc9";
                String videoUrlSuzume = "https://firebasestorage.googleapis.com/v0/b/animestream-fa009.appspot.com/o/Black%20clover%2Fy2mate.com%20-%20Suzume%20Trailer%201%202023_720p.mp4?alt=media&token=77e19fe9-bae8-45fa-970d-88a59a5c9aff";
                String videoUrlKonosuba = "https://firebasestorage.googleapis.com/v0/b/animestream-fa009.appspot.com/o/Black%20clover%2Fy2mate.com%20-%20KONOSUBA%20%20LEGEND%20OF%20CRIMSON%20Official%20Trailer%20%20In%20Cinemas%205%20March%202020_720p.mp4?alt=media&token=c8826288-9890-4b33-9dcf-d2b512a49545";

                // Check the description and navigate to the corresponding episode page
                if ("Black Clover".equals(description)) {
                    // Navigate to EpisodePage1
                    // You should have an EpisodePage1 class for this

                    String videoUrl = videoUrlBlackClover;
                    Intent intent = new Intent(v.getContext(), VideoPlayerActivity.class);
                    intent.putExtra("videoUrl", videoUrl);
                    intent.putExtra("Descrip", description);
                    intent.putExtra("foodImg", modelArrayList2.get(position).getImageId());
                    v.getContext().startActivity(intent);
                } else if ("Weathering with you".equals(description)) {
                    // Navigate to AnotherEpisodePage
                    // You should have an AnotherEpisodePage class for this
                    String videoUrl = videoUrlWethering;
                    Intent intent = new Intent(v.getContext(), VideoPlayerActivity.class);
                    intent.putExtra("videoUrl", videoUrl);
                    intent.putExtra("Descrip", description);
                    intent.putExtra("foodImg", modelArrayList2.get(position).getImageId());
                    v.getContext().startActivity(intent);
                }else if ("That Time I Got reincarnated as a slime".equals(description)) {
                        // Navigate to AnotherEpisodePage
                        // You should have an AnotherEpisodePage class for this
                        String videoUrl = videoUrlSlime;
                        Intent intent = new Intent(v.getContext(), VideoPlayerActivity.class);
                        intent.putExtra("videoUrl", videoUrl);
                        intent.putExtra("Descrip", description);
                        intent.putExtra("foodImg", modelArrayList2.get(position).getImageId());
                        v.getContext().startActivity(intent);
                }
                else if ("Dragon ball super hero".equals(description)) {
                    // Navigate to AnotherEpisodePage
                    // You should have an AnotherEpisodePage class for this
                    String videoUrl = videoUrlDragon;
                    Intent intent = new Intent(v.getContext(), VideoPlayerActivity.class);
                    intent.putExtra("videoUrl", videoUrl);
                    intent.putExtra("Descrip", description);
                    intent.putExtra("foodImg", modelArrayList2.get(position).getImageId());
                    v.getContext().startActivity(intent);
                }
                else if ("Suzume".equals(description)) {
                    // Navigate to AnotherEpisodePage
                    // You should have an AnotherEpisodePage class for this
                    String videoUrl = videoUrlSuzume;
                    Intent intent = new Intent(v.getContext(), VideoPlayerActivity.class);
                    intent.putExtra("videoUrl", videoUrl);
                    intent.putExtra("Descrip", description);
                    intent.putExtra("foodImg", modelArrayList2.get(position).getImageId());
                    v.getContext().startActivity(intent);
                }
                else if ("A Whisker Away".equals(description)) {
                    // Navigate to AnotherEpisodePage
                    // You should have an AnotherEpisodePage class for this
                    String videoUrl = videoUrlWhisker;
                    Intent intent = new Intent(v.getContext(), VideoPlayerActivity.class);
                    intent.putExtra("videoUrl", videoUrl);
                    intent.putExtra("Descrip", description);
                    intent.putExtra("foodImg", modelArrayList2.get(position).getImageId());
                    v.getContext().startActivity(intent);
                }
                else if ("Konosuba Legend of  Crimson".equals(description)) {
                    // Navigate to AnotherEpisodePage
                    // You should have an AnotherEpisodePage class for this
                    String videoUrl = videoUrlKonosuba;
                    Intent intent = new Intent(v.getContext(), VideoPlayerActivity.class);
                    intent.putExtra("videoUrl", videoUrl);
                    intent.putExtra("Descrip", description);
                    intent.putExtra("foodImg", modelArrayList2.get(position).getImageId());
                    v.getContext().startActivity(intent);
                }
                else if ("Kuroko no Basket Last game".equals(description)) {
                    // Navigate to AnotherEpisodePage
                    // You should have an AnotherEpisodePage class for this
                    String videoUrl = videoUrlKuroko;
                    Intent intent = new Intent(v.getContext(), VideoPlayerActivity.class);
                    intent.putExtra("videoUrl", videoUrl);
                    intent.putExtra("Descrip", description);
                    intent.putExtra("foodImg", modelArrayList2.get(position).getImageId());
                    v.getContext().startActivity(intent);
                }
                else if ("Fairy Tail Dragon Cry".equals(description)) {
                    // Navigate to AnotherEpisodePage
                    // You should have an AnotherEpisodePage class for this
                    String videoUrl = videoUrlFairy;
                    Intent intent = new Intent(v.getContext(), VideoPlayerActivity.class);
                    intent.putExtra("videoUrl", videoUrl);
                    intent.putExtra("Descrip", description);
                    intent.putExtra("foodImg", modelArrayList2.get(position).getImageId());
                    v.getContext().startActivity(intent);
                }
                else if ("Seven Deadly Sins: Prisoners of the Sky".equals(description)) {
                    // Navigate to AnotherEpisodePage
                    // You should have an AnotherEpisodePage class for this
                    String videoUrl = videoUrlSeven;
                    Intent intent = new Intent(v.getContext(), VideoPlayerActivity.class);
                    intent.putExtra("videoUrl", videoUrl);
                    intent.putExtra("Descrip", description);
                    intent.putExtra("foodImg", modelArrayList2.get(position).getImageId());
                    v.getContext().startActivity(intent);
                }
                else {
                    // Handle other descriptions or set a default destination
                    // For example, you can show a toast message.
                    Toast.makeText(v.getContext(), "Unknown description", Toast.LENGTH_SHORT).show();
                }

            }
        });




    }

    @Override
    public int getItemCount() {
        return modelArrayList2.size();
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
