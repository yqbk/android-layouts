package mw.gridviewexample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class SongAlbumAdapter extends ArrayAdapter<Song> {

    private Context context;
    private List<Song> songs;

    public SongAlbumAdapter(Context context, List<Song> songs) {
        super(context, R.layout.song_list_view_item, songs);
        this.songs = songs;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView,@NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.song_list_view_item,null);
            viewHolder = new ViewHolder();
            viewHolder.songNumberTextView = (TextView)convertView.findViewById(R.id.songNumberTextView);
            viewHolder.songTitleTextView = (TextView)convertView.findViewById(R.id.songTitleTextView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder)convertView.getTag();
        }
        final Song song = songs.get(position);
        viewHolder.songNumberTextView.setText(String.valueOf(song.getNumber()));
        viewHolder.songTitleTextView.setText(song.getTitle());
        return convertView;
    }

    private static class ViewHolder {
        private TextView songNumberTextView;
        private TextView songTitleTextView;
    }
}
