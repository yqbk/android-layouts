package mw.gridviewexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class AlbumContentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_content);

        Intent intent = getIntent();
        final Album album = (Album)intent.getExtras().getSerializable("album");

        TextView artistTextView = (TextView)findViewById(R.id.artistContentTextView);
        TextView titleTextView = (TextView)findViewById(R.id.titleContentTextView);
        artistTextView.setText(album.getArtist());
        titleTextView.setText(album.getTitle());
        SongAlbumAdapter adapter = new SongAlbumAdapter(this,album.getSongs());
        ListView listView = (ListView)findViewById(R.id.songListView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView songTitleTextView = (TextView)view.findViewById(R.id.songTitleTextView);
                Toast.makeText(getApplicationContext(),songTitleTextView.getText(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
