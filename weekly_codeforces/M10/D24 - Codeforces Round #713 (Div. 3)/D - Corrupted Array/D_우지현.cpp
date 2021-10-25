#include <iostream>
#include <algorithm>
#include <numeric>
#include <set>
#define MAX 200002
#define endl "\n"
using namespace std;
typedef long long ll;

int n;
int b[MAX];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T;
    cin >> T;

    while (T--) {
        cin >> n;
        for (int i = 0; i < n + 2; i++)
            cin >> b[i];

        // b 원소 합 = a 배열 합 * 2 + x
        ll sum = accumulate(b, b + n + 2, 0LL);
        multiset<int> a(b, b + n + 2);

        bool possible = false;
        for (int i = 0; i < n + 2; i++) {
            sum -= b[i]; // sum -= x
            a.erase(a.find(b[i])); // a에서 x 하나 제거

            // sum = a 배열 합 * 2이므로 b[i]가 x라면 sum % 2 == 0이어야 함
            // 1 <= b_i <= 10^9이므로 sum은 2 * 10^9 이하여야 함
            // b_n+1 = a_1 + ... + a_n이므로 a에 sum / 2가 있어야 함
            if (sum % 2 == 0 && sum <= 2000000000  && a.find(sum / 2) != a.end()) {
                possible = true;
                a.erase(a.find(sum / 2)); // b_n+1 제거
                for (int k : a) {
                    cout << k << " ";
                }
                cout << endl;
                break;
            }

            // b[i]가 x가 아니므로 원래대로 돌려놓는다
            sum += b[i];
            a.insert(b[i]);
        }

        if (!possible) // a 배열을 찾지 못한 경우
            cout << -1 << endl;
    }
    return 0;
}