#coding:utf-8
'''
斐波那契数列。
'''
#暴力遍历
def fib(n):
    a,b=1,1
    for i in range(n-1):
        a,b=b,a+b
    return a
print fib(10)
#递归法
def fib_(n):
    if n==1 or n==2:
        return 1
    return fib_(n-1)+fib_(n-2)
print fib_(12)
#全输出
def fib__(n):
    if n==1:
        return [1]
    if n==2:
        return [1,1]
    fibs=[1,1]
    for i in range(2,n):
        fibs.append(fibs[-1]+fibs[-2])
    return  fibs
print fib__(10)
