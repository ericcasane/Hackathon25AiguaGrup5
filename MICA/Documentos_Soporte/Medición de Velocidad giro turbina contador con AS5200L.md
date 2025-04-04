# Reto: Adaptación del Sensor AS5200L para la Medición de Velocidad de Giro en Contadores de Agua

## Introducción

El desafío consiste en aplicar el sensor AS5200L en un contador de agua volumétrico JV400. Este tipo de contador destaca por su gran precisión y capacidad de medir caudales muy bajos, sin embargo, presenta dos particularidades técnicas relevantes para este reto:

1. La velocidad de giro del pistón es muy baja, con pocas vueltas por litro.

2. El giro no es uniforme a lo largo de los 360°, debido a la geometría interna y el acople mecánico del sistema volumétrico.

Esto genera una dificultad adicional: no basta con contar vueltas, ya que la relación entre posición angular y volumen no es lineal. La propuesta es utilizar el AS5200L para obtener información angular detallada y así poder:

* Generar múltiples pulsos por vuelta, mejorando la resolución.

* Compensar la no uniformidad del giro mediante un análisis angular más fino.

* Hacer todo esto con un sistema de bajo consumo energético, esencial para aplicaciones autónomas.

## Conceptos Clave

1. AS5200L: Un Sensor de Posición Rotativo Popular y Accesible

El AS5200L es un sensor de posición magnético que se emplea principalmente en aplicaciones como:

● Sistemas automotrices, para la detección de posiciones de pedales o actuadores. ● Electrónica industrial, en la detección de posiciones angulares en motores y actuadores. ● Potenciómetros sin contacto, donde reemplaza soluciones mecánicas propensas al desgaste.

El AS5200L destaca por su precisión, robustez y bajo consumo de energía, lo que lo hace ideal para aplicaciones de monitoreo de flujo donde la durabilidad es crucial.

2. Medición de Velocidad de Giro en un Contador de Agua

Los contadores de agua funcionan midiendo el giro de una turbina interna impulsada por el flujo de agua. Tradicionalmente, la velocidad de esta turbina se mide mediante sensores de efecto Hall o sensores mecánicos. En este reto, se busca reemplazar estos métodos por el AS5200L, aprovechando su capacidad para detectar posiciones angulares de forma precisa y sin contacto.

Ventajas de este enfoque: ✅ Mayor precisión en la medición de velocidad instantánea. ✅ Menor desgaste, ya que el sensor funciona sin contacto mecánico. ✅ Optimización del consumo de energía, gracias a su diseño eficiente.

3. Implementación del AS5200L en la Medición de Velocidad

El sensor AS5200L se utiliza con un imán diametralmente magnetizado acoplado a la turbina del contador de agua. A medida que la turbina gira, el sensor detecta el ángulo del campo magnético y, a partir de sus cambios en el tiempo, se puede calcular la velocidad instantánea de giro.

Datos obtenidos por el sensor: ● Posición angular absoluta. ● Cálculo del desplazamiento angular en un intervalo de tiempo. ● Conversión de la velocidad angular a caudal de agua.

El AS5200L ofrece salidas digitales mediante I²C o PWM, lo que facilita su integración con microcontroladores.

4. Alternativa de Bajo Consumo: Conversión de PWM a Voltaje y Comparación Analógica

Para reducir aún más el consumo energético del sistema, es posible aprovechar la salida PWM del AS5200L mediante un enfoque hardware de muy bajo consumo. Este método permite generar pulsos por ángulo sin necesidad de que el microcontrolador esté continuamente activo.

## Descripción del enfoque:

* El AS5200L en modo PWM entrega un ciclo de trabajo proporcional al ángulo (de 1% a 99%).

* Un filtro RC convierte el PWM en una tensión continua proporcional al ángulo.

* Un comparador analógico de ultra bajo consumo (por ejemplo, TLV3691) compara esa señal con una referencia fija.

* Cuando la señal supera el umbral de referencia, se genera un pulso digital que puede activar una interrupción del microcontrolador.

Dimensionamiento del filtro:

* Frecuencia del PWM: \~1 kHz → Periodo \= 1 ms.

* Giro de la turbina: \~1 vuelta/segundo → cambio de 1% en duty cada 10 ms aprox.

* Recomendación: filtro RC con constante de tiempo de 5 ms a 20 ms (por ejemplo, R \= 47 kΩ y C \= 100 nF) para equilibrar retardo y rizado.

Resolución obtenible:

* Dado que el duty cycle varía de 1% a 99%, se pueden detectar hasta 100 pasos por vuelta (3.6°/paso) o incluso más si el comparador es sensible.

Ventajas del enfoque: ✅ El microcontrolador puede dormir la mayor parte del tiempo. ✅ Solo se despierta al detectar pasos angulares definidos. ✅ Consumo total del circuito analógico puede estar por debajo de 1 µA. ✅ Precisión suficiente para generar múltiples eventos por vuelta con resolución angular adecuada.

Este enfoque híbrido hardware/software combina la precisión del sensor AS5200L con la eficiencia extrema de un sistema por interrupciones.

## Desafío para la Hackatón

Objetivo: Diseñar e implementar una estrategia para capturar y procesar los datos de velocidad instantánea de la turbina en un contador de agua utilizando el sensor AS5200L.

Puntos clave a explorar:

1. Configuración del AS5200L para capturar datos de posición angular con alta precisión.

2. Conversión de las mediciones de ángulo en velocidad instantánea de giro.

3. Desarrollo de algoritmos para procesar los datos y calcular el flujo de agua.

4. Comparación con métodos tradicionales y análisis de ventajas en consumo energético y precisión.

5. Análisis adicional utilizando un contador volumétrico JV400:

   * El contador JV400 destaca por medir caudales muy bajos y tener gran precisión en la medición del caudal instantáneo. Sin embargo, presenta una velocidad de giro no uniforme debido al acople mecánico del pistón.

   * Explorar cómo varía la velocidad de giro del pistón en cada vuelta, incluso a caudal constante.

   * Evaluar posibles métodos para compensar esta variación, analizando la necesidad de multiplicar el número de vueltas por litro mediante engranajes o aumentando la resolución de pulsos por vuelta.

   * Establecer la relación precisa entre el caudal, la velocidad de giro y las variaciones dentro de cada vuelta por motivos geométricos, utilizando el sensor AS5200L para proporcionar mediciones detalladas y precisas.

## Conclusión

Este reto invita a explorar nuevas formas de mejorar la medición de flujo de agua utilizando sensores magnéticos de posición, optimizando la precisión y reduciendo el desgaste de los sistemas mecánicos tradicionales. Los resultados de esta investigación podrían permitir un monitoreo más eficiente del consumo de agua, mejorando así la gestión de recursos y favoreciendo el uso sostenible del agua en diversos contextos.

