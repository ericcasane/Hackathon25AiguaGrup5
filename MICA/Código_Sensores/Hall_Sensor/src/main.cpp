#include <Arduino.h>

volatile unsigned long lastTimestamp = 0;
volatile unsigned long currentTimestamp = 0;
volatile bool newPulse = false;

const int HALL_PIN = D2;  // Usa directamente la etiqueta D2 (equivale a GPIO4 en Wemos D1 Mini)

void IRAM_ATTR handlePulse() {
  unsigned long now = millis();
  if (now - currentTimestamp > 5) {
    lastTimestamp = currentTimestamp;
    currentTimestamp = now;
    newPulse = true;
  }
}

void setup() {
  Serial.begin(115200);
  delay(1000);

  pinMode(HALL_PIN, INPUT_PULLUP);
  attachInterrupt(digitalPinToInterrupt(HALL_PIN), handlePulse, FALLING);

  Serial.println("Sistema iniciado. Esperando pulsos en D2...");
}

void loop() {
  if (newPulse) {
    noInterrupts();
    unsigned long ts = currentTimestamp;
    unsigned long diff = ts - lastTimestamp;
    newPulse = false;
    interrupts();

    Serial.print("Pulso detectado en: ");
    Serial.print(ts);
    Serial.print(" ms. Δt = ");
    Serial.print(diff);
    Serial.println(" ms");
  }
}
