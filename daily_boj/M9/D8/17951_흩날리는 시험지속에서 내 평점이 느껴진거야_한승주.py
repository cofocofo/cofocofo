import sys
input = sys.stdin.readline

# 최소 예측값으로 K이상 분류할 수 있나?
def is_possible(target):
    cnt = 0
    sum_n = 0
    for score in scores:
        sum_n += score
        if sum_n >= target:
            cnt += 1
            sum_n = 0
    if cnt >= K:
        return True
    return False

N, K = map(int, input().split())
scores = list(map(int, input().split()))

left, right = 0, int(2e6)
max_score = 0
while left <= right:
    mid = (left + right)//2
    if is_possible(mid):
        left = mid + 1
        max_score = mid
    else:
        right = mid - 1
print(max_score)