package mw.gridviewexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final AlbumAdapter adapter = new AlbumAdapter(this,createAlbums());
        GridView gridView = (GridView)findViewById(R.id.albumsGridView);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Album album = (Album)adapter.getItem(position);
                //Toast.makeText(getApplicationContext(),album.getArtist() + " - " + album.getTitle(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("album",album);
                intent.putExtras(bundle);
                intent.setClass(MainActivity.this,AlbumContentActivity.class);
                startActivity(intent);
            }
        });
    }

    private ArrayList<Album> createAlbums(){
        ArrayList<Album> albums = new ArrayList<>(15);
        albums.add(new Album("3 Doors Down","The Better Life",R.drawable.better,createListOfSongs("3 Doors Down",getResources().getStringArray(R.array.the_better_life))));
        albums.add(new Album("Alice Cooper","Trash",R.drawable.trash,createListOfSongs("Alice Cooper",getResources().getStringArray(R.array.trash))));
        albums.add(new Album("Black Sabbath","Paranoid",R.drawable.paranoid,createListOfSongs("Black Sabbath",getResources().getStringArray(R.array.paranoid))));
        albums.add(new Album("Foo Fighters","Echoes, Silence, Patience And Grace",R.drawable.echo,createListOfSongs("Foo Fighters",getResources().getStringArray(R.array.echos))));
        albums.add(new Album("Foo Fighters","Wasting Light",R.drawable.wasting,createListOfSongs("Foo Fighters",getResources().getStringArray(R.array.wasting))));
        albums.add(new Album("Foo Fighters","Sonic Highways",R.drawable.sonic,createListOfSongs("Foo Fighters",getResources().getStringArray(R.array.sonic))));
        albums.add(new Album("Foo Fighters","Saint Cecilia EP",R.drawable.saint,createListOfSongs("Foo Fighters",getResources().getStringArray(R.array.saint))));
        albums.add(new Album("Ghost BC","Meliora",R.drawable.meliora,createListOfSongs("Ghost BC",getResources().getStringArray(R.array.meliora))));
        albums.add(new Album("Guns N' Roses","Appetite For Destruction",R.drawable.appetite,createListOfSongs("Guns N' Roses",getResources().getStringArray(R.array.appetite))));
        albums.add(new Album("Nick Cave","Skeleton Tree",R.drawable.skeleton,createListOfSongs("Nick Cave",getResources().getStringArray(R.array.skeleton))));
        albums.add(new Album("Nirvana","Bleach",R.drawable.bleach,createListOfSongs("Nirvana",getResources().getStringArray(R.array.bleach))));
        albums.add(new Album("Nirvana","Nevermind",R.drawable.nevermind,createListOfSongs("Nirvana",getResources().getStringArray(R.array.nevermind))));
        albums.add(new Album("Nirvana","In Utero",R.drawable.utero,createListOfSongs("Nirvana",getResources().getStringArray(R.array.utero))));
        albums.add(new Album("The Beach Boys","Pet Sounds",R.drawable.pet,createListOfSongs("The Beach Boys",getResources().getStringArray(R.array.pet))));
        albums.add(new Album("The Beach Boys","Smiley Smile",R.drawable.smiley,createListOfSongs("The Beach Boys",getResources().getStringArray(R.array.smiley))));
        return albums;
    }

    private ArrayList<Song> createListOfSongs(String artist, String[] titles){
        ArrayList<Song> songs = new ArrayList<>(10);
        for(int i = 0 ; i < titles.length; i++){
            songs.add(new Song(i+1,artist,titles[i]));
        }
        return songs;
    }
}
