#include <iostream>
#include <vector>
#include <algorithm>
#define endl "\n"
#define MAX 5001
#define fi first
#define se second
using namespace std;
typedef pair<int, int> pii;

int set[MAX];

int getParent(int x)
{
    if (set[x] == x) return x;
    return set[x] = getParent(set[x]);
}

void unionParent(int a, int b)
{
    a = getParent(a);
    b = getParent(b);
    if (a < b) set[b] = a;
    else set[a] = b;
}

int findParent(int a, int b)
{
    a = getParent(a);
    b = getParent(b);
    return a == b;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T;
    cin >> T;

    while (T--) {
        int n;
        cin >> n;

        vector<int> a(n);
        for (int i = 0; i < n; i++) {
            cin >> a[i];
        }

        vector<pii> answer;
        for (int i = 1; i <= n; i++) {
            set[i] = i;
        }

        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.size(); j++) {
                // n - 1개의 도로를 지었을 경우 종료
                if (answer.size() == n - 1) break;
                // 서로 다른 gang에 속해있고 사이클을 형성하지 않는 경우 도로 건설
                if (a[j] != a[i] && !findParent(i, j)) {
                    answer.push_back({i + 1, j + 1});
                    unionParent(i, j);
                }
            }
        }

        cout << ((answer.size() == n - 1) ? "YES" : "NO") << endl;
        if (answer.size() == n - 1) {
            for (const auto &r : answer) {
                cout << r.fi << " " << r.se << endl;
            }
        }
    }
    return 0;
}