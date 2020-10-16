package task;

public class Event extends Task {
    private String taskName;
    private String date;

    public Event(String taskName, String date) {
        this.taskName = taskName;
        this.date = date;
    }
}
