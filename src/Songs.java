public class Songs {

    private String songName;
    private String duration;

    public Songs(String name, String duration)
    {
        this.songName=name;
        this.duration = duration;
    }

    public String getSongName() {
        return songName;
    }

    public String getDuration() {
        return duration;
    }

    @Override
    public String toString(){
        return "{Title: '"+songName+"' , 4Duration: '"+duration+"'}";
    }
}
