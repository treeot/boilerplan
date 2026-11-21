import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Planner {
    private List<Assignment> assignments = new ArrayList<>();

    public void add(Assignment assignment) {
        assignments.add(assignment);
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void markDone(int index) {
        assignments.get(index).markDone();
    }

    public List<Assignment> getSortedByDueDate() {
        List<Assignment> sorted = new ArrayList<>(assignments);
        sorted.sort(Comparator.comparing(Assignment::getDueDate));
        return sorted;
    }
}
