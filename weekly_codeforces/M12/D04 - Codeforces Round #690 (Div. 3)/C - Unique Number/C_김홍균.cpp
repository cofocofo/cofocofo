//
//  CodeForces
//  ver.C++
//
//  Created by GGlifer
//
//  Open Source

#include <iostream>
#include <queue>

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
        queue<int> que;
        for (int i=1; i<=9; i++) {
            que.push(i);
        }

        int ans = -1;
        bool isFound = false;
        while (not(que.empty())) {
            int c = que.front(); que.pop();

            int temp = c, sum = 0;
            while (temp) {
                sum += (temp % 10);
                temp /= 10;
            } if (sum == x) {
                ans = c;
                break;
            }

            for (int i=c%10+1; i<=9; i++) {
                que.push(10*c + i);
            }
        }

        // Control : Output
        cout << ans << endl;
    }
}

// Helper Functions
/* None */
