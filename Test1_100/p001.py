#coding:utf-8
'''
有4个数字1，2，3，4能组成多少互不重复的三位数？打印出每一个数
'''
sum=0
for i in range(1,5):
    for j in range(1,5):
        for k in range(1,5):
            if (i!=k) and (i!=j) and (j!=k):
                sum=sum+1
                print i,j,k
print "总数：",sum