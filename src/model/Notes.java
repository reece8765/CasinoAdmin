package model;

public class Notes {

    private String id;
    private String user;
    private String title;
    private String message;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUser(String input) {
        this.user = input;
    }

    public String getUser() {
        return this.user;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String input) {
        this.title = input;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String input) {
        this.message = input;
    }
}
