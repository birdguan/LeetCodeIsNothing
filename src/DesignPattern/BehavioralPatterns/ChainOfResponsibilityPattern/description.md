# 责任链模式
顾名思义，责任链模式（Chain of Responsibility）为请求创建一个接受者对象的链。这种模式给予请求的类型，对请求的发送者和接受者进行解耦。这种类型的设计莫属属于行为形模式。  
在这种模式中，通常每个接受者都包含对另一个接收者的引用。如果一个对象不能处理该请求，那么它会把相同的请求传给下一个接收者，依次类推。

|类别|说明|
|:-:|:--|
|意图|避免请求发送者与接收者耦合在一起，让多个对象都有可能接收请求，将这些对象连接成一条链，并且沿着这条链传递请求，直到有对象处理它为止。|
|主要解决|职责链上的处理者负责处理请求，客户只需要将请求发送到职责链上即可，无需关心请求的处理细节和请求的传递，所以责任链将请求的发送者和请求的处理者解耦了。|
|何时使用|在处理消息的时候以过滤多道|
|如何解决|拦截的类都实现统一接口|
|关键代码|Handler里面聚合它自己，在HandlerRequest里判断是否合适，如果没达到条件则向下传递，向谁传递之前set进去。|
|优点|1. 降低耦合度。它将请求的发送者和接受者解耦。<br/> 2. 简化了对象，使得对象不需要知道链的结构。<br/> 3. 增强给对象指派责任的灵活性，通过改变链内成员或者调动它们的次序，允许动态地新增或者删除责任。 <br/> 4. 增加新的请求处理类很方便。|
|缺点|1. 不能保证请求一定被接收。 <br/> 2. 系统性能将收到一定影响，而且在进行代码调试时不太方便，可能会造成循环调用。 <br/> 3. 可能不容易观察运行时的特征，有碍于排错。|