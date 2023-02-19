public class Calculator {
    String allNames = "";
    double allPrices = 0;

    String declension(double priceD) {
        int priceI = (int) Math.floor(priceD);

        String rubl = " рубль";
        String rublya = " рубля";
        String rubley = " рублей";

        if (priceI > 100) {
            priceI %= 100;
        }

        if (priceI > 20) {
            priceI %= 10;
        }

        switch (priceI) {
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

    void add(String name, double price) {
        allNames = allNames + "\n" + name + " " + String.format("%.2f", price) + declension(price);
        allPrices += price;
        System.out.println("Товар успешно добавлен!");
    }

    void out() {
        System.out.println("Добавленные товары:" + allNames);
        System.out.println("Общая стоимость: " + allPrices + declension(allPrices));
    }

    void calculate(int people) {
        double one = allPrices / people;
        System.out.println("Каждый должен заплатить: " + String.format("%.2f", one) + declension(one));
    }
}
