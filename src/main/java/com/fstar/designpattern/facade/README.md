# 外观模式（Facade）
简单来说，外观模式就是把很多复杂的操作以及复杂的依赖隐藏起来，通过一个外观类把所有相互依赖而且关联复杂的接口整理为一个高层接口，同时保证各个类的调用顺序，只对外暴露简单的操作接口。
## Example
启动一辆汽车的发动机需要关联很多的操作，油泵抽油、检测气流、开启冷却器、催化转化器等等复杂的操作。

把启动和关闭所需要的流程全部封装到CarEngineFacade里，方便调用。

**开启引擎**
```java
public void startEngine(){
    fuelInjector.on();
    airFlowController.takeAir();
    fuelInjector.on();
    fuelInjector.inject();
    starter.start();
    coolingController.setTemperatureUpperLimit(DEFAULT_COOLING_TEMP);
    coolingController.run();
    catalyticConverter.on();
}
```

**关闭引擎**
```java
public void stopEngine(){
    fuelInjector.off();
    catalyticConverter.off();
    coolingController.cool(MAX_ALLOWED_TEMP);
    coolingController.stop();
    airFlowController.off();
}
```

现在我们启动一辆车的引擎和关闭一辆车的引擎，只需要两行代码了
```java
carEngineFacade.startEngine();
// ...
carEngineFacade.stopEngine();
```

控制台的输出
```java
喷油器准备喷油！
空气流量计开始测量...
气流控制器开始提供气流！
喷油器准备喷油！
抽油泵正在抽油...
开始喷油！
引擎启动！
设置温度的上限为：90
冷却控制器准备好了！
设置散热速度到：10
催化转化器开启，有害排放降低了！
--------------------
停止喷油！
催化转化器已关闭！
预设冷却最高允许温度为：50
从温度传感器获取温度...
散热器开启！
冷却控制器停止
散热器关闭！
气流控制器关闭
```