package mw.gridviewexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

class AlbumAdapter extends BaseAdapter {

    private List<Album> albums;
    private Context context;

    AlbumAdapter(Context context, List<Album> albums){
        this.context = context;
        this.albums = albums;
    }

    @Override
    public Object getItem(int position) {
        return albums.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getCount() {
        return albums.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.grid_view_item,null);
            viewHolder = new ViewHolder();
            viewHolder.coverImageView = (ImageView)convertView.findViewById(R.id.coverImageView);
            viewHolder.artistTextView = (TextView)convertView.findViewById(R.id.artistTextView);
            viewHolder.titleTextView = (TextView)convertView.findViewById(R.id.titleTextView);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder)convertView.getTag();
        }
        final Album album = albums.get(position);
        viewHolder.coverImageView.setImageResource(album.getCover());
        viewHolder.artistTextView.setText(album.getArtist());
        viewHolder.titleTextView.setText(album.getTitle());
        return convertView;
    }

    private static class ViewHolder{
        private ImageView coverImageView;
        private TextView artistTextView;
        private TextView titleTextView;
    }
}
