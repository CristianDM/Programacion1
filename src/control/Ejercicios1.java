package control;

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
			 * System.out.println("El número " + (i + 1) + " ha salido " +
			 * datos[i] + " veces (" + ((datos[i] * 100) / cuantasLanzadas) +
			 * "%).");
			 */
			System.out.printf("El número %d aparece %d veces (%.2f)\n", (i + 1), datos[i],
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
				// System.out.println("El número " + numero + " no es primo.");
				return false;
			}
		}
		// System.out.println("El número " + numero + " es primo.");
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

	// Práctica: Leer datos desde el teclado y convertir esa cadena en un entero

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
		System.out.println("Los números son válidos.");
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
			// Validamos el número aleatorio
			boolean error1 = true;
			int numeroObjetivo = 0;
			while (error1) {
				try {
					Scanner teclado = new Scanner(System.in);
					System.out.println("Teclee un número entero.");
					String numeroTecleado = teclado.nextLine();

					if (numeroTecleado.compareToIgnoreCase("Q") == 0) {
						System.out.println("Fin de la partida. Hasta la próxima.");
						System.exit(0);
					}

					numeroObjetivo = Integer.parseInt(numeroTecleado);
					error1 = false;
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					System.out.println("Número incorrecto.");
				}
			}
			//Creamos el intento.
			Intento intento = new Intento(numeroObjetivo, new Date());
			//Guardamos el intento.
			intentos[contadorIntentos++] = intento;
			
			//Mostrar los intentos realizados hasta el momento.
			for(int i = 0; i < intentos.length; i++){
				try {
					System.out.printf("%d, \t%d\t%s\n", i+1, intentos[i].getNumeroIntroducido(), intentos[i].getFechaHora());
				} catch (NullPointerException e) {
					// TODO Auto-generated catch block
					break;
				}
			}

			// El número tecleado es válido.

			if (numeroObjetivo < numeroAleatorio)
				System.out.println("Pruebe un número mayor.");
			else if (numeroObjetivo > numeroAleatorio) {
				System.out.println("Pruebe un número menor.");
			} else {
				System.out.println("Has acertado. Felicidades.");
				jugando = false;
			}

		} while (jugando);
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

		ej1.adivinaNumero();
	}
}
