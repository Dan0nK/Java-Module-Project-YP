import com.sun.tools.javac.util.Convert;

import java.util.Scanner;

// dev branch for Y.Practicum
public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static String declension(double priceD)
    {
        int priceI = (int)Math.floor(priceD);

        String rubl = " рубль";
        String rublya = " рубля";
        String rubley = " рублей";

        if(priceI > 100) {
            priceI %= 100;
        }

        if(priceI > 20) {
            priceI %= 10;
        }

        switch(priceI)
        {
            case 1:
                return rubl;
            case 2:
            case 3:
            case 4:
                return rublya;
            default:
                return rubley;
        }
    }

    public static class Calculator {
        String allNames = "";
        double allPrices = 0;


        void add(String name, double price) {
            allNames = allNames + "\n" + name + " " + String.format("%.2f", price) + declension(price);
            allPrices = allPrices + price;
            System.out.println("Товар успешно добавлен!");
        }

        void out(){
            System.out.println("Добавленные товары:" + allNames);
            System.out.println("Общая стоимость: " + allPrices + declension(allPrices));
        }

        void calculate(int people){
            double one = allPrices/people;
            System.out.println("Каждый должен заплатить: " + String.format("%.2f", one) + declension(one));
        }
    }

    public static void main(String[] args) {
        int countPeople;

        while(true)
        {
            System.out.println("На скольких человек разделить счёт?");
            countPeople = scanner.nextInt();

            if (countPeople > 1)
            {
                System.out.println("Вы указали: " + countPeople);
                break;
            }
            else
            {
                System.out.println("Ошибка. Попробуйте ещё раз. Введите число > 1");
            }
        }

        Calculator calculator = new Calculator();

        while (true){
            System.out.println("Укажите название товара");
            String name = scanner.next();
            System.out.println("Укажите цену товара");
            double price = scanner.nextDouble();

            calculator.add(name, price); //добавление к списку и стоимости

            System.out.println("Хотите добавить ещё один товар? (Для добавления нового товара - введите любой символ. Для того чтобы закончить - введите \"Завершить\".)");
            if (scanner.next().equalsIgnoreCase("завершить")) {
                calculator.out(); //вывод списка и общей стоимости
                break;
            }
        }
        calculator.calculate(countPeople); //расчёт на одного человека
    }
}
