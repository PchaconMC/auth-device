## Caso 1
Actualmente se tiene un proveedor de autenticación externo que es el encargado de validar las credenciales de los usuarios que ingresan a la plataforma de autenticación, dicho proveedor expone servicios tipo Soap, de nombre login y DispositivosRegistrados.

Se requiere que el servicio soap de login sea consumido desde un servicio creado en springboot (3), java 17 y maven, este consumo debe devolver un token JWT que deberá almacenarse en una base de datos (H2), para el consumir el servicio, debe implementarse resiliencia con Resilience4J retry, circuitbreaker. 

Con el token Jwt generado, hacer el consumo del servicio soap DispositivosRegistrados, previa validación del token para hacer el consumo

![DiagramaCaso1](https://github.com/PchaconMC/auth-device/assets/60486812/086af514-8159-4762-b205-7ceb208edbce)


## Solución
Para la solición del caso 1, se generan los siguientes entregables:
1. Mocks para los servicios de Autenticación desarorllados en Postman, se adjunta archivo con la colección
     documentacion/Caso1/Mocks/ProveedorExterno-Mocks.postman_collection.json

   
![MocksPostman](https://github.com/PchaconMC/auth-device/assets/60486812/16ef7499-4d3f-4660-a5f0-d64397de659c)

2. El despliegue se hizo localmente, contenerizando cada componente (microservicios usuario y dispositivo, Gateway, Eureka server), para esto debemos contar con Docker instalado.
  - Primero debemos crear una red, con la que vamos a vincular los contenedores, todos deben estar dentro de la misma red para que se puedan comunicar y estar enlazados

    >docker network create auth-network

   
   - Genera el Jar para contenerizar cada proyecto, nos ubicamos en la ruta base del proyecto, ejecutamos comando maven desde consola 

     >.\mvnw clean package

![consola](https://github.com/PchaconMC/auth-device/assets/60486812/165d7b67-bc07-4102-b2d4-edf65961263d)

   - Las imagenes se construyen basado en los archivos Docker File, estos se encuentran en la raiz de cada proyecto

     >docker build -t image-eureka-server:v1 .

- Levantamos el contenedor a partir de la imagen, nos aseguramos que todos los contenedores se asocie a la misma red recordar que la red creada fue la auth-network

     >docker run -p 8090:8090 --name eureka-server --network auth-network image-eureka-server:v1

  Nota: se debe repetir este procedimiento para los proyectos auth-service, device-service, gateway-server

  
![eureka](https://github.com/PchaconMC/auth-device/assets/60486812/bdd5fbc4-ba65-4751-8321-968f86854d9d)

     
  
