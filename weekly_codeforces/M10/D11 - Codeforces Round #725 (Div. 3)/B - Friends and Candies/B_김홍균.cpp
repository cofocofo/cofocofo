//
//  CodeForces
//  ver.C++
//
//  Created by GGlifer
//
//  Open Source

#include <iostream>
#include <numeric>

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
        int S = accumulate(A, A+N, 0);  // sum

        int ans;
        if (S % N != 0) {
            ans = -1;
        } else {
            int avg = S / N;
            ans = 0;
            for (int i=0; i<N; i++) {
                if (A[i] > avg) {
                    ans++;
                }
            }
        }

        // Control : Output
        cout << ans << endl;
    }
}

// Helper Functions
/* None */