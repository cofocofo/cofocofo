//
//  CodeForces
//  ver.C++
//
//  Created by GGlifer
//
//  Open Source

#include <iostream>

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
        int x; cin >> x;

        // Process
        int ans = 0;
        for (int i=1; i<=9; i++) {
            for (int j=i, cnt=1; j<=10000; j=10*j+i, cnt++) {
                ans += cnt;
                if (j == x) { goto end; }
            }
        } end:

        // Control : Output
        cout << ans << endl;
    }
}

// Helper Functions
/* None */
