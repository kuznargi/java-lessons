package SecondAssigment;

public class FurnitureFactory {
    public Furniture getFurniture(String furnitureType) {
        if(furnitureType == null) {
            return null;
        }
        if(furnitureType.equalsIgnoreCase("CHAIR")) {
            return new Chair();
        } else if(furnitureType.equalsIgnoreCase("SOFA")) {
            return new Sofa();
        }
        return null;
    }
}
