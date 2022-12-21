import java.util.ArrayList;
import java.util.LinkedList;

public class Albums {
    private String name;

    private  String artistName;

    private ArrayList<Songs> songs;

    public Albums(String name, String artistName) {
        this.name = name;
        this.artistName = artistName;
        this.songs=new ArrayList<>();
    }


    public boolean findSong(String name)
    {
        for(Songs song : songs)
        {
            if(name.equals(song.getSongName()))
            {
                return true;
            }
        }
        return false;
    }

    public void addSongtoAlbum(String sname,String duration)
    {
        if(!findSong(sname)) {
            Songs s=new Songs(sname,duration);
            songs.add(s);
            System.out.println("Song '" +sname+ "' added to album: "+name);
        }
        else {
            System.out.println("Song '" +name+ "' already in the Album");
        }
    }

    public void addToPlaylist(String title, LinkedList<Songs> playList)
    {
        for(Songs song : songs)
        {
            if(title.equals(song.getSongName()))
            {
                playList.add(song);
            }
        }
    }

}
