import com.sun.tools.javac.util.Convert;

import java.util.Scanner;

// dev branch for Y.Practicum
public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CheckInput checkInput = new CheckInput();
        Calculator calculator = new Calculator();
        int countPeople = checkInput.CheckCountPeople();

        while (true) {
            String name = checkInput.CheckNameGood();
            double price = checkInput.CheckPriceGood();

            calculator.add(name, price); //добавление к списку и стоимости

            System.out.println("Хотите добавить ещё один товар? (Для добавления нового товара - введите любой символ. Для того чтобы закончить - введите \"Завершить\".)");
            if (scanner.next().equalsIgnoreCase("завершить")) {
                calculator.out(); //вывод списка и общей стоимости
                break;
            }
            scanner.skip(".*\n");
        }
        calculator.calculate(countPeople); //расчёт на одного человека
    }
}
