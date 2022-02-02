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
#define str(x) to_string(x)
#define error logic_error("line " + str(__LINE__))

// Set up : Definitions
typedef long long ll;

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
        int A[n+1];
        for (int i=1; i<=n; i++)
            cin >> A[i];

        // Process
        auto [mini, maxi] = minmax_element(A+1, A+(n+1));
        int ans;
        if (*mini == *maxi) {
            ans = -1;
        } else {
            for (int i=1; i<n; i++) {
                if (A[i] == *maxi && A[i+1] < *maxi) {
                    ans = i;
                    break;
                }
                if (A[i] < *maxi && A[i+1] == *maxi) {
                    ans = i+1;
                    break;
                }
            }
        }

        // Control : Output
        cout << ans << endl;
    }
}

// Helper Functions
/* None */
