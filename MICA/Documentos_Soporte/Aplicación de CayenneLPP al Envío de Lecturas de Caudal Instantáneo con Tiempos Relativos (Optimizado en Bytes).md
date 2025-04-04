**Aplicación de CayenneLPP al Envío de Lecturas de Caudal Instantáneo en Formato Batch con Tiempos Relativos (Optimizado en Bytes)**

1. Objetivo del documento
Este documento describe una adaptación extendida del protocolo CayenneLPP (Low Power Payload) para transmitir lecturas de caudal de agua instantáneo de forma compacta mediante LoRa/LoRaWAN o LoRa punto a punto. El enfoque propuesto utiliza una estructura de tipo batch que incluye múltiples tramos por mensaje, optimizando al máximo el tamaño del paquete sin perder información temporal clave.

2. Fundamentos de CayenneLPP
CayenneLPP es un estándar ligero binario (TLV: Type-Length-Value) desarrollado por myDevices, diseñado para sensores IoT en redes de bajo ancho de banda como LoRaWAN. Facilita la integración con plataformas como The Things Network o ChirpStack.

Estructura básica CayenneLPP
Cada valor de sensor se codifica como:

java
Copia
Modifica
[Canal (1 byte)] [Tipo de dato (1 byte)] [Valor codificado (N bytes)]
Ejemplos de tipos de datos predefinidos:

Tipo	ID Hex	Bytes	Descripción
Temperature	0x67	2	Temperatura en décimas °C
Humidity	0x68	1	Humedad relativa en %
GPS	0x88	9	Latitud, longitud, altitud
Voltage	0x74	2	Voltaje en milivoltios
El formato permite concatenar múltiples lecturas de sensores en un único paquete.

3. Extensión Propuesta: Batch de Tramos de Caudal
Formato general del paquete batch
Proponemos un nuevo tipo extendido de CayenneLPP para enviar múltiples tramos de caudal agrupados:

csharp
Copia
Modifica
[Canal (1B)]  
[Tipo extendido batch (1B)]   // Ej: 0xE1  
[Número de tramos (1B)]  
[Tramo 1 (6B)]  
[Tramo 2 (6B)]  
...  
[Tramo N (6B)]
Formato de cada tramo
csharp
Copia
Modifica
[Start offset (2B)]   // Segundos antes del envío  
[End offset (2B)]     // Segundos antes del envío  
[Pulsos (2B)]         // Número de impulsos de caudal
Total por tramo: 6 bytes

Total overhead del batch: 3 bytes (canal, tipo, número de tramos)

Esto permite ahorrar 2 bytes por tramo respecto a la versión anterior (que usaba 8B por tramo al incluir el canal y tipo en cada uno).

4. Tiempo Relativo: Sincronización sin RTC
Cada tramo incluye el tiempo de inicio y fin relativo al momento de transmisión, codificado en segundos.

El backend reconstruye los tiempos absolutos así:

ini
Copia
Modifica
timestamp_absoluto = timestamp_recepcion - offset_relativo
Esto permite evitar el uso de reloj en tiempo real (RTC) en el sensor, y reduce el tamaño de las marcas temporales de 4 a 2 bytes.

5. Ejemplo de Codificación
Supongamos que queremos enviar 2 tramos:

Canal: 0x01

Tipo extendido batch: 0xE1

Nº tramos: 0x02

Los tramos son:

Tramo	Start offset	End offset	Pulsos
1	300 s	180 s	25
2	180 s	0 s	30
Payload codificado (en hex):

cpp
Copia
Modifica
01 E1 02 
01 2C 00 B4 00 19   // Tramo 1  
00 B4 00 00 00 1E   // Tramo 2
Total: 3 (cabecera) + 2×6 = 15 bytes

6. Ventajas del Enfoque Batch
Compacto: solo 6 bytes por tramo + 3 de cabecera.

Flexible: se pueden enviar entre 1 y N tramos por paquete.

Modular: sigue el estilo TLV de CayenneLPP.

Compatible con datos estándar (batería, temperatura, etc.) en el mismo mensaje.

Eficiente en energía y ancho de banda.

7. Recomendaciones de Uso
Enviar los tramos en orden descendente (más reciente primero).

Mantener una frecuencia de envío regular (ej: cada 5 minutos).

En el backend, usar el timestamp de recepción para reconstruir tiempos absolutos.

Asegurar que sensor y gateway comparten configuración LoRa (SF, BW, frecuencia).

8. Conclusión
La extensión batch del protocolo CayenneLPP permite enviar lecturas de caudal instantáneo de forma eficiente, compacta y robusta. Gracias a su estructura basada en tiempos relativos, se minimiza el uso de energía y ancho de banda sin perder precisión temporal, permitiendo reconstruir series de consumo en el backend con gran fidelidad.

Este diseño está alineado con la filosofía de CayenneLPP, manteniendo compatibilidad y extensibilidad, y es ideal para aplicaciones IoT donde cada byte cuenta.

