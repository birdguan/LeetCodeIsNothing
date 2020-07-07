# 装饰器模式
装饰器模式（Decorator Pattern）允许向一个现有的对象添加新的功能，同时又不改变其结构。这种类型的设计模式属于结构型模式，它是作为现有的类的一个包装。  
这种模式创建了一个装饰类，用来包装原有的类，并在保持类方法签名完整性的前提下，提供了额外的功能。

|类别|说明|
|:-:|:--|
|意图|动态地给一个对象添加一些额外的职责。就增加功能来说，装饰器模式相比生成子类更为灵活。|
|主要解决|一般的，我们为了扩展一个类经常使用集成方式实现，由于继承为类引入静态特征，并且随着扩展功能的增多，子类会很膨胀。|
|何时使用|在不想增加很多子类的情况下扩展类|
|如何解决|将具体功能职责划分，同时继承装饰者模式|
|关键代码|1. Component类充当抽象角色，不应该具体实现。<br/> 2. 修饰类引用和继承Compnent类，具体扩展类重写父类方法。|
|优点|修饰类和被修饰类可以独立发展，不会相互耦合，装饰模式是继承的一个替代模式，装饰模式可以动态扩展一个实现类的功能。|
|缺点|多层装饰比较复杂|