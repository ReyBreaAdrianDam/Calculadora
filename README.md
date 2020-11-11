# Calculadora 
Ejercicio calculadora realizado en AWT
## AVISO: Este proyecto ha sido creado usando Gradle y IntelliJ
Se ha probado a importar a Eclipse, y al importar funciona
## Contenido

Esta calculadora consta de 20 Botones funcionales con la siguiente distribución
| | | | |
| :---: | :---: | :---: | :---: |
| Del | CE | C | / |
| 7 | 8 | 9 | * |
| 4 | 5 | 6 | - |
| 1 | 2 | 3 | + |
| . | 0 | % | = |

## Clases
### El ejercicio consta de 3 clases:
#### Main
Clase principal del programa, esta ejecutara un objeto Calculadora(), le asignara el titulo y hara que se cierre
#### Calculadora
Esta clase generara toda la estructura de la calculadora y le dara uso a los botones que hay en ella
##### Metodo generarBotones()
Este metodo es encargado de crear botones y darle funcion, requiere un array de Strings y no devuelve nada
```
public void generarBotones(String... tecla){
        for(String x : tecla) {
           //Aqui el codigo para cada boton
        }
    }
```
#### Operaciones
Esta clase es una clase enum que contiene los siguientes enums
```
SUMA
RESTA
MULTIPLICACION
DIVISION
```
Estos enums sirven para guardar el estado en el que esta la calculadora
