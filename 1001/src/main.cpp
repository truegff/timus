#include <cstdio>
#include <cmath>
#include <cstdlib>

void main()
{
	int i = 0;
	int k;
	double b;
	double *a = (double*)malloc(sizeof(double)*1000000);
	while(scanf("%lf",&b) != EOF)
	{
		a[i] = sqrt(b);
		i++;
	}
	for(k = i - 1;k >= 0; k--)
	{
		printf("%.4lf\n",a[k]);
	}
} 
