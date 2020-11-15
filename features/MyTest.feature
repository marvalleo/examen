Feature: Pruebas de conexion a BD, login del sitio y reserva 
Scenario: Conexion BD Incorrecta
Given Probar conexion BD ""
Scenario: Conexion BD Correcta
Given Probar conexion BD "jdbc:mysql://localhost:3306/clinica"

Scenario: Caso 1: Login sin datos
Given abrir navegador
When ingresa Username "" y Password ""
Then inicia sesion

Scenario: Caso 2: Login con datos incorrectos
Given abrir navegador
When ingresa Username "bbb" y Password "bbb"
Then inicia sesion

Scenario: Caso 3: Login con datos correctos
Given abrir navegador
When ingresa Username "aaa" y Password "aaa"
Then inicia sesion

Scenario: Conectar al sitio,iniciar sesión, reservar hora.
Given abrir navegador
When ingresa Username "aaa" y Password "aaa" 
Then inicia sesion
When Agenda Hora RUT="12345" NOMBRE="valentin" APELLIDO="martinez" DIRECCION="guemes" CORREO="valen@argen.cl" FONO="123456" NOMBRE_MASCOTA="tot" TIPO="Gato" EDAD="3" HR="19" MN="30" DIA="19" MES="Mayo"
Then Reservar Hora
And Cerrar navegador