//
//  CodeForces
//  ver.C++
//
//  Created by GGlifer
//
//  Open Source

#include <iostream>
#include <algorithm>
#include <vector>

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
        int N, L, R;
        cin >> N >> L >> R;
        vector<int> A(N);
        for (int i=0; i<N; i++)
            cin >> A[i];

        // Process
        sort(A.begin(), A.end());  // sort ascending

        long long ans = 0;
        for (int i=0; i<N; i++) {
            // lower_bound num - more than num
            // upper_bound num - over num

            // L = 4, R = 7
            // num : 1 2 3 4 5 6 7 8 9
            // idx : 0 1 2 3 4 5 6 7 8

            // i = 2, A[i] = 3
            // L-A[i] = 1
            // lower_bound(A.begin()+(i+1), A.end(), L-A[i]) = 3(idx) pointer
            // R-A[i] = 4
            // upper_bound(A.begin()+(i+1), A.end(), R-A[i]) = 4(idx) pointer

            // [lower_bound, upper_bound)
            auto s_pos = lower_bound(A.begin()+(i+1), A.end(), L-A[i]);
            auto e_pos = upper_bound(A.begin()+(i+1), A.end(), R-A[i]);
            ans += (e_pos - s_pos);
        }

        // Control : Output
        cout << ans << endl;
    }
}

// Helper Functions
/* None */