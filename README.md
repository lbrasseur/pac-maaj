# Pac-Maaj
Trabajo practico final curso Java AAJ

## Objetivo
El trabajo práctico consiste en implementar la base para un juego estilo PAC-MAN (PAC-MAAJ en este caso).

El objetivo del trabajo práctico es escribir un método que genere el laberinto a partir de un archivo de texto. En dicho archivo, hay diferentes caracteres que representan los distintos tipos de elementos: las paredes, las pastillas, el pac-man, los fantasmas, etc.

Para realizar el trabajo práctico se debe implementar el siguiente método:

[`com.aajtech.pacmaaj.Maze.fromText(String)`](https://github.com/lbrasseur/pac-maaj/blob/master/core/src/com/aajtech/pacmaaj/Maze.java)

Cada clase de celda está representada por una enumeración de tipo `com.aajtech.pacmaaj.Maze.Cell`. Por ese motivo, la lógica debe de alguna manera, mapear cada caracter con su correspondiente elemento de la enumeración. También se necesitarán implementar las colecciones apropiadas para generar el arreglo bidimensional que la clase Maze recibe como parámetro en el constructor. De esta manera, se ejercita el uso de colecciones.

A fin de ejercitar el manejo de excepciones, el método deberá reportar excepciones en caso de que alguna línea del archivo de texto no coincida con el resto y en caso de que haya un caracter inválido.

El archivo de definición del laberinto puede encontrarse [aquí](https://github.com/lbrasseur/pac-maaj/blob/master/android/assets/maze.txt).

## Instalación
La aplicación se construyó utilizando [LibGDX](http://libgdx.badlogicgames.com/), que permite escirbir juegos para distintas plataformas utilizando un API Java unificada.

Dado que dicha plataforma está basada en [Gradle](https://gradle.org/), será necesario descargar e instalar esta herramienta en primer lugar.

Una vez hecho esto, desde el directorio de la aplicación se debe ejecutar:

`gradle eclipse`

Esto generará los proyectos de Eclipse, descargando las dependencias necesarias. Una vez generados dichos proyectos, pueden importarse desde Eclipse. Para este práctico sólo será necesario importar `pac-maaj-core` y `pac-maaj-desktop`. En el primero se encuentra la clase a modificar y en el segundo la clase para ejecutar el juego como aplicación Java desktop.

## Instrucciones para la realización
Una vez finalizado el proyecto, ejecutando la aplicación mediante la siguiente opción de menú:

![](https://raw.githubusercontent.com/lbrasseur/pac-maaj/master/img/run_as.png)

debería aparecer una pantalla como la siguiente:

![](https://raw.githubusercontent.com/lbrasseur/pac-maaj/master/img/pac-maaj.png)

El proyecto también incluye test unitarios, a fin de comporbar que la salida del método implementado sea correcta. Dichos tests unitarios validan tanto los datos de salida como las excepciones que debería lanzar el método. La clase [`com.aajtech.pacmaaj.MazeTests`](https://github.com/lbrasseur/pac-maaj/blob/master/core/src/com/aajtech/pacmaaj/MazeTests.java) realiza dicha validación y puede usarse como referencia para probar el correcto comportamiento de la implementación del método.

Para ejecutar los test unitarios, se debe seleccionar la siguiente opción:

![](https://raw.githubusercontent.com/lbrasseur/pac-maaj/master/img/unit_test.png)

## Puntos extra
Cualquier extra que se quiera realizar (movimiento del PAC-MAN, música, etc.) es bienvenido.
