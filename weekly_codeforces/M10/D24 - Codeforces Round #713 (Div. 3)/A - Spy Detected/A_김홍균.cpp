//
//  CodeForces
//  ver.C++
//
//  Created by GGlifer
//
//  Open Source

#include <iostream>
#include <set>

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
        int A[N+1];
        for (int i=1; i<=N; i++)
            cin >> A[i];

        // Process
        int ans = -1;
        /* Check (A[i-2], A[i-1], A[i]) */
        for (int i=3; i<=N; i++) {
            int a = A[i-2], b = A[i-1], c = A[i];
            if (a == b && b == c) continue;

            if (a == b && b != c) { ans = i; break; }
            if (a == c && a != b) { ans = i-1; break; }
            if (b == c && a != b) { ans = i-2; break; }
        }

        // Control : Output
        cout << ans << endl;
    }
}

// Helper Functions
/* None */
