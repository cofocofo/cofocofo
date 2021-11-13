TC = int(input())
for tc in range(1, TC + 1):
    N = int(input())
    lst = list(map(int, input().split()))

    res_num = lst[0]  # 현재(왼쪽) 숫자
    next_idx = 1  # 오른쪽 숫자
    cnt = 0  # 이동 횟수
    while next_idx < N:
        num1 = res_num
        num2 = lst[next_idx]

        if num1 >= num2:  # 왼쪽이 크면
            if num1 > num2 * 2:  # 두배 이상 크면
                res_num = num1 // 2
                if num1 % 2 != 0:
                    res_num += 1
                cnt += 1  # 중간에  하나 숫자 넣어주고 카운트 추가
            else:
                res_num = num2
                next_idx += 1

        else:  # 오른쪽이 크면
            if num2 > num1 * 2:
                res_num = num1 * 2
                cnt += 1
            else:
                res_num = num2
                next_idx += 1
    print(cnt)
