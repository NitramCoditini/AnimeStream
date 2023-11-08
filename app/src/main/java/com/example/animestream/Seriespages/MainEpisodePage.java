package com.example.animestream.Seriespages;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.animestream.R;
import com.example.animestream.VideoPlayerActivity;
import com.example.animestream.ui.home.HomeFragment;

public class MainEpisodePage extends AppCompatActivity {

    ImageView imageView;
    CardView cardView, cardView2, cardView3, cardView4, cardView5;

    TextView labelText;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_episode_page);

        Intent intent1 = getIntent();
        String description = intent1.getStringExtra("Descrip");

        imageView = findViewById(R.id.back2);
        cardView = findViewById(R.id.epi1);
        labelText = findViewById(R.id.textSeriesLabel);
        cardView2 = findViewById(R.id.epi2);
        cardView3 = findViewById(R.id.epi3);
        cardView4 = findViewById(R.id.epi4);
        cardView5 = findViewById(R.id.epi5);


        labelText.setText(description);


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainEpisodePage.this, HomeFragment.class);
                startActivity(intent2);
            }
        });

        if ("Jujutsu Kaisen 1".equals(description)) {
            cardView2.setVisibility(View.VISIBLE);
            cardView3.setVisibility(View.VISIBLE);
        } else if ("Assassination Classroom".equals(description)) {
            cardView2.setVisibility(View.VISIBLE);
            cardView3.setVisibility(View.VISIBLE);
            cardView4.setVisibility(View.VISIBLE);
            cardView5.setVisibility(View.VISIBLE);
        }

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getEpisode1(description);
            }
        });
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getEpisode2(description);
            }
        });
        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getEpisode3(description);
            }
        });
        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getEpisode4(description);
            }
        });
        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getEpisode5(description);
            }
        });
    }



    private void getEpisode1(String description) {
        if ("My Home Hero".equals(description)) {
            // Navigate to AnotherEpisodePage
            // You should have an AnotherEpisodePage class for this
            String videoUrl = "https://firebasestorage.googleapis.com/v0/b/animestream-fa009.appspot.com/o/home%20hero%2F%5BOAH%5D%20%5BS1-01%5D%20720p%20My%20Home%20Hero.mkv?alt=media&token=7c2169ff-4ee5-488d-a488-6cb63cd5c514"; // Start a new activity to play the video
            Intent intent = new Intent(MainEpisodePage.this, VideoPlayerActivity.class);
            intent.putExtra("videoUrl", videoUrl);
            startActivity(intent);

        }
        else if ("Kaguya-sama: Love is War".equals(description)) {
            // Navigate to AnotherEpisodePage
            // You should have an AnotherEpisodePage class for this
            String videoUrl = "https://firebasestorage.googleapis.com/v0/b/animestream-fa009.appspot.com/o/kaguya%20sama%2FKaguya%20Sama%20Love%20Is%20War%20S1%20-%2001%20%5B720p%5D%20%5BDual%5D%20%40AnimeEspada.mkv?alt=media&token=6c17ebd8-8e98-4fbd-855c-1067f6809cb6";
            Intent intent = new Intent(MainEpisodePage.this, VideoPlayerActivity.class);
            intent.putExtra("videoUrl", videoUrl);
            startActivity(intent);

        }
        else if ("Uncle From Another World".equals(description)) {
            // Navigate to AnotherEpisodePage
            // You should have an AnotherEpisodePage class for this
            String videoUrl = "https://firebasestorage.googleapis.com/v0/b/animestream-fa009.appspot.com/o/uncle%20from%20another%20world%2FEP01%20%5B720p%5D%20AnimeDynasty.mkv?alt=media&token=dc4eb4c9-2070-4a28-8431-667917c98af7"; // Start a new activity to play the video
            Intent intent = new Intent(MainEpisodePage.this, VideoPlayerActivity.class);
            intent.putExtra("videoUrl", videoUrl);
            startActivity(intent);

        }
        else if ("Konosuba".equals(description)) {
            // Navigate to AnotherEpisodePage
            // You should have an AnotherEpisodePage class for this
            String videoUrl = "https://firebasestorage.googleapis.com/v0/b/animestream-fa009.appspot.com/o/konosuba%2F01%20Kono%20Subarashii%20Sekai%20ni%20Shukufuku%20wo!.mkv?alt=media&token=df3bc5b1-ee57-4f6e-8f40-eb0175cac235";
            Intent intent = new Intent(MainEpisodePage.this, VideoPlayerActivity.class);
            intent.putExtra("videoUrl", videoUrl);
            startActivity(intent);

        }
        else if ("Mushoku Tensei: Jobless Reincarnation".equals(description)) {
            // Navigate to AnotherEpisodePage
            // You should have an AnotherEpisodePage class for this
            String videoUrl = "https://firebasestorage.googleapis.com/v0/b/animestream-fa009.appspot.com/o/mushoku%20tensei%2FJobless%20Reincarnation%20S1%20-%2001%20%5B720p%5D%20%5BSub%5D%20%40Anime_Gallery.mkv?alt=media&token=4f5d7360-543f-4581-a646-6bef31dbdb38"; // Start a new activity to play the video
            Intent intent = new Intent(MainEpisodePage.this, VideoPlayerActivity.class);
            intent.putExtra("videoUrl", videoUrl);
            startActivity(intent);
        }
        else if ("Re:zero starting life in another world".equals(description)) {
            // Navigate to AnotherEpisodePage
            // You should have an AnotherEpisodePage class for this
            String videoUrl = "https://firebasestorage.googleapis.com/v0/b/animestream-fa009.appspot.com/o/re%20zero%2FS1E01%20-%20Re_Zero%20%5B720p%5D%5BDual%5D.mkv?alt=media&token=050551cc-4f92-4c50-b78b-cc938454f062";
            Intent intent = new Intent(MainEpisodePage.this, VideoPlayerActivity.class);
            intent.putExtra("videoUrl", videoUrl);
            startActivity(intent);
        }

        else if ("Oshi No Ko".equals(description)) {
            // Navigate to AnotherEpisodePage
            // You should have an AnotherEpisodePage class for this
            String videoUrl = "https://firebasestorage.googleapis.com/v0/b/animestream-fa009.appspot.com/o/oshi%20no%20ko%2FOshi%20No%20Ko%20%5BE01%5D%5B720p%5D.mkv?alt=media&token=9e2fa9c1-7e81-4c30-b8f2-13f648d5fd7c";
            Intent intent = new Intent(MainEpisodePage.this, VideoPlayerActivity.class);
            intent.putExtra("videoUrl", videoUrl);
            startActivity(intent);
        }
        else if ("That Time I Got Reincarnated As a Slime".equals(description)) {
            // Navigate to AnotherEpisodePage
            // You should have an AnotherEpisodePage class for this
            String videoUrl = "https://firebasestorage.googleapis.com/v0/b/animestream-fa009.appspot.com/o/Reincarnated%20Slime%2FEP01%20%5B720p%5D%20%5BEng%20Sub%5D.mkv?alt=media&token=c06a5bec-14bb-4a9d-a954-404c175b549c"; // Start a new activity to play the video
            Intent intent = new Intent(MainEpisodePage.this, VideoPlayerActivity.class);
            intent.putExtra("videoUrl", videoUrl);
            startActivity(intent);
        }
        else if ("Rising of The Shield Hero".equals(description)) {
            // Navigate to AnotherEpisodePage
            // You should have an AnotherEpisodePage class for this
            String videoUrl = "https://firebasestorage.googleapis.com/v0/b/animestream-fa009.appspot.com/o/rise%20of%20the%20shield%20hero%2FRising%20of%20The%20Shield%20Hero%20S1-%2001.mkv?alt=media&token=113dab34-1976-45e6-b36a-e4f092e9b178";
            Intent intent = new Intent(MainEpisodePage.this, VideoPlayerActivity.class);
            intent.putExtra("videoUrl", videoUrl);
            startActivity(intent);
        }
        else if ("Chainsaw Man".equals(description)) {
            // Navigate to AnotherEpisodePage
            // You should have an AnotherEpisodePage class for this
            String videoUrl = "https://firebasestorage.googleapis.com/v0/b/animestream-fa009.appspot.com/o/Chainsaw%20man%2F1%20-%20Chainsaw%20Man%20%5BSub%5D%20720p%20%40NarutoBaryon09.mkv?alt=media&token=837e2fc4-99e1-4b71-a2c7-ed6265c54075";
            Intent intent = new Intent(MainEpisodePage.this, VideoPlayerActivity.class);
            intent.putExtra("videoUrl", videoUrl);
            startActivity(intent);
        }
        else if ("Hells Paradise".equals(description)) {
            // Navigate to AnotherEpisodePage
            // You should have an AnotherEpisodePage class for this
            String videoUrl = "https://firebasestorage.googleapis.com/v0/b/animestream-fa009.appspot.com/o/hells%20paradise%2FS1E01%20-%20Hell's%20Paradise%20%5B720p%5D%5BSub%5D%5B%40AnimeDictionary%5D.mkv?alt=media&token=3427544e-d6f2-48b5-958c-976a3f987f96"; // Start a new activity to play the video
            Intent intent = new Intent(MainEpisodePage.this, VideoPlayerActivity.class);
            intent.putExtra("videoUrl", videoUrl);
            startActivity(intent);
        }
        else if ("Hunter X Hunter".equals(description)) {
            // Navigate to AnotherEpisodePage
            // You should have an AnotherEpisodePage class for this
            String videoUrl = "https://firebasestorage.googleapis.com/v0/b/animestream-fa009.appspot.com/o/Hunter%20x%20hunter%2F001.Hunter%20x%20Hunter%20%5B720p%5D%20%40Anime_Collectors.mkv?alt=media&token=e85f937e-8b4a-4e5d-b13c-3111a09c0689";
            Intent intent = new Intent(MainEpisodePage.this, VideoPlayerActivity.class);
            intent.putExtra("videoUrl", videoUrl);
            startActivity(intent);
        }
        else if ("Attack on Titan 1".equals(description)) {
            // Navigate to AnotherEpisodePage
            // You should have an AnotherEpisodePage class for this
            String videoUrl = "https://firebasestorage.googleapis.com/v0/b/animestream-fa009.appspot.com/o/Attack%2FAttack%20on%20Titan%20S1%20-%2001%20%5B720p%5D%20%40Anime_Gallery.mkv?alt=media&token=08425861-9055-4026-b39b-af47b17566c4";
            // Start a new activity to play the video
            Intent intent = new Intent(MainEpisodePage.this, VideoPlayerActivity.class);
            intent.putExtra("videoUrl", videoUrl);
            startActivity(intent);
        }
        else if ("Sword Art Online 1".equals(description)) {
            // Navigate to AnotherEpisodePage
            // You should have an AnotherEpisodePage class for this
            String videoUrl = "https://firebasestorage.googleapis.com/v0/b/animestream-fa009.appspot.com/o/Sword%2FSword%20Art%20Online%20S1%20-%2001%20%5B720p%5D%20%5BDual%5D%20%40Anime_Maniaac.mkv?alt=media&token=ce70d469-c6c3-4a0d-81f9-bd90299957d1";
            Intent intent = new Intent(MainEpisodePage.this, VideoPlayerActivity.class);
            intent.putExtra("videoUrl", videoUrl);
            startActivity(intent);
        }
        else if ("Spy x Family 1".equals(description)) {
            // Navigate to AnotherEpisodePage
            // You should have an AnotherEpisodePage class for this
            String videoUrl = "https://firebasestorage.googleapis.com/v0/b/animestream-fa009.appspot.com/o/spy%2FSpy%20x%20Family%20S1%20-%2001%20%5B720p%5D%20%5BDual%5D%20%40Anime_Gallery.mkv?alt=media&token=68dfb96a-7afa-4325-9ee2-7e57d95c860d";
            // Start a new activity to play the video
            Intent intent = new Intent(MainEpisodePage.this, VideoPlayerActivity.class);
            intent.putExtra("videoUrl", videoUrl);
            startActivity(intent);
        }
        else if ("Eminence in Shadow".equals(description)) {
            // Navigate to AnotherEpisodePage
            // You should have an AnotherEpisodePage class for this
            String videoUrl = "https://firebasestorage.googleapis.com/v0/b/animestream-fa009.appspot.com/o/Eminence%2FS01E01_The_Eminence_in_Shadow_720p_Dual_%40Animester_Ongoing.mkv?alt=media&token=c437e62f-1f92-4e14-8be4-a91e407f1919";// Start a new activity to play the video
            Intent intent = new Intent(MainEpisodePage.this, VideoPlayerActivity.class);
            intent.putExtra("videoUrl", videoUrl);
            startActivity(intent);
        }
        else if ("The Legend Hero is Dead".equals(description)) {
            // Navigate to AnotherEpisodePage
            // You should have an AnotherEpisodePage class for this
            String videoUrl = "https://firebasestorage.googleapis.com/v0/b/animestream-fa009.appspot.com/o/Legendary%20hero%2F01%20-%20%5B720p%5D%5BSub%5D%20Animepirates.mkv?alt=media&token=2ce718a2-1503-485c-8373-4fb66db0452f";// Start a new activity to play the video
            Intent intent = new Intent(MainEpisodePage.this, VideoPlayerActivity.class);
            intent.putExtra("videoUrl", videoUrl);
            startActivity(intent);

        }else if ("Naruto Shippuden".equals(description)) {
            // Navigate to AnotherEpisodePage
            // You should have an AnotherEpisodePage class for this
            String videoUrl = "https://firebasestorage.googleapis.com/v0/b/animestream-fa009.appspot.com/o/Naruto%2F%5BHorribleSubs%5D%20Naruto%20Shippuuden%20-%2001%20%5B480p%5D.mkv?alt=media&token=8d204a9a-8ff2-4b32-baf8-6e238956e789";
            Intent intent = new Intent(MainEpisodePage.this, VideoPlayerActivity.class);
            intent.putExtra("videoUrl", videoUrl);
            startActivity(intent);
        }
        else if ("Demon slayer".equals(description)) {
            // Navigate to AnotherEpisodePage
            // You should have an AnotherEpisodePage class for this
            String videoUrl = "https://firebasestorage.googleapis.com/v0/b/animestream-fa009.appspot.com/o/Demon%20slayer%2FDemon%20Slayer%20S1%20-%2003%20%5B720p%5D%20%5BDual%5D%20%40Anime_Gallery.mkv?alt=media&token=ec1d9a8e-a08b-49d0-bbae-bcac00f623ae";
            Intent intent = new Intent(MainEpisodePage.this, VideoPlayerActivity.class);
            intent.putExtra("videoUrl", videoUrl);
            startActivity(intent);
        }
        else if ("Zom 100: Bucket List of the Dead".equals(description)) {
            // Navigate to AnotherEpisodePage
            // You should have an AnotherEpisodePage class for this
            String videoUrl = "https://firebasestorage.googleapis.com/v0/b/animestream-fa009.appspot.com/o/zom%20100%2F%5BAE%5D%20Zom%20100%20S1EP01%20%5B720p%5D%5BEng%20Sub%5D%20%5B%40Anime_Edge%5D.mkv?alt=media&token=03e42dbb-3086-4928-8fc4-f9f2a8efdad0";
            Intent intent = new Intent(MainEpisodePage.this, VideoPlayerActivity.class);
            intent.putExtra("videoUrl", videoUrl);
            startActivity(intent);
        }
        else if ("Tomodachi Game".equals(description)) {
            // Navigate to AnotherEpisodePage
            // You should have an AnotherEpisodePage class for this
            String videoUrl = "https://firebasestorage.googleapis.com/v0/b/animestream-fa009.appspot.com/o/Tomodachi%2F%5BS1-01%5D%20Tomodachi%20Game%20%5B480p%5D%20%5BDual%5D%20%40Anime_Ocean.mkv?alt=media&token=c4b1c9ee-fdd3-4345-89ab-457b3c7080b5";
            Intent intent = new Intent(MainEpisodePage.this, VideoPlayerActivity.class);
            intent.putExtra("videoUrl", videoUrl);
            startActivity(intent);
        }
        else if ("Seraph of the End".equals(description)) {
            // Navigate to AnotherEpisodePage
            // You should have an AnotherEpisodePage class for this
            String videoUrl = "https://firebasestorage.googleapis.com/v0/b/animestream-fa009.appspot.com/o/Seraph%2F01%20-%20The%20World%20of%20Blood%20Legacy.mkv?alt=media&token=6024b9fb-a1ca-471c-a9b1-eb50451d78b7";
            Intent intent = new Intent(MainEpisodePage.this, VideoPlayerActivity.class);
            intent.putExtra("videoUrl", videoUrl);
            startActivity(intent);
        }
        else if ("Vinland Saga 1".equals(description)) {
            // Navigate to AnotherEpisodePage
            // You should have an AnotherEpisodePage class for this
            String videoUrl = "https://firebasestorage.googleapis.com/v0/b/animestream-fa009.appspot.com/o/Vinland%20saga%2F01.%20Somewhere%20not%20here.mkv?alt=media&token=3379e245-5fc8-4677-af3a-fb4df7b3639c";
            // Start a new activity to play the video
            Intent intent = new Intent(MainEpisodePage.this, VideoPlayerActivity.class);
            intent.putExtra("videoUrl", videoUrl);
            startActivity(intent);
        }
        else if ("Jujutsu Kaisen 1".equals(description)) {
            // Navigate to EpisodePage1
            // You should have an EpisodePage1 class for this
            String videoUrl = "https://firebasestorage.googleapis.com/v0/b/animestream-fa009.appspot.com/o/jujutsu%2FEp_1_jujutsu_kaisen_Eng%2Bjap_Dub_Quality_720p_TG_%40Dub_Animes_in_English.mkv?alt=media&token=907f3d6a-f4b7-429b-a9cb-4bb3f8bb5240";
            Intent intent = new Intent(MainEpisodePage.this, VideoPlayerActivity.class);
            intent.putExtra("videoUrl", videoUrl);
            startActivity(intent);
        } else if ("Assassination Classroom".equals(description)) {
            // Navigate to AnotherEpisodePage
            // You should have an AnotherEpisodePage class for this
            String videoUrl = "https://firebasestorage.googleapis.com/v0/b/animestream-fa009.appspot.com/o/Assasination%20classroom%2FAss.%20Class.%20%20S1%20(1)%20480p%20Dual%20Audio.mkv?alt=media&token=5bef71d2-89b4-49b5-927c-02ec415f61a4";
            Intent intent = new Intent(MainEpisodePage.this, VideoPlayerActivity.class);
            intent.putExtra("videoUrl", videoUrl);
            startActivity(intent);
        }


        else {
            // Handle other descriptions or set a default destination
            // For example, you can show a toast message.
            Toast.makeText(MainEpisodePage.this, "Unknown description", Toast.LENGTH_SHORT).show();

        }




    }
    private void getEpisode2(String description) {
        if ("Jujutsu Kaisen 1".equals(description)) {
            // Navigate to EpisodePage1
            // You should have an EpisodePage1 class for this
            String videoUrl = "https://firebasestorage.googleapis.com/v0/b/animestream-fa009.appspot.com/o/jujutsu%2FEp_2_jujutsu_kaisen_Eng%2Bjap_Dub_Quality_720p_TG_%40Dub_Animes_in_English.mkv?alt=media&token=80f5df21-4dae-4c9a-a8ab-6dfa9907cc70";
            Intent intent = new Intent(MainEpisodePage.this, VideoPlayerActivity.class);
            intent.putExtra("videoUrl", videoUrl);
            startActivity(intent);
        } else if ("Assassination Classroom".equals(description)) {
            // Navigate to AnotherEpisodePage
            // You should have an AnotherEpisodePage class for this
            String videoUrl = "https://firebasestorage.googleapis.com/v0/b/animestream-fa009.appspot.com/o/Assasination%20classroom%2FAss.%20Class.%20%20S1%20(2)%20480p%20Dual%20Audio.mkv?alt=media&token=2df3f652-b7e0-4943-816e-a98e7ba18a3e";
            Intent intent = new Intent(MainEpisodePage.this, VideoPlayerActivity.class);
            intent.putExtra("videoUrl", videoUrl);
            startActivity(intent);
        }
    }
    private void getEpisode3(String description) {
        if ("Jujutsu Kaisen 1".equals(description)) {
            // Navigate to EpisodePage1
            // You should have an EpisodePage1 class for this
            String videoUrl = "https://firebasestorage.googleapis.com/v0/b/animestream-fa009.appspot.com/o/jujutsu%2FEp_3_jujutsu_kaisen_Eng%2Bjap_Dub_Quality_720p_TG_%40Dub_Animes_in_English.mkv?alt=media&token=33e91765-6fbb-4b77-8dbd-4518b7cf070d";
            Intent intent = new Intent(MainEpisodePage.this, VideoPlayerActivity.class);
            intent.putExtra("videoUrl", videoUrl);
            startActivity(intent);
        } else if ("Assassination Classroom".equals(description)) {
            // Navigate to AnotherEpisodePage
            // You should have an AnotherEpisodePage class for this
            String videoUrl = "https://firebasestorage.googleapis.com/v0/b/animestream-fa009.appspot.com/o/Assasination%20classroom%2FAss.%20Class.%20%20S1%20(3)%20480p%20Dual%20Audio.mkv?alt=media&token=142c9fc5-d638-4fe1-80be-2a4e8eba1ebc";
            Intent intent = new Intent(MainEpisodePage.this, VideoPlayerActivity.class);
            intent.putExtra("videoUrl", videoUrl);
            startActivity(intent);
        }
    }
    private void getEpisode4(String description) {
        if ("Assassination Classroom".equals(description)) {
            // Navigate to AnotherEpisodePage
            // You should have an AnotherEpisodePage class for this
            String videoUrl = "https://firebasestorage.googleapis.com/v0/b/animestream-fa009.appspot.com/o/Assasination%20classroom%2FAss.%20Class.%20%20S1%20(4)%20480p%20Dual%20Audio.mkv?alt=media&token=bf0edf99-73e9-4f4c-a05c-d61a2a5e9513";
            Intent intent = new Intent(MainEpisodePage.this, VideoPlayerActivity.class);
            intent.putExtra("videoUrl", videoUrl);
            startActivity(intent);
        }
    }
    private void getEpisode5(String description) {
         if ("Assassination Classroom".equals(description)) {
            // Navigate to AnotherEpisodePage
            // You should have an AnotherEpisodePage class for this
             String videoUrl = "https://firebasestorage.googleapis.com/v0/b/animestream-fa009.appspot.com/o/Assasination%20classroom%2FAss.%20Class.%20%20S1%20(5)%20480p%20Dual%20Audio.mkv?alt=media&token=1eff509a-2883-4601-b06d-3a8db0b94f21";
             Intent intent = new Intent(MainEpisodePage.this, VideoPlayerActivity.class);
             intent.putExtra("videoUrl", videoUrl);
             startActivity(intent);
        }
    }

}