//
//  CodeForces
//  ver.C++
//
//  Created by GGlifer
//
//  Open Source

#include <iostream>
#include <set>
#include <algorithm>
#include <vector>

using namespace std;

#define endl '\n'

// Set up : Global Variables
/* None */

// Set up : Functions Declaration
string getResult(string A, string O);


int main()
{
    // Set up : I/O
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    // Set up : Input
    int TC; cin >> TC;

    while (TC--) {
        string T; cin >> T;

        // Process
        set<char> S;
        string R(T.rbegin(), T.rend());
        string O;
        for (char c : R) {
            if (S.find(c) == S.end()) {
                S.insert(c);
                O += c;
            }
        } reverse(O.begin(), O.end());

        vector<int> C[26];
        for (int i=0; i<T.length(); i++) {
            C[T[i]-'a'].push_back(i);
        }


        bool isPossible = true;
        for (int i=0; i<O.length(); i++) {
            if (C[O[i]-'a'].size() % (i+1) != 0) {
                isPossible = false;
                break;
            }
        }

        int idx = -1;
        for (int i=0; i<O.length(); i++) {
            char c = O[i]-'a';
            int val = C[c].size() / (i+1);
            idx = max(idx, C[c][val-1]);
        }

        string A = T.substr(0, idx+1);

        string res = getResult(A, O);
        if (isPossible) {
            isPossible = (T == res);
        }

        // Control : Output
        if (isPossible)
            cout << A << ' ' << O << endl;
        else
            cout << -1 << endl;
    }
}

// Helper Functions
string getResult(string A, string O)
{
    string ret;

    for (char o : O) {
        ret += A;
        A.erase(remove(A.begin(), A.end(), o), A.end());
    }

    return ret;
}