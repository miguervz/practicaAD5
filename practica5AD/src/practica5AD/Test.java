package practica5AD;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		int opcion=0;
		do {
			Scanner teclado = new Scanner(System.in);
			System.out.println("Seleccione la función que desea realizar: \n \n 1. Insertar nuevos documentos.\n 2."
					+ " Mostrar todos los personajes humanos.\n 3. Mostrar todos los personajes nacidos antes de 1979.\n 4. Mostrar todos los personajes cuyo atributo 'wood' de la varita sea 'holly'.\n 5. "
					+ "Mostrar los personajes vivos que sean estudiantes.\n 6. Actualizar documentos.\n 7. Eliminar documentos.\n 8. Finalizar Programa ");
			opcion = Integer.parseInt(teclado.nextLine());
			switch(opcion){
			case 1 :
				Metodos.insertarDocumentos();
				System.out.println("\n Clase Manolo introducida.\n");
				break;
			case 2 :
				Metodos.consultarHumanos();
				System.out.println("\n");
				break;
			case 3 :
				Metodos.consultarAntesDe1979();
				System.out.println("\n");
				break;
			case 4 :
				Metodos.consultarVaritaSagrada();
				System.out.println("\n");
				break;
			case 5 :
				Metodos.consultarEstudiantesVivos();
				System.out.println("\n");
				break;
			case 6 :
				Metodos.actualizarDocumentos();
				System.out.println("\n Clase Manolo cambiada de nombre a Gobernador.\n");
				break;
			case 7 :
				Metodos.eliminarDocumentos();
				System.out.println("\n Clase Gobernador eliminada.\n");
				break;
			case 8:
				System.out.println("Programa finalizado");
				teclado.close();
				break;
			}
		}
		while(opcion!=8);
		}
}