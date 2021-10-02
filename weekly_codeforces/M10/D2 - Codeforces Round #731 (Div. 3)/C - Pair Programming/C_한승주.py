import sys
input = sys.stdin.readline

for test in range(int(input())):
    input()
    k, n, m = map(int, input().split())
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))
    answer = []
    idx_a = 0
    idx_b = 0
    # 최초 0값 + k 값 갱신
    while idx_a < n and not a[idx_a]:
        answer.append(0)
        idx_a += 1
        k += 1
    while idx_b < m and not b[idx_b]:
        answer.append(0)
        idx_b += 1
        k += 1
    # 두 배열이 모두 순회가 끝날떄까지.
    while idx_a != n or idx_b != m:
        flag = 0
        if idx_a < n:
            # k이하면 삽입, 뒤에나오는 0도 같이 삽입
            if a[idx_a] <= k:
                answer.append(a[idx_a])
                idx_a += 1
                flag = 1
                while idx_a < n and not a[idx_a]:
                    answer.append(0)
                    idx_a += 1
                    k += 1
        if idx_b < m:
            if b[idx_b] <= k:
                answer.append(b[idx_b])
                idx_b += 1
                flag = 1
                while idx_b < m and not b[idx_b]:
                    answer.append(0)
                    idx_b += 1
                    k += 1
        # a, b둘다 k보다 크면 불가능한 command이므로 -1출력
        if not flag:
            answer = [-1]
            break

    print(*answer)
