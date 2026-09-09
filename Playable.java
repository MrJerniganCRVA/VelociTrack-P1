/**
 * VelociTrack -- Playable Interface
 *
 * Every media type in VelociTrack (Song, Podcast, Audiobook, and any future
 * type) must implement this interface. It defines the shared contract every
 * playable item follows.
 *
 * NOTE: Some of these methods won't actually matter until later projects --
 * getPlayCount() isn't used until Project 5 (Trending), getReleaseYear()
 * isn't used until Project 4 (Browsing). You still need to implement all of
 * them now. Most of these should simply return a field that MediaItem
 * already stores for you, since your subclasses extend MediaItem.
 *
 * getCreator() is the one exception -- MediaItem does NOT store this field
 * for you, because different media types call it something different
 * (a Song has an artist, a Podcast has a host, an Audiobook has a
 * narrator). You'll need to add your own field for this in each subclass
 * and implement getCreator() yourself in each one.
 */
public interface Playable {

    /** Plays this item. Each media type should implement this differently. */
    void play();

    /** @return the title of this item */
    String getTitle();

    /**
     * @return whoever is credited as making this item -- an artist, a
     *         podcast host, an audiobook narrator, etc. What this field is
     *         called and how it's stored is up to you; this method just
     *         needs to return it.
     */
    String getCreator();

    /** @return the duration of this item, in seconds */
    int getDuration();

    /** @return how many times this item has been played */
    int getPlayCount();

    /** @return the genre of this item (e.g. "Rock", "True Crime") */
    String getGenre();

    /** @return the date this item was added to the library, formatted YYYY-MM-DD */
    String getDateAdded();

    /** @return the year this item was originally released */
    int getReleaseYear();
}
