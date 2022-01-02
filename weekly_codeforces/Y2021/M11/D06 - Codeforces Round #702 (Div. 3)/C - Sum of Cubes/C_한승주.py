import sys
input = sys.stdin.readline

dic = {}
for i in range(1, 10001):
    dic[i**3] = True

for test in range(int(input())):
    x = int(input())
    for num in dic:
        if x - num in dic:
            print("YES")
            break
        if num > x // 2:
            print("NO")
            break