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



   

  
