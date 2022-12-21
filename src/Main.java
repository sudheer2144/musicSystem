import sun.awt.image.ImageWatched;

import java.util.*;

public class Main extends Exception{
    public static void main(String[] args) {
        System.out.println("Welcome to PLAY SYSTEM");


        ArrayList<Albums> album=new ArrayList<>();

        Albums a1=new Albums("English","Eminem");
        a1.addSongtoAlbum("lose yourself","4:56");
        a1.addSongtoAlbum("RapGod","6:02");
        a1.addSongtoAlbum("Slim Shady","5:40");
        a1.addSongtoAlbum("Venom","4:32");
        album.add(a1);

        a1=new Albums("Telugu","Sudheeer");
        a1.addSongtoAlbum("Come to the party Subalakshmi","2:50");
        a1.addSongtoAlbum("naa valley","7:02");
        a1.addSongtoAlbum("nee valle","2:40");
        a1.addSongtoAlbum("mana valley","6:32");
        album.add(a1);

        LinkedList<Songs> playlist=new LinkedList<>();
        album.get(0).addToPlaylist("lose yourself",playlist);
        album.get(0).addToPlaylist("Slim Shady",playlist);
        album.get(1).addToPlaylist("Come to the party Subalakshmi",playlist);
        album.get(1).addToPlaylist("mana valley",playlist);

        play(playlist);

    }

    public static void play(LinkedList<Songs> playlist)
    {
        if(playlist.size() == 0) {
            System.out.println("Play List is Empty");
        }
        else {
            ListIterator<Songs> songsListIterator = playlist.listIterator();

            System.out.println("\nPlaying the First Song");
            System.out.println(songsListIterator.next().toString());
            boolean forward = true;
            boolean quit = false;

            printMenu();

            Scanner sc = new Scanner(System.in);

            while (quit == false) {
                System.out.println("\nEnter your option: ");

                int option = sc.nextInt();

                switch (option) {

                    case 0:
                        quit = true;
                        break;
                    case 1:
                        if (songsListIterator.hasNext()) {
                            System.out.println("Next Song: " + songsListIterator.next().toString());
                            forward=true;
                        }
                        else {
                            System.out.println("You are at end of the list");
                            //forward=false;
                        }
                        break;
                    case 2:
                        if (forward) {
                            songsListIterator.previous();
                            forward = false;
                        }
                        if (songsListIterator.hasPrevious()) {
                            System.out.println("\nPrevious Song: " + songsListIterator.previous().toString());
                            forward = false;
                        }
                        else {
                            System.out.println("You are at the Beginning of the playlist");
                            forward = false;
                        }
                        break;
                    case 3:
                        if(forward) {
                            if (songsListIterator.hasPrevious()) {
                                System.out.println("\nRepeating the Song: " + songsListIterator.previous().toString());
                                forward = false;
                            }
                        }
                        else {
                            if (songsListIterator.hasNext()) {
                                System.out.println("\nRepeating the Song: " + songsListIterator.next().toString());
                                forward = false;
                            }
                        }
                        break;
                    case 4:
                        System.out.println("\nPrinting all the songs: ");
                        printSongs(playlist);
                        break;
                    case 5:
                        if (forward) {
                            songsListIterator.remove();
                            forward = false;
                        }
                        else {
                            songsListIterator.next();
                            songsListIterator.remove();
                        }
                        break;
                    case 6:
                        printMenu();
                        break;
                }
            }
        }
    }

    public static void printMenu(){
        System.out.println
                ("\n " +
                "Available Options \n " +
                "0:Exit \n " +
                "1:Next Song \n " +
                "2:Previous Song \n " +
                "3:Repeat Current Song \n " +
                "4:List Songs \n " +
                "5:Delete Current Song \n " +
                "6:Print all available options"
                );
    }

    public static void printSongs(LinkedList<Songs> playlist)
    {
        for(Songs song:playlist)
        {
            System.out.println(song.toString());
        }
    }
}





























