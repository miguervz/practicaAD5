package practica5AD;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		int opcion=0;
		do {
			Scanner teclado = new Scanner(System.in);
			System.out.println("Seleccione la función que desea realizar: \n \n 1. Insertar nuevos documentos.\n 2."
					+ " Mostrar todos los personajes humanos.\n 3. Mostrar todos los personajes nacidos antes de 1979.\n 4. Mostrar todos los personajes cuyo atributo 'wood' de la varita sea 'holly'.\n 5. "
					+ "Mostrar los personajes vivos que sean estudiantes.\n 6. Actualizar documento 'Manolo', cambiar a 'Alfredo' y a la casa 'Slytherin'.\n 7. Eliminar documento 'Alfredo'.\n 8. Finalizar Programa ");
			opcion = Integer.parseInt(teclado.nextLine());
			switch(opcion){
			case 1 :
				System.out.println("\n");
				System.out.println("Escribe '1' para introducir el documento Manolo.\nEscribe '2' para introducir los documentos Julio y Juana.");
				String n = teclado.nextLine();
				if (n.equals("1")) {
					Metodos.insertarDocumento();
					System.out.println("\n Documento Manolo introducido.\n");
				}
				if (n.equals("2")) {
					Metodos.insertarDocumentos();
					System.out.println("\n Documentos Julián y Juana introducidos.\n");
				}
				
				
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
				System.out.println("\n Clase Manolo cambiada de nombre a Alfredo y a la casa Slytherin.\n");
				break;
			case 7 :
				Metodos.eliminarDocumentos();
				System.out.println("\n Clase Alfredo eliminada.\n");
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