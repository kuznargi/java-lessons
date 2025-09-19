package SecondAssigment;

public class ChairFactory implements FurnitureFactoryAbstract {
    @Override
    public Furniture createFurniture() {
        return new Chair();
    }
}
