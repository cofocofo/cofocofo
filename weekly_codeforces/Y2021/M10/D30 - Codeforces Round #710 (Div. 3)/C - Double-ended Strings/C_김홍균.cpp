//
//  CodeForces
//  ver.C++
//
//  Created by GGlifer
//
//  Open Source

#include <iostream>
#include <cstring>

using namespace std;

#define endl '\n'

// Set up : Global Variables
/* None */

// Set up : Functions Declaration
/* None */


int main()
{
    // Set up : I/O
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    // Set up : Input
    int TC; cin >> TC;

    for (int tc=1; tc<=TC; tc++) {
        string a; cin >> a;
        string b; cin >> b;

        // Process
        int la = (int)a.length();
        int lb = (int)b.length();
        int dp[la+1][lb+1];
        memset(dp, 0, sizeof(dp));

        int ofs = 0;  /* length of LCS (Longest Common Substring) */
        for (int i=1; i<=la; i++) {
            for (int j=1; j<=lb; j++) {
                if (a[i-1] == b[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    ofs = max(ofs, dp[i][j]);
                }
            }
        }

        int ans = la + lb - 2*ofs;

        // Control : Output
        cout << ans << endl;
    }
}

// Helper Functions
/* None */

// hello
// codeforces