#include <iostream>
#include <algorithm>
#define endl "\n"
using namespace std;

int n;
int a[100];
int answer[100];

void makeTree(int left, int right, int depth)
{
    // 더 이상 나눌 수 없을 때 종료
    if (left >= right) return;

    // 최댓값의 인덱스
    int maxi = distance(a, max_element(a + left, a + right));

    // depth 저장
    answer[maxi] = depth;

    makeTree(left, maxi, depth + 1); // 왼쪽
    makeTree(maxi + 1, right, depth + 1); // 오른쪽
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T;
    cin >> T;

    while (T--) {
        cin >> n;
        for (int i = 0; i < n; i++) {
            cin >> a[i];
        }

        makeTree(0, n, 0);

        for (int i = 0; i < n; i++) {
            cout << answer[i] << " ";
        }
        cout << endl;
    }
    return 0;
}
