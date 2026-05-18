# cruz-del-sur-console-app
Aplicación de consola en Java para la gestión de transporte y venta de pasajes de Cruz del Sur.

## conceptos usados
- bucles
- condicionales
- records





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

## Record Bus
Se utiliza para crear los tipos de buses disponibles.
Contiene:
- Tipo de bus
- Cantidad de asientos
- Variación de precio

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

## Librerías importadas
- Scanner
- LocalDate

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



## LocalDate
Ejemplo:
- LocalDate fecha

## Uso de Records
Se utilizaron records dentro de Datos.
## Records utilizados:
•	Datos.Ruta 
•	Datos.Bus 
•	Datos.Pasaje 

## Objetos creados
Se creó un objeto de tipo Pasaje.
Ejemplo:
- new Datos.Pasaje(bus, ruta, fecha);

## subtitulo para esto //
- Validaciones
- Cálculos realizados

## Cómo ejecutar

1. Abrir el proyecto en VS Code
2. Ejecutar Main.java

## Autor
Bernabe Shatel

