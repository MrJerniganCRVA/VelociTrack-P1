public class Song extends MediaItem implements Playable{
    private Artist artist; 
    private String album;

    public Song(String id, String title, int durationSeconds,
                      String genre, String dateAdded, int releaseYear, 
                      Artist artist, String album){
        super(id, title, durationSeconds, genre, dateAdded, releaseYear);
        this.artist = artist;
        this.album = album;
    }

    @Override
    public String getCreator(){
        return this.artist.getName();
    }
    @Override
    public void play(){
        incrementPlayCount();
        //Option 1 - Boring
        System.out.println("Now playing " + this.getTitle());
    }
}