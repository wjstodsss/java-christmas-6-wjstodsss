package christmas;

import christmas.model.menu.Appetizer;

import static christmas.util.Calculator.calculateSum;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Appetizer[] appetizers = Appetizer.values();
        for (Appetizer appetizer : appetizers) {
            System.out.println(appetizer);
        }

        Appetizer appetizer = Appetizer.valueOf("MUSHROOM_SOUP");
        System.out.println(appetizer);

        int position = Appetizer.MUSHROOM_SOUP.ordinal();
        System.out.println(position);
String str = "키위쥬 스-1 6,바나나우유-1,초코케이크-2";

        int sum = calculateSum(str);
        System.out.println("총합: " + sum);
    }

}
