import java.time.LocalDate;

void main() {
    IO.println("Welcome to BoilerPlan, an assignment tracker.");

    Planner planner = new Planner();
    planner.add(new Assignment("Math HW", LocalDate.of(2026, 11, 10)));
    planner.add(new Assignment("English Essay", LocalDate.of(2026, 11, 20)));

    IO.println("");
    IO.println("Your assignments:");
    for (Assignment a : planner.getAssignments()) {
        IO.println("- " + a);
    }
}
