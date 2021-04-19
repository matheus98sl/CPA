#include <iostream>
#include <stdlib.h>
#include <string.h>
#define TAM 2



using namespace std;

struct Registro {
	char nome[30];
	int quantidade;
	float precoUnitario;
	float precoTotal;	
};

struct Registro rege[TAM];


int main() {
	
	float total;
	
	//Alocação estatica
	for( int c = 0; c < TAM ; c++ ){
		
	
	cout << "Digite o nome do produto: " << endl;
	cin >> rege[c].nome;
	
	cout << "Digite a quantidade: " << endl;
	cin >> rege[c].quantidade;
	
	cout << "Digite o valor unitario: " << endl;
	cin >> rege[c].precoUnitario;
		
		
	total += rege[c].precoUnitario * rege[c].quantidade;
	
	}
	
	
	
		
	cout << endl << "Alocacao Estatica";
	for ( int a = 0; a < TAM ; a++ ){
		cout << endl << "Produto [" << a <<"]: " << "Nome: " << rege[a].nome << " \tQuantidade: " << rege[a].quantidade << " \tPreco: " << rege[a].precoUnitario;
	}
	cout << "Preco total: " << total << endl;
	
	
	
	//Alocação dinâmica
	struct Registro* regd;
	regd = (struct Registro*)malloc(TAM*sizeof(struct Registro*));
	
	if ( regd != NULL ){
		
	cout << "Digite seu nome: " << endl;
	cin >> (regd)->nome;
	
	cout << "Digite a quantidade: " << endl;
	cin >> (regd)->quantidade;
	
	cout << "Digite o valor unitario: " << endl;
	cin >> (regd)->precoUnitario;
	
	cout << endl << "Alocacao Estatica";
	
	for ( int b = 0; b < TAM ; b++ ){
		cout << endl << "Nome: " << (regd+b)->nome << " Quantidade: " << (regd+b)->quantidade << " Preco: " << (regd+b)->precoUnitario << "\n";
	}
	
	
	}
	
	
	
	return 0;
}
