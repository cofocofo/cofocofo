#include <iostream>
#include <map>
#define endl "\n"
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T;
    cin >> T;

    while (T--) {
        string order, s;
        cin >> order >> s;

        map<char, int> keyboard;
        for (int i = 0; i < 26; i++) {
            keyboard[order[i]] = i;
        }

        int answer = 0;
        for (int i = 1; i < s.size(); i++) {
            answer += abs(keyboard[s[i - 1]] - keyboard[s[i]]);
        }
        cout << answer << endl;
    }
    return 0;
}
