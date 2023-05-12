# card-chip-producer

- #Descripción general
Este proyecto tiene como finalidad encolar (almacenar) los movimientos de las tarjetas de metrorrey en diferentes colas o "queues".

Los movimientos de las tarjetas de metrorrey pueden ser procesados en lotes ("batch") cada 5 minutos o en tiempo real a través de los endpoints o puntos de acceso que se hayan definido en la aplicación. En ambos casos, los movimientos de las tarjetas de metrorrey se encolarán en las diferentes queues que se hayan configurado.

La encolación de los movimientos de las tarjetas de metrorrey permite que la aplicación pueda procesarlos de manera ordenada y eficiente, asegurando que cada movimiento sea registrado y procesado correctamente. Además, al utilizar diferentes queues, se pueden asignar prioridades y niveles de procesamiento a los movimientos de las tarjetas de metrorrey según su importancia o urgencia.

En resumen, el objetivo del proyecto "card-chip-processor" es permitir el procesamiento ordenado y eficiente de los movimientos de las tarjetas de metrorrey, utilizando la encolación en diferentes queues y la conciliación en lotes o en tiempo real a través de endpoints.

- #Requisitos previos
- Java 11 JDK: El proyecto se desarrolla utilizando la versión 11 de Java. Por lo tanto, es necesario instalar el kit de desarrollo de Java (JDK) 11 o superior.

- Maven: Maven es una herramienta de construcción y gestión de dependencias para proyectos Java. Se debe tener instalado Maven en el equipo para poder construir el proyecto.

- IDE: Es recomendable utilizar un IDE (Integrated Development Environment) para desarrollar el proyecto. Puede usarse como Eclipse o IntelliJ IDEA(recomendable)

- Swagger: Swagger es una herramienta para documentar y probar API.

- RabbitMQ: RabbitMQ es una cola de mensajes de código abierto que se utiliza en el proyecto.

- Resilience4j: Resilience4j es una biblioteca que ayuda a los desarrolladores a escribir aplicaciones resistentes y tolerantes a fallos.

- OpenAPI: OpenAPI es una especificación para describir APIs RESTful. 

- Lombok: Lombok es una biblioteca que ayuda a los desarrolladores a reducir la cantidad de código que se necesita escribir para algunas tareas repetitivas.

- Spring AOP: Spring AOP (Aspect Oriented Programming) es una técnica para separar la lógica de programación en aspectos o módulos independientes.

- #Instrucciones de instalación

Para construir el contenedor de Docker, ingresar a la carpeta Docker y ejecutar el comando:

 -  # docker-compose up 

Este comando, ejecutado desde la terminal o línea de comandos, permitirá descargar las imágenes necesarias de RabbitMQ y construir el contenedor a partir de un archivo de configuración llamado "docker-compose.yml".

Los contenedores que levanta son:

- grafana (http://localhost:3000)
- prometheus (http://localhost:9090)
- rabbitmq
- rabbitmq_exporter

Grafana y Prometheus ya están configurados para conectarse automaticamente y generar un dashboard con metricas de RabbitMQ.

Una vez que el contenedor de RabbitMQ esté en funcionamiento, es posible acceder a su plataforma web en la dirección URL 
- http://localhost:15672/#

Desde esta plataforma, se pueden gestionar las colas de mensajes, intercambios, usuarios y otros aspectos de RabbitMQ.
Para iniciar sesión en la plataforma, se deben utilizar las credenciales proporcionadas en la frase. El usuario es "metrorrey" y la contraseña también es "metrorrey". Estas credenciales se deben proporcionar cuando se inicie sesión en la plataforma web de RabbitMQ.

- #Guía de uso
Para el acceso de la documentación de los endpoints donde se encola
los mensajes a cinco tipos de colas :

- activation

- desactivation

- disqualification

- payments

- rechange

Será en la siguiente dirección:

http://localhost:8081/metrorrey/swagger-ui/index.html

- #Contribuciones

- #Licencia





