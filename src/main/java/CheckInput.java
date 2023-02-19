import java.util.Scanner;

public class CheckInput {
    Scanner scanner = new Scanner(System.in);

    int CheckCountPeople() {
        while (true) {
            System.out.println("На скольких человек разделить счёт?");
            String s = scanner.nextLine();
            try {
                int countPeople = Integer.parseInt(s);
                if (countPeople > 1) {
                    return countPeople;
                } else {
                    System.out.println("Ошибка. Попробуйте ещё раз. Введите число > 1");
                }

            } catch (Exception e) {
                System.out.println("Ошибка. Попробуйте ещё раз. Введите число > 1");
            }
        }
    }

    String CheckNameGood() {
        while (true) {
            System.out.println("Укажите название товара");
            String name = scanner.nextLine();
            if (name.length()> 2) {
                return name;
            } else {
                System.out.println("Ошибка. Попробуйте ещё раз. Название должно содержать минимум 3 символ.");
            }
        }
    }

    double CheckPriceGood() {
        while (true) {
            System.out.println("Укажите цену товара");
            String s = scanner.nextLine();
            try {
                double price = Double.parseDouble(s);
                if (price > 0.01) {
                    return price;
                } else {
                    System.out.println("Ошибка. Попробуйте ещё раз. Введите число > 0.01");
                }

            } catch (Exception e) {
                System.out.println("Ошибка. Попробуйте ещё раз. Введите число > 0.01");
            }
        }
    }
}
