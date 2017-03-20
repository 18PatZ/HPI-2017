#include <iostream>
using namespace std;
int b, n, m;
int val[15];
bool used[15];
bool dp[51][51][32768];
/*bool rec(int i, int j)
{
    for (int k=0; k<b; k++)
    {

    }
}*/
int main()
{
    cin >> b;
    cin >> n >> m;
    for (int i=0; i<b; i++)
        cin >> val[i];
    dp[n][m][0]=true;
    for (int i=0; i<=50; i++)
        for (int j=0; j<=50; j++)
            for (int k=0; k<=(1<<b)-1; k++)
        {
            for (int l=0; l>=b; l++)
            {
                if (((k>>l)%2)==0)
                {
                    if (val[l]%n==0)
                        dp[n][m-val[l]/n][k+(1<<l)]=true;
                    if (val[l]%m==0)
                        dp[n-val[l]/m][m][k+(1<<l)]=true;
                }
            }
        }
    if (dp[0][0][(1<<b)-1])
        cout << "no" << endl;
    else
        cout << "yes" << endl;

}