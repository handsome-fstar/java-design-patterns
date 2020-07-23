# 建造者模式（Builder）
当创建对象的复杂性增加时，构建器模式可以使用另一个对象(一个构建器)来构造对象，从而用简化对象的创建。
## Example
组装一台电脑需要CPU、主板、内存、显卡、等等。  
**Computer**  
```java
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
```
**Main**
```java
public class Main {
    public static void main(String[] args) {
        // 直接new Computer对象，提供默认配置
        Computer computer = new Computer();
        System.out.println(computer);

        // 自定义配置
        Computer.Builder builder = new Computer.Builder();
        Computer computer1 = builder
                .CPU("3900X")
                .cooler("original cooler")
                .memory("16G")
                .graphicsCard("5700XT")
                .motherboard("X570")
                .build();
        System.out.println(computer1);

        Computer computer2 = new Computer.Builder()
                .CPU("i9")
                .cooler("water cooler")
                .memory("64G")
                .graphicsCard("2080TI")
                .motherboard("ROG")
                .build();
        System.out.println(computer2);
    }
}
```