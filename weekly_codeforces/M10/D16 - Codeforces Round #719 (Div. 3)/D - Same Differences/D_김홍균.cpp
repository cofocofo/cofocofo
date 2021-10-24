//
//  CodeForces
//  ver.C++
//
//  Created by GGlifer
//
//  Open Source

#include <iostream>
#include <map>

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
        int N; cin >> N;
        int A[N];
        for (int i=0; i<N; i++)
            cin >> A[i];

        // Process
        /*
         * aj - ai = j - i
         * aj - j = ai - i
         *
         * if (aj -j == ai - i) {
         *     ans++;  // can make (i, j)
         * }
         */
        map<int,long long> dp;
        for (int i=0; i<N; i++) {
            A[i] -= i;
            dp[A[i]]++;
        }

        long long ans = 0;
        for (auto [k, v] : dp) {
            ans += v*(v-1)/2;
        }

        // Control : Output
        cout << ans << endl;
    }
}

// Helper Functions
/* None */