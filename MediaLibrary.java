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
}