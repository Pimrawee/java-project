package models;

public class Document extends Letter{
    private String receiver;
    private String sender;
    private int size;
    private String levelImportant;


    public Document(String receiver, String sender, int size, String levelImportant) {
        super(receiver, sender, size);
        this.levelImportant = levelImportant;
    }

    public String getLevelImportant() {
        return levelImportant;
    }

    public void setLevelImportant(String levelImportant) {
        this.levelImportant = levelImportant;
    }
}
