#coding:utf-8
'''
输入某年某月某日，判断这一天是这一年的第几天？
'''
year=int(raw_input('年：'))
month=int(raw_input('月:'))
day=int(raw_input('日:'))

months=(0,31,59,90,120,151,181,212,243,273,304,334)
if 0 < month < 12:
    sum=months[month-1]
else:
    print '日期输入错误!'
sum+=day
#判断闰年
leap=0
if(year%400==0) or ((year%4==0) and (year%100!=0)):
    leap=1
if(leap==1) and (month>2):
    sum+=1
print '今天是第%d天'%sum
