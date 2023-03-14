package Grupo3.GestorCompeticiones.utils;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import Grupo3.GestorCompeticiones.model.DO.Aparato;
import Grupo3.GestorCompeticiones.model.DO.Categoria;
import Grupo3.GestorCompeticiones.model.DO.Competicion;
import Grupo3.GestorCompeticiones.model.DO.TipoPrueba;

public class Utils {
	/**
	 * Metodo que valida si ingresas un obj tipo String.
	 * @param mensaje: cadena que le muestras al usuario.
	 * @return: String ya validado.
	 */
	 public static String leeString(String mensaje) {
		  Scanner sc = new Scanner (System.in);
		  String result = null;
		  boolean valid = false;
		  do {
			try {
				System.out.print(mensaje);
				result = sc.nextLine();
				valid = true;
			} catch (Exception e) {
				System.out.println("Error. Introduzca una cadena");
				sc.nextLine();
			}
		} while (!valid);
		  
		  return result;
		  
	  }
	 
	  /**
	   * Metodo que valida si el caracter introducido es  entero.
	   * @param mensaje: cadena que le muestras al usuario.
	   * @return: el entero validado.
	   */
	  public static int leeEntero(String mensaje) {
		  Scanner sc = new Scanner (System.in);
		  int result = 0;
		  boolean valid = false;
		  do {
			try {
				System.out.print(mensaje);
				result = sc.nextInt();
				valid = true;
			} catch (Exception e) {
				System.out.println("Error. Introduzca un entero");
				sc.nextLine();
			}
		} while (!valid);
		  return result;
	  }
	  
	  
	  
	  
	  
	  
	  
	  /*
	   * VALIDAR EL DNI
	   */
	  
	  
	  private static final Pattern REGEXP = Pattern.compile("[0-9]{8}[A-Z]");
      private static final String DIGITO_CONTROL = "TRWAGMYFPDXBNJZSQVHLCKE";
      private static final String[] INVALIDOS = new String[] { "00000000T", "00000001R", "99999999R" };
      /**
       * Metodo que valida el DNI introducido
       * @param dni: el dni a validar
       * @return el dni validado
       */
      private static boolean validarDNI(String dni) {
        return Arrays.binarySearch(INVALIDOS, dni) < 0 // (1)
            && REGEXP.matcher(dni).matches() // (2)
            && dni.charAt(8) == DIGITO_CONTROL.charAt(Integer.parseInt(dni.substring(0, 8)) % 23); // (3)
      }
	  /**
	   * Metodo que valida el DNI introducido
	   * @param mensaje: cadena que le muestras al usuario.
	   * @return String dni validados
	   */
	  public static String validaDNI(String mensaje) {
		  Scanner sc = new Scanner (System.in);
		  String result = null;
		  boolean valid = false;
		  do {
			try {
				System.out.print(mensaje);
				result = sc.nextLine();
				if(validarDNI(result)) {
					valid = true;
				}else {
					System.out.println("DNI invalido.");
				}
			} catch (Exception e) {
				System.out.println("Error. Introduzca un entero");
				sc.nextLine();
			}
		} while (!valid);
		  return result;
	  }
	  
	  
	  
	  
	
	  
	/**
	 * Metodo que valida el telefono introducido.
	 * @param mensaje: cadena que le muestras al usuario.
	 * @return: String ya validado.
	 */
	  public static String  validaTLF(String mensaje) {
		  Scanner sc = new Scanner (System.in);
		  String result= null;
		  boolean valid = false;
		  String patron = "^[6-9]\\d{8}$"; 
		  do {
			 try {
				System.out.print(mensaje);
				result=sc.nextLine();
				if(result.matches(patron)) {
					 valid = true;
				  }else {
					  System.out.println("Telefono invalido.");
				  }
			} catch (Exception e) {
				System.out.println("Error, introduzca una cadena");
				sc.nextLine();
			}
		} while (!valid);
		  
		 return result;
	  }
	  
	  /**
		 * Metodo que valida la fecha introducida.
		 * @param mensaje: cadena que le muestras al usuario.
		 * @return: Date ya validado.
		 */
	  public static Date validaFecha(String mensaje) {
		  Scanner sc = new Scanner (System.in);
		  Date result = null;
		  boolean valid = false;
		  SimpleDateFormat sdfrmt = new SimpleDateFormat("dd/MM/yyyy");
		  sdfrmt.setLenient(false);
		  do {
			 
			try {
				 System.out.print(mensaje);
				 String fechaString = sc.nextLine();
				 result = sdfrmt.parse(fechaString);
				 valid = true;
			} catch (ParseException e) {
				 System.out.println("Fecha invalida");
			} catch (Exception e) {
				System.out.println("Error, introduzca una cadena");
				sc.nextLine();
			}
		} while (!valid);
		  return result;
	  }
	  
	  
	  
	  
	  /*
	   * VALIDA ENUMS: Metodos que valida ENUMS en bucle. 
	   */
	  
	  
	 
	  public static Aparato validaAparato(String mensaje) {
			Scanner sc = new Scanner (System.in);
			Aparato result = null;
			boolean valid = false;
			do {
				try {
					System.out.print(mensaje);
					String tipo = sc.nextLine().toLowerCase();
					
					result = Enum.valueOf(Aparato.class, tipo);
					valid = true;
					
					
				} catch (IllegalArgumentException e) {
					System.out.println(" La cadena no es un valor valido del enum");
					
				}
			} while (!valid);
			
			return result;
			
		}
	  public static TipoPrueba validaTipoPrueba(String mensaje) {
		  Scanner sc = new Scanner (System.in);
			TipoPrueba result = null;
			boolean valid = false;
			do {
				try {
					System.out.print(mensaje);
					String tipo = sc.nextLine().toLowerCase();
					
					result = Enum.valueOf(TipoPrueba.class, tipo);
					valid = true;
					
					
				} catch (IllegalArgumentException e) {
					System.out.println(" La cadena no es un valor valido del enum");
					
				}
			} while (!valid);
			
			return result;
	  }
	  public static Categoria validaCategoria(String mensaje) {
		  Scanner sc = new Scanner (System.in);
			Categoria result = null;
			boolean valid = false;
			do {
				try {
					System.out.print(mensaje);
					String tipo = sc.nextLine().toLowerCase();
					
					result = Enum.valueOf(Categoria.class, tipo);
					valid = true;
					
					
				} catch (IllegalArgumentException e) {
					System.out.println(" La cadena no es un valor valido del enum");
					
				}
			} while (!valid);
			
			return result;
	  }
	 	  
	  	//envia un mensaje
		public static void mensaje(String mensaje) {
			System.out.println(mensaje);
		}
		
		
		
		
		
		//metodo que imprime objeto
		
		public static void imprimeCompeticion(Competicion c) {
			System.out.println(c);
		}
		public static void imprimeObjeto (Object o) {
			System.out.println(o);
		}
		
		public static<T> NodeList buscarObjetos(T tipoObjeto, String nombreArchivo) {
			try {
				File inputfile = new File(nombreArchivo);
				
				
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(inputfile);
				
				
				doc.getDocumentElement().normalize();
				
				NodeList nList = doc.getElementsByTagName((String) tipoObjeto);
				return nList;
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		
		
		public static void buscarMostrarObjetos() {
			String tipoObjeto = leeString("Introduce el tipo de objeto que quieres buscar");
			NodeList objetos = buscarObjetos(tipoObjeto, "fichero.xml");
			
			for(int i=0; i< objetos.getLength();i++) {
				Node objeto = objetos.item(i);
				if(objeto.getNodeType() == Node.ELEMENT_NODE) {
					Element elementoObjeto = (Element) objeto;
					String id = elementoObjeto.getAttribute("dni");
					String nombre = elementoObjeto.getElementsByTagName("nombre").item(0).getTextContent();
					Utils.mensaje("El objeto tiene el nombre "+ nombre);
					
				}
			}
		}
}
