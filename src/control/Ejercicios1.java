package control;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import modelo.Intento;
import modelo.Persona;

public class Ejercicios1 {

	public int lanzarDado() {
		int valor = (int) (1 + Math.random() * 6);
		// System.out.println(valor);
		return valor;
	}

	public int[] lanzadas(int numLanzadas) {
		int[] resultado = new int[6];
		int numero;
		for (int i = 0; i < numLanzadas; i++) {
			numero = lanzarDado();
			resultado[(numero - 1)]++;
		}
		return resultado;
	}

	public void mostrarLanzadas(int[] datos, int cuantasLanzadas) {
		for (int i = 0; i < datos.length; i++) {
			/*
			 * System.out.println("El n�mero " + (i + 1) + " ha salido " +
			 * datos[i] + " veces (" + ((datos[i] * 100) / cuantasLanzadas) +
			 * "%).");
			 */
			System.out.printf("El n�mero %d aparece %d veces (%.2f)\n", (i + 1), datos[i],
					(float) (datos[i] * 100) / cuantasLanzadas);
		}
	}

	public void listaNPrimerosEnteros(int n) {
		for (int i = 0; i < n; i++)
			System.out.println(i + 1);

	}

	int h, m, s = 0;

	public void bucleReloj() {
		while (h < 24) { // bucle de las horas
			m = 0;

			while (m < 60) { // bucle de los minutos
				s = 0;

				while (s < 60) { // bucle de los segundos
					System.out.println(h + ":" + m + ":" + s);
					s++;
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				m++;
			}
			h++;
		}
	}

	public void bucleCronometro() {
		int h = 23;
		while (h > 0) { // bucle de las horas
			m = 59;

			while (m > 0) { // bucle de los minutos
				s = 59;

				while (s > 0) { // bucle de los segundos
					System.out.println(h + ":" + m + ":" + s);
					s--;
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				m--;
			}
			h--;
		}
	}

	public int sumaIntervalo(int menor, int mayor) {
		int acum = 0;
		for (int i = menor; i < mayor; i++) {
			acum += i;
		}
		return acum;
	}

	public void fibonacci(int n) {
		int a, b, c;
		a = 0;
		b = 1;

		/*
		 * for(int i = 0; i < n; i++){ c = a + b; System.out.println(c + ", ");
		 * a = b; b = c; }
		 */

		int i = 0;
		while (i < n) {
			c = a + b;
			System.out.print(c + ", ");
			a = b;
			b = c;
			i++;
		}
	}

	int fibonacciRecursivo(int n) {

		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			return fibonacciRecursivo(n - 1) + fibonacciRecursivo(n - 2);
		}
	}

	public int producto(int a, int b) {
		int resultado = 0;
		for (int i = 0; i < b; i++) {
			resultado = resultado + a;
		}
		return resultado;
	}

	public boolean esPrimo(int numero) {
		for (int i = 2; i < numero; i++) {
			if (numero % i == 0) {
				// System.out.println("El n�mero " + numero + " no es primo.");
				return false;
			}
		}
		// System.out.println("El n�mero " + numero + " es primo.");
		return true;
	}

	public void listaPrimos(int cuantos) {
		int candidato = 1;
		for (int contador = 0; contador < cuantos; contador++) {
			if (esPrimo(candidato))
				System.out.println(candidato);
			candidato++;
		}
	}

	public void creaListaPersonas() {
		Persona juan = new Persona("987654321Z", "Juan El Polla", 'M', new Date());
		Persona pepe = new Persona();
		Persona luisa = new Persona("666555999T", "Luisa La Verdulera", 'F', new Date());
		Persona[] listaPersonas = new Persona[20];
		listaPersonas[0] = juan;
		listaPersonas[1] = pepe;
		listaPersonas[2] = luisa;
		for (int i = 0; i < listaPersonas.length; i++) {
			try {
				// if (listaPersonas[i] != null)
				System.out.println(listaPersonas[i].getNombre());
			} catch (NullPointerException e) {
				// TODO Auto-generated catch block
				System.out.println("El objeto no es nulo.");
			}
		}
	}

	public void crearHebras(int cuantas) {
		for (int i = 0; i < cuantas; i++) {
			Thread hebra = new Hebra();
			hebra.setName("Hebra" + i);
			hebra.start();
		}
		/*
		 * hebra1.setName("hebra1"); hebra2.setName("hebra2"); hebra1.start();
		 * hebra2.start();
		 */
	}

	// Pr�ctica: Leer datos desde el teclado y convertir esa cadena en un entero

	public void adivinaNumero() {

		int[] intervalo = generarIntervalo();

		int numeroAleatorio = generaNumeroAleatorioEntre(intervalo[0], intervalo[1]);

		jugarAdivinaNumero(numeroAleatorio);
	}

	public int[] generarIntervalo() {
		Scanner teclado = new Scanner(System.in);
		boolean error1 = true;
		int min = 0;
		int max = 0;
		while (error1) {
			System.out.println("Teclee el intervalo (min/max)");
			String intervalo = teclado.nextLine();
			String[] limites = intervalo.split("/");
			if (limites.length != 2) {
				System.out.println("Teclee dos valores");
				continue;
			}
			try {
				min = Integer.parseInt(limites[0]);
				max = Integer.parseInt(limites[1]);
				if (min >= max) {
					System.out.println("El primer numero introducido ha de ser menor que el segundo.");
					continue;
				}
				error1 = false;
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				System.out.println("Los datos introducidos no son correctos");
				continue;
			}
		}
		System.out.println("Los n�meros son v�lidos.");
		int[] intervalo = new int[2];
		intervalo[0] = min;
		intervalo[1] = max;
		return intervalo;
	}

	public int generaNumeroAleatorioEntre(int min, int max) {
		return new Random().nextInt(max - min) + min;
	}

	public void jugarAdivinaNumero(int numeroAleatorio) {
		int contadorIntentos = 0;
		Intento[] intentos = new Intento[200];
		boolean jugando = true;
		do {
			// Validamos el n�mero aleatorio
			boolean error1 = true;
			int numeroObjetivo = 0;
			while (error1) {
				try {
					Scanner teclado = new Scanner(System.in);
					System.out.println("Teclee un n�mero entero � Q/q para salir.");
					String numeroTecleado = teclado.nextLine();

					if (numeroTecleado.compareToIgnoreCase("Q") == 0) {
						System.out.println("Fin de la partida. Hasta la pr�xima.");
						System.exit(0);
					}

					numeroObjetivo = Integer.parseInt(numeroTecleado);
					error1 = false;
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					System.out.println("N�mero incorrecto.");
				}
			}
			// Creamos el intento.
			Intento intento = new Intento(numeroObjetivo, new Date());
			// Guardamos el intento.
			intentos[contadorIntentos++] = intento;

			// Mostrar los intentos realizados hasta el momento.
			for (int i = 0; i < intentos.length; i++) {
				try {
					System.out.printf("%d, \t%d\t%s\n", i + 1, intentos[i].getNumero(), intentos[i].getFechaHora());
				} catch (NullPointerException e) {
					// TODO Auto-generated catch block
					break;
				}
			}

			// El n�mero tecleado es v�lido.

			if (numeroObjetivo < numeroAleatorio)
				System.out.println("Pruebe un n�mero mayor.");
			else if (numeroObjetivo > numeroAleatorio) {
				System.out.println("Pruebe un n�mero menor.");
			} else {
				System.out.println("Has acertado. Felicidades.");
				jugando = false;
			}

		} while (jugando);
	}

	public void ordenaListaCadenas(String[] lista) {
		for (int i = 0; i < lista.length - 1; i++) {
			for (int j = i + 1; j < lista.length; j++) {
				if (lista[i].compareTo(lista[j]) > 0) // hay que permutar
				{
					String aux = lista[i];
					lista[i] = lista[j];
					lista[j] = aux;
				}
			}
		}
	}

	public void ordenaListaNumeros(int[] lista) {
		for (int i = 0; i < lista.length - 1; i++) {
			for (int j = i + 1; j < lista.length; j++) {
				if (lista[i] > (lista[j])) // hay que permutar
				{
					int aux = lista[i];
					lista[i] = lista[j];
					lista[j] = aux;
				}
			}
		}
	}

	public boolean busquedaBinaria(int buscame, Integer[] numeros) {
		int min = 0;
		int max = numeros.length - 1;
		int medio;

		while (min <= max) {
			medio = min + ((max - min) / 2);
			if (numeros[medio] == buscame)
				return true;
			else if (numeros[medio] > buscame)
				max = medio - 1;
			else
				min = medio + 1;
		}
		return false;
	}

	public String ordenaCadena(String cadena) {
		char[] letras = cadena.toCharArray();
		Arrays.sort(letras);
		String cadenaOrdenada = new String(letras);
		return cadenaOrdenada;
	}

	public int[] mezclaArraysEnteros(int[] array1, int[] array2) {
		int[] arrayResultado = new int[array1.length + array2.length];
		int i = 0;
		int j = 0;
		int k = 0;

		while (k < arrayResultado.length) {
			try {
				if (array1[i] < array2[j]) {
					arrayResultado[k] = array1[i];
					i++;
				} else {
					arrayResultado[k] = array2[j];
					j++;
				}
				k++;
			} catch (ArrayIndexOutOfBoundsException e) {
				if (i >= array1.length) {
					array1[i - 1] = Integer.MAX_VALUE;
					i--;
				} else if (j >= array2.length) {
					array2[j - 1] = Integer.MAX_VALUE;
					j--;
				}
			}
		}

		return arrayResultado;

	}
	
	public int[] sumaFilasMatrizEnteros (int[][] matriz){
		int[] resultado = new int[matriz.length];
		for (int i = 0; i < matriz.length; i++){
			for (int j = 0; j < matriz[i].length; j++){
				resultado[i] += matriz[i][j];
			}
		}
		return resultado;
	}
	
	public int[] sumaColumnasMatrizEnteros (int[][] matriz){
		int numMaxColumnas = 0;
		for (int i = 0; i < matriz.length; i++) {
			if (matriz[i].length > numMaxColumnas){
				numMaxColumnas = matriz[i].length;
			}
		}
		int[] resultado = new int[numMaxColumnas];
		for (int j = 0; j < numMaxColumnas; j++) {
			for (int i = 0; i < matriz.length; i++) {
				//try {
				if (i < matriz.length && j < matriz[i].length){
					resultado[j] += matriz[i][j];
				//} catch (ArrayIndexOutOfBoundsException e) {
				}
			}
		}
		return resultado;
	}

	public static void main(String[] args) {
		Ejercicios1 ej1 = new Ejercicios1();

		/*
		 * int x = 5; int y = 9; System.out.println("El producto de " + x +
		 * " por " + y + " es igual a " + ej1.producto(x, y) + ".");
		 */

		/*
		 * int z = 10; ej1.fibonacci(z);
		 */

		// System.out.println(ej1.fibonacciRecursivo(10));

		/*
		 * int x = 17; int y = 39; int resultado = ej1.sumaIntervalo(x, y);
		 * System.out.println("El sumatorio del intervalo entre " + x + " y " +
		 * y + " da como resultado: " + resultado);
		 */

		/*
		 * int n = 100; for(int i=0; i<n; i++) ej1.lanzarDado();
		 */
		/*
		 * int cuantasLanzadas = 10000; int[] salida =
		 * ej1.lanzadas(cuantasLanzadas); ej1.mostrarLanzadas(salida,
		 * cuantasLanzadas);
		 */

		// int x = 1000;
		// ej1.listaNPrimerosEnteros(x);

		// ej1.bucleCronometro();

		/*
		 * int numero = 1987; ej1.esPrimo(numero);
		 */
		// ej1.listaPrimos(100);

		/*
		 * ej1.creaListaPersonas();
		 * 
		 * Estudiante jorge = new Estudiante("987654321A", "Jorge", 'M', new
		 * Date(), 1, "2010-03-01");
		 */

		// ej1.crearHebras(3);

		// ej1.adivinaNumero();

		/*
		 * String[] nombres = {"Paco", "Carlos", "Mar�a", "Luis", "Fernando", "Isabel"}; 
		 * ej1.ordenaListaCadenas(nombres);
		 */

		/*
		 * Integer[] numeros = { 1, 8, 9, 4, 2, 99 };
		 * ej1.ordenaListaNumeros(numeros); 
		 * boolean encontrado = ej1.busquedaBinaria(99, numeros); 
		 * if (encontrado) {
		 * System.out.println("N�mero encontrado."); 
		 * } else {
		 * System.out.println("N�mero no encontrado."); 
		 * }
		 */

		// System.out.println(ej1.ordenaCadena("esternocleidomastoideo"));

		/*int[] array1 = { 1, 3, 5, 7, 9, 11, 13 };
		int[] array2 = { 0, 2, 4, 6, 8 };
		
		ej1.ordenaListaNumeros(array1);
		ej1.ordenaListaNumeros(array2);
		
		int[] arrayResultado = ej1.mezclaArraysEnteros(array1, array2);
		System.out.println("Mezcla terminada");*/
		
		int[][] matriz = {{1, 5, 3, 3, 1, 9}, {2, 4}, {0, 8, 7, 6}};
		//int[] sumaFilas = ej1.sumaFilasMatrizEnteros(matriz);
		int[] sumaColumnas = ej1.sumaColumnasMatrizEnteros(matriz);
		System.out.println("Se acab�, pibe.");

	}
}
