import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> storage;
    private float boxWeight;

    Box(){
        storage = new ArrayList<>();
        boxWeight = 0;
    }

    public void addFruit (T fruit){
        storage.add(fruit);
        boxWeight += fruit.getWeight();
    }

    public float getWeight(){
        return boxWeight;
    }

    public float getFruitsNumber(){
        return storage.size();
    }

    public boolean compare(Box<? extends Fruit> anotherBox){
        return Math.abs(this.boxWeight-anotherBox.boxWeight) < 0.001f;
    }

    public void pour(Box<T> fromBox){
        if(fromBox!=this) {
            this.storage.addAll(fromBox.storage);
            this.boxWeight += fromBox.getWeight();
            fromBox.boxWeight = 0;
            fromBox.storage.clear();
        } else System.out.println("Попытка пересыпать ящик сам в себя");
    }
}
