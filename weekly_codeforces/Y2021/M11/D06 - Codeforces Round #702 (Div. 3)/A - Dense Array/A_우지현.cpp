#include <iostream>
#define endl "\n"
using namespace std;

int a[50];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T;
    cin >> T;

    while (T--) {
        int n;

        cin >> n;

        int answer = 0;
        for (int i = 0; i < n; i++) {
            cin >> a[i];

            if (i > 0) {
                int maxi = max(a[i], a[i - 1]);
                int mini = min(a[i], a[i - 1]);

                // max / min <= 2일 때까지 element 추가
                while (maxi > 2 * mini) {
                    if (maxi % 2 == 0)
                        maxi /= 2;
                    else
                        maxi = (maxi + 1) / 2; // ceil
                    answer++;
                }
            }
        }
        cout << answer << endl;
    }
    return 0;
}
