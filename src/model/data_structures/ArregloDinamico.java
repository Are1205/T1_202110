package model.data_structures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 2019-01-23
 * Estructura de Datos Arreglo Dinamico de Strings.
 * El arreglo al llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.
 * @author Fernando De la Rosa
 *
 */
public class ArregloDinamico implements IArregloDinamico {
		/**
		 * Capacidad maxima del arreglo
		 */
        private int tamanoMax;
		/**
		 * Numero de elementos presentes en el arreglo (de forma compacta desde la posicion 0)
		 */
        private int tamanoAct;
        /**
         * Arreglo de elementos de tamaNo maximo
         */
        private String elementos[ ];

        /**
         * Construir un arreglo con la capacidad maxima inicial.
         * @param max Capacidad maxima inicial
         */
		public ArregloDinamico( int max )
        {
               elementos = new String[max];
               tamanoMax = max;
               tamanoAct = 0;
        }
        
		public void agregar( String dato )
        {
               if ( tamanoAct == tamanoMax )
               {  // caso de arreglo lleno (aumentar tamaNo)
                    tamanoMax = 2 * tamanoMax;
                    String [ ] copia = elementos;
                    elementos = new String[tamanoMax];
                    for ( int i = 0; i < tamanoAct; i++)
                    {
                     	 elementos[i] = copia[i];
                    } 
            	    System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
               }	
               elementos[tamanoAct] = dato;
               tamanoAct++;
       }

		public int darCapacidad() {
			return tamanoMax;
		}

		public int darTamano() {
			return tamanoAct;
		}

		public String darElemento(int i) {
			// TODO implementar
			String elemento = "";
			elemento = tamanoAct >= i? elementos[i]:null;
			return elemento;
		}

		public String buscar(String dato) {
			// TODO implementar
			// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings.
			
			String elemento = null;
			boolean encontro = false;
			for (int i=0; i< tamanoAct && elemento == null ; i++)
			{
				
				elemento = elementos[i].compareTo(dato)==0? elementos[i]:null;
	
			}
			
			return elemento;
			
		}

		public String eliminar(String dato) {
			// TODO implementar
			// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings.
			String elemento = null;
			boolean encontro =  false;
			ArrayList<String> lista =  new ArrayList<String>();
			
			for (int i=0; i<tamanoAct && !encontro; i++)
			{
				System.out.println("...................");
				System.out.println(elementos[i]);
				System.out.println("...................");
				
				if (elementos[i].compareTo(dato) == 0)	
				{
					elemento = elementos[i];
					Collections.addAll(lista, elementos);
					lista.remove(i);
					elementos = lista.toArray(new String[lista.size()]);
					tamanoAct --;
					encontro = true;
				} 
			}
			
			return elemento;
			
		}

}
