import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

# 분할정복 2의 제곱 구하기.
def pow(n):
    if n<=0:
        return 1
    p_n = pow(n//2)
    if n&1:
        return p_n*p_n*2%MOD
    return p_n*p_n%MOD


MOD = int(1e9)+7
for _ in range(int(input())):
    N = int(input())
    # 2~N-1 번의 징검다리를 선택하거나 선택하지 않는 모든 경우의 수.
    print((pow(N-2))%MOD)