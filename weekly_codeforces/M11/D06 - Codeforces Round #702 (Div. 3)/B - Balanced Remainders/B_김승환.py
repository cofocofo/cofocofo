TC = int(input())
for tc in range(1, TC + 1):
    N = int(input())
    lst = list(map(int, input().split()))
    box = [[0, 0], [0, 1], [0, 2]]

    for num in lst:
        if num % 3 == 0:
            box[0][0] += 1
        elif num % 3 == 1:
            box[1][0] += 1
        else:
            box[2][0] += 1

    avg = N / 3
    cnt = 0
    while True:
        for i in range(3):
            if box[i][0] > avg:
                for j in range(3):
                    if box[j][0] < avg:
                        box[i][0] -= 1
                        box[j][0] += 1
                        if j > i:
                            cnt += abs(box[i][1] - box[j][1])
                        else:
                            cnt += 1 + abs(box[i][1] - box[j][1]) % 2
                        break
        if box[0][0] == box[1][0] == box[2][0]:
            break
    print(cnt)
