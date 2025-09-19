package SecondAssigment;



public class SofaFactory implements FurnitureFactoryAbstract {
    @Override
    public Furniture createFurniture() {
        return new Sofa();
    }
}
