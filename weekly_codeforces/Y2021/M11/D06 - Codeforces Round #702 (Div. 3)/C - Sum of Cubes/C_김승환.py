box = []
contain = 1
while contain ** 3 <= 10 ** 12:
    box.append(contain ** 3)
    contain += 1

TC = int(input())
for tc in range(1, TC + 1):
    num = int(input())
    result = 'NO'
    max_idx = 0
    while max_idx ** 3 <= num:
        max_idx += 1
    max_idx -= 1

    for i in range(max_idx, -1, -1):
        find = False
        for j in range(i, -1, -1):
            if box[i] + box[j] == num:
                find = True
                result = 'YES'
                break
            elif box[i] + box[j] < num:
                break
        if find:
            break

    print(result)
