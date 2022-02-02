//
//  CodeForces
//  ver.C++
//
//  Created by GGlifer
//
//  Open Source

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

#define endl '\n'
#define len(x) (int)(x).length()
#define size(x) (int)(x).size()
#define str(x) to_string(x)
#define error logic_error("line " + str(__LINE__))

// Set up : Definitions
const int INF = 987654321;
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
        vector<int> A(n);
        for (int i=0; i<n; i++)
            cin >> A[i];

        // Process
        auto lp = distance(A.begin(), find(A.begin(), A.end(), 1));
        auto rp = distance(find(A.rbegin(), A.rend(),1), A.rend()) - 1;

        int ans = 0;
        for (int i=lp; i<rp; i++) {
            if (A[i] == 0) {
                ans++;
            }
        }

        // Control : Output
        cout << ans << endl;
    }
}

// Helper Functions
/* None */
