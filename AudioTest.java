import javax.sound.sampled.*;
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

/**
 * AudioTest -- standalone sound-check script
 *
 * HOW TO USE:
 * When you've added a file and you want to make sure it plays without going through the application.
 * Type in the lowercase name of the file you wish to test. 
 * Best practice will be to make sure you always save your files in lowercase but this program turns it to lowercase anyway
 * 
 * If it exists, it will attempt to play.
 * 
 * If it can't play, the program will tell you. 
 */
public class AudioTest {

    public static void main(String[] args) throws InterruptedException {
        System.out.print("\u000C"); //clears screen in BlueJ, may be different on your end
        File soundsFolder = new File("sounds");

        if (!soundsFolder.exists() || !soundsFolder.isDirectory()) {
            System.out.println("No 'sounds' folder found next to this project. Nothing to test.");
            return;
        }

        File[] wavFiles = soundsFolder.listFiles((dir, name) -> name.toLowerCase().endsWith(".wav"));

        if (wavFiles == null || wavFiles.length == 0) {
            System.out.println("No .wav files found in the sounds folder yet.");
            return;
        }
        
        Arrays.sort(wavFiles);
        System.out.println("Found " + wavFiles.length + " .wav file(s).\n");

        Scanner input = new Scanner(System.in);
        System.out.println("What file would you like to play? Don't include the .wav. I'll add that shortly.");
        String fileAttempt = input.nextLine().trim();
        fileAttempt += ".wav";
        boolean fileFound = false;
        for(File file : wavFiles){
            if(fileAttempt.equals(file.getName())){
                testOneFile(file);
                fileFound = true;
            }
        }
        if(fileFound){
            System.out.println("File Found! And Played");
        } else {
            System.out.println("File never found! Check spelling and rerun test");
        }
        }

    private static boolean testOneFile(File file) throws InterruptedException {
        System.out.print(file.getName() + " ... ");
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            AudioFormat format = audioStream.getFormat();
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            long durationMillis = clip.getMicrosecondLength() / 1000;
            clip.start();

            System.out.println("playing (" + String.format("%.1f", durationMillis / 1000.0) + "s, "
                    + (int) format.getSampleRate() + "Hz, " + format.getChannels() + " channel(s))");

            // Wait for the clip to actually finish (plus a small buffer) before moving on,
            // otherwise this file and the next one would play on top of each other.
            Thread.sleep(durationMillis + 300);
            clip.close();
            return true;

        } catch (UnsupportedAudioFileException e) {
            System.out.println("FAILED -- not a format Java can read.");
            System.out.println("   Fix: open it in Audacity and re-export as");
            System.out.println("   File > Export > Export as WAV, format = 'WAV (Microsoft) signed 16-bit PCM'.");
            return false;
        } catch (Exception e) {
            System.out.println("FAILED -- " + e.getMessage());
            return false;
        }
    }
}