import java.util.ArrayList;
import java.util.List;

public class HistoryManager {
    private final List<String> logs = new ArrayList<>();

    // Метод для добавления записи в историю
    public void addRecord(double num1, char op, double num2, double result) {
        String record = String.format("%.2f %c %.2f = %.2f", num1, op, num2, result);
        logs.add(record);
    }

    // Метод для вывода всей истории
    public void printHistory() {
        System.out.println("\n=== История вычислений ===");
        if (logs.isEmpty()) {
            System.out.println("История пока пуста.");
        } else {
            for (String log : logs) {
                System.out.println(log);
            }
        }
        System.out.println("==========================");
    }
}
