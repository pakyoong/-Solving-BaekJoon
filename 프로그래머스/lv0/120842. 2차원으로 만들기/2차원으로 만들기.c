#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int** solution(int num_list[], size_t num_list_len, int n) {
    int x = 0, y = 0;
    int row = num_list_len/n;

    int** answer = (int**)malloc(sizeof(int*)*row);

    for(int i=0;i<row;i++)
        answer[i] = (int *)malloc(sizeof(int)*n);

    for(int i=0;i<num_list_len;i++){
        answer[x][y++] = num_list[i];
        if(y==n){
            y=0;
            x++;
        }
    }

    return answer;
}