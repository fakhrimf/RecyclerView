package com.pwpb.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<Song> songList;
    private SongAdapter songAdapter;

    String[] names = {
            "I Took A Pill In Ibiza",
            "7 Years",
            "Pillow Talk",
            "Work From Home",
            "Never Forget You",
            "Don't Let Me Down",
            "Love Yourself",
            "Me, Myself & I",
            "Cake By The Ocean",
            "Dangerous Woman",
            "My House",
            "Stressed Out",
            "One Dance",
            "Middle",
            "No"};

    String[] singers = {
            "Mike Posner",
            "Lukas Graham",
            "Zayn",
            "Fifth Harmony",
            "Zara Larsson & MNEK",
            "The Chainsmokers",
            "Justin Bieber",
            "G-Eazy x Bebe Rexha",
            "DNCE",
            "Ariana Grande",
            "Flo Rida",
            "Twenty one Pilots",
            "Drake",
            "DJ Snake",
            "Meghan Trainor"};

    int[] pics = {
            R.drawable.took_a_pill,
            R.drawable.seven_years,
            R.drawable.pillow_talk,
            R.drawable.work,
            R.drawable.never_forget_you,
            R.drawable.dont_let_me_down,
            R.drawable.love_yourself,
            R.drawable.me_myself_and_i,
            R.drawable.cake_by_the_ocean,
            R.drawable.dangerous_woman,
            R.drawable.my_house_florida,
            R.drawable.stressed_out,
            R.drawable.one_dance,
            R.drawable.middle,
            R.drawable.no};

    public void initUI() {
        recyclerView = findViewById(R.id.rv);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();

        if (recyclerView != null) recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        songList = new ArrayList<>();

        //Menambahkan lagu kedalam list
        for (int i = 0; i < names.length; i++) {
            Song song = new Song(names[i], singers[i],  pics[i], i+1);
            songList.add(song);
        }
        //init adapter
        songAdapter = new SongAdapter(songList);
        //membuat view dan mengganti isinya
        recyclerView.setAdapter(songAdapter);
        songAdapter.notifyDataSetChanged();
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Toast.makeText(MainActivity.this, "Card at " + position + " is clicked", Toast.LENGTH_SHORT).show();
                    }
                }));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activitymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_grid:
                layoutManager = new GridLayoutManager(this, 2);
                recyclerView.setLayoutManager(layoutManager);
                break;
            case R.id.item_staggered_grid:
                layoutManager = new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(layoutManager);
                break;
            case R.id.item_horizontal:
                layoutManager = new
                LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
                recyclerView.setLayoutManager(layoutManager);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
