package models;

public class Document extends Letter{
    private String levelImportant;


    public Document(String receiver, String sender, String size, String levelImportant) {
        super(receiver, sender, size);
        this.levelImportant = levelImportant;
    }

    public String getLevelImportant() {
        return levelImportant;
    }

    public void setLevelImportant(String levelImportant) {
        this.levelImportant = levelImportant;
    }

    @Override
    public String toString() {
        return super.toString() + " " + getLevelImportant();
    }
}