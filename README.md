# birdguan的刷题斗争之路
## 仪式先来一波
🙏 🙏 🙏 🙏 🙏 🙏 🙏 🙏 🙏 🙏 🙏 🙏 🙏 🙏 🙏 🙏 🙏 🙏 🙏 🙏 🙏
    
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  OFFER +10086
    
 
🙏 🙏 🙏 🙏 🙏 🙏 🙏 🙏 🙏 🙏 🙏 🙏 🙏 🙏 🙏 🙏 🙏 🙏 🙏 🙏 🙏

## 目录说明
- *./LeetcodeTop*: Leetcode精选TOP面试题
- *./CommonAlgorithm*: 常用算法整理
- *./DesignPattern*: 设计模式
## 个人刷题步骤
1. 剑指offer（[方法类型分类](#方法类型) | [题目类型分类](#题目类型)）
2. Leetcode精选TOP面试题（[方法类型分类](#方法类型) | [题目类型分类](#题目类型)）
3. [手写设计模式](#手写设计模式)
4. 常见算法

## 方法类型
- 多指针

|题号|题目|说明|    
|:--:|:--:|:--:|    
|15|三数之和|排序+双指针|
|26|删除排序数组中的重复项|快慢指针|
|28|实现strStr()|双指针|
|42|接雨水|双指针，汇合于中间最高峰|
|75|颜色分类/荷兰国旗问题|双指针|
|88|合并两个有序数组|双指针（从前往后/从后往前）|



- 哈希表

|题号|题目|说明|
|:--:|:--:|:--:|
|1|两数之和|一遍哈希表/两遍哈希表|
|13|罗马数字转整数|注意双字符罗马数字优先匹配|
|36|有效的数独|行、列、单元格三个哈希表数组|
|49|字母异位词分组|哈希表（排序数组分类/计数分类）|




- 滑动窗口

|题号|题目|说明|
|:--:|:--:|:--:|
|1|两数之和|一遍哈希表/两遍哈希表|
|3|无重复字符串的最长子串|Hashset验重|
|76|最小覆盖子串|滑动窗口|


- 动态规划

|题号|题目|说明|
|:--:|:--:|:--:|
|10|正则表达式匹配|动态规划|
|44|通配符匹配|动态规划|
|53|最大子序和|动态规划|
|62|不同路径|动态规划|
|70|爬楼梯|动态规划、斐波那契数|
|91|解码方法|动态规划|
|118|杨辉三角|动态规划|
|121|买卖股票的最佳时机|动态规划|
|122|买卖股票的最佳时机2|动态规划|


- dfs

|题号|题目|说明|
|:--:|:--:|:--:|
|17|电话号码的字母组合|dfs+哈希表|
|46|全排列|dfs回溯|
|78|子集|回溯|
|79|单词搜索|dfs回溯|

- bfs

|题号|题目|说明|
|:--:|:--:|:--:|
|102|二叉树的层序遍历|bfs|

- 栈

|题号|题目|说明|
|:--:|:--:|:--:|
|20|有效的括号|栈|
|42|接雨水|单调栈|
|84|柱状图中最大的矩形|单调栈|
|94|二叉树的中序遍历|基于栈的遍历|


- 二分

|题号|题目|说明|
|:--:|:--:|:--:|
|33|搜搜旋转排序数组|转换后二分|
|34|在排序数组中查找元素的第一个和最后一个位置|二分|



- 贪心

|题号|题目|说明|
|:--:|:--:|:--:|
|55|跳跃游戏|贪心|


- 数学方法

|题号|题目|说明|
|:--:|:--:|:--:|
|69|x的平方根|牛顿迭代|

## 题目类型
- 链表

|题号|题目|方法|
|:-:|:-:|:-:|
|2|两数相加|注意进位carry|
|19|删除链表的倒数第N个节点|快慢指针|
|21|合并两个有序链表|递归/迭代|
|23|合并K个有序链表|小根堆PriorityQueue|
|24|两两交换链表中的节点|递归/迭代|




- 字符串

|题号|题目|方法|
|:-:|:-:|:-:|
|3|无重复字符的最长子串|滑动窗口|
|5|最长回文子串|中心扩张法|
|8|字符串转整数|有限状态机|
|10|正则表达式匹配|动态规划|
|13|罗马数字转整数|哈希表|
|14|最长公共前缀|水平扫描法、二分查找法|
|17|电话号码的字母组合|dfs+哈希表|
|20|有效的括号|栈|
|28|实现strStr()|双指针|


- 树

|题号|题目|方法|
|:-:|:-:|:-:|
|94|二叉树的中序遍历|递归/迭代|
|98|验证二叉搜索树|递归/中序遍历|
|101|对称二叉树|递归/迭代|
|102|二叉树的层序遍历|BFS|
|103|二叉树的锯齿形（Z字形）层序遍历|BFS/DFS|
|104|二叉树的最大深度|递归/迭代|
|105|从前序与中序遍历序列构造二叉树|递归/迭代|
|108|将有序数组转换为二叉搜索树|中序遍历|
|116|填充每个节点的下一个右侧节点指针|递归或迭代使用next指针 <br/> node.left.next = node.right <br/> node.right.next = node.next.left|


## 手写设计模式
1. 创建型模式
   - 工厂模式 (Factory Pattern)
   - 抽象工厂模式 (Abstract Factory Pattern)
   - 单例模式 (Singleton Pattern)
   - 建造者模式 (Builder Pattern)
   - 原型模式 (Prototype Pattern)

2. 结构型模式
   - 适配器模式 (Adapter Pattern)
   - 桥接模式 (Bridge Pattern)
   - 过滤器模式 (Filter, Criteria Pattern)
   - 组合模式 (Composite Pattern)
   - 装饰器模式 (Decorator Pattern)
   - 外观模式 (Facade Pattern)
   - 享元模式 (Flyweight Pattern)
   - 代理模式 (Proxy Pattern)

3. 行为型模式
   - 责任链模式 (Chain of Responsibility Pattern)
   - 命令模式 (Command Pattern)
   - 解释器模式 (Interpreter Pattern)
   - 迭代器模式 (Iterator Pattern)
   - 中介者模式 (Mediator Pattern)
   - 备忘录模式 (Memento Pattern)
   - 状态模式 (State Pattern)
   - 空对象模式 (Null Object Pattern)
   - 策略模式 (Strategy Pattern)
   - 模板模式 (Template Pattern)
   - 访问者模式 (Visitor Pattern)

4. J2EE模式
   - MVC模式 (MVC Pattern)
   - 业务代表模式 (Business Delegate Pattern)
   - 组合实体模式 (Composite Entity Pattern)
   - 数据访问对象模式 (Data Access Object Pattern)
   - 前端控制器模式 (Front Controller Pattern)
   - 拦截过滤器模式 (Intercepting Filter Pattern)
   - 服务定位器模式 (Service Locator Pattern)
   - 传输对象模式 (Transfer Object Pattern)


