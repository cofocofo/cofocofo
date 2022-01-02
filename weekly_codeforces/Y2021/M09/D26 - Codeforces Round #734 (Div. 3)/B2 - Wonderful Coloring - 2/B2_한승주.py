import sys
input = sys.stdin.readline
from collections import defaultdict

for test in range(int(input())):
    n, k = map(int, input().split())
    arr = list(map(int, input().split()))
    num_set = defaultdict(int)
    for num in arr:
        num_set[num] += 1
    check = {num: 1 for num in num_set}
    answer = [0] * n
    cnt = [[]]
    for i in range(n):
        if num_set[arr[i]] >= k:
            if check[arr[i]] == k + 1:
                continue
            answer[i] = check[arr[i]]
            check[arr[i]] += 1
        else:
            for j in range(len(cnt)):
                if arr[i] not in cnt[j]:
                    break
            else:
                cnt.append([i])
                continue
            print(j)
            cnt[j].append(i)
            if len(cnt[j]) == k:
                color = 1
                while cnt[j]:
                    answer[cnt[j].pop()] = color
                    color += 1
    print(*answer)