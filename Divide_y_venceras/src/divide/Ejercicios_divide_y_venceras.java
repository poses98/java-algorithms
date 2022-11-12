package divide;

public class Ejercicios_divide_y_venceras {
	
	/**
	 * Ejercicio 1
	 * @param arr - array en el que sumar los positivos
	 * @return int -  suma de los números positivos
	 */
	public static int sumaPositivos (int[] arr) {
		return sumaPositivosAux(arr, 0, arr.length-1);
	}
	private static int sumaPositivosAux (int[] arr, int i0, int iN) {
		if(i0 == iN) {
			//Si el número es mayor que 0 lo devolvemos, sino devolvemos 0
			if(arr[i0]>0) {
				return arr[i0];
			}else {
				return 0;
			}
		}else {
			//Sacamos la mitad del array para dividirlo nuevamente
			int k = (i0+iN)/2;
			//Primera mitad del array
			int s1= sumaPositivosAux(arr, i0, k);
			//Segunda mitad del array
			int s2= sumaPositivosAux(arr, k + 1 , iN);
			
			return s1 + s2;
		}		
	}
	
	/**
	 * Ejercicio 2
	 */
	public static int numeroSolitario(int[] arr) {
		return numeroSolitarioAux(arr, 0, arr.length - 1);
	}
	private static int numeroSolitarioAux(int[] arr, int i0, int iN) {
		if(i0 == iN) {
			return arr[i0];
		}else {
			//Separamos en 2 la longitud del array
			int k = (i0 + iN) / 2;
			
			if(arr[k - 1] == arr[k]) {
				//Se encuentra en [i0..k-2] o en [k+1..iN] 
				if((i0 + 1) + (k - 2) % 2 == 0) {
					return numeroSolitarioAux(arr, k + 1, iN);
				}else {
					return numeroSolitarioAux(arr, i0, k - 1);
				}
			}else if(arr[k] == arr[k + 1]) {
				//Se encuentra en [i0..k+1] o en [k+2..iN]
				if((i0 + 1) + (k + 1) % 2 == 0) {
					return numeroSolitarioAux(arr, k + 2, iN);
				}else {
					return numeroSolitarioAux(arr, i0, k + 1);
				}
			}else {
				return arr[k];	
			}
		}		
	}

	/**
	 * Ejercicio 3
	 */
	public static int elementoEspecial(int[] arr) {
		return elementoEspecialAux(arr,0,arr.length-1);
	}
	private static int elementoEspecialAux(int[] arr, int i0, int iN) {
		if(i0==iN) {
			if(arr[i0] == i0) 
				return arr[i0];
			else 
				return 0;
		}else {
			int k = (i0 + iN) / 2;
			
			if(arr[k] > k) {
				return elementoEspecialAux(arr, i0, k-1);
			}else if(arr[k] == k){
				return k;
			}else {
				return elementoEspecialAux(arr, k+1, iN);

			}
		}
	}

	/**
	 * Ejercicio 4
	 */
	public static int[] check2pos(int[] arr_A,int[] arr_B, int v) {
		  return check2posAux(arr_A, arr_B, v,0,0,arr_A.length-1,arr_B.length-1);
	}
	private static int[] check2posAux(int[] arr_A,int[] arr_B, int v,int iA0, int iB0, int iAN, int iBN) {
		
		
		return null;
		
	}

	/**
	 * Suma elementos array
	 */
	public static int sumaEnArray(int[] v) {
		return sumaEnArrayAux(v,0,v.length-1);
	}
	private static int sumaEnArrayAux(int[] v, int i0, int iN) {
		if(i0==iN) {
			return v[i0];
		}else {
			//[i0..k..iN] Dividimos
			int k = (i0 + iN)/2;
			//[i0..k]
			int s1 = sumaEnArrayAux(v, i0, k);
			//[k+1..iN]
			int s2 = sumaEnArrayAux(v, k+1, iN);
			return s1 + s2;
		}
		
	}
	
	/**
	 * Suma elementos array
	 */
	public static int multiplicacionEnArray(int[] v) {
		return multiplicacionEnArrayAux(v,0,v.length-1);
	}
	private static int multiplicacionEnArrayAux(int[] v, int i0, int iN) {
		if(i0==iN) {
			return v[i0];
		}else {
			//[i0..k..iN] Dividimos
			int k = (i0 + iN)/2;
			//[i0..k]
			int s1 = multiplicacionEnArrayAux(v, i0, k);
			//[k+1..iN]
			int s2 = multiplicacionEnArrayAux(v, k+1, iN);
			return s1 * s2;
		}
	}
	
	/**
	 * Iguales
	 */
	public static boolean sonIguales(int[] v1, int[] v2) {
		if(v1.length != v2.length) return false;
		return sonIgualesAux(v1, v2,0,v1.length-1);
	}
	public static boolean sonIgualesAux(int[] v1, int[] v2, int i0, int iN) {
		if(i0 == iN) {
			return v1[i0] == v2[i0];
		}else {
			int k = (iN+i0)/2;
			// [i0..k] && [k+1,iN]
			return sonIgualesAux(v1, v2, i0, k) && sonIgualesAux(v1, v2, k+1, iN);	
		}
	}
	
	/**
	 * Maximo y minimo de un vector
	 * @param v - vector 
	 * @return int[] - min y max respectivamente
	 */
	public static int[] minMax(int[] v) {
		return minMaxAux(v,0,v.length-1);
	}
	private static int[] minMaxAux(int[] v, int i0, int iN) {
		if(iN - i0 <= 1) {
			int[] minMax = new int[2];
			//Guardamos el pequeño en [0]
			minMax[0] = v[i0];
			minMax[1] = v[iN];
			
			if(minMax[0] > minMax[1]) {
				int aux = minMax[0];
				minMax[0]=minMax[1];
				minMax[1]=aux;
			}
			//Devolvemos el array ordenado
			return minMax;
		} else {
			//Dividimos
			int k = (iN+i0)/2;
			//Conquistamos
			//Arr [i0..k]
			int[] x = minMaxAux(v,i0,k);
			//Arr [k+1..iN]
			int[] y = minMaxAux(v,k+1,iN);
			
			//Combinamos
			//Cogemos los números +xikis +grandes
			if(x[0] > y[0]) {
				x[0] = y[0];
			}
			if(x[1] < y[1]) {
				x[1]=y[1];
			}
			
			return x;
		}
	}

	/**
	 * Array tipo colmena [DICIEMBRE 2020]
	 */
	public static int maximoColina(int[]v) {
		return maximoColinaAux(v,0,v.length-1); //O(T(n/2) + O(1) = O(log N)
	}
	private static int maximoColinaAux(int[] v, int i0, int iN) {
		if(i0==iN)
			return v[i0];								//O(1)
		else {
			//Dividimos el array
			int k = (iN+i0)/2;							//O(1)
			
			//Consquistamos y combinamos
			if(v[k] > v[k-1] && v[k] > v[k+1]){
				//Caso base, devolvemos el índice	
				return v[k];							//O(1)
			}else if(v[k-1] < v[k] && v[k] < v[k+1]){
				//Se encuentra en [k+1..iN]
				return maximoColinaAux(v,k+1,iN);  		//O(T(N/2))
			}else {
				//Se encuentra en [k+1..iN]
				return maximoColinaAux(v,i0,k);			//O(T(N/2))
			}
		}
	}

	/**
	 * Arrays idénticos hasta una posición [JUNIO 2021]
	 * 
	 * Complejidad:
	 * 
	 * Tenemos que la complejidad del algoritmo es:
	 * 
	 * Si N = 1 (un único elemento) -> O(1)
	 * Si N > 1 -> O(T(N/2))
	 * 
	 * Aplicando el Teorema Maestro tenemos que la complejidad es
	 * de O(log n) debido al segundo caso ya que:
	 * 
	 * log en base 2 de 1 ln 1 = 0 = O(1)
	 */
	public static int ejDyVsept(int[] v1, int[] v2) {
		return ejDyVSeptAux(v1,v2,0,v1.length-1);
	}
	private static int ejDyVSeptAux(int[] v1, int[] v2, int i0, int iN) {
		if(i0 == iN) {
			return v1[i0] != v2[i0] ? i0 : -1;
		}else {
			int k = (i0 + iN)/2;
			if(v1[k]==v2[k]) {
				return ejDyVSeptAux(v1, v2, k+1, iN);
			}else {
				return ejDyVSeptAux(v1, v2, i0, k);
			}
		}
		
	}

	/**
	 * Array rotado encontrar mínimo [NOVIEMBRE 2018]
	 */
	public static int minArrayRotado(int[] v) {
		return minArrayRotadoAux(v,0,v.length-1);
	}
	private static int minArrayRotadoAux(int[] v, int i0, int iN) {
		if(i0==iN) {
			return v[i0];
		}else {
			int k = (i0+iN)/2;
			
			if(v[i0] <= v[k] && v[k] < v[iN]) {
				return v[i0];
			}else if(v[i0] > v[k]) {
				return minArrayRotadoAux(v, i0, k);
			}else {
				return minArrayRotadoAux(v, k+1, iN);

			}
		}
	}
}
























