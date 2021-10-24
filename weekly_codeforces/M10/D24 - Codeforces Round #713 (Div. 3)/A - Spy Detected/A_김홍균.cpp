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
        int A[N];
        for (int i=0; i<N; i++)
            cin >> A[i];

        // Process
        set<int> S;
        int equal_num = -1;
        for (int i=0; i<N; i++) {
            if (S.find(A[i]) == S.end()) {
                S.insert(A[i]);
            } else {
                equal_num = A[i];
                break;
            }
        }

        int ans = -1;
        for (int i=0; i<N; i++) {
            if (A[i] != equal_num) {
                ans = i+1;
            }
        }

        // Control : Output
        cout << ans << endl;
    }
}

// Helper Functions
/* None */
