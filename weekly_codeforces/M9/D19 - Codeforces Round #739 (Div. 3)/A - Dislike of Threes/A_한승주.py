import sys
input = sys.stdin.readline


ans = [0]
for i in range(1667):
    if not i%3 or str(i)[-1]=='3':
        continue
    ans.append(i)


for _ in range(int(input())):
    k = int(input())
    print(ans[k])