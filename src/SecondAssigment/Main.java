package SecondAssigment;



public class Main {
    public static void main(String[] args) {

        FurnitureFactoryAbstract chairFactory = new ChairFactory();
        FurnitureStore store = new FurnitureStore(chairFactory);
        store.createFurniture();
    }
}