//
//  CodeForces
//  ver.C++
//
//  Created by GGlifer
//
//  Open Source

#include <iostream>
#include <algorithm>
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
        string S; cin >> S;

        // Process
        S.erase(unique(S.begin(), S.end()), S.end());  // 1223334444 -> 1234
        set<char> isDone;

        bool isSuspicious = false;
        for (char c : S) {
            if (isDone.find(c) != isDone.end()) {
                isSuspicious = true;
                break;
            } isDone.insert(c);
        }

        // Control : Output
        cout << ((isSuspicious) ? "NO" : "YES") << endl;
    }
}

// Helper Functions
/* None */