#include <iostream>
using namespace std;

int main()
{
	int ngroup, 
		groups[101], 
		minSum=0, 
		tmp, 
		reqGroup;

	// +information input
	cin >> ngroup;
	for (int c=0; c<ngroup; ++c)
	{
		cin >> groups[c];
	}
	// -information input

	// +information sort
	if (ngroup>1) 
	{
		for (int c=1; c<ngroup; ++c)
		{
			if (groups[c]<groups[c-1]) 
			{
				tmp=groups[c];
				groups[c]=groups[c-1];
				groups[c-1]=tmp;
			};

			for (int v=c; v>0; --v)
			{
				if (groups[v]<groups[v-1]) 
				{
					tmp=groups[v];
					groups[v]=groups[v-1];
					groups[v-1]=tmp;
				};
			}
		}
	}
	// +information sort
	
	reqGroup=(ngroup-1)/2+1; //finding required amout of groups voted FOR the party

	for (int c=0; c<reqGroup; ++c)
	{
		minSum+=(groups[c]-1)/2+1;
	}

	cout << minSum;
}
