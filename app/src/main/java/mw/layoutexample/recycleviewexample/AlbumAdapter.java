package mw.layoutexample.recycleviewexample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder> {

    private List<Album> albums;

    AlbumAdapter(List<Album> albums) {
        this.albums = albums;
    }

    @Override
    public AlbumAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.album_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AlbumAdapter.ViewHolder holder, int position) {
        Album album = albums.get(position);
        holder.coverImageView.setImageResource(album.getCover());
        holder.artistTextView.setText(album.getArtist());
        holder.titleTextView.setText(album.getTitle());
    }

    @Override
    public int getItemCount() {
        return albums.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        ImageView coverImageView;
        TextView artistTextView;
        TextView titleTextView;

        ViewHolder(View itemView) {
            super(itemView);
            coverImageView = (ImageView)itemView.findViewById(R.id.coverImageView);
            artistTextView = (TextView)itemView.findViewById(R.id.artistTextView);
            titleTextView = (TextView)itemView.findViewById(R.id.titleTextView);
        }
    }

    public void removeAlbum(int position){
        albums.remove(position);
    }

}
