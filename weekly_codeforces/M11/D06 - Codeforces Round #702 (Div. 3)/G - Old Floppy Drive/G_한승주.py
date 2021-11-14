import sys
input = sys.stdin.readline
from bisect import bisect_left

# 풀이 참고했는데
for test in range(int(input())):
    n, m = map(int, input().split())
    arr = list(map(int, input().split()))
    prefix_sum, idxes, idx, total = [], [], 0, 0
    for num in arr:
        total += num
        if not prefix_sum or prefix_sum[-1] < total:
            prefix_sum.append(total)
            idxes.append(idx)
        idx += 1
    x = list(map(int, input().split()))
    answer = []
    for target in x:
        # 총합이 더해질 수 없고 양의 총합보다 목표치가 높으면 도달할 수 없음
        if prefix_sum[-1] < target and total <= 0:
            answer.append(-1)
            continue
        # 이부분이 이해가 잘 안감.
        # 바퀴수 = (목표치 - 양의 최대치 + 총합 - 1) // 총합 ?
        # 양의 최대치에서 목표치를 초과할 가능성에 대해 보정해주는건가?
        cycle = 0
        if prefix_sum[-1] < target:
            cycle = (target - prefix_sum[-1] + total - 1) // total
        target -= cycle * total
        # 바퀴수 * 크기 + 나머지의 누적합에서의 위치
        answer.append(cycle * n + idxes[bisect_left(prefix_sum, target)])
    print(*answer)