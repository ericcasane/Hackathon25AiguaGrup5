#include <Arduino.h>
#include <Wire.h>
#include <QMC5883LCompass.h>

QMC5883LCompass compass;

void setup() {
  Serial.begin(115200);
  Serial.println("Iniciando comunicación I2C...");
  Wire.begin(D2, D1); // SDA en D2, SCL en D1 para Wemos D1 Mini
  Serial.println("Inicializando el sensor QMC5883L...");
  compass.init();
  Serial.println("Sensor QMC5883L inicializado correctamente.");
}

void loop() {
  int x, y, z;
  float heading;

  // Actualizar las lecturas del sensor
  compass.read();
  x = compass.getX();
  y = compass.getY();
  z = compass.getZ();
  heading = compass.getAzimuth();

  // Mostrar las lecturas en el monitor serie
  Serial.print("X: ");
  Serial.print(x);
  Serial.print(" µT, Y: ");
  Serial.print(y);
  Serial.print(" µT, Z: ");
  Serial.print(z);
  Serial.print(" µT, Orientación (Azimuth): ");
  Serial.print(heading);
  Serial.println("°");

  delay(500);
}
