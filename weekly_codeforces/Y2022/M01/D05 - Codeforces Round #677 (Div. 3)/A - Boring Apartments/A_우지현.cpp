#include <iostream>
#define endl "\n"
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T;
    cin >> T;

    int num[] = { 0, 1, 11, 111, 1111 };

    while (T--) {
        int x;
        cin >> x;

        int answer = 0;

        for (int i = 1; i < 10; i++) {
            for (int j = 1; j <= 4; j++) {
                answer += j; // digit 개수
                if (num[j] * i == x) // 응답했으면 종료
                    goto end;
            }
        }

        end:
        cout << answer << endl;
    }
    return 0;
}