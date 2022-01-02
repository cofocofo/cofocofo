//
//  CodeForces
//  ver.C++
//
//  Created by GGlifer
//
//  Open Source

#include <iostream>
#include <algorithm>

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
        int min_idx = min_element(A, A+N) - A;
        int max_idx = max_element(A, A+N) - A;

        int s = min(min_idx, max_idx);  // left idx
        int b = max(min_idx, max_idx);  // right idx

        const int INF = N+1;  // Init ans value
        int ans = INF;

        ans = min(ans, b+1);  // -> ->
        ans = min(ans, N-s);  // <- <-
        ans = min(ans, (s+1) + (N-b)); // -> <-

        // Control : Output
        cout << ans << endl;
    }
}

// Helper Functions
/* None */