import java.util.ArrayList;
import java.util.List;
import java.lang.IllegalArgumentException;

public class MediaLibrary {
    private List<Playable> items = new ArrayList<>();

    public MediaLibrary(){
        this.items = new ArrayList<>();
    }
    public void add(Playable item){
        if (item == null){
            throw new IllegalArgumentException("Don't give me nulls!");
        }
        this.items.add(item);
    }
    public void remove(Playable item){
        if(items.contains(item)){
            items.remove(item);
        } else {
            System.out.println("Item not found. Nothing removed. Try again");
        }
    }
    public List<Playable> getAll(){
        return new ArrayList<>(items);
    }
    public void linearSearch(String searchTitle){
        if(this.getAll().isEmpty()){
            System.out.println("Library empty. Please add sick beats!");
            return;
        }
        for(Playable p : this.getAll()){
            if(p.getTitle().equalsIgnoreCase(searchTitle)){
                System.out.println("Found Title!");
                System.out.println("More info about your song");
                System.out.println("Title: "+p.getTitle());
                System.out.println("Artist: "+p.getCreator().getName());
                System.out.println("Year Released: "+p.getReleaseYear());
                //p.play();
                return;
            }
        }
        System.out.println("Song never found. :( ");
    }
}