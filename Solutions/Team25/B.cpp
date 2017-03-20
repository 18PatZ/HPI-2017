#include <iostream>
using namespace std;
bool knap[100000];
int n;
int main()
{
    int a;
    int s;
    cin >> s;
    cin >> n;
    knap[0]=true;
    for (int i=0; i<n; i++)
    {
        cin >> a;
        for (int j=s; j>=a; j--)
        {
            if (knap[j-a])
                knap[j]=true;
        }
    }
    for (int i=s; i>=0; i--)
    {
        if (knap[i])
        {
            cout << i << endl;
            return 0;
        }
    }
}