#include <stdio.h>
long F(long num);
int main(int argc, char * argv[])
{
	printf("Fibonacci Nums.\n");
	long x = 30;
	printf("%ld\n",F(x));
	for(int i = 0; i <= x; i++)
	{
		if(i != x)
			printf("%ld, ", F(i));
		else
			printf("%ld\n", F(i));
	}
	return 0;
}

long F(long x)
{
	if(x == 0)
		return 0;
	else if(x == 1)
		return 1;
	else
		return F(x-1) + F(x-2);
}