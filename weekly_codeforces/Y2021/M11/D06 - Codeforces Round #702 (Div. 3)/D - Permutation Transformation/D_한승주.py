import sys
input = sys.stdin.readline

def make_tree(depth, a):
    if not a:
        return a
    max_num = 0
    for idx, num in enumerate(a):
        if max_num < num:
            max_idx = idx
            max_num = num
    answer[dic[max_num]] = depth
    make_tree(depth+1, a[:max_idx])
    make_tree(depth+1, a[max_idx+1:])



for test in range(int(input())):
    n = int(input())
    arr = list(map(int, input().split()))
    dic = {num: idx for idx, num in enumerate(arr)}
    answer = [0] * n
    make_tree(0, arr)
    print(*answer)