package baitap1;

public class Course {
    private String id;
    private String title;
    private int maxStudents;

    public Course(String id, String title, int maxStudents) {
        this.id = id;
        this.title = title;
        this.maxStudents = maxStudents;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getMaxStudents() {
        return maxStudents;
    }

    public void setMaxStudents(int maxStudents) {
        this.maxStudents = maxStudents;
    }
}
