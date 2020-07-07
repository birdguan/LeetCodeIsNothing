# 观察者模式
当对象间存在一对多关系时，则使用观察者模式（Observer Pattern）。比如，当一个对象被修改时，则会自动通知依赖它的对象，观察者模式属于幸卫星模式。

|类别|说明|
|:-:|:--|
|意图|定义对象间的一种一对多的依赖关系，当一个对象的状态发生改变时，所有依赖与它的对象都得到通知并自动更新。|
|主要解决|一个对象状态改变给其他对象通知的问题，而且要考虑到易用和低耦合，保证高度的协作。|
|何时使用|一个对象（目标对象）的状态发生改变，所有的依赖对象（观察者对象）都将得到通知，进行广播通知。|
|如何解决|使用面向对象技术，可以将这种依赖关系弱化。|
|关键代码|在抽象类里有一个ArrayList存放观察者们。|
|优点|1. 观察者和被观察者是抽象耦合的。<br/> 2. 建立一套触发机制。|
|缺点|1. 如果一个被观察者有很多直接或间接的观察者的话，将所有的观察者都通知到会花费很多时间。<br/> 2. 如果在观察者和被观察者之间有循环依赖的话，观察目标会触发它们之间进行循环调用，可能导致系统崩溃。<br/> 3. 观察者模式没有相应的机制让观察者知道所观察的目标对象是怎么发生变化的，而仅仅是知道观察目标发生了变化。|
