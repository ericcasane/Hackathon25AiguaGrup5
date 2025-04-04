#include <Arduino.h>
#include <Wire.h>
#include <AS5600.h>
#include <math.h> // Para round() y fabs()

// Instancia del sensor AS5600
AS5600 as5600;

// Constantes y variables globales
const float VELOCITY_THRESHOLD = 1.0;     // Umbral: cambios menores a 1 grado se consideran 0
const unsigned long samplingInterval = 20; // Intervalo de muestreo en ms (más frecuente)
float previousAngle = 0.0;
unsigned long previousTime = 0;

// Prototipos de funciones
float readAngle();
float computeDeltaAngle(float previous, float current);
float calculateAngularVelocity(float deltaAngle, unsigned long prevTime, unsigned long currTime);

void setup() {
  Serial.begin(115200);
  Wire.begin(); // Inicia I2C en los pines por defecto

  if (!as5600.begin()) {
    Serial.println("Error al inicializar el sensor AS5600.");
    while (1); // Detiene el programa si no se encuentra el sensor
  }

  // Inicializar: leer ángulo inicial redondeado
  previousAngle = round(readAngle());
  previousTime = millis();
}

void loop() {
  unsigned long currentTime = millis();
  if (currentTime - previousTime >= samplingInterval) {
    // Leer el ángulo actual y redondearlo a grados enteros
    float currentAngle = round(readAngle());
    // Calcular el cambio de ángulo, corrigiendo el cruce 0°/360°
    float deltaAngle = computeDeltaAngle(previousAngle, currentAngle);
    // Calcular la velocidad angular en grados/segundo
    float angularVelocity = calculateAngularVelocity(deltaAngle, previousTime, currentTime);

    // Si el cambio es menor a 1 grado, consideramos que la velocidad es 0
    if (fabs(deltaAngle) < VELOCITY_THRESHOLD) {
      angularVelocity = 0.0;
    }

    // Imprimir resultados
    Serial.print("Ángulo actual: ");
    Serial.print(currentAngle);
    Serial.print(" grados, Velocidad angular: ");
    Serial.print(angularVelocity);
    Serial.println(" grados/segundo");

    // Actualizar valores previos para la siguiente iteración
    previousAngle = currentAngle;
    previousTime = currentTime;
  }
}

// Lee el ángulo del sensor AS5600 y lo convierte a grados.
// La función readAngle() devuelve un valor entre 0 y 360 (calculado a partir del valor raw de 0 a 4095)
float readAngle() {
  int rawAngle = as5600.readAngle();  
  return (rawAngle * 360.0) / 4096.0;
}

// Calcula la diferencia de ángulo entre dos lecturas, ajustando el cruce de 0°/360°
float computeDeltaAngle(float previous, float current) {
  float delta = current - previous;
  if (delta > 180.0) {
    delta -= 360.0;
  } else if (delta < -180.0) {
    delta += 360.0;
  }
  return delta;
}

// Calcula la velocidad angular (grados/segundo) usando la diferencia de ángulo y el tiempo transcurrido
float calculateAngularVelocity(float deltaAngle, unsigned long prevTime, unsigned long currTime) {
  float deltaTime = (currTime - prevTime) / 1000.0; // Convertir milisegundos a segundos
  if (deltaTime == 0) return 0.0;
  return deltaAngle / deltaTime;
}
