import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Storage {

    public static void save(List<Assignment> assignments, String path) throws IOException {
        List<String> lines = new ArrayList<>();
        for (Assignment a : assignments) {
            lines.add(a.getName() + "," + a.getDueDate() + "," + a.isDone());
        }
        Files.write(Path.of(path), lines);
    }

    public static List<Assignment> load(String path) throws IOException {
        List<Assignment> assignments = new ArrayList<>();
        for (String line : Files.readAllLines(Path.of(path))) {
            if (line.isBlank()) {
                continue;
            }
            String[] parts = line.split(",");
            Assignment a = new Assignment(parts[0], LocalDate.parse(parts[1]));
            if (parts[2].equals("true")) {
                a.markDone();
            }
            assignments.add(a);
        }
        return assignments;
    }
}
