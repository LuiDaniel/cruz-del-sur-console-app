# cruz-del-sur-console-app
Aplicación de consola en Java para la gestión de transporte y venta de pasajes de Cruz del Sur.

## teconologias usadas para los datos
Hemos usado los records para almacenar datos necesarios 
trasladamos los datos den tipos de datos definidos en records
## Funciones

- Ver rutas
- Comprar pasajes
- Mostrar precios
- Menú interactivo

## Conceptos usadas
- Java
- Scanner
- Bucles

- Condicionales
- Funciones
- Records

## Colores de texto
- Negro
- Rojo
- Verde
- Amarillo
- Azul
- Morado
- Cyan
- Blanco

## Colores brillantes
- Versiones más intensas y llamativas de los colores normales.

## Fondos
- Permiten cambiar el color del fondo del texto mostrado en consola.

## Estilos:
- Negrita
- Subrayado
- Texto invertido

### Clase Datos
- Implementación de una clase llamada `Datos`.
- La clase almacena toda la información principal del sistema.
- Uso de `records` para organizar los datos de manera más simple y ordenada.

## Record Ruta
-Se utiliza para crear las rutas de viaje.
Contiene:
- Origen
- Destino
- Precio

## Ejemplo
- Lima → Arequipa  
- Cusco → Puno
- Tacna → Lima

## Record Bus
Se utiliza para crear los tipos de buses disponibles.
Contiene:
- Tipo de bus
- Cantidad de asientos
- Variación de precio

Tipos de buses:
- Evolution
- Confort Suite
- Suite

## Record Pasaje
-Se utiliza para almacenar toda la información del pasaje comprado.
Contiene:
- Datos del bus
- Datos de la ruta
- Fecha del viaje

## Arreglo de rutas
- Se creó un arreglo global de tipo `Ruta`.
- El arreglo almacena todas las rutas disponibles del sistema.
- Cada ruta tiene:
  - Ciudad de origen
  - Ciudad de destino
  - Precio del viaje

## Arreglo de buses
- Se creó un arreglo global de tipo `Bus`.
- El arreglo almacena los buses disponibles del sistema.
- Cada bus tiene:
  - Tipo de bus
  - Número de asientos
  - Variación del precio

### Funciones
## Lenguaje de programación
•	Java 

## Librerías importadas
Scanner
Se utilizó para ingresar datos desde el teclado.
- import java.util.Scanner;
Ejemplo:
- Scanner sc = new Scanner(System.in);
- Método utilizado:
- sc.nextInt();

## LocalDate
Se utilizó para manejar fechas.
- import java.time.LocalDate;
- Métodos utilizados:
- LocalDate.now()
- plusDays(1)
- LocalDate.of()

##Programación Orientada a Objetos
Clase
- Se utilizó una clase llamada:
- public class Funciones

## Métodos
Métodos utilizados en el código:
•	elegirOrigen() 
•	elegirDestino() 
•	elegirFecha() 
•	devolverRutaSeleccionada() 
•	pasaje() 
•	mostrarBuses() 

## Métodos static
Se utilizó:
- public static
También:
- static Scanner sc

##Tipos de datos usados
- int
Ejemplos:
- int opcion;
- int dia;

double
Ejemplo:
- double precioFinal;

String
Ejemplos:
- String origen
- String destino

## LocalDate
Ejemplo:
- LocalDate fecha

## Uso de Records
Se utilizaron records dentro de Datos.
## Records utilizados:
•	Datos.Ruta 
•	Datos.Bus 
•	Datos.Pasaje 
Ejemplos:
- Datos.Ruta
- Datos.Bus
- Datos.Pasaje

## Arreglos (Arrays)
Se utilizaron arreglos para almacenar datos.
Ejemplos:
- Datos.rutas
- Datos.buses

## Bucles usados
- Bucle for
Se utilizó para recorrer arreglos.
Ejemplo:
- for (int i = 0; i < Datos.rutas.length; i++)

También:
- for(int i = 0; i < Datos.buses.length; i++)

Bucle do-while
Se utilizó para repetir una acción hasta que el usuario ingrese una opción válida.
Ejemplo:

- do{

- }while(opcion < 1 || opcion > buses.length);

##Condicionales
- if
Ejemplos:
- if (opcion == 1)
- if (opcion < 1 || opcion > buses.length)

else if
Ejemplo:
- else if (opcion == 2)

## Operadores usados
Operador lógico OR
- ||
Ejemplo:
- opcion < 1 || opcion > buses.length

## Operador lógico AND
&&
Ejemplo:
- origen.equalsIgnoreCase(Datos.rutas[i].origen()) 
- && destino.equalsIgnoreCase(Datos.rutas[i].destino())

## Comparación de texto
Se utilizó:
- equalsIgnoreCase()
Ejemplo:
- origen.equalsIgnoreCase(Datos.rutas[i].origen())

## Uso de return
Se utilizó return para devolver datos.
Ejemplos:
- return LocalDate.now();
- return Datos.rutas[i];
- return buses[opcion - 1];

## Objetos creados
Se creó un objeto de tipo Pasaje.
Ejemplo:
- new Datos.Pasaje(bus, ruta, fecha);

## Variables utilizadas
Variables usadas en el código:
•	opcion 
•	dia 
•	hoy 
•	precioFinal 
•	origen 
•	destino 
•	ruta 
•	bus 
•	fecha 
•	buses 

## Validaciones
Se validaron opciones incorrectas.
Ejemplo:
- if (opcion < 1 || opcion > buses.length)

## Cálculos realizados
Se realizó el cálculo del precio final del pasaje.
Ejemplo:
- double precioFinal = ruta.precio() + buses[i].variacionPrecio();

## Colores de texto usados
Se utilizó una clase llamada Colores.
Colores usados:
•	BG_NEGRO 
•	NEGRITA 
•	AMARILLO 
•	VERDE 
•	RESET 
Ejemplo:
- Colores.BG_NEGRO
- Colores.NEGRITA
- Colores.AMARILLO
- Colores.VERDE
- Colores.RESET

## Funciones del sistema
Seleccionar origen
Método:
- elegirOrigen()

## Seleccionar destino
Método:
-elegirDestino()

## Seleccionar fecha
Método:
- elegirFecha()

## Buscar ruta seleccionada
Método:
- devolverRutaSeleccionada()

## Generar pasaje
Método:
- pasaje()

## Mostrar buses disponibles
Método:
- mostrarBuses()


## Cómo ejecutar

1. Abrir el proyecto en VS Code
2. Ejecutar Main.java

## Autor
Bernabe Shatel
