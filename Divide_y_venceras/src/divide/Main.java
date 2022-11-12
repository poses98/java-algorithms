package divide;

public class Main {

	public static void main(String[] args) {
		//EJERCICIO 1
		int[] arrayEjercicio1 = {-1,0,2,3,10,12,-23,-14,-7};
		System.out.println("Ejercicio 1: " + Ejercicios_divide_y_venceras.sumaPositivos(arrayEjercicio1));
		
		
		//EJERCICIO 2
		int [] arrayEjercicio2 = {1,1,4,5,5,6,6,7,7};
		System.out.println("Ejercicio 2: " + Ejercicios_divide_y_venceras.numeroSolitario(arrayEjercicio2));
		
		//EJERCICIO 3
		int[] arrayEjercicio3 = {-10,-2,0,2,3,5,19,28,30,42,55};
		System.out.println("Ejercicio 3: " + Ejercicios_divide_y_venceras.elementoEspecial(arrayEjercicio3));
		
		//EJERCICIO 4
		int[] arrayAEjercicio4 = {-5,-2,-9,-4,1,5,7,0,-3};
		int[] arrayBEjercicio4 = {8,-1,2,4,2,-2,1,0,1};
		System.out.println("Ejercio 4: " + Ejercicios_divide_y_venceras.check2pos(arrayAEjercicio4, arrayBEjercicio4, 5));
		
		//Suma en array
		int[] arrSuma = {2,3,4};
		System.out.println("Suma en array:" + Ejercicios_divide_y_venceras.sumaEnArray(arrSuma));
		
		//Multiplicacion en array
		int[] arrMult = {2,3,4};
		System.out.println("Multiplicación en array:" + Ejercicios_divide_y_venceras.multiplicacionEnArray(arrMult));
		
		//Son iguales
		int[] arr1 = {2,3,4,5,6,7,8,9,5,2,4,5,67,7};
		int[] arr2 = {2,3,4,5,6,7,8,9,5,2,2,5,67,7};
		System.out.println("Son iguales: " + Ejercicios_divide_y_venceras.sonIguales(arr1, arr2));
		
		//Minimo y maximo en un vector
		System.out.printf("El más grande es %d\nElm más pequeño es:%d\n",Ejercicios_divide_y_venceras.minMax(arrayEjercicio3)[1],Ejercicios_divide_y_venceras.minMax(arrayEjercicio3)[0]);
		
		//Array colina
		int[] arrColina = {5,7,8,9,14,16,17,19,20,25,56,78};
		System.out.println("El índice en array colina es: " + Ejercicios_divide_y_venceras.maximoColina(arrColina));
		
		// Junio 2021      0 1 2 3 4 5 6 7 8  9 10 11 12 13
		int[] arrJunio1 = {2,3,4,5,6,7,8,9,10,2,4, 5, 7, 9};
		int[] arrJunio2 = {2,3,4,5,6,7,8,9,5, 2,2, 5, 67,7};
		System.out.println("Los arrays son diferentes a partir de la posición: " + Ejercicios_divide_y_venceras.ejDyVsept(arrJunio1, arrJunio2));
		
		// Noviembre 2018
		int[] noviembre2018 = {10,15,23,32,1,2,3,6,7};
		System.out.println("El menor en el array rotado es: " + Ejercicios_divide_y_venceras.minArrayRotado(noviembre2018));
		
	}

}
