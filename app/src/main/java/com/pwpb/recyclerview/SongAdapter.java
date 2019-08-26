package com.pwpb.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.ViewHolder> {
    private List<Song> songList;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        //each data item is just a string in this case
        public TextView tvRank, tvSongName, tvSinger, tvYear;
        public ImageView ivAlbumCover;

        public ViewHolder(View v) {
            super(v);
            tvRank = v.findViewById(R.id.tv_rank);
            tvSongName = v.findViewById(R.id.tv_songname);
            tvSinger = v.findViewById(R.id.tv_singer);
            tvYear = v.findViewById(R.id.tv_year);
            ivAlbumCover = v.findViewById(R.id.iv_albumcover);
        }

    }

    //Provide a suitable constructor
    public SongAdapter(List<Song> songList) {
        this.songList = songList;
    }

    //Create new views (invoked by the layout manager)
    @Override
    public SongAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_song_list, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(SongAdapter.ViewHolder holder, int position) {
        Song song = songList.get(position);
        holder.tvRank.setText(String.valueOf(song.getRank()));
        holder.tvSongName.setText(song.getName());
        holder.tvSinger.setText(song.getSinger());
        holder.tvYear.setText(song.getYear());
        holder.ivAlbumCover.setImageResource(song.getPic());
        holder.tvYear.setText("2016");
    }

    @Override
    public int getItemCount() {
        return songList.size();
    }
}
