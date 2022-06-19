#include <LiquidCrystal.h>

// Initialize Pins
int analogPin = 0;
int chargePin = 2;
int dischargePin = 3; //speeds up discharging process, not necessary though

// Initialize Resistor
int resistorValue = 10000;

// Init display
LiquidCrystal lcd( 13, 12, 11, 10, 9, 8 );

// Initialize Timer
unsigned long startTime;
unsigned long elapsedTime;

// Initialize Capacitance Variables
float microFarads;                
float nanoFarads;

void setup()
{
  pinMode(chargePin, OUTPUT);     
  digitalWrite(chargePin, LOW);  
  Serial.begin(9600); // Necessary to print data to serial monitor over USB
  lcd.begin( 16 , 2 );
}

void clearAndHome() {
    lcd.clear();
    lcd.home();
}

void loop()
{
  digitalWrite(chargePin, HIGH); // Begins charging the capacitor
  startTime = millis(); // Begins the timer
  
  while(analogRead(analogPin) < 648)
  {       
    // Does nothing until capacitor reaches 63.2% of total voltage
  }

  elapsedTime= millis() - startTime; // Determines how much time it took to charge capacitor
  microFarads = ((float)elapsedTime / resistorValue) * 1000;
  clearAndHome();
  lcd.print(elapsedTime);
  lcd.print(" mS    ");
  Serial.print(elapsedTime);       
  Serial.print(" mS    ");

  if (microFarads > 1) // Determines if units should be micro or nano and prints accordingly
  {
    clearAndHome();
    lcd.print((long)microFarads);       
    lcd.println(" microF");         
    
    Serial.print((long)microFarads);       
    Serial.println(" microF");         
  }

  else
  {
    nanoFarads = microFarads * 1000.0;      
    
    clearAndHome();
    lcd.print((long)nanoFarads);
    lcd.println(" nanoF");
    
    Serial.print((long)nanoFarads);         
    Serial.println(" nanoF");          
    delay(500); 
  }

  digitalWrite(chargePin, LOW); // Stops charging capacitor
  pinMode(dischargePin, OUTPUT); 
  digitalWrite(dischargePin, LOW); // Allows capacitor to discharge    
  while(analogRead(analogPin) > 0)
  {
    // Do nothing until capacitor is discharged      
  }

  pinMode(dischargePin, INPUT); // Prevents capacitor from discharging  
}


















// ONLY DISPLAY

//#include <LiquidCrystal.h>
//
//// Init display
//LiquidCrystal lcd( 13, 12, 11, 10, 9, 8 );
//
//void setup()
//{
//    lcd.begin( 16 , 2 );
//    lcd.print("Hello, World!");
//}
//
//void loop()
//{
//    
//}
