package mw.listviewexample3;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

class AlbumsArrayAdapter extends ArrayAdapter<Album> {

    private Activity context;
    private List<Album> albums;

    AlbumsArrayAdapter(Activity context, List<Album> albums) {
        super(context, R.layout.list_view_item, albums);
        this.context = context;
        this.albums = albums;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        View rowView = convertView;
        if (rowView == null) {
            LayoutInflater layoutInflater = context.getLayoutInflater();
            rowView = layoutInflater.inflate(R.layout.list_view_item, null, true);
            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView)rowView.findViewById(R.id.coverImageView);
            viewHolder.artistTextView = (TextView)rowView.findViewById(R.id.artistTextView);
            viewHolder.titleTextView = (TextView)rowView.findViewById(R.id.titleTextView);
            rowView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder)rowView.getTag();
        }
        Album album = albums.get(position);
        viewHolder.imageView.setImageResource(album.getCover());
        viewHolder.artistTextView.setText(album.getArtist());
        viewHolder.titleTextView.setText(album.getTitle());

        return rowView;
    }

    private static class ViewHolder {
        private ImageView imageView;
        private TextView artistTextView;
        private TextView titleTextView;
    }
}
