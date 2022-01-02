#include <iostream>
#include <string>
#define endl "\n"
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T;
    cin >> T;

    while (T--) {
        string a, b;
        cin >> a >> b;

        int answer = 0;
        if (a != b) {
            if (a.size() > b.size()) // a의 길이가 항상 작도록 바꿔준다
                swap(a, b);

            // 가능한 최댓값은 a, b 모두 empty string이 되는 경우
            answer = a.size() + b.size();

            for (int i = 0; i < a.size(); i++) {
                for (int j = a.size() - i; j > 0; j--) {
                    // 공통되는 문자열
                    string s = a.substr(i, j);

                    // 해당 문자열이 있는지 찾는다
                    int result = b.find(s);

                    // 있으면 제거해야하는 문자수 갱신하고 종료
                    if (result != string::npos) {
                        int cnt = a.size() + b.size() - (j * 2);
                        answer = min(answer, cnt);
                        break;
                    }
                }
            }
        }
        cout << answer << endl;
    }
    return 0;
}
