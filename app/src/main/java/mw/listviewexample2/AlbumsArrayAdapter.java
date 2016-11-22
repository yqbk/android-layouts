package mw.listviewexample2;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AlbumsArrayAdapter extends ArrayAdapter<Album> {

    private Activity context;
    private List<Album> albums;

    public AlbumsArrayAdapter(Activity context, List<Album> albums) {
        super(context, R.layout.list_view_item, albums);
        this.context = context;
        this.albums = albums;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = context.getLayoutInflater();
        View rowView = layoutInflater.inflate(R.layout.list_view_item, null, true);

        ImageView imageView = (ImageView)rowView.findViewById(R.id.coverImageView);
        TextView artistTextView = (TextView)rowView.findViewById(R.id.artistTextView);
        TextView titleTextView = (TextView)rowView.findViewById(R.id.titleTextView);
        Album album = albums.get(position);

        imageView.setImageResource(album.getCover());
        artistTextView.setText(album.getArtist());
        titleTextView.setText(album.getTitle());

        return rowView;
    }
}
