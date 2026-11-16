import java.time.LocalDate;
import java.util.List;

void main() {
    Planner planner = new Planner();

    check("a new planner has no assignments", planner.getAssignments().isEmpty());

    Assignment math = new Assignment("Math HW", LocalDate.of(2026, 11, 10));
    Assignment essay = new Assignment("English Essay", LocalDate.of(2026, 11, 20));
    planner.add(math);
    planner.add(essay);

    List<Assignment> all = planner.getAssignments();
    check("add puts assignments in the planner", all.size() == 2);
    check("first assignment is the one we added first", all.get(0).getName().equals("Math HW"));
    check("second assignment is the one we added second", all.get(1).getName().equals("English Essay"));
}

void check(String label, boolean passed) {
    IO.println((passed ? "PASS" : "FAIL") + ": " + label);
}
