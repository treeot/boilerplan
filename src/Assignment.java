import java.time.LocalDate;

public class Assignment {
    private String name;
    private LocalDate dueDate;
    private boolean done;

    public Assignment(String name, LocalDate dueDate) {
        this.name = name;
        this.dueDate = dueDate;
        this.done = false;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public boolean isDone() {
        return done;
    }

    public void markDone() {
        this.done = true;
    }

    public String toString() {
        String status = done ? "done" : "not done";
        return name + " (due " + dueDate + ") - " + status;
    }
}
