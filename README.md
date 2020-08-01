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

|        题号         |              题目              |            说明             |
| :-----------------: | :----------------------------: | :-------------------------: |
|         15          |            三数之和            |         排序+双指针         |
|         26          |     删除排序数组中的重复项     |          快慢指针           |
|         28          |          实现strStr()          |           双指针            |
|         42          |             接雨水             |  双指针，汇合于中间最高峰   |
|         75          |     颜色分类/荷兰国旗问题      |           双指针            |
|         88          |        合并两个有序数组        | 双指针（从前往后/从后往前） |
|         125         |           验证回文串           |           双指针            |
|         141         |            环形链表            |          快慢指针           |
|     160/Sword52     |            相交链表            |         双指针交替          |
|         202         |             快乐数             |  快慢指针（环形链表变体）   |
|         238         |             移动零             |           双指针            |
|         344         |           反转字符串           |           双指针            |
| Sword 21（类比238） | 调整数组顺序使奇数位于偶数前面 |           双指针            |
|      Sword 22       |      链表中倒数第k个节点       |          快慢指针           |
|      Sword 48       |   最长不含重复字符的子字符串   |        双指针+哈希表        |
|      Sword 57       |        和为s的两个数字         |           双指针            |
|     Sword 58_1      |          翻转单词顺序          |           双指针            |



- 哈希

|     题号     |           题目           |              说明               |
| :----------: | :----------------------: | :-----------------------------: |
|      1       |         两数之和         |      一遍哈希表/两遍哈希表      |
|      13      |      罗马数字转整数      |   注意双字符罗马数字优先匹配    |
|      36      |        有效的数独        |  行、列、单元格三个哈希表数组   |
|      49      |      字母异位词分组      | 哈希表（排序数组分类/计数分类） |
|     128      |       最长连续序列       |             哈希表              |
|     146      |       LRU缓存机制        |        哈希表 + 双向链表        |
|     242      |     有效的字母异位词     |             哈希表              |
|     350      |     两个数组的交集2      |             哈希表              |
| 387/Sword 50 | 字符串中的第一个唯一字符 |             哈希表              |
|   Sword 03   |     数组中重复的数字     |             HashSet             |
|   Sword 35   |      复杂链表的复制      |             HashMap             |
|   Sword 61   |      扑克牌中的顺子      |             HashSet             |



- 滑动窗口

|    题号    |          题目          |         说明          |
| :--------: | :--------------------: | :-------------------: |
|     1      |        两数之和        | 一遍哈希表/两遍哈希表 |
|     3      | 无重复字符串的最长子串 |      Hashset验重      |
|     76     |      最小覆盖子串      |       滑动窗口        |
| Sword 57_2 |  和为s的连续正数序列   |       滑动窗口        |


- 动态规划

|     题号     |            题目            |         说明         |
| :----------: | :------------------------: | :------------------: |
|      10      |       正则表达式匹配       |       动态规划       |
|      44      |         通配符匹配         |       动态规划       |
|      53      |         最大子序和         |       动态规划       |
|      62      |          不同路径          |       动态规划       |
|      70      |           爬楼梯           | 动态规划、斐波那契数 |
|      91      |          解码方法          |       动态规划       |
|     118      |          杨辉三角          |       动态规划       |
| 121/Sword 63 |     买卖股票的最佳时机     |       动态规划       |
|     122      |    买卖股票的最佳时机2     |       动态规划       |
|     139      |          单词拆分          |       动态规划       |
|     140      |         单词拆分2          |      记忆化回溯      |
|     198      |          打家劫舍          |       动态规划       |
|  Sword 10_1  |        斐波那契数列        |   常数空间动态规划   |
|  Sword 10_2  |       青蛙跳台阶问题       |   常数空间动态规划   |
|  Sword 14_1  |           剪绳子           |       动态规划       |
|   Sword 42   |     连续子数组的最大和     |       动态规划       |
|   Sword 46   |   把数字   翻译成字符串    |       动态规划       |
|   Sword 47   |       礼物的最大价值       |       动态规划       |
|   Sword 48   | 最长不含重复字符的子字符串 |   动态规划+哈希表    |
|   Sword 49   |            丑数            |       动态规划       |
|   Sword 60   |       n个骰子的点数        |       动态规划       |


- dfs

|    题号    |           题目           |     说明     |
| :--------: | :----------------------: | :----------: |
|     17     |    电话号码的字母组合    |  dfs+哈希表  |
|     46     |          全排列          |   dfs回溯    |
|     78     |           子集           |     回溯     |
|     79     |         单词搜索         |   dfs回溯    |
|    139     |         单词拆分         |  记忆化回溯  |
|    140     |        单词拆分2         |  记忆化回溯  |
|  Sword 54  |  二叉搜索树的第k大节点   | 右-中-左 dfs |
| Sword 55_1 |       二叉树的深度       |     dfs      |
|  Sword 34  | 二叉树中和为某一值的路径 |   dfs回溯    |
|  Sword 38  |       字符串的排列       |   dfs回溯    |

- bfs

|     题号      |          题目           | 说明  |
| :-----------: | :---------------------: | :---: |
| 102/Sword32_2 |    二叉树的层序遍历     |  bfs  |
|      139      |        单词拆分         |  bfs  |
|  Sword 31_1   |   从上到下打印二叉树    |  bfs  |
|   Sword 37    | 序列化二叉树     ｜ bfs |
|  Sword 55_1   |      二叉树的深度       |  bfs  |

- 栈

|     题号     |        题目        |     说明     |
| :----------: | :----------------: | :----------: |
|      20      |     有效的括号     |      栈      |
|      42      |       接雨水       |    单调栈    |
|      84      | 柱状图中最大的矩形 |    单调栈    |
|      94      |  二叉树的中序遍历  | 基于栈的遍历 |
| 155/Sword 30 |       最小栈       |    辅助栈    |
|   Sword 06   |  从尾到头打印链表  |    辅助栈    |
|   Sword 31   | 栈的压入、弹出序列 |    辅助栈    |
|  Sword 59_1  |  滑动窗口的最大值  |    单调栈    |
|  Sword 59_2  |    队列的最大值    |    单调栈    |



- 二分

|   题号    |                    题目                    |    说明    |
| :-------: | :----------------------------------------: | :--------: |
|    33     |              搜搜旋转排序数组              | 转换后二分 |
|    34     | 在排序数组中查找元素的第一个和最后一个位置 |    二分    |
|  Sword11  |             旋转数组的最小数字             |    二分    |
| Sword53_1 |         在排序数组中查找数字（1）          |    二分    |



- 贪心

|   题号   |        题目        | 说明  |
| :------: | :----------------: | :---: |
|    55    |      跳跃游戏      | 贪心  |
| Sword 42 | 连续子数组的最大和 | 贪心  |


- 位操作
  

|   题号    |                 题目                  |  说明  |
| :-------: | :-----------------------------------: | :----: |
|    371    |              两整数之和               | 位操作 |
| Sword56_1 |         数组中数字出现的次数          | 位运算 |
| Sword56_2 | 数组中数字出现的次数2（其他出现三次） | 位操作 |



- 数学方法/技巧性

|     题号      |          题目          |                   说明                   |
| :-----------: | :--------------------: | :--------------------------------------: |
|      69       |       x的平方根        |                 牛顿迭代                 |
|  169/Sword39  |        多数元素        |              Moore投票算法               |
| 191/Sword 15  |       位1的个数        |        n&(n-1)可以让最后一位1置0         |
|      204      |        计数质数        |                  排除法                  |
|      234      |        回文链表        |             中间节点翻转链表             |
|      237      |    删除链表中的节点    |              修改节点后的值              |
| 268/Sword53_2 |        缺失数字        |             期望和 - 实际和              |
|      326      |         3的幂          | 整数限制，int型最大3次幂为Math.pow(3,19) |
|   Sword 04    |    二维数组中的查找    |        从矩阵的右上角向左/下寻找         |
|  Sword 14_1   |         剪绳子         |     a = n/3; b = n % 3; switch(b)...     |
|   Sword 43    |  1~n整数中1出现的次数  |                  找规律                  |
|   Sword 44    | 数字序列中某一位的数字 |                  找规律                  |
|   Sword 62    |  圆圈中最后剩下的数字  |          数学方法：约瑟夫环问题          |

## 题目类型
- 链表

| 题号  |          题目           |        方法         |
| :---: | :---------------------: | :-----------------: |
|   2   |        两数相加         |    注意进位carry    |
|  19   | 删除链表的倒数第N个节点 |      快慢指针       |
|  21   |    合并两个有序链表     |      递归/迭代      |
|  23   |     合并K个有序链表     | 小根堆PriorityQueue |
|  24   |  两两交换链表中的节点   |      递归/迭代      |




- 字符串

|   题号   |         题目         |          方法          |
| :------: | :------------------: | :--------------------: |
|    3     | 无重复字符的最长子串 |        滑动窗口        |
|    5     |     最长回文子串     |       中心扩张法       |
|    8     |     字符串转整数     |       有限状态机       |
|    10    |    正则表达式匹配    |        动态规划        |
|    13    |    罗马数字转整数    |         哈希表         |
|    14    |     最长公共前缀     | 水平扫描法、二分查找法 |
|    17    |  电话号码的字母组合  |       dfs+哈希表       |
|    20    |      有效的括号      |           栈           |
|    28    |     实现strStr()     |         双指针         |
| Sword 20 |   表示数字的字符串   |       有限状态机       |


- 树

| 题号  |               题目               |                                              方法                                               |
| :---: | :------------------------------: | :---------------------------------------------------------------------------------------------: |
|  94   |         二叉树的中序遍历         |                                            递归/迭代                                            |
|  98   |          验证二叉搜索树          |                                          递归/中序遍历                                          |
|  101  |            对称二叉树            |                                            递归/迭代                                            |
|  102  |         二叉树的层序遍历         |                                               BFS                                               |
|  103  | 二叉树的锯齿形（Z字形）层序遍历  |                                             BFS/DFS                                             |
|  104  |         二叉树的最大深度         |                                            递归/迭代                                            |
|  105  |  从前序与中序遍历序列构造二叉树  |                                            递归/迭代                                            |
|  108  |    将有序数组转换为二叉搜索树    |                                            中序遍历                                             |
|  116  | 填充每个节点的下一个右侧节点指针 | 递归或迭代使用next指针 <br/> node.left.next = node.right <br/> node.right.next = node.next.left |


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


