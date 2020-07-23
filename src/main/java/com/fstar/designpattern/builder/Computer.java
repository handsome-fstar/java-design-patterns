package com.fstar.designpattern.builder;

public class Computer {
    private String CPU;
    private String cooler;
    private String memory;
    private String motherboard;
    private String graphicsCard;

    public Computer() {
        this(new Builder());
    }

    Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.cooler = builder.cooler;
        this.memory = builder.memory;
        this.motherboard = builder.motherboard;
        this.graphicsCard = builder.graphicsCard;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "CPU='" + CPU + '\'' +
                ", cooler='" + cooler + '\'' +
                ", memory='" + memory + '\'' +
                ", motherboard='" + motherboard + '\'' +
                ", graphicsCard='" + graphicsCard + '\'' +
                '}';
    }

    public static final class Builder {
        private String CPU;
        private String cooler;
        private String memory;
        private String motherboard;
        private String graphicsCard;

        public Builder() {
            CPU = "i5";
            cooler = "original fan";
            memory = "16G";
            motherboard = "B460";
            graphicsCard = "RTX2060";
        }

        public Builder CPU(String CPU) {
            this.CPU = CPU;
            return this;
        }

        public Builder cooler(String cooler) {
            this.cooler = cooler;
            return this;
        }

        public Builder memory(String memory) {
            this.memory = memory;
            return this;
        }

        public Builder motherboard(String motherboard) {
            this.motherboard = motherboard;
            return this;
        }

        public Builder graphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}
