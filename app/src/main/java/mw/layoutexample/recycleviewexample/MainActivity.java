package mw.layoutexample.recycleviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        //LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        //GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        final AlbumAdapter adapter = new AlbumAdapter(createAlbums());
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(new RecyclerItemTouchListener(getApplicationContext(), recyclerView, new RecyclerItemTouchListener.OnItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                String artist = ((TextView)view.findViewById(R.id.artistTextView)).getText().toString();
                String title = ((TextView)view.findViewById(R.id.titleTextView)).getText().toString();
                Toast.makeText(getApplicationContext().getApplicationContext(),artist + " - " + title,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongPress(View view, int position) {
                adapter.removeAlbum(position);
                adapter.notifyItemRemoved(position);
            }
        }));
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
