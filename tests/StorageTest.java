import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

void main() throws Exception {
    Path file = Files.createTempFile("boilerplan", ".csv");

    Planner planner = new Planner();
    planner.add(new Assignment("Math HW", LocalDate.of(2026, 11, 10)));
    Assignment essay = new Assignment("English Essay", LocalDate.of(2026, 11, 20));
    essay.markDone();
    planner.add(essay);

    Storage.save(planner.getAssignments(), file.toString());
    List<Assignment> loaded = Storage.load(file.toString());

    check("loads the same number of assignments", loaded.size() == 2);
    check("keeps the name", loaded.get(0).getName().equals("Math HW"));
    check("keeps the due date", loaded.get(0).getDueDate().equals(LocalDate.of(2026, 11, 10)));
    check("keeps not-done status", loaded.get(0).isDone() == false);
    check("keeps done status", loaded.get(1).isDone() == true);

    Files.deleteIfExists(file);
}

void check(String label, boolean passed) {
    IO.println((passed ? "PASS" : "FAIL") + ": " + label);
}
