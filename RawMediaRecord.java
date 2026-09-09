/**
 * VelociTrack -- Raw Sample Data Record
 *
 * A plain data holder used ONLY by SampleDataGenerator. This is NOT one of
 * your MediaItem subclasses -- it's just a simple bag of fields you can use
 * to build your own Song, Podcast, and Audiobook objects once you've
 * written those classes in Project 1.
 */
public class RawMediaRecord {

    public final String id;
    public final String type;       // "SONG", "PODCAST", or "AUDIOBOOK"
    public final String title;
    public final String creator;    // artist, host, or narrator depending on type
    public final String genre;
    public final int durationSeconds;
    public final String dateAdded;  // format: YYYY-MM-DD
    public final int releaseYear;
    public final String filePath;

    public RawMediaRecord(String id, String type, String title, String creator,
                           String genre, int durationSeconds, String dateAdded, int releaseYear) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.creator = creator;
        this.genre = genre;
        this.durationSeconds = durationSeconds;
        this.dateAdded = dateAdded;
        this.releaseYear = releaseYear;
        this.filePath = null;
    }
    //This constructor takes a file path so that you can actually "play" a specific song
    public RawMediaRecord(String id, String type, String title, String creator,
                            String genre, int durationSeconds, String dateAdded, int releaseYear, String filePath){
        this.id = id;
        this.type = type;
        this.title = title;
        this.creator = creator;
        this.genre = genre;
        this.durationSeconds = durationSeconds;
        this.dateAdded = dateAdded;
        this.releaseYear = releaseYear;
        this.filePath = filePath;              
    }

    @Override
    public String toString() {
        return type + ": \"" + title + "\" by " + creator + " (" + genre + ", " + releaseYear + ")";
    }
}
