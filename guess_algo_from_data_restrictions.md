# 由数据范围反推算法复杂度以及算法内容
[出处](https://www.acwing.com/blog/content/32/)

一般ACM或者笔试题的时间限制是1秒或2秒。
在这种情况下，C++代码中的操作次数控制在 107∼108107∼108 为最佳。

下面给出在不同数据范围下，代码的时间复杂度和算法该如何选择：
1. $n≤30$, 指数级别, dfs+剪枝，状态压缩dp
2. $n≤100$ => O($n^3$)，floyd，dp，高斯消元
3. $n≤1000$ => O($n^2$)，O($n^2$log$n$)，dp，二分，朴素版Dijkstra、朴素版Prim、Bellman-Ford
4. $n≤10000$ => O($n$∗$\sqrt{n}$)，块状链表、分块、莫队
5. $n≤100000$ => O($n$*log$n$) => 各种sort，线段树、树状数组、set/map、heap、拓扑排序、dijkstra+heap、prim+heap、spfa、求凸包、求半平面交、二分、CDQ分治、整体二分
6. $n≤1000000$ => O($n$), 以及常数较小的 O($n$log$n$) 算法 => 单调队列、 hash、双指针扫描、并查集，kmp、AC自动机，常数比较小的 O(nlogn)O(nlogn) 的做法：sort、树状数组、heap、dijkstra、spfa
7. $n≤10000000$ => O($n$)，双指针扫描、kmp、AC自动机、线性筛素数
8. $n≤10^9$ => O($\sqrt{n}$)，判断质数
9. $n≤10^18$ => O(log$n$)，最大公约数，快速幂
10. $n≤10^1000$ => O($(log$n$)^2$)，高精度加减乘除
11. $n≤10^100000$ => O(log$k$ * loglog$k$)，k表示位数，高精度加减、FFT/NTT