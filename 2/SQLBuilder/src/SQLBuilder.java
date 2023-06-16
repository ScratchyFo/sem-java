import java.util.Scanner;

public class SQLBuilder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder queryBuilder = new StringBuilder("SELECT * FROM table WHERE ");

        String parName = "";
        String parValue = "";

// Сканер консли
        for (;;) {
            System.out.print("Введите название параметра (или пустую стрку, чтобы закончить):\n");
            parName = scanner.nextLine().trim();

            if (parName.isEmpty()) {
                break;
            }

            System.out.print("Введите значение параметра:\n");
            parValue = scanner.nextLine().trim();

            if (!parValue.isEmpty()) {
                if (queryBuilder.length() > "SELECT * FROM table WHERE ".length()) {
                    queryBuilder.append(" AND ");
                }
                queryBuilder.append(parName).append(" = '").append(parValue).append("'");
            }
        }
// Вывод запрса
        System.out.println("Сформированный SQL-запрос: " + queryBuilder.toString());

        scanner.close();
    }
}