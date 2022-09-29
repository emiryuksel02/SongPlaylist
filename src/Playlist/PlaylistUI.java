package Playlist;

import java.util.Scanner;

/**
 * User interface for the playlist.
 * 
 * @author Emir Yuksel
 * @version 1.0
 *
 */

public class PlaylistUI {
    private static final String COMMAND_SEPARATOR = " ";
    private static final String PARAMETER_SEPARATOR = ":";

    private static final String COMMAND_ADD = "add";
    private static final int ADD_PARAMETER_ID = 0;
    private static final int ADD_PARAMETER_ARTIST = 1;
    private static final int ADD_PARAMETER_TITLE = 2;
    private static final int ADD_PARAMETER_LENGTH = 3;
    private static final int ADD_PARAMETER_PRIORITY = 4;

    private static final String COMMAND_REMOVE = "remove";
    private static final int REMOVE_PARAMETER_ID = 0;

    private static final String COMMAND_PLAY = "play";
    private static final int PLAY_PARAMETER_LENGTH = 0;

    private static final String COMMAND_SKIP = "skip";

    private static final String COMMAND_PEEK = "peek";

    private static final String COMMAND_LIST = "list";

    private static final String COMMAND_HISTORY = "history";

    private static final String COMMAND_QUIT = "quit";

    private static final String PLEASE_ENTER_VALID_COMMAND = "Please enter a valid command.";

    private Playlist playlist = new Playlist();

    public PlaylistUI(Playlist playlist) {
        this.playlist = playlist;
    }

    /**
     * Starts an interactive session.
     */

    public void interactive() {

        boolean quit = false;
        Scanner scanner = new Scanner(System.in);

        do {
            String input = scanner.nextLine();
            String[] split = input.split(COMMAND_SEPARATOR);
            String command = split[0];
            String[] parameters = (split.length > 1) ? split[1].split(PARAMETER_SEPARATOR) : null;

            switch (command) {
            case COMMAND_ADD:
                add(parameters);
                break;

            case COMMAND_REMOVE:
                remove(parameters);
                break;

            case COMMAND_PLAY:
                play(parameters);
                break;

            case COMMAND_SKIP:
                skip(parameters);
                break;

            case COMMAND_PEEK:
                peek(parameters);
                break;

            case COMMAND_LIST:
                list(parameters);
                break;

            case COMMAND_HISTORY:
                history(parameters);
                break;

            case COMMAND_QUIT:
                quit = true;
                break;

            default:
                System.out.println(PLEASE_ENTER_VALID_COMMAND);
                break;

            }
        } while (!quit);

        scanner.close();

    }

    private void add(String[] parameters) {
        int id = Integer.valueOf(parameters[ADD_PARAMETER_ID]);
        String artist = parameters[ADD_PARAMETER_ARTIST];
        String title = parameters[ADD_PARAMETER_TITLE];
        int length = Integer.valueOf(parameters[ADD_PARAMETER_LENGTH]);
        int priority = Integer.valueOf(parameters[ADD_PARAMETER_PRIORITY]);
        this.playlist.add(new Song(id, artist, title, length, priority));

    }

    private void remove(String[] parameters) {
        this.playlist.remove(Integer.valueOf(parameters[REMOVE_PARAMETER_ID]));
    }

    private void play(String[] parameters) {
        this.playlist.play(Integer.valueOf(parameters[PLAY_PARAMETER_LENGTH]));
    }

    private void skip(String[] parameters) {
        this.playlist.skip();
    }

    private void peek(String[] parameters) {
        this.playlist.peek();
    }

    private void list(String[] parameters) {
        this.playlist.list();
    }

    private void history(String[] parameters) {
        this.playlist.history();
    }

}
