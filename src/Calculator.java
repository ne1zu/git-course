import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Создаем объект менеджера истории
        HistoryManager history = new HistoryManager();

        System.out.println("=== Продвинутый калькулятор с историей ===");

        while (true) {
            System.out.print("\nВведите первое число (или 'exit' для выхода, 'history' для просмотра): ");
            String input = scanner.next();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("До свидания!");
                break;
            }

            if (input.equalsIgnoreCase("history")) {
                history.printHistory();
                continue;
            }

            double num1;
            try {
                num1 = Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Введите число, 'exit' или 'history'!");
                continue;
            }

            System.out.print("Введите операцию (+, -, *, /): ");
            char operation = scanner.next().charAt(0);

            System.out.print("Введите второе число: ");
            double num2 = scanner.nextDouble();

            double result;

            switch (operation) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        System.out.println("Ошибка: деление на ноль!");
                        continue;
                    }
                    break;
                default:
                    System.out.println("Неверная операция!");
                    continue;
            }

            System.out.println("Результат: " + result);

            // Записываем успешное вычисление в историю
            history.addRecord(num1, operation, num2, result);
        }
    }
}
