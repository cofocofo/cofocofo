#include <iostream>
#include <vector>
#include <algorithm>
#define endl "\n"
#define fi first
#define se second
using namespace std;
typedef long long ll;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T;
    cin >> T;

    while (T--) {
        ll n;
        cin >> n;

        vector<pair<int, ll>> divisor;
        for (ll d = 2; d * d <= n; d++) {
            if (n % d == 0) { // d로 나누어 떨어지는 경우
                int cnt = 0;
                while (n % d == 0) {
                    cnt++;
                    n /= d;
                }
                divisor.push_back({ cnt, d });
            }
        }

        if (n > 1) {
            divisor.push_back({ 1, n });
        }

        // cnt가 큰 순서로 정렬
        sort(divisor.rbegin(), divisor.rend());

        // 지수가 가장 큰 소인수로 벡터 초기화
        vector<ll> a(divisor[0].fi, divisor[0].se);

        // 남은 수들을 마지막 값에 곱해준다
        for (int i = 1; i < divisor.size(); i++) {
            for (int j = 0; j < divisor[i].fi; j++) {
                a.back() *= divisor[i].se;
            }
        }

        cout << a.size() << endl;
        for (ll num : a) {
            cout << num << " ";
        }
        cout << endl;
    }
    return 0;
}
