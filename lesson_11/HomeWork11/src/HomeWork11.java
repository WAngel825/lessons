import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class HomeWork11 {
    static final int SIZE = 100000;
    public static void main(String[] args) {

        List <Integer> listForSort = new ArrayList<>(SIZE);
        List <Integer> listForCollections = new ArrayList<>(SIZE);
        int minIndex;
        int minValue;
        int tempValue;
        int listElement;

        // заполним лист
        for (int i = 0; i < SIZE; i++) {
            listElement = (int) (Math.random() * SIZE * 3);
            listForSort.add(listElement);
            listForCollections.add(listElement);
        }

        long startChoiceSort = new Date().getTime();

        // сортировка
        for (int i = 0; i < SIZE; i++) {
            minIndex = i;
            minValue = listForSort.get(i);

            for (int j = i + 1; j < SIZE; j++) {
                if (minValue > listForSort.get(j)) {
                    minValue = listForSort.get(j);
                    minIndex = j;
                }
            }
            tempValue = listForSort.get(i);
            listForSort.set(i, minValue);
            listForSort.set(minIndex, tempValue);
        }

        long endChoiceSort = new Date().getTime();

        System.out.println("delta Choice Sort " + (endChoiceSort - startChoiceSort) + " ms");

        long startSort = new Date().getTime();
        Collections.sort(listForCollections);
        long endSort = new Date().getTime();

        System.out.println("delta Collections Sort " + (endSort - startSort) + " ms");

    }
}
