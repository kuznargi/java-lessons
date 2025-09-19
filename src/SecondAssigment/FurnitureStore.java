package SecondAssigment;


public class FurnitureStore {
    private FurnitureFactoryAbstract furnitureFactory;


    public FurnitureStore(FurnitureFactoryAbstract factory) {
        this.furnitureFactory = factory;
    }

    public void createFurniture() {
        Furniture furniture = furnitureFactory.createFurniture();
        furniture.create();
    }
}

