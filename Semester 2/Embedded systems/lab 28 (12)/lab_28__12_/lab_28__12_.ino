






// ЭТО ГОВНО ПОЛУРАБОТАЕТ, ЕГО НАДО ДОПИЛИВАТЬ !!!








#define BUZZER_PIN 6
#define START_PAUSE 4
#define FIRST_SOUND 3
#define SECOND_SOUND 2

#include <LiquidCrystal.h>

// Init display
LiquidCrystal lcd( 13, 12, 11, 10, 9, 8 );

boolean toPlay = false;
int soundNumber = 1;

void setup()
{
    lcd.begin( 16 , 2 );
    
    pinMode(BUZZER_PIN, OUTPUT);
    pinMode(START_PAUSE, INPUT_PULLUP);
    pinMode(FIRST_SOUND, INPUT_PULLUP);
    pinMode(SECOND_SOUND, INPUT_PULLUP);
}

void startPause() {
    lcd.clear();
    lcd.print("pause");

    toPlay = !toPlay;
    delay(500);
}


void laba() {
    boolean startpause = !digitalRead(START_PAUSE);
    boolean sound1 = !digitalRead(FIRST_SOUND);
    boolean sound2 = !digitalRead(SECOND_SOUND);

    if (startpause == HIGH) {
        delay(500);
        if (startpause == HIGH){
            startPause(); 
        }
    }

    if (sound1 == HIGH) {
        delay(500);
        if (sound1 == HIGH){
        soundNumber = 1;
        }
    }

    if (sound2 == HIGH) {
        delay(500);
        if (sound2 == HIGH){
        
        soundNumber = 2;
        }
    }
    
    if (toPlay){
        if (soundNumber = 1){
            tone(BUZZER_PIN, 1000, 1000);
            lcd.clear();
            lcd.print("s1");
        }
            
        if (soundNumber = 2){
            lcd.clear();
            lcd.print("s2");
            tone(BUZZER_PIN, 2000, 500);
        }
    }
}

void loop()
{
    laba();
//    lcd.print("work");
}
