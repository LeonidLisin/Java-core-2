import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        String[] str = {"a", "b", "c"};
        Integer[] integer = {1, 2, 3, 4};
        Main obj = new Main();
        obj.swap(str, 0, 1);
        obj.swap(integer, 3, 2);

        for (String s: str)
            System.out.print(s + " ");
        System.out.println();
        for (Integer i: integer)
            System.out.print(i + " ");
        System.out.println();

        System.out.println(obj.mas2Array(str)); // ArrayList из массива
        System.out.println(obj.mas2Array(integer));

        // задача про фрукты

        Box<Apple> appleBox1 = new Box<>();
        Box<Apple> appleBox2 = new Box<>();
        Box<Orange> orangeBox1 = new Box<>();

        for (int i = 0; i < 3; i++)
            appleBox1.addFruit(new Apple());
        for (int i = 0; i < 2; i++) {
            orangeBox1.addFruit(new Orange());
            appleBox2.addFruit(new Apple());
        }
        //appleBox1.addFruit(new Orange()); //- при попытке добавить апельсин в ящик с яблоками ошибка компиляции

        System.out.println(appleBox1.compare(orangeBox1)); // ящик с яблоками сравнивается с ящиком апельсинов
        System.out.println(appleBox2.compare(orangeBox1));

        appleBox1.pour(appleBox2); // пересыпаем яблоки из 1 коробки во 2ю
        appleBox1.pour(appleBox1); // пересыпаем яблоки сами в себя

        System.out.println(appleBox1.getFruitsNumber());
        System.out.println(appleBox2.getFruitsNumber());

        appleBox2.pour(appleBox1); // пересыпаем яблоки обратно из 2й коробки в 1ю

        System.out.println(appleBox1.getFruitsNumber());
        System.out.println(appleBox2.getFruitsNumber());
    }

    private <T> void swap(T[] mas, int i1, int i2){
        try {
            T temp = mas[i1];
            mas[i1] = mas[i2];
            mas[i2] = temp;
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("Выход за границы массива");
        }
    }

    private <N> ArrayList<N> mas2Array(N[] mas){
        ArrayList<N> al = new ArrayList<>(mas.length);
        Collections.addAll(al, mas);
        return al;
    }
}
