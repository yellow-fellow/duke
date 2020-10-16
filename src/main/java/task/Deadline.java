package task;

public class Deadline extends Task {
    private String taskName;
    private String date;

    public Deadline(String taskName, String date) {
        this.taskName = taskName;
        this.date = date;
    }

}
