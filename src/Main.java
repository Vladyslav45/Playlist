import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args){
        Playlist playlist = new Playlist();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        menu(reader,playlist);
    }

    private static void menu(BufferedReader reader, Playlist playlist){
        String op;
        boolean status = true;
        while (status) {
            System.out.println("Menu: \n" +
                    "1 - Show playlist\n" +
                    "2 - Adding music or film to playlist\n" +
                    "3 - Play randomly , sequentially or looping\n");
            try {
                if (!(op = reader.readLine()).equalsIgnoreCase("exit")) {
                    switch (Integer.parseInt(op)) {
                        case 1:
                            playlist.showPlaylist();
                            break;
                        case 2:
                            playlist.addMusicOrFilmToPlaylist();
                            break;
                        case 3:
                            System.out.println("Play:\n" +
                                    "1 - randomly\n" +
                                    "2 - sequentially\n" +
                                    "3 - looping\n");
                            int choice = Integer.parseInt(reader.readLine());
                            switch (choice) {
                                case 1:
                                    playlist.playRandomList();
                                    break;
                                case 2:
                                    playlist.playSequentiallyPlaylist();
                                    break;
                                case 3:
                                    playlist.playLoopingPlaylist();
                                    break;
                            }
                            break;
                        default:
                            System.out.println("There is no such operation\n");
                    }
                } else {
                    status = false;
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NumberFormatException ne){
                System.out.println("Wrong operation");
            }
        }
    }
}
