//
//  BOJ
//  ver.C++
//
//  Created by GGlifer
//
//  Open Source

#include <iostream>

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
    int N, K;
    cin >> N >> K;
    int A[N];
    for (int i=0; i<N; i++)
        cin >> A[i];

    // Process
    const int INF = 100000 * 20 + 1;

    int l = 0, r = INF; /* Binary Search */
    int ans = -1;
    while (l <= r) {
        int m = (l+r) / 2; /* Answer candidate */
        int k = 0, s = 0; /* Group count, Sum scores */
        for (int i=0; i<N; i++) {
            s += A[i];
            if (s >= m) { /* If valid group */
                k++, s = 0;
            }
        }

        if (k >= K) {
            ans = m;
            l = m+1;
        } else {
            r = m-1;
        }
    }

    // Control : Output
    cout << ans << endl;
}

// Helper Functions
/* None */