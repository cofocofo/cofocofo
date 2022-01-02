//
//  CodeForces
//  ver.C++
//
//  Created by GGlifer
//
//  Open Source

#include <iostream>
#include <algorithm>
#include <numeric>

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
        int A[n];
        for (int i=0; i<n; i++)
            cin >> A[i];

        // Process
        int sum = accumulate(A, A+n, 0);

        int ans = n-1;
        for (int i=n; i>=1; i--) {
            if (sum%i != 0) continue;

            int sub_sum = 0, cnt = 0;
            bool isPossible = true;
            for (int j=0; j<n; j++) {
                sub_sum += A[j];
                cnt++;
                if (sub_sum == sum/i) {
                    sub_sum = 0;
                    cnt--;
                } else if (sub_sum > sum/i) {
                    isPossible = false;
                    break;
                }

            } if (sub_sum != 0) {
                isPossible = false;
            }

            if (isPossible) {
                ans = min(ans, cnt);
            }
        }

        // Control : Output
        cout << ans << endl;
    }
}

// Helper Functions
/* None */
