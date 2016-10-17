package control;

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
		Persona[] listaPersonas = new Persona[20];
		Persona juan = new Persona("987654321Z", "Juan El Polla", 'M', null);
		Persona pepe = new Persona();
		Persona luisa = new Persona("666555999T", "Luisa La Verdulera", 'F', null);
		listaPersonas[0] = juan;
		listaPersonas[1] = pepe;
		listaPersonas[2] = luisa;
		for (int i = 0; i < listaPersonas.length; i++) {
			System.out.println(listaPersonas[i].getNif());
		}
	}

	public void crearHebras(int cuantas) {
		for(int i = 0; i < cuantas; i++){
			Thread hebra = new Hebra();
			hebra.setName("Hebra" + i);
			hebra.start();
		}
		/*hebra1.setName("hebra1");
		hebra2.setName("hebra2");
		hebra1.start();
		hebra2.start();*/
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

		//ej1.creaListaPersonas();
		
		ej1.crearHebras(3);
	}
}
