#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
int solution(const char* s) {
    int answer = 0;
    int data[1000]={0,};
    int cnt=0;
    int tmp=0;
    int flag=0;
    int old=0;
    for(int i=0;i<strlen(s);i++)
    {
        if(s[i]=='-')
        {
            i++;
            while(s[i]>='0' && s[i]<='9')
             {
                tmp*=10;
                tmp+=s[i]-'0';
                i++;
            }
            tmp*=-1;
            data[cnt++]=tmp;
            tmp=0;
        }
        if(s[i]>='0' && s[i]<='9')
        {
            tmp+=s[i]-'0';
            i++;
            while(s[i]>='0' && s[i]<='9')
            {
                tmp*=10;
                tmp+=s[i]-'0';
                i++;
            }
            data[cnt++]=tmp;
            tmp=0;
        }
        if(s[i]=='Z')
        {
            data[--cnt]=0;
        }

    }
    for(int i=0;i<cnt;i++)
    {
        answer+=data[i];
    }
    return answer;
}
