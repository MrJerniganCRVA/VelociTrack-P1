import java.util.List;
import java.util.Scanner;

/**
 * VelociTrack -- Console Driver
 *
 * This menu covers the WHOLE semester, not just the project you're
 * currently on. Options for projects you haven't built yet will print a
 * "coming soon" message -- that's expected! As you complete each project,
 * come back to this file and replace the matching TODO with a real call
 * into your own code.
 *
 * You WILL edit this file throughout the semester. That's the point.
 */
public class Main {
    //This is the main way we are "testing" the program by making a bunch of semi-random songs, audiobooks, and podcasts
    //If you want to add in your own sounds, you can make a private static Song with proper information
    private static List<RawMediaRecord> sampleData = null;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean running = true;

        while (running) {
            printMenu();
            System.out.print("Enter choice: ");
            //Decided to use a string instead of a number.
            //Doesn't need a try/catch to validate input is an int
            String choice = input.nextLine().trim(); //remove white space
            //When adding features, you can remove the comingSoon function call
            switch (choice) {
                case "1":
                    loadSampleData(input);
                    break;
                case "2":
                    // TODO (Project 1): print every item in your MediaLibrary
                    comingSoon("Project 1", "build your MediaLibrary class, then list its contents here.");
                    break;
                case "3":
                    // TODO (Project 1): call your MediaLibrary's linearSearch(String title)
                    comingSoon("Project 1", "call your linearSearch(String title) method here.");
                    break;
                case "4":
                    // TODO (Project 2): print the contents of a Playlist
                    comingSoon("Project 2", "build your Playlist class, then display it here.");
                    break;
                case "5":
                    // TODO (Project 2): show Recently Played (stack) and Up Next (queue)
                    comingSoon("Project 2", "wire up your Recently Played stack and Up Next queue here.");
                    break;
                case "6":
                    // TODO (Project 3): call your HashMap-based fast search
                    comingSoon("Project 3", "call your hashSearch(String title) method here.");
                    break;
                case "7":
                    // TODO (Project 3): show Liked Songs (Set) and genre tags (Map)
                    comingSoon("Project 3", "wire up your Liked Songs and genre tagging here.");
                    break;
                case "8":
                    // TODO (Project 4): sort the library by a chosen key
                    comingSoon("Project 4", "call your hand-written sort method here.");
                    break;
                case "9":
                    // TODO (Project 4): browse the BST in order
                    comingSoon("Project 4", "build your BST, then call its in-order traversal here.");
                    break;
                case "10":
                    // TODO (Project 5): show the heap-based Top 10 Trending list
                    comingSoon("Project 5", "call your getTrendingTop10() method here.");
                    break;
                case "11":
                    // TODO (Project 5): show BFS/DFS-based recommendations
                    comingSoon("Project 5", "call your getRecommendations(Playable item) method here.");
                    break;
                case "12":
                    loadRealSongs(input);
                    break;
                case "0":
                    running = false;
                    System.out.println("Thanks for using VelociTrack!");
                    break;
                default:
                    System.out.println("Not a valid option -- try again.\n");
            }
        }
        input.close();
    }

    private static void printMenu() {
        System.out.println("\n===== VelociTrack =====");
        System.out.println(" 1. Load Sample Data");
        System.out.println(" 2. View All Media");
        System.out.println(" 3. Search by Title (Linear Search)");
        System.out.println(" 4. View Playlist");
        System.out.println(" 5. Recently Played / Up Next");
        System.out.println(" 6. Fast Search (Hash Lookup)");
        System.out.println(" 7. Liked Songs & Genre Tags");
        System.out.println(" 8. Sort Library");
        System.out.println(" 9. Browse by Genre / Decade (BST)");
        System.out.println("10. Trending Top 10");
        System.out.println("11. Recommendations");
        System.out.println("12. Load Real Songs");
        System.out.println(" 0. Exit");
    }

    private static void loadSampleData(Scanner input) {
        System.out.print("How many items would you like to generate? ");
        int count;
        try {
            count = Integer.parseInt(input.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Not a valid number -- generating 500 by default.");
            count = 500;
        }
        sampleData = SampleDataGenerator.generate(count);
        System.out.println("Generated " + sampleData.size() + " sample records.");
        System.out.println("Example: " + sampleData.get(0));
        System.out.println("Once your MediaItem subclasses exist, loop over this data");
        System.out.println("to build real Song/Podcast/Audiobook objects for your library.");
    }
    private static void loadRealSongs(Scanner input){
        sampleData = SampleDataGenerator.generate(1);
        sampleData.clear();
        sampleData = SampleDataGenerator.getActualSongs();
        System.out.println("Real Songs Loaded.");
        System.out.println("Example: " + sampleData.get(0));
        System.out.println("This will now let you check if your play() features are working.");
    }
    private static void comingSoon(String project, String hint) {
        System.out.println("\nComing in " + project + " " + hint);
    }
}
