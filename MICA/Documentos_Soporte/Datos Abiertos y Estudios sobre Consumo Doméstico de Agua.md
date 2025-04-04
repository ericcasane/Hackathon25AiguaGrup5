# **🚰 Resumen Completo: Datos Abiertos y Estudios sobre Consumo Doméstico de Agua**

## **📌 1\. Datos Abiertos sobre Consumo Residencial en Barcelona**

### **🔹 Open Data Barcelona (Ayuntamiento BCN)**

* **Consumo medio de agua doméstica por barrio (año 2015\)**.

* Consumo medio por habitante (litros/día).

* **Formato:** GeoPackage GIS  
   🔗 Open Data BCN: Consumo por barrio (2015)

### **🔹 Agencia Catalana del Agua (ACA)**

* **Consumo histórico por municipio en Cataluña** (incluye Barcelona).

* Diferencia consumo doméstico de otros usos.

* **Formato:** Excel  
   🔗 ACA: Consumo agua municipal histórico

* **Consumo doméstico por comarca (API/Visualización interactiva)**.

* Formatos: CSV/JSON mediante API.  
   🔗 ACA: Consumo agua por comarca (visualización/API)

### **🔹 Aigües de Barcelona (Telelectura)**

* Información sobre sistema de telelectura (datos en tiempo real por hogar).

* No disponible públicamente, pero potencialmente accesible en hackathones o colaboraciones específicas.  
   🔗 Aigües Barcelona \- Telelectura

---

## **📌 2\. Datos Abiertos sobre Consumo Residencial en Otras Regiones (Internacional)**

### **🔹 Instituto Nacional de Estadística (INE, España)**

* Datos generales sobre consumo residencial medio anual (128 litros por persona/día en 2022).  
   🔗 INE: Estadísticas consumo de agua

### **🔹 Empresa Servicios Públicos (Colombia)**

* Datos de consumo y facturación residencial (útil para análisis comparativos).  
   🔗 Datos Consumo Agua Colombia

---

## **📌 3\. Estudios Científicos sobre Patrones de Consumo (Útiles para IA)**

Estos estudios contienen patrones útiles para reconocer y clasificar puntos específicos de consumo doméstico (duchas, cisternas, lavadoras…) mediante algoritmos inteligentes:

### **🔹 Non-intrusive Water Usage Classification (IEEE)**

* Clasificación automática de eventos específicos con pocos datos reales usando datos sintéticos.

* Enfoque muy útil para entrenar modelos predictivos.  
   🔗 [Estudio IEEE sobre clasificación del consumo](https://ieeexplore.ieee.org/document/9054845)

### **🔹 Tracking Behavioural Consistency (arXiv)**

* Análisis de patrones periódicos en consumo doméstico mediante datos cada 15 minutos durante largos períodos.

* Demuestra cómo el consumo residencial puede clasificarse con IA a partir de patrones de periodicidad.  
   🔗 [Estudio sobre patrones periódicos del consumo de agua](https://arxiv.org/abs/1905.05025)

### **🔹 Caracterización del consumo doméstico (Scielo)**

* Proporciona porcentajes generales sobre distribución del consumo doméstico por tipo de uso (ducha \~34%, WC \~21%, etc.).

* Útil para calibrar o generar datos sintéticos realistas para entrenar modelos de clasificación.  
   🔗 Caracterización por tipo de uso doméstico

---

## **📌 4\. Estrategias para obtener Datos de Alta Calidad para IA**

Ante la dificultad para obtener datos abiertos altamente detallados, estas estrategias son recomendables:

* **Generación de datos sintéticos:**  
   Crear datasets simulados realistas basados en estudios existentes sobre distribución del consumo doméstico por actividad.

* **Colaboración con empresas gestoras:**  
   Explorar posibles acuerdos con entidades locales (ej. Aigües de Barcelona) que puedan facilitar acceso puntual a datos detallados o anonimizados.

* **Contactar investigadores:**  
   Solicitar datasets usados en investigaciones académicas mediante contacto directo con autores en plataformas como [ResearchGate](https://www.researchgate.net) o [arXiv](https://arxiv.org).

---

## **📌 5\. Conclusión y recomendaciones**

Para desarrollar soluciones tecnológicas y de IA que promuevan un consumo de agua responsable en hogares:

1. Comienza con los **datos agregados oficiales (Open Data BCN, ACA)**.

2. Usa los **patrones detallados de los estudios científicos** para generar modelos y datos sintéticos.

3. Explora posibles **colaboraciones con entidades locales** para acceder a datasets más detallados.

Con esta estrategia combinada podrás diseñar soluciones robustas, innovadoras y realistas para tu hackathon en Barcelona.

---

## **🌐 Recapitulación de todos los Enlaces Directos:**

* Open Data BCN: Consumo por barrio 2015

* ACA: Consumo agua municipal histórico

* ACA: Consumo agua por comarca (API)

* Aigües Barcelona \- Telelectura

* INE (España): Estadísticas de consumo agua

* Datos Consumo Agua Colombia

* [Estudio IEEE: Non-intrusive Water Usage Classification](https://ieeexplore.ieee.org/document/9054845)

* [Estudio arXiv: Tracking Behavioural Consistency](https://arxiv.org/abs/1905.05025)

* Scielo: Caracterización consumo doméstico

