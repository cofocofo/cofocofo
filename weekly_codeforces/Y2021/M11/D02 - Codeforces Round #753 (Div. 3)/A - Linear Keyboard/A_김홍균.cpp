//
//  CodeForces
//  ver.C++
//
//  Created by GGlifer
//
//  Open Source

#include <iostream>
#include <map>

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

    cin.ignore();
    while (t--) {
        string keyboard; cin >> keyboard;
        string word; cin >> word;

        // Process
        map<char,int> M;
        for (int i=0; i<len(keyboard); i++) {
            M[keyboard[i]] = i;
        }

        int ans = 0;
        for (int i=1; i<len(word); i++) {
            ans += abs(M[word[i]] - M[word[i-1]]);
        }

        // Control : Output
        cout << ans << endl;
    }
}

// Helper Functions
/* None */
