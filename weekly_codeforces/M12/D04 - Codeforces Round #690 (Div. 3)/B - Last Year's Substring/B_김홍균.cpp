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
        int n; cin >> n;
        string s; cin >> s;

        // Process
        size_t pos1, pos2;

        bool isPossible = false;
        if (s.substr(0, 4) == "2020") {
            isPossible = true;
        } else if (s.substr(0, 3) == "202" && s.substr(n-1, 1) == "0") {
            isPossible = true;
        } else if (s.substr(0, 2) == "20" && s.substr(n-2, 2) == "20") {
            isPossible = true;
        } else if (s.substr(0, 1) == "2" && s.substr(n-3, 3) == "020") {
            isPossible = true;
        } else if (s.substr(n-4, 4) == "2020") {
            isPossible = true;
        }

        // Control : Output
        cout << ((isPossible) ? "YES" : "NO") << endl;
    }
}

// Helper Functions
/* None */
