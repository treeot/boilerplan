import java.time.LocalDate;

void main() {
    Assignment a = new Assignment("Math HW", LocalDate.of(2026, 11, 10));

    check("name is set", a.getName().equals("Math HW"));
    check("due date is set", a.getDueDate().equals(LocalDate.of(2026, 11, 10)));
    check("new assignment is not done", a.isDone() == false);

    a.markDone();
    check("markDone sets done to true", a.isDone() == true);

    IO.println(a);
}

void check(String label, boolean passed) {
    IO.println((passed ? "PASS" : "FAIL") + ": " + label);
}
