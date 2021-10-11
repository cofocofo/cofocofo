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

    while (TC--) {
        string S; cin >> S;

        // Process
        deque<char> D(S.begin(), S.end());
        bool isAlphabetical = true;
        char c = max(D[0], D[D.size()-1]); /* Find max alpha */
        while (not(D.empty())) {
            if (D.front() == c) { /* Current max alpha locates front */
                D.pop_front();
            } else if (D.back() == c) { /* Current max alpha locates back */
                D.pop_back();
            } else { /* Can't find max alpha */
                isAlphabetical = false;
                break;
            } c--;
        } if (c >= 'a') { /* Alphabetical string must use all alpha */
            isAlphabetical = false;
        }

        // Control : Output
        cout << ((isAlphabetical) ? "YES" : "NO") << endl;
    }
}

// Helper Functions
/* None */