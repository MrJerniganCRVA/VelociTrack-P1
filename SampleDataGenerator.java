import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * VelociTrack -- Sample Data Generator
 *
 * Generates realistic-looking fake catalog data so you can test your code
 * against hundreds (or thousands) of items instead of typing them by hand.
 *
 * This does NOT create Song/Podcast/Audiobook objects -- those are yours to
 * build in Project 1. It generates plain RawMediaRecord objects instead.
 * See the comment at the top of RawMediaRecord.java for an example of how
 * to turn these into real objects once your classes exist.
 *
 * You do NOT need to modify this file.
 */
public class SampleDataGenerator {
    
    //These are random titles and artists to make fake data with
    //Built with the help of Claude...I didn't feel like making random songs.
    //If you want to add more or less you can
    private static final String[] SONG_TITLES = {
        "Midnight Drive", "Paper Skies", "Electric Bloom", "Static Hearts",
        "Neon Rain", "Glass Horizon", "Velvet Static", "Windows Down",
        "Ghost in the Wire", "Autumn Static", "Low Fidelity", "Chrome Heart",
        "Backroad Static", "Slow Burn", "Radio Silence", "Faded Polaroid"
    };
    private static final String[] ARTISTS = {
        "The Wandering Signal", "June Static", "Hollow Coast", "Radar Youth",
        "The Paper Lanterns", "Static Season", "Nova Drift", "The Glass Room"
    };
    private static final String[] PODCAST_TITLES = {
        "Deep Dive Weekly", "The Backstory", "Unsolved Files", "Code & Coffee",
        "History Uncovered", "The Debrief", "Late Night Signal", "Mind the Gap"
    };
    private static final String[] HOSTS = {
        "Jordan Reyes", "Priya Anand", "Marcus Cole", "Dana Whitfield"
    };
    private static final String[] AUDIOBOOK_TITLES = {
        "The Last Lighthouse", "Static Horizon", "Beneath the Archive",
        "The Quiet Frequency", "Ashfall", "The Long Signal Home"
    };
    private static final String[] NARRATORS = {
        "Grace Whitfield", "Theo Marsh", "Renee Okafor", "Diego Salinas"
    };
    private static final String[] GENRES = {
        "Rock", "Pop", "Indie", "True Crime", "Comedy", "Sci-Fi", "Fantasy",
        "Electronic", "Hip-Hop", "History", "Technology", "Mystery"
    };

    private static final Random random = new Random();

    /**
     * Generates the requested number of raw sample records, split roughly
     * evenly across songs, podcasts, and audiobooks.
     */
    public static List<RawMediaRecord> generate(int count) {
        List<RawMediaRecord> data = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int roll = random.nextInt(3);
            if (roll == 0) {
                data.add(generateSong(i));
            } else if (roll == 1) {
                data.add(generatePodcast(i));
            } else {
                data.add(generateAudiobook(i));
            }
        }
        return data;
    }
    //Makes "real" tracks with playable songs
    public static List<RawMediaRecord> getActualSongs(){
        List<RawMediaRecord> actual = new ArrayList<>();
        actual.add(new RawMediaRecord("featured-1","SONG","Ultra Polka","Kevin MacLeod", "Polka",224,"2020-1-1", 2021, "ultra-polka.wav"));
        actual.add(new RawMediaRecord("featured-2","SONG","Canon in D","Kevin MacLeod", "Classical",339,"2020-1-1", 2021, "canon-in-d.wav"));
        actual.add(new RawMediaRecord("featured-3","SONG","Blue Ska","Kevin MacLeod", "Ska",145,"2020-1-1", 2021, "blue-ska.wav"));
        actual.add(new RawMediaRecord("featured-4","SONG","Retro Future","Kevin MacLeod", "Future",205,"2020-1-1", 2021, "retro-future.wav"));
        actual.add(new RawMediaRecord("featured-5","SONG","SCP X6X","Kevin MacLeod", "Sound Effect",209,"2020-1-1", 2021, "scp-x6x.wav"));
        return actual;
    }
    private static RawMediaRecord generateSong(int index) {
        String title = pick(SONG_TITLES);
        String artist = pick(ARTISTS);
        String genre = pick(GENRES);
        int duration = 150 + random.nextInt(120); // 2:30 - 4:30
        return new RawMediaRecord("song-" + index, "SONG", title, artist,
                genre, duration, randomDate(), randomYear());
    }

    private static RawMediaRecord generatePodcast(int index) {
        String title = pick(PODCAST_TITLES);
        String host = pick(HOSTS);
        String genre = pick(GENRES);
        int duration = 1200 + random.nextInt(2400); // 20 - 60 min
        return new RawMediaRecord("podcast-" + index, "PODCAST", title, host,
                genre, duration, randomDate(), randomYear());
    }

    private static RawMediaRecord generateAudiobook(int index) {
        String title = pick(AUDIOBOOK_TITLES);
        String narrator = pick(NARRATORS);
        String genre = pick(GENRES);
        int duration = 10800 + random.nextInt(21600); // 3 - 9 hours
        return new RawMediaRecord("audiobook-" + index, "AUDIOBOOK", title, narrator,
                genre, duration, randomDate(), randomYear());
    }

    private static String pick(String[] options) {
        return options[random.nextInt(options.length)];
    }

    private static int randomYear() {
        return 1990 + random.nextInt(36); // 1990 - 2025
    }

    private static String randomDate() {
        int year = 2000 + random.nextInt(25);       // 2011 - 2025
        int month = 1 + random.nextInt(12);
        int day = 1 + random.nextInt(28);
        return String.format("%04d-%02d-%02d", year, month, day);
    }
}
