## **Alargar la vida de los sensores en salas sin energía**

### **Contexto**

En el proyecto **Mica**, desplegamos sensores en **salas de contadores** donde no hay acceso a red eléctrica ni conectividad Wi-Fi. Los sensores funcionan con **baterías LiFePO₄** y deben durar **años sin mantenimiento**.

A diferencia de otros sistemas de lectura, en Mica necesitamos:

* Detectar y reportar **consumo en tiempo real**

* Transmitir eventos justo cuando se produce un uso de agua

* Mantener una interfaz ágil para el usuario final

Esto supone un **consumo energético elevado**, especialmente por las transmisiones inalámbricas frecuentes.

---

## **La oportunidad: usar el propio contador como fuente de energía**

Los contadores volumétricos de agua incluyen un mecanismo interno (por ejemplo, **un pistón oscilante**) que **gira lentamente pero con fuerza** cada vez que pasa agua. Este movimiento se puede aprovechar para:

* Acoplar **un tren de engranajes** que multiplique la velocidad

* Conectarlo a un **motor brushless trifásico de bajo KV** (como los usados en drones y gimbals)

* Usarlo como **generador electromagnético** para recolectar energía en cada uso del agua

---

## **Nueva línea de exploración: Motores brushless trifásicos como generadores**

Los **motores brushless de drones** (BLDC) pueden generar electricidad si los hacemos girar mecánicamente:

* Los motores con **KV bajos (80–300)** pueden generar **5 V a \~1000 RPM**

* Con un **sistema de engranajes 1:10 o más**, se puede convertir la rotación lenta del contador en velocidad útil

* El voltaje generado puede usarse para:

  * Cargar un **supercondensador**

  * **Reducir el consumo neto de la batería**

  * **Alimentar transmisiones** cuando hay paso de agua

---

## **Ventajas de esta solución**

* No se necesita modificar el contador (solo acoplar mecánicamente)

* Aumenta la autonomía sin eliminar la batería

* Aprovecha tecnología **comercial, barata y accesible** como los motores de drones

* Adaptable a distintos modelos de contadores volumétricos

