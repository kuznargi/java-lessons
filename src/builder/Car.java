package builder;

import java.util.Objects;


public final class Car {
    private final String model;
    private final String engineType;
    private final String color;
    private final int doors;
    private final Transmission transmission;


    private Car(String model, String engineType, String color, int doors, Transmission transmission) {
        this.model = Objects.requireNonNull(model, "Model must not be null");
        this.engineType = Objects.requireNonNull(engineType, "Engine type must not be null");
        this.color = color != null ? color : "Default";  // Default for optional field
        this.doors = doors > 0 ? doors : 4;             // Default for optional field
        this.transmission = transmission != null ? transmission : Transmission.MANUAL; // Default
    }


    public String getModel() { return model; }
    public String getEngineType() { return engineType; }
    public String getColor() { return color; }
    public int getDoors() { return doors; }
    public Transmission getTransmission() { return transmission; }

    @Override
    public String toString() {
        return String.format("Car{model='%s', engineType='%s', color='%s', doors=%d, transmission=%s}",
                model, engineType, color, doors, transmission);
    }

    public static class Builder {
        private final String model;
        private String engineType;
        private String color;
        private Integer doors;
        private Transmission transmission;

        public Builder(String model) {
            this.model = Objects.requireNonNull(model, "Model must be provided to start building");
        }

        public Builder withEngineType(String engineType) {
            this.engineType = Objects.requireNonNull(engineType, "Engine type must not be null");
            return this;
        }

        public Builder withColor(String color) {
            this.color = color;
            return this;
        }

        public Builder withDoors(int doors) {
            if (doors < 2) {
                throw new IllegalArgumentException("Doors must be at least 2");
            }
            this.doors = doors;
            return this;
        }

        public Builder withTransmission(Transmission transmission) {
            this.transmission = transmission;
            return this;
        }


        public Car build() {
            if (engineType == null) {
                throw new IllegalStateException("Engine type is required");
            }
            return new Car(model, engineType, color, doors != null ? doors : 4, transmission);
        }
    }

    public enum Transmission {
        MANUAL, AUTOMATIC
    }

    public static void main(String[] args) {
        Car myCar = new Builder("Sedan")
                .withEngineType("V6")
                .withColor("Red")
                .withDoors(4)
                .withTransmission(Transmission.AUTOMATIC)
                .build();
        System.out.println(myCar);
        try {
            new Builder("Sedan").build();
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage()); // Output: Error: Engine type is required
        }
    }
}