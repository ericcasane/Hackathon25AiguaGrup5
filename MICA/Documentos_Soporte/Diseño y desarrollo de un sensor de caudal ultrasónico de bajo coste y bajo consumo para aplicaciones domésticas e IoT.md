## **1\. Ideación del Proyecto**

### **1.1 Título Provisional**

**Diseño y desarrollo de un sensor de caudal ultrasónico de bajo coste y bajo consumo para aplicaciones domésticas e IoT**

### **1.2 Motivación**

La gestión eficiente del agua se ha convertido en una prioridad global. En el ámbito doméstico, los sistemas de medición actuales están limitados por dispositivos mecánicos que requieren mantenimiento, tienen precisión limitada a bajos caudales y no permiten una integración sencilla con plataformas de monitorización en tiempo real o redes IoT.  
 Los sensores de caudal por ultrasonidos, ampliamente utilizados en entornos industriales, ofrecen una solución precisa, sin contacto y sin partes móviles, pero su alto coste impide su adopción masiva en viviendas o proyectos de pequeña escala.

Este proyecto propone diseñar un **sensor ultrasónico de caudal de bajo coste**, con capacidad de operar en **modo ultra low-power**, que pueda integrarse fácilmente en entornos domésticos o sistemas de monitorización distribuida (smart home, riego, control de consumos, etc.).

### **1.3 Objetivos**

**Objetivo general:** Diseñar, implementar y validar un prototipo funcional de sensor de caudal basado en tecnología ultrasónica, orientado a bajo coste y bajo consumo energético, integrable en sistemas IoT.

**Objetivos específicos:**

* Estudiar el principio físico de medición de caudal por tiempo de tránsito ultrasónico (Time-of-Flight).

* Analizar y seleccionar transductores ultrasónicos adecuados para agua a bajo coste.

* Diseñar el sistema electrónico de generación, recepción y detección de señales ultrasónicas.

* Implementar algoritmos de cálculo de caudal basados en diferencias de tiempo de vuelo.

* Explorar e implementar métodos pasivos de detección de flujo (ultrasónica o térmica) para minimizar el consumo energético.

* Validar experimentalmente el sistema con distintas configuraciones de flujo y tuberías.

* Comparar el rendimiento frente a sensores comerciales de efecto Hall.

* Documentar el diseño de hardware y software para facilitar su replicabilidad.

### **1.4 Justificación técnica**

El principio del **tiempo de tránsito ultrasónico** (transit-time TOF) permite medir el caudal de un fluido mediante la diferencia en el tiempo que tarda una onda ultrasónica en recorrer un trayecto a favor y en contra del flujo. Esta técnica tiene ventajas claras frente a sensores mecánicos:

* No tiene partes móviles → mayor durabilidad.

* Puede instalarse sin modificar la tubería (clamp-on) o con contacto directo en línea.

* Funciona en un amplio rango de caudales.

* Permite un diseño hermético y sin obstrucciones.

A nivel tecnológico, el proyecto involucra el uso de:

* **Microcontroladores modernos** (ej. ESP32, STM32), con capacidades de procesamiento en tiempo real, conectividad inalámbrica y gestión energética avanzada.

* **Transductores ultrasónicos piezoeléctricos** de 1 MHz o similares, disponibles comercialmente a bajo coste.

* **Electrónica analógica básica** para amplificación y detección de señales ultrasónicas débiles.

* Algoritmos de procesamiento digital para cálculo de diferencias temporales y derivación del caudal.

Además, se explorarán técnicas para mantener el sistema en reposo durante la mayor parte del tiempo (modo sleep), utilizando sensores pasivos como:

* Detección ultrasónica pasiva (captación de ruido generado por flujo turbulento).

* Detección térmica (variación de temperatura por arrastre térmico del agua).

### **1.5 Alcance del proyecto**

El proyecto se limitará a:

* Flujo de **agua fría a presión atmosférica**, en tuberías de ½” a 1”.

* Diseño para entornos de laboratorio o pruebas reales en entorno doméstico controlado.

* Uso de componentes de bajo coste y fácil adquisición.

* Transmisión de datos vía USB, UART o Wi-Fi (MQTT).

Quedan fuera del alcance:

* Integración en redes comerciales de medición o entornos industriales.

* Validación certificada de precisión metrológica (fuera del objetivo académico).

* Uso con fluidos corrosivos o a alta presión.

### **1.6 Aplicaciones potenciales**

* Medición de consumo de agua en viviendas individuales.

* Integración en sistemas de domótica (Home Assistant, Node-RED).

* Monitorización remota de redes de riego o sistemas de agua comunitarios.

* Detección temprana de fugas o consumos anómalos.

* Uso como sistema educativo para introducir principios de sensórica avanzada.

### **1.7 Valor añadido como PFG**

Este proyecto combina varias disciplinas clave en la formación de un ingeniero:

* Electrónica analógica y digital.

* Sensórica y procesamiento de señales.

* Programación embebida.

* Comunicaciones IoT.

* Optimización energética.

El resultado final será un sistema funcional y replicable, con documentación abierta, que puede tener aplicación real inmediata, así como proyección hacia versiones comerciales o integradas en plataformas smart metering.

