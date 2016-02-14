public class FeedItems {
    private String title;
    private String description;

    public FeedItems(){
    }

    public String toString(){
        return "Title: " + getTitle() + "\nDescription: " + getDescription() +"\n";
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setDescription(String description){
        this.description = description;
    }
}
