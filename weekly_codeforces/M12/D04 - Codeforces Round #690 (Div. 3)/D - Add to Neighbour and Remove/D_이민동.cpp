#include <bits/stdc++.h>

#define lint long long
#define endl '\n'

using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int T;
    cin >> T;
    while (T--) {
        int n;
        cin >> n;
        vector<int> arr(n);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            cin >> arr[i];
            sum += arr[i];
        }

        for (int i = n; i > 0; i--) {
            if(sum%i==0){
                bool flag = true;
                int target = sum/i;
                int tmp = 0;
                for(int e : arr){
                    tmp += e;
                    if(tmp == target){
                        tmp = 0;
                    } else if(tmp > target) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    cout << n-i << endl;
                    break;
                }
            }
        }
    }
}