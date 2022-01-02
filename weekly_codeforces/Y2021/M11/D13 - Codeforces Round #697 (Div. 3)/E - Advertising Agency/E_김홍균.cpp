//
//  CodeForces
//  ver.C++
//
//  Created by GGlifer
//
//  Open Source

#include <iostream>
#include <map>
#include <cstring>

using namespace std;

#define endl '\n'
#define len(x) (int)(x).length()
#define size(x) (int)(x).size()
typedef long long ll;
#define fi first
#define se second

// Set up : Global Variables
const int MOD = 1'000'000'007;
const int MAX = 1000;
ll dp[MAX+1][MAX+1];

// Set up : Functions Declaration
/* None */


int main()
{
    // Set up : I/O
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    // Process
    for (int i=1; i<=MAX; i++) {
        dp[i][0] = dp[i][i] = 1;
        for (int j=1; j<=i-1; j++) {
            dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
            dp[i][j] %= MOD;
        }
    }

    // Set up : Input
    int t; cin >> t;

    while (t--) {
        int n, k;
        cin >> n >> k;
        int A[n];
        for (int i=0; i<n; i++)
            cin >> A[i];

        // Process
        map<int,int> M;
        for (int a : A) {
            M[a]++;
        }

        ll ans = 1;
        for (auto itr=M.rbegin(); itr!=M.rend(); itr++) {
            auto [no, a] = *itr;
            if (k >= a) {
                k -= a;
                if (k == 0) break;
            } else {
                ans *= dp[a][k];
                ans %= MOD;
                break;
            }
        }

        // Control : Output
        cout << ans << endl;
    }
}

// Helper Functions
/* None */
