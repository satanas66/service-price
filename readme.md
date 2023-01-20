## Proyecto service-price"

### Servicio de precios

El siguiente proyecto ha sido realizado siguiendo los requerimientos del documento Java developer Prueba Técnica Java - PLATAFORMA CORE.txt que se encuentra localizado en el directorio de recursos.

Las tecnologías más relevantes para el desarrollo del proyecto service-price son:

* IDE Intellij Ultimate 2020.3
* Spring boot 2.7.5
* JDK 11
* JPA 2.2.3
* H2
* Spring WEB 5.3.23
* Lombok 1.18.24
* JUnit 5.7.0
* POSTMAN: Para probar los servicios publicados.

## Análisis desarrollo y pruebas

### Casos de uso

* Listar todos los precios: Este es un caso de prueba para comprobar el correcto funcionamiento entre los distintos componentes y capas
* Obtener el precio con mayor prioridad dada una fecha de aplicación, un id de producto y un id de cadena (findPriceWithHigherPriority)

### Paquetes

En el paquete entity se implementan dos clases entidad

* Cadena: Representa las cadenas de almacenes.
* Prices: Representa las precios que se pueden aplicar en un rango de fechas a un producto de una determinada cadena.

En el paquete dto se implementan las clases para la tranferencia de datos tanto de entrada como de salida

En el paquete mapper se implementa la clase encargada de la conversión de una entidad a un dto

En el paquete repository se encuentran las interfaces que son las abstracciones que uso para la conexión a base de datos, definición de los casos de uso y también para definir metodos que no me provee la interfaz JPARepsitory.

En el paquete servicio se encuentran la clase encargada de servir el dato aplicando la lógica de negocio necesaria.

En el paquete controlador se encuentra la implementación del controlador encargado de exponer el endpoint.


### Servicios

Previa cosumisión de los servicios se debe arrancar el proyecto cuyo núcleo es la clase "ServiceProductApplication"

Una vez arrancado el proyecto y mediante la herramienta "POSTMAN" se podrán consumir los servicios.

Un ejemplo de la url del servicio es la siguiente:

http://localhost:3001/prices/priority?applicationDate=2020-06-14 00:12:15&productId=35455&cadenaId=1

* Dónde applicationDate es la fecha de aplicación y debe tener el formato yyyy-MM-ddd HH:mm:ss tal y como se muestra en el ejemplo
* Dónde productId debe ser un número entero
* Dónde cadenaId debe ser un número entero

### Pruebas (test)

Se han realizado un total de 6 test entre unitarios y de integración y todos ellos son los solicitados en el documento de requisitos.

### Notas

Al tratarse de una prueba de habilidades de análisis, diseño, estructura y desarrollo/pruebas donde el único input es un documento de requisitos, este proyecto tiene muchas carencias como por ejemplo:

* No se han realizado test para todos los casos posibles
* No se han realizado control ni lanzamiento de excepciones
* No se han realizado validaciones en el caso POST

## Author Computer Enginner
* Edwin Patricio Arévalo Angulo
* edwinarevaloangulo@gmail.com


