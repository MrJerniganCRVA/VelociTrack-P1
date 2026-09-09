public class Artist{
    private final String name;
    private String aboutMe; 
    public Artist(String name, String aboutMe){
        this.name = name;
        this.aboutMe = aboutMe;
    }
    public void setAboutMe(String newAboutMe){
        this.aboutMe = newAboutMe;
    }
    public String getName(){
        return this.name;
    }
    public String getAboutMe(){
        return this.aboutMe;
    }
}