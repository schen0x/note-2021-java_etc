#include <stdio.h>
void swap(int v[], int i, int j);
void qsort(int v[], int left, int right);
/* qsort: sort v[left]...v[right] into increasing order */
void qsort(int v[], int left, int right)
{
    int i, last;
    // you can declare a function inside a function 
    // implicit declaration if not declared.
    void swap(int v[], int i, int j);
    if (left >= right) /* do nothing if array contains */
        return;
    /* fewer than two elements */
    swap(v, left, (left + right) / 2); /* move partition elem */
    last = left;
    /* to v[0] */
    for (i = left + 1; i <= right; i++) /* partition */
        if (v[i] < v[left])
            swap(v, ++last, i);
    swap(v, left, last);
    /* restore partition elem */
    qsort(v, left, last - 1);
    qsort(v, last + 1, right);
}
/* swap: interchange v[i] and v[j] */
void swap(int v[], int i, int j)
{
    int temp;
    temp = v[i];
    v[i] = v[j];
    v[j] = temp;
}
int main(int argc, char const *argv[])
{
    int intA[] = {1, 7, 2, 4, 0, 9, 3};
    qsort(intA, 0, 6);

    for (int i = 0; i < (sizeof(intA) / sizeof(intA[0])); i++)
    {
        int j = intA[i];
        printf("%d", j);
    }
    return 0;
}
