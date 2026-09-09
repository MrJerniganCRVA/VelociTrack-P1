import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

/**
 * VelociTrack -- MediaItem Abstract Base Class
 *
 * Holds the fields and behavior every media type has in common. Song,
 * Podcast, and Audiobook should each extend this class (Project 1) AND
 * separately implement the Playable interface.
 *
 * You do NOT need to modify this file -- just extend it.
 *
 * Shape of what you'll build (fill in the details yourself):
 *
 *   public class YourMediaType extends MediaItem implements Playable {
 *       // add whatever field(s) make this type unique
 *
 *       public YourMediaType(String id, String title, int durationSeconds,
 *                             String genre, String dateAdded, int releaseYear,
 *                             ...) {
 *           super(id, title, durationSeconds, genre, dateAdded, releaseYear);
 *           // set your own field(s) here
 *       }
 *
 *       public void play() {
 *           // your own behavior here
 *       }
 *
 *       public String getCreator() {
 *           // return whatever this type calls its "creator"
 *       }
 *   }
 *
 * Notice: getTitle(), getDuration(), getGenre(), getDateAdded(),
 * getReleaseYear(), and getPlayCount() are all inherited from MediaItem for
 * free, and Java still counts them toward satisfying the Playable
 * interface. You only need to write play() and getCreator() yourself --
 * everything else about how your class is designed is up to you.
 */
public abstract class MediaItem {

    private final String id;
    private final String title;
    private final int durationSeconds;
    private final String genre;
    private final String dateAdded;
    private final int releaseYear;
    private int playCount;

    public MediaItem(String id, String title, int durationSeconds,
                      String genre, String dateAdded, int releaseYear) {
        this.id = id;
        this.title = title;
        this.durationSeconds = durationSeconds;
        this.genre = genre;
        this.dateAdded = dateAdded;
        this.releaseYear = releaseYear;
        this.playCount = 0;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return durationSeconds;
    }

    public String getGenre() {
        return genre;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public int getPlayCount() {
        return playCount;
    }

    /**
     * Call this from inside your play() method (in Song, Podcast, etc.) so
     * VelociTrack can track how many times each item has been played.
     * You won't need this to actually matter until Project 5 (Trending),
     * but it's good practice to start calling it in Project 1.
     */
    protected void incrementPlayCount() {
        playCount++;
    }

    /**
     * Plays a .wav file from the project's "sounds" folder.
     *
     * You do NOT need to pass a full file path -- just the file name, like
     * "generic-song.wav". BlueJ runs your program with the project folder
     * as the working directory, so a relative path like "sounds/<fileName>"
     * is all that's needed to find it.
     *
     * If the file doesn't exist yet this prints a friendly message instead of crashing your program.
     *
     * Call this from your play() method, for example:
     *   playSound("generic-song.wav");
     *
     * Note: playback happens on a separate thread and continues in the
     * background. In a menu-driven program like Main.java, this is fine --
     * the program is sitting at the next input prompt while the clip plays.
     * If you write a short standalone test that calls play() and then
     * immediately ends the program, you may not hear the whole clip.
     */
    protected void playSound(String fileName) {
        File soundFile = new File("sounds/" + fileName);
        if (!soundFile.exists()) {
            System.out.println("(No sound file found at sounds/" + fileName
                    + " -- add one to hear it play!)");
            return;
        }
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
            //best practice would be to add a way to stop this. Luckily for us, best practices and learning don't
            //always have to be one and the same. 
        } catch (Exception e) {
            System.out.println("(Couldn't play sounds/" + fileName + ": " + e.getMessage() + ")");
        }
    }
}
