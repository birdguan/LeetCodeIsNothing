# 单例模式
单例模式（Singleton Pattern）是Java中最简单的设计模式之一。这种设计模式属于创建型模式，它提供了一种创建对象的最佳方式。  
这种模式涉及到一个单一的类，该类负责创建自己的类，同时确保只有单个对象被创建。这个类提供了一种访问其唯一的对象的方式，可以直接访问，不需要实例化该类的对象。

注意：
1. 单例类只能有一个实例。
2. 单例类必须自己创建自己的唯一实例。
3. 单例类必须给所有其他对象提供这一实例。

|类别|描述|
|:-:|:--|
|意图|保证一个类仅有一个实例，并提供一个访问它的全局访问点|
|主要解决|一个全局使用的类频繁地创建与销毁|
|何时使用|当你想控制实例数目，节省系统资源的时候|
|如何解决|判断系统是否已经有这个单例，如果有则返回，没有则创建。|
|关键代码|构造函数是私有的|
|优点|1. 在内存里只有一个实例，减少了内存的开销，尤其是频繁的创建和销毁实例。<br/> 2. 避免对资源的多重占用。|
|缺点|没有接口，不能集成，与单一职责原则冲突，一个类应该只关心内部逻辑，而不必关心外面怎么样来实例化。|
|注意事项|getInstance()方法中需要使用同步锁synchronized(Singleton.class)防止多线程同时进入造成instance被多次实例化。|

## 单例模式的几种实现方式
1. 懒汉式，线程不安全

> 是否Lazy初始化：是  
> 是否多线程安全：否  
> 实现难度：易  
> 描述：这种方式是最基本的实现方式，这种实现方式最大的问题就是不支持多线程。因为没有加锁synchronized，所以严格意义上它不算单例模式。

```java
public class Singleton {
    private static Singleton instance;
    private Singleton() {}
    
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```


2. 懒汉式，线程安全

> 是否Lazy初始化：是  
> 是否多线程安全：是  
> 实现难度：易  
> 描述：这种方式具备很好的lazy loading，能够在多线程中很好的工作，但是效率很低，99%的情况下不需要同步。  
> 优点：第一次调用才初始化，避免内存浪费。
> 缺点：必须加锁synchronized才能保证单例，但加锁会影响效率。

```java
public class Singleton {
    private static Singleton instance;
    private Singleton() {}
    
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```

3. 饿汉式

> 是否Lazy初始化：否
> 是否多线程安全：是  
> 实现难度：易  
> 描述：这种方式比较常用，但容易产生垃圾对象。  
> 优点：没有加锁，执行效率会提高。
> 缺点：类加载时就初始化，浪费内存。

```java
```java
public class Singleton {
    private static final Singleton instance = new Singleton();
    private Singleton(){}
    public static Singleton getInstance() {
        return instance;
    }
}
```

4. 双检锁/双重校验锁（DCL,即double-checked locking）

> 是否Lazy初始化：是
> 是否多线程安全：是  
> 实现难度：较复杂  
> 描述：这种方式采用双锁机制，安全且在多线程情况下能保持高性能。

```java
public class Singleton {
    private volatile static Singleton instance;
    private Singleton() {}
    
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
```

5. 登记式/静态内部类

> 是否Lazy初始化：是
> 是否多线程安全：是  
> 实现难度：一般  
> 描述：这种方式能达到双检锁方式一样的功效，但实现更简单。对静态域使用延迟初始化，应使用这种方式而不是双检锁方式。这种方式只适用于静态域的情况，双检锁可以在实例域需要延迟初始化时使用。

```java
public class Singleton {
    private static class SingletonHolder {
        private static final Singleton instance = new Singleton();
    }
    private Singleton() {}
    public static Singleton getInstance() {
        return SingletonHolder.instance;
    }
}
```

6. 枚举

> 是否Lazy初始化：否
> 是否多线程安全：是  
> 实现难度：易  
> 描述：这种实现方式还没有被广泛采用，但这是实现单例模式的最佳方法。它更简洁，自动支持序列化机制，绝对防止多次实例化

```java
public enum Singleton {
    INSTANCE;
    public void method() {}
} 
```