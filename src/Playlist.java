import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Playlist {
    private List<Media> playlist = new LinkedList<>();
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void addMusicOrFilmToPlaylist(){
        try {
            System.out.println("Enter name music or film: ");
            String name = reader.readLine();
            System.out.println("Enter type: ");
            String typ = reader.readLine();

            Media media = new Media(name, Type_list.valueOf(typ));
            playlist.add(media);
            System.out.println("Media adding to playlist\n");
        }  catch (IllegalArgumentException ie){
            System.out.println("You're enter the wrong type. Example: MUSIC, FILM, ...\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showPlaylist(){
        if (!playlist.isEmpty())
            playlist.forEach(System.out::println);
        else
            System.out.println("Playlist are empty\n");
    }

    public void playRandomList(){
        Collections.shuffle(playlist);
        System.out.println("Play the playlist ...");
        play(playlist);
    }

    public void playLoopingPlaylist() throws IOException {
        System.out.println("Play the playlist ...");
        while (!reader.readLine().equalsIgnoreCase("stop")){
           play(playlist);
        }
    }

    public void playSequentiallyPlaylist(){
        play(playlist);
    }

    private void play(List<Media> playlists){
        if (!playlists.isEmpty()){
            playlists.forEach(media -> {
                try {
                    Thread.sleep(3000);
                    System.out.println(media.toString());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        } else {
            System.out.println("Playlist are empty\n");
        }
    }

}
