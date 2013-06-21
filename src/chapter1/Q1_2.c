#include <stdio.h>

void reverse(char* str);

void main(char argc, char** argv) {

char a[]="abcdesfgghfsc";

printf("before reverse: %s\n",a);
reverse(a);
printf("after reverse: %s\n", a);

}

void reverse(char* str){
	if(!str) return;
	char* end=str;
	while(*end){
		end++;
	}
	end--;

	char tmp;
	while(str<end){
		tmp=*str;
		*str++=*end;
		*end--=tmp;  
	}  	
}

