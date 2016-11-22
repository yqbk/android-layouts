package mw.listviewexample2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AlbumsArrayAdapter adapter = new AlbumsArrayAdapter(this,createAlbums());
        ListView listView = (ListView)findViewById(R.id.albumsListView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView artistTextView = (TextView)view.findViewById(R.id.artistTextView);
                TextView titleTextView = (TextView)view.findViewById(R.id.titleTextView);
                Toast.makeText(getApplicationContext(),artistTextView.getText() + " - " + titleTextView.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private ArrayList<Album> createAlbums(){
        ArrayList<Album> albums = new ArrayList<>(15);
        albums.add(new Album("3 Doors Down","The Better Life",R.drawable.better));
        albums.add(new Album("Alice Cooper","Trash",R.drawable.trash));
        albums.add(new Album("Black Sabbath","Paranoid",R.drawable.paranoid));
        albums.add(new Album("Foo Fighters","Echoes, Silence, Patience And Grace",R.drawable.echo));
        albums.add(new Album("Foo Fighters","Wasting Light",R.drawable.wasting));
        albums.add(new Album("Foo Fighters","Sonic Highways",R.drawable.sonic));
        albums.add(new Album("Foo Fighters","Saint Cecilia EP",R.drawable.saint));
        albums.add(new Album("Ghost BC","Meliora",R.drawable.meliora));
        albums.add(new Album("Guns N' Roses","Appetite For Destruction",R.drawable.appetite));
        albums.add(new Album("Nick Cave","Skeleton Tree",R.drawable.skeleton));
        albums.add(new Album("Nirvana","Bleach",R.drawable.bleach));
        albums.add(new Album("Nirvana","Nevermind",R.drawable.nevermind));
        albums.add(new Album("Nirvana","In Utero",R.drawable.utero));
        albums.add(new Album("The Beach Boys","Pet Sounds",R.drawable.pet));
        albums.add(new Album("The Beach Boys","Smiley Smile",R.drawable.smiley));
        return albums;
    }

}
