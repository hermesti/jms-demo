JMS Demo
--------

Proyecto de demostración del uso de Java Message Services (JMS) con Spring y ActiveMQ.

Incluye un único controlador:

com.sstrategy.demo.controlador.DemoController.java

Con los siguientes endpoints:

Envío de un mensaje a través de una cola (punto a punto):
 
    GET <url>/jms-demo/api/demo/objeto-punto-a-punto

Publicación de un mensaje broadcast:

    GET <url>/jms-demo/api/demo/objeto-broadcast
    
Existen tres clases receptoras de mensajes:

- Receiver: recibe los mensajes punto a punto y los muestra en consola.
- Subscriber1 y Subscriber2: dos suscriptores que reciben los mensajes broadcast y los muestran por consola.