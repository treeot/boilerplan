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

    Planner sortTest = new Planner();
    sortTest.add(new Assignment("Late Lab", LocalDate.of(2026, 12, 1)));
    sortTest.add(new Assignment("Early Quiz", LocalDate.of(2026, 11, 5)));
    sortTest.add(new Assignment("Mid Paper", LocalDate.of(2026, 11, 18)));

    List<Assignment> sorted = sortTest.getSortedByDueDate();
    check("earliest due date comes first", sorted.get(0).getName().equals("Early Quiz"));
    check("middle due date comes second", sorted.get(1).getName().equals("Mid Paper"));
    check("latest due date comes last", sorted.get(2).getName().equals("Late Lab"));
    check("sorting does not change the original order", sortTest.getAssignments().get(0).getName().equals("Late Lab"));

    Planner doneTest = new Planner();
    doneTest.add(new Assignment("Reading", LocalDate.of(2026, 11, 8)));
    doneTest.add(new Assignment("Problem Set", LocalDate.of(2026, 11, 12)));

    doneTest.markDone(1);
    check("marking done flips the right assignment", doneTest.getAssignments().get(1).isDone());
    check("marking done leaves the others alone", doneTest.getAssignments().get(0).isDone() == false);
}

void check(String label, boolean passed) {
    IO.println((passed ? "PASS" : "FAIL") + ": " + label);
}
