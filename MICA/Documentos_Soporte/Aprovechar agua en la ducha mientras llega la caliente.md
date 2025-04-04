**Sistema de Recirculación de Agua Caliente Sanitaria (ACS) para el Hogar: Concepto, Soluciones Existentes y Propuesta DIY con Open Hardware**

---

## **Introducción**

La recirculación de agua caliente sanitaria (ACS) en el hogar es una técnica diseñada para proporcionar agua caliente de manera inmediata en los puntos de consumo, como duchas y grifos, evitando el desperdicio de agua mientras se espera a que alcance la temperatura deseada. Este sistema mejora la comodidad y contribuye significativamente al ahorro de agua y energía.

---

## **Funcionamiento de la Recirculación de Agua Caliente**

En los sistemas tradicionales, al abrir un grifo de agua caliente, es común que el agua inicialmente salga fría debido a que el agua caliente en las tuberías se ha enfriado. Esto provoca que se desperdicie agua mientras se espera a que llegue el agua caliente desde el calentador. Un sistema de recirculación de ACS resuelve este problema mediante una bomba que mantiene el agua caliente circulando continuamente o bajo demanda a través de las tuberías, asegurando que el agua caliente esté disponible de inmediato al abrir el grifo.

---

## **Proyecto AquaReturn y Dispositivos Similares**

**AquaReturn** es un dispositivo compacto que evita el desperdicio de agua fría mientras se espera a que salga caliente. Detecta la temperatura del agua y, si es inferior a 35°C, la redirige al calentador a través de la tubería de agua fría. Una vez que el agua alcanza la temperatura adecuada, emite una señal sonora. Este sistema permite ahorrar hasta 10.000 litros de agua por persona al año.

Otros dispositivos similares:

1. **Smartwater**: Dispositivo desarrollado por fontaneros españoles, permite ahorrar hasta un 40% del consumo de agua al evitar el desperdicio mientras se espera agua caliente.  
2. **Moonshan Kit**: Bomba con termostato y temporizador digital instalada bajo el fregadero, para agua caliente instantánea.  
3. **Astro 2 (Armstrong)**: Sistema automático de recirculación que ahorra hasta 12.000 galones al año en hogares de cuatro personas.  
4. **InstaWater**: Recirculador que combina eficiencia y tecnología para disponibilidad inmediata de agua caliente.  
5. **PROZRTED**: Bomba inteligente con modos ajustables y termostato integrado.

---

## **Propuesta de Sistema DIY con Microprocesador, Sensor y Conectividad Wi-Fi**

Un sistema casero de recirculación puede construirse con componentes asequibles y fáciles de programar, integrando tecnología IoT:

### **Componentes:**

* **Bomba de recirculación** (12V o 220V, según instalación).  
* **Sonda de temperatura** (ej. DS18B20).  
* **Microprocesador con Wi-Fi** (ESP32 o ESP8266).  
* **Relé o controlador de potencia**.  
* **Fuente de alimentación segura**.  
* **Caja estanca e interfaz web/app para el usuario.**

### **Funcionamiento:**

1. La sonda mide la temperatura del agua en la tubería.  
2. Si la temperatura está por debajo de un umbral (p.ej., 35°C), el microprocesador activa la bomba.  
3. La bomba mueve el agua fría hacia el calentador hasta alcanzar el umbral superior (p.ej., 50°C).  
4. La conectividad Wi-Fi permite al usuario controlar el sistema y ajustar parámetros desde el móvil.

### **Beneficios:**

* **Ahorro de agua y energía**.  
* **Mejora del confort**.  
* **Control remoto y personalizable**.  
* **Posibilidad de integrarlo en domótica del hogar.**

---

## **Fomentar la Adopción Ciudadana: Talleres y Open Hardware**

Para extender el uso de estos sistemas, se puede promover un enfoque participativo y abierto:

### **1\. Talleres DIY**

* **Objetivo**: construir un sistema funcional en pocas horas.  
* **Formato**: presencial o en línea, dirigido a familias, estudiantes o comunidades.  
* **Contenido**: montaje de hardware, programación básica, pruebas en entorno real.

### **2\. Publicación como Proyecto Open Hardware**

* **Repositorio en GitHub, Hackaday o Instructables**.  
* **Incluye**: esquemas, código fuente, manuales y guías paso a paso.  
* **Licencia abierta**: permite adaptaciones locales y mejoras.

### **3\. Acciones de Concienciación**

* Charlas, ferias y simuladores de ahorro.  
* Proyectos escolares y colaboración con ayuntamientos.  
* Subvenciones locales para proyectos piloto.

### **4\. Retos y Hackathons**

* Diseño de versiones más eficientes o con mejor interfaz.  
* Premios: visibilidad, implementación real, reconocimiento.

---

## **Conclusión**

La recirculación de ACS no es solo una mejora técnica: es una herramienta de sostenibilidad accesible. Mediante la combinación de tecnología abierta, educación práctica y compromiso ciudadano, podemos lograr que cada ducha sin desperdicio se convierta en una acción cotidiana de cambio. Estos sistemas permiten transformar los hábitos domésticos con un impacto real y replicable en miles de hogares.

