package backtracking;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		int n = 6;
		ArrayList<Integer> lista = new ArrayList<Integer>();
		//combinacionesSuma(n, lista, 0);
		
		int[] herencia = {1,1,1,2,2,2,1,1,1,2,2,2};
		//hayRepartoEquitativo(herencia);
		
		int[] subconjuntos = {4,2,5,5,1,8};
		int objetivoSuma = 10;
		System.out.println("Existen 2 subconjuntos: " + dosSubconjuntos(subconjuntos, objetivoSuma));
		
		dados(3);
		
		int[] suma0max = {0,-5,5,12,9,-3,6,5};
		
		for (int i = 0; i < subcSuma(suma0max).length; i++) {
			System.out.println(i + " " + subcSuma(suma0max)[i]);
		}
		
	}
	
	/**
	 * Ejercicio 1 DDR
	 * Sacar todas las posibles combinaciones para sumar un número
	 */
	public static void combinacionesSuma(int n, ArrayList<Integer> lista, int suma) {
		if (n==suma) {
			System.out.println(lista);
		} else {
			for(int i=1;i <= n;i++) {
				suma += i;
				if(suma <= n) {
					lista.add(i);
					combinacionesSuma(n, lista, suma);
					//realizamos la vuelta atrás
					lista.remove(lista.indexOf(i));
				}
				suma -= i;
			}
		}
	}
	
	public static boolean hayRepartoEquitativo(int[] bienes) {
		int suma = 0;
		//Recorremos los bienes para ver la suma total
		for (int i = 0; i < bienes.length; i++) suma+=bienes[i];
		if(suma%3==0) {
			System.out.println("La suma de los bienes es buena.");
			int intentos=0;
			boolean exito = false; //Variable para saber si ha habido éxito
			int[] falta = {suma/3,suma/3,suma/3}; //Variable que contiene la suma restante de un heredero
			hayRepartoEquitativo(bienes,falta,exito,0);
			return exito;
		}else
			return false;
	}
	
	public static void hayRepartoEquitativo(int[] bienes, int[] falta, boolean exito, int obj) {
		/*
		 * Si el objeto es igual a la longitud del vector entonces nos hemos
		 * gastado todos los objetos disponibles.
		 * Procedemos a comprobar si ha sido equitativo.
		 */
		if(obj == bienes.length) {
			if(falta[0] == falta[1] && falta[1] == falta[2]) 
			{ 
				exito = true;
			}
		}else {
			//Numero de herederos
			int c = 0;
			while(c<=2 && !exito) {
				/*
				 * Si el bien siguiente es menor que la cantidad que le queda
				 * por recibir al heredero C entonces se le atribuye a él
				 */
				if(bienes[obj] <= falta[c]) {
					falta[c] -= bienes[obj];
					obj++;
					hayRepartoEquitativo(bienes, falta, exito, obj);
					//Realizamos la vuelta atrás
					if(!exito) {
						//Restamos un objeto
						obj--;
						//Sumamos el bien a cantidad
						falta[c] += bienes[obj];
					}
				}
				//Siguiente heredero
				c++;
			}
		}
	}

	static void hayRepartoEquitativoAux(int[] bienes, int[] falta, int obj, boolean exito){ 
	    if (obj==bienes.length){ 
	        if (falta[0]==falta[1] && falta[1]==falta[2]) exito=true; 
	    } 
	    else{ 
	        int c=0; 
	        while ((c<3) && !exito){ 
	            if (bienes[obj]<=falta[c]) { //podemos asignarle el bien al heredero k. 
	                falta[c] = falta[c] - bienes[obj]; 
	                obj++; 
	                hayRepartoEquitativoAux(bienes, falta, obj,exito); 
	                if (!exito) { 
	                    obj--; 
	                    falta[c] = falta[c] + bienes[obj]; 
	                } 
	            } 
	            c++; 
	        } 
	    } 
	 
	}

	static boolean dosSubconjuntos(int[] v, int vObjetivo) {
		boolean exito=false; 
	    int total=0; 
	    for (int i=0; i<v.length; i++) total=total+v[i]; 
	    if ((total/2)>=vObjetivo) 
	        dosSubconjuntosAux(v, vObjetivo, exito, 0, 0, 0); 
	    return exito; 
	}

	private static void dosSubconjuntosAux(int[] v, int vObjetivo, boolean exito, int acumA, int acumB, int obj) {
		if ((acumA==vObjetivo) && (acumB==vObjetivo)) {
			System.out.println("True");
			exito=true;
		} 
	    else if (obj<v.length){ 
			int c=0; 
	        while (c<3 && !exito){ 
	            if (c==0 || ((c==1) && acumA+v[obj] <=vObjetivo) || ((c==2) && acumB+v[obj] <=vObjetivo)){ 
	                if (c==1)   acumA = acumA + v[obj]; 
	                else if (c==2)   acumB = acumB + v[obj]; 
	                obj++;
	                dosSubconjuntosAux(v, vObjetivo, exito, acumA, acumB, obj); 
	                if (!exito){ 
	                    obj--; 
	                    if (c==1)   acumA = acumA - v[obj]; 
	                    else if (c==2)   acumB = acumB - v[obj]; 
	                } 
	            } 
	            c++; 
	        } 
		}
	}
	
	private static void dados(int valor){
		ArrayList<int[]> combinaciones = new ArrayList<int[]>();
		int [] dados_v= {1,1,1};
		if(valor <= 6*3) {
			dadosAux(valor,dados_v, 0, 0);
		}
		
	}
	
	private static void dadosAux(int valor, int[] dados, int tirada, int suma) {
		if(suma >= valor && tirada==dados.length) {
			System.out.println(dados[0] +" + "+ dados[1]+" + " + dados[2] + " = " + suma);
		}else if(tirada != dados.length){
			for (int i = 1; i <= 6; i++) {
				dados[tirada] = i;
				suma += i;
				dadosAux(valor, dados, tirada+1, suma);
				suma -=i;
			}
		}
	}
	
	static boolean[] subcSuma(int[]v) {
		boolean[] res = new boolean[v.length];
		ArrayList<Integer> posiciones = new ArrayList<Integer>();
		subcSumaAux(v, res, posiciones, 0, 0);
		return res;
	}
	
	static void subcSumaAux(int[] v,boolean[]res,ArrayList<Integer> posiciones,int suma,int posicion) {
		if(suma==0 && posicion !=0) {
			System.out.println(posiciones);
			int n_resultado = 0;
			for (int i = 0; i < res.length; i++) 
				if(res[i])
					n_resultado++;
			if(n_resultado<posiciones.size()) {
				for (int i = 0; i < res.length; i++) 
					res[i]=false;
				for(Integer e : posiciones) {
					res[e]=true;
				}
			}
		}else if(posicion!=v.length) {
			for(int i=posicion+1;i<v.length;i++) {
				suma += v[i];
				
				posiciones.add(i);
				subcSumaAux(v, res, posiciones, suma, posicion+1);
				posiciones.remove(posiciones.indexOf(i));
				suma -= v[i];
			}
		}
	}
}













