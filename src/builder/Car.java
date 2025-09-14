package builder;

import java.util.Objects;

public final class Car{
    private final String model;
    private final String engineType;
    private final String color;
    private final int doors;
    private final Transmission  transmission;

    private Car(String model, String engineType, String color, int doors, Transmission transmission) {
        this.model = model;
        this.engineType = engineType;
        this.color = color;
        this.doors = doors;
        this.transmission = transmission;

    }

    public String getModel() {return model;}
    public String getEngineType() {return engineType;}
    public String getColor() {return color;}
    public int getDoors() {return doors;}
    public Transmission getTransmission() {return transmission;}

    @Override
  public String toString() {
        return String.format("Car{model='%s', engineType='%s', color='%s', doors=%d}", model, engineType, color, doors);
    }


public static class Builder {
    private String model;
    private String engineType;
    private String color;
    private int doors;
    private Transmission transmission;
    public Builder model(String model){
        this.model = model;
        return this;
    }
    public Builder(String model) {
        this.model = Objects.requireNonNull(model, "Model must be provided to start building");
    }
    public Builder engineType(String engineType){
        this.engineType = engineType;
        return this;
    }
    public Builder color(String color){
        this.color = color;
        return this;

    }
    public Builder doors(int doors){
        this.doors = doors;
        return this;
    }
    public Builder transmission(Transmission transmission){
        this.transmission=transmission;
        return this;
    }
    public Car build(){
        if(engineType == null){
            throw new IllegalArgumentException("Engine type cannot be null");
        }
        return new  Car(model, engineType, color, doors, transmission);
    }
}

public enum Transmission{
    MANUAL,AUTOMATIC
}
public static void main(String[] args) {
    Car myCar= new Builder("Sedan")
            .color("Red")
            .doors(4)
            .model("V3")
            .engineType("V2")
            .transmission(Transmission.AUTOMATIC).build();
    System.out.println(myCar);

}}