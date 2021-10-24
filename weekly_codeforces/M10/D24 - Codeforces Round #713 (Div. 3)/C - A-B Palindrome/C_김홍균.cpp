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
        int A, B;
        cin >> A >> B;
        string S; cin >> S;

        // Process
        int L = (int)S.length();
        int RA = A, RB = B, RQ = 0;
        for (int i=0; i<L; i++) {
            if (S[i] == '0') RA--;
            if (S[i] == '1') RB--;
            if (S[i] == '?') RQ++;
        }

        bool isPossible = (A+B == L) && (RA >= 0) && (RB >= 0) && (RA+RB == RQ);

        if (isPossible) {
            for (int i=0; i<L/2; i++) {
                int j = (L-1) - i;
                if (S[i] == '0' && S[j] == '1') {
                    isPossible = false;
                    break;
                } else if (S[i] == '1' && S[j] == '0') {
                    isPossible = false;
                    break;
                }
            }
        }

        if (isPossible) {
            for (int i=0; i<L/2; i++) {
                int j = (L-1) - i;
                if (S[i] == '?' && S[j] == '?') continue;

                if (S[i] == '?') {
                    if (S[j] == '0') {
                        if (RA >= 1) {
                            S[i] = '0'; RA--;
                        } else {
                            isPossible = false;
                            break;
                        }
                    } else if (S[j] == '1') {
                        if (RB >= 1) {
                            S[i] = '1'; RB--;
                        } else {
                            isPossible = false;
                            break;
                        }
                    }

                } else if (S[j] == '?') {
                    if (S[i] == '0') {
                        if (RA >= 1) {
                            S[j] = '0'; RA--;
                        } else {
                            isPossible = false;
                            break;
                        }
                    } else if (S[i] == '1') {
                        if (RB >= 1) {
                            S[j] = '1'; RB--;
                        } else {
                            isPossible = false;
                            break;
                        }
                    }
                }
            }
        }

        if (isPossible) {
            for (int i=0; i<L/2; i++) {
                int j = (L-1) - i;
                if (S[i] == '?' && S[j] == '?') {
                    if (RA >= 2) {
                        S[i] = S[j] = '0';
                        RA -= 2;
                    } else if (RB >= 2) {
                        S[i] = S[j] = '1';
                        RB -= 2;
                    } else {
                        isPossible = false;
                        break;
                    }
                }
            }
        }

        if (isPossible && (L%2 == 1)) {
            int i = L/2;
            if (S[i] == '?') {
                if (RA >= 1) {
                    S[i] = '0';
                    RA--;
                } else if (RB >= 1) {
                    S[i] = '1';
                    RB--;
                } else {
                    isPossible = false;
                    break;
                }
            }
        }

        // Control : Output
        cout << ((isPossible) ? S : "-1") << endl;
    }
}

// Helper Functions
/* None */
