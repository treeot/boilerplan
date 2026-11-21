import java.time.LocalDate;

void main() throws Exception {
    IO.println("Welcome to BoilerPlan, an assignment tracker.");

    Planner planner = new Planner();
    planner.add(new Assignment("Math HW", LocalDate.of(2026, 11, 10)));
    planner.add(new Assignment("English Essay", LocalDate.of(2026, 11, 20)));
    planner.add(new Assignment("Chem Lab", LocalDate.of(2026, 11, 3)));

    IO.println("");
    IO.println("Your assignments, soonest first:");
    for (Assignment a : planner.getSortedByDueDate()) {
        IO.println("- " + a);
    }

    planner.markDone(0);

    IO.println("");
    IO.println("After finishing Math HW:");
    for (Assignment a : planner.getSortedByDueDate()) {
        IO.println("- " + a);
    }

    Storage.save(planner.getAssignments(), "assignments.csv");
    Planner reopened = new Planner();
    for (Assignment a : Storage.load("assignments.csv")) {
        reopened.add(a);
    }

    IO.println("");
    IO.println("Loaded back from assignments.csv:");
    for (Assignment a : reopened.getSortedByDueDate()) {
        IO.println("- " + a);
    }
}
