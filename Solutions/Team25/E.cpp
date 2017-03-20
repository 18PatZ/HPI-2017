#include <iostream>
#include <algorithm>
using namespace std;
int v[1000];
int w[1000];
int knap[5001];
int main()
{
    int n, s;
    cin >> n >> s;
    for (int i=0; i<n; i++)
    {
        cin >> w[i] >> v[i];
    }
    knap[0]=1;
    for (int i=0; i<n; i++)
    {
        for (int j=s; j>=0; j--)
        {
            if (j<w[i])
                break;
            if (knap[j-w[i]]!=0)
                knap[j]=max(knap[j], knap[j-w[i]]+v[i]);
        }
    }
    int ans=0;
    for (int i=0; i<=s; i++)
        ans=max(ans, knap[i]);
    cout << ans-1 << endl;
}