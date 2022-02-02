#include <iostream>
#include <vector>
#define endl "\n"
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T;
    cin >> T;

    while (T--) {
        int n;
        cin >> n;

        vector<int> pos;
        for (int i = 0; i < n; i++) {
            int x;
            cin >> x;
            if (x == 1) { // 1의 위치 저장
                pos.push_back(i);
            }
        }

        int answer = 0;
        for (int i = 1; i < pos.size(); i++) {
            answer += pos[i] - pos[i - 1] - 1; // 1과 1 사이의 0 개수
        }
        cout << answer << endl;
    }
    return 0;
}