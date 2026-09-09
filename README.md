VelociTrack Starter Code
==========================================

This is the starter package for the CSC 223 VelociTrack project series

WHAT'S HERE
-----------
- Playable.java             The interface every media type implements.
- MediaItem.java             The abstract base class Song/Podcast/Audiobook will extend.
                              Now includes a playSound() helper for real audio playback.
- RawMediaRecord.java        A plain data holder used only by the sample data generator.
- SampleDataGenerator.java   Generates realistic fake catalog data for testing.
- Main.java                  The console menu that ties everything together.
- AudioTest.java	     Test individual files to see if Java will play them
- sounds/                    Folder for .wav clips. See sounds/README.txt.

You should NOT need to modify Playable.java, MediaItem.java, RawMediaRecord.java,
or SampleDataGenerator.java. Just extend/use them. However, if you want to you always
can. 

NOTE: Playable.java includes a getCreator() method that MediaItem does NOT
implement for you -- each media type (Song, Podcast, Audiobook) calls this
something different (artist, host, narrator), so you'll add your own field
for it and implement getCreator() yourself in each subclass.

You WILL need to edit Main.java throughout the semester -- look for the "TODO"
comments inside each menu option. Each one tells you which project it belongs
to and what to wire in once you've built that piece.

HOW TO OPEN THIS IN BLUEJ
---------------------------
This folder is a plain folder of Java files, not a pre-packaged BlueJ
project (that file -- package.bluej -- gets created automatically the
first time you save, so there's nothing to break by skipping it).

1. Unzip this package somewhere on disk. Keep the "sounds" folder in the
   same place as the .java files -- don't separate them.
2. Open BlueJ.
3. Go to Project -> Open Non BlueJ...
4. Select the folder containing these .java files (the one with Main.java
   directly inside it, not a parent folder).
5. Click "Open in BlueJ". BlueJ will ask to convert it into a BlueJ
   project -- say yes. This creates the package.bluej file for you.
6. From then on, you can open this project normally with Project -> Open...

RUNNING IT
----------
1. In the BlueJ project window, right-click the Main class and choose
   "void main(String[] args)".
2. Leave the args parameter blank (or type nothing) and click OK.
3. The terminal window will open with the VelociTrack menu.
4. Choose option 1 to generate sample data and confirm everything compiles
   and runs.
5. Everything else will say "Coming in [Project X]" until you build it --
   that's expected on day one!

ABOUT AUDIO PLAYBACK
----------------------
MediaItem now includes a playSound(String fileName) helper. Call it from
inside your own play() method once you've built your Song/Podcast/Audiobook
classes in Project 1:

  public void play() {
      incrementPlayCount();
      System.out.println(getTitle() + " -- now playing");
      playSound("song.wav");
  }

You do NOT need to build a file path yourself -- just pass the file name,
and playSound() looks for it inside the "sounds" folder automatically.
BlueJ runs your program with the project folder as the working directory,
so this works without any extra setup, as long as the sounds folder stays
in the project alongside the .java files.

If a sound file isn't there yet, playSound() prints a friendly message
instead of crashing -- so this is safe to call even before the sounds
folder has been filled in.

A NOTE ON SAMPLE DATA
----------------------
SampleDataGenerator does NOT create Song, Podcast, or Audiobook objects --
those are yours to build in Project 1. It generates plain RawMediaRecord
objects instead. Once your MediaItem subclasses exist, loop over the
generated list and use each record's fields to construct your own objects.
