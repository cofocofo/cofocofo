import sys
input = sys.stdin.readline

for test in range(int(input())):
    n = input().rstrip()
    ln = len(n)
    # 숫자의 임의의 숫자를 지운다. 오른족에 한자리를 더한다. 둘 중 하나의 작업 수행 가능.
    # 두번째 숫자가 0이면 첫번째 자리 숫자 지울 수 없다.
    # 2의 거듭제곱을 만들기 위한 최소한의 작업.
    # 거듭제곱이 숫자 안에 있을 경우 = 그 제외한 것만 지워주면 됨.
    # 거듭제곱과 편집거리를 계산. 변경의 cost가 2. 추가 1, 제거 1
    powers = []
    i = 1
    while i < int(1e18):
        s2 = str(i)
        powers.append(s2)
        i *= 2
    min_change = float('inf')
    for power in powers:
        lp = len(power)
        if lp - ln > min_change:
            break
        idx1 = 0
        idx2 = 0
        cnt = 0
        while idx1 < lp and idx2 < ln:
            if n[idx2] == power[idx1]:
                cnt += 1
                idx1 += 1
                idx2 += 1
            else:
                idx2 += 1
        min_change = min(min_change,(ln + lp - 2*cnt))
    print(min_change)
