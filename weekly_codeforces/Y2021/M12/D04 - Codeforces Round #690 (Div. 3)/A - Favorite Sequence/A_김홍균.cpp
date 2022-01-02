//
//  CodeForces
//  ver.C++
//
//  Created by GGlifer
//
//  Open Source

#include <iostream>
#include <deque>

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
        deque<int> B;
        for (int i=0; i<n; i++) {
            int b; cin >> b;
            B.push_back(b);
        }

        // Process
        deque<int> A;

        while (true) {
            if (not(B.empty())) {
                A.push_back(B.front());
                B.pop_front();
            } if (B.empty()) break;

            if (not(B.empty())) {
                A.push_back(B.back());
                B.pop_back();
            } if (B.empty()) break;
        }

        // Control : Output
        for (int a : A) {
            cout << a << ' ';
        } cout << endl;
    }
}

// Helper Functions
/* None */
