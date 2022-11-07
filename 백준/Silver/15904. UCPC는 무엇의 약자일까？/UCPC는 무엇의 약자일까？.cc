#include<iostream>
#include<string>
using namespace std;
int main(){
	string target= "UCPC";
	string s;
	getline(cin,s);
	int j =0;
	for(int i =0;i<s.size();i++){
		if(s[i]==target[j]) j++;	
		else continue;
	}
	if(j==4){
		cout<<"I love UCPC";
	}else{
		cout<<"I hate UCPC";
	}
	cout<<'\n';
}