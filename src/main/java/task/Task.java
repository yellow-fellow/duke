package task;

public class Task {
    private Boolean completion = false;
    private String taskName;
    private String date;

    public void completeTask() {
        this.completion = true;
    }

    public boolean getTaskStatus() {
        return this.completion;
    }

    public String getTaskName() {
        return this.taskName;
    }

    public void setTaskName(String input) {
        this.taskName = input;
    }

    public String returnDate() {
        return this.date;
    }

    public String getClassName() {
        String className = this.getClass().getSimpleName();
        return className;
    }
}
