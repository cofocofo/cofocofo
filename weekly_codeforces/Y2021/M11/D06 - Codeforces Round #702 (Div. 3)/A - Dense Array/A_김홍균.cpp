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
#define len(x) (int)(x).length()
#define size(x) (int)(x).size()

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
    int t; cin >> t;

    while (t--) {
        int n; cin >> n;
        int A[n];
        for (int i=0; i<n; i++)
            cin >> A[i];

        // Process
        int ans = 0;
        for (int i=0; i<n-1; i++) {
            int maxi = max(A[i], A[i+1]);
            int mini = min(A[i], A[i+1]);

            while (maxi > 2 * mini) {
                mini *= 2;
                ans++;
            }
        }

        // Control : Output
        cout << ans << endl;
    }
}

// Helper Functions
/* None */
