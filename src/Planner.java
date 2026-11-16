import java.util.ArrayList;
import java.util.List;

public class Planner {
    private List<Assignment> assignments = new ArrayList<>();

    public void add(Assignment assignment) {
        assignments.add(assignment);
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }
}
