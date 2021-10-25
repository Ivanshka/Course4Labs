
// ���� 14 � 15: ������� ������� + ������� ��������� ���������
/*
#define DATA_PIN 13
#define LATCH_PIN 12
#define CLOCK_PIN 11

#define DATA_PIN_2 9
#define LATCH_PIN_2 8

#define BUTTON_PIN 10

int clicks = 0;
int ten = 0;
boolean buttonWasUp = true;
byte segments[10] = {
	0b01111101, 0b00100100, 0b01111010, 0b01110110, 0b00100111,
	0b01010111, 0b01011111, 0b01100100, 0b01111111, 0b01110111
};

void setup()
{
	Serial.begin(9600);
	pinMode(DATA_PIN, OUTPUT);
	pinMode(DATA_PIN_2, OUTPUT);
	pinMode(CLOCK_PIN, OUTPUT);
	pinMode(LATCH_PIN, OUTPUT);
	pinMode(LATCH_PIN_2, OUTPUT);
	pinMode(BUTTON_PIN, INPUT_PULLUP);
}

void loop()
{
	if (buttonWasUp && !digitalRead(BUTTON_PIN)) {
		delay(10);
		if (!digitalRead(BUTTON_PIN))
			clicks = (clicks + 1) % 10;
		if (clicks == 0) {
			ten++;
		}
		Serial.print("clicks ");
		Serial.println(clicks);
	}

	buttonWasUp = digitalRead(BUTTON_PIN);

	digitalWrite(LATCH_PIN, LOW);
	shiftOut(DATA_PIN, CLOCK_PIN, LSBFIRST, segments[clicks]);
	digitalWrite(LATCH_PIN, HIGH);
	digitalWrite(LATCH_PIN_2, LOW);
	shiftOut(DATA_PIN_2, CLOCK_PIN, LSBFIRST, segments[ten]);
	digitalWrite(LATCH_PIN_2, HIGH);
}
*/










// ���� 13: ������� ������
/*
// ������������ ����� ���������� � ������ ����� �������������
// ������. ��� �������� ����� ������� � ���������� �����
#define FIRST_LED_PIN 2
#define LAST_LED_PIN 11
void setup()
{
	// � ����� 10 �����������. �� �� ����� �������� pinMode 10
	// ���: ��� ������� �� �����, �� ��� �� ������� ��� �
	// ������� ��� ��������� ����� ��������������.
	// ������� ����� ��������������� ������. �� ���������
	// pinMode ��� (����. for) ������� ���� (���������� pin)
	// �� ������� (= FIRST_LED_PIN) �� ���������� ������������
	// (<= LAST_LED_PIN), ������ ��� ����������� � ����������
	// (++pin ����������� �������� pin �� �������)
	// ��� ��� ���� �� 2-�� �� 11-� ���� �� ������ ������ ��������
	for (int pin = FIRST_LED_PIN; pin <= LAST_LED_PIN; ++pin)
		pinMode(pin, OUTPUT);
}
void loop()
{
	// �������� ����� � �������������, ��������� � �������
	// ��������� ����������������
	unsigned int ms = millis();
	// �������� ����������� ���������, ����� ���������
	// ������ ������ ������ ������. ����� ����� �����������
	// ������ 120 �����������. Y % X � ��� ������� ��
	// ������� Y �� X; ����, �����, ������ � ��� � �������.
	int pin = FIRST_LED_PIN + (ms / 120) % 10;
	// �������� ������ ��������� �� 10 �����������, ����� �
	// ���������. �� ��������� ������� ����� �� ����� ���������,
	// ���� ������ ��� ����, � �� ������ �� ������� ����������
	digitalWrite(pin, HIGH);
	delay(10);
	digitalWrite(pin, LOW);
}
*/










// ���� 11: ����������
/*
#define FIRST_SEGMENT_PIN 2
#define SEGMENT_COUNT 7
// ������� �0b� ��������, ��� ����� ����� �� ��� �������� �
// � �������� ����. ��������� �� ��������� ������ ���������
// ����������, ������� ������ ���� �������� ��� �����������
// �������� �����. ����� ���� 10, ������� � ������� 10 �����.
// ��� ���������� ����� ����� (����. byte, 8 ���) ��� ��������
// ���������� ��������� ��� ������ �� ����.
byte numberSegments[10] = {
 0b00111111, 0b00001010, 0b01011101, 0b01011110, 0b01101010,
 0b01110110, 0b01110111, 0b00011010, 0b01111111, 0b01111110,
};
void setup()
{
	for (int i = 0; i < SEGMENT_COUNT; ++i)
		pinMode(i + FIRST_SEGMENT_PIN, OUTPUT);
}
void loop()
{
	// ���������� �����, ������� ���������� ����������. ����� ��
	// ����� ����� ������� �������, ����������� �� �������
	int number = (millis() / 1000) % 10;
	// �������� ���, � ������� ����������� �������� �����
	int mask = numberSegments[number];
	// ��� ������� �� 7 ��������� ����������...
	for (int i = 0; i < SEGMENT_COUNT; ++i) {
		// ...����������: ������ �� �� ���� �������. ��� �����
		// ��������� ��� (����. read bit), ��������������� ��������
		// �������� �i�. ������ � �� ���������� (1), ���� � ��� (0)
		boolean enableSegment = bitRead(mask, i);
		// ��������/��������� ������� �� ������ ����������� ��������
		digitalWrite(i + FIRST_SEGMENT_PIN, enableSegment);
	}
}
*/













// ���� 10: ������� �������� ���������
/*
int LED = 13;
int LDR = 0;
int Poti = 1;
int cnt = 0;

void setup() {
	pinMode(LED, OUTPUT);
	Serial.begin(9600);
}

void loop() {
	Serial.print("LDR: ");
	Serial.print(analogRead(LDR));
	Serial.print(", Poti: ");
	Serial.println(analogRead(Poti));
	if (analogRead(LDR) < analogRead(Poti)) {
		digitalWrite(LED, HIGH);
	}
	else
		digitalWrite(LED, LOW);

	delay(10);

}
*/







// ���� 9: ������������
/*
#include <math.h>
int minute = 1;
// �������� ����������� ���� ���������� (�� datasheet):
#define TERMIST_B 4300
#define VIN 5.0
void setup()
{
	// �� ����� ���������� ���������� �� ��������� ����� USB, �
	// ������ ����� ���������������� (����. serial) ����.
	// ��� ����� ���������� ������ (����. begin) ��������, ������
	// ��������. 9600 ��� � ������� � ������������ ��������.
	// ������� �begin� �� �������� ����������, ��� �����������
	// ������� � ������ �Serial�. ������� � ��� ������������
	// ����������, ������� �������� ������������ ���������,
	// � ������� ���������� ����� ������ �����.
	Serial.begin(9600);
	// ������� ��������� ����� ������� � ��������� ����, �����
	// ������ �������� ������ (����. print line). ������� �\t� �
	// ��� ����������� ������������������, ������� ���������� ��
	// ���� ��������� (����. tab): 8-������� ����������� ������
	//Serial.println("CLEARDATA"); // ������� ����� excel
	Serial.println("CLEARSHEET");
	Serial.println("LABEL,Minute,Temperature"); // ��������� ��������
}
void loop()
{
	// ��������� ����������� � �� � ������� ���������� �������.
	// ���������� ��� ���� �� ����� �����, � ������������. �� ���
	// �������� ������� � ��������� (����. float) ������. �
	// ���������� � ������������� ������� ����������� ����� ����
	// ��������� ������� ����� � ���� ��������. ����� �������
	// ����� ���������� ����� ���������
	float voltage = analogRead(A0) * VIN / 1024.0;
	float r1 = voltage / (VIN - voltage);
	float temperature = 1. / (1. / (TERMIST_B)*log(r1) + 1. / (25. + 273.)) - 273;
	// �������� ������� ������ � �����������, �������� �� �����.
	// println ��������� ������ �� ����� ������, � print � ���
	Serial.print("DATA,");//
	Serial.print(minute);
	Serial.print(",");
	Serial.println(temperature);
	delay(1000); // �������� �� ������
	++minute; // ����������� �������� ������ �� 1
	// �������� ���� Serial Monitor � ����� Arduino, �������� ��
	// �����, ���������� ������ � Excel, ����� ��������� �������
}
*/















//// ���� 7 � 8: ��������� ������� + �������� � ��������
//
//int LEDrot = 12;
//int LEDgelb = 11;
//int LEDgruen = 10;
//int cnt = 0;
//int state = 1;
//int sleepState = 1;
//
//int mode = 0;
//int incomingByte = 0; // ���������� ��� �������� ����������� �����
//
//void setup() {
//	Serial.begin(9600); // ������������� ���������������� ����������
//	pinMode(LEDrot, OUTPUT);
//	pinMode(LEDgelb, OUTPUT);
//	pinMode(LEDgruen, OUTPUT);
//}
//
//void loop() {
//	if (Serial.available() > 0) { // ���� ���� ��������� ������
//		incomingByte = Serial.read();
//
//		switch (incomingByte) {
//		case 'n':
//			mode = 1;
//			Serial.println("Normal mode");
//			break;
//		case 's':
//			mode = 2;
//			Serial.println("Sleep mode");
//			break;
//		case 'r':
//			mode = 3;
//			Serial.println("Red mode");
//			break;
//		case 'g':
//			mode = 4;
//			Serial.println("Green mode");
//			break;
//		}
//	}
//
//	cnt++;
//	if (cnt == 100) {
//		cnt = 0;
//		Statemaschine();
//	}
//
//	delay(10);
//}
//
//void Statemaschine() {
//	switch (mode)
//	{
//	case 0:
//		break;
//	case 1:
//		normal();
//		break;
//	case 2:
//		sleep();
//		break;
//	case 3:
//		red();
//		break;
//	case 4:
//		green();
//		break;
//	}
//}
//
//void normal() {
//	switch (state)
//	{
//	case 1:
//		digitalWrite(LEDrot, HIGH);
//		digitalWrite(LEDgelb, LOW);
//		digitalWrite(LEDgruen, LOW);
//		state++;
//		break;
//	case 2:
//		digitalWrite(LEDrot, HIGH);
//		digitalWrite(LEDgelb, HIGH);
//		digitalWrite(LEDgruen, LOW);
//		state++;
//		break;
//	case 3:
//		digitalWrite(LEDrot, LOW);
//		digitalWrite(LEDgelb, LOW);
//		digitalWrite(LEDgruen, HIGH);
//		state++;
//		break;
//	case 4:
//		digitalWrite(LEDrot, LOW);
//		digitalWrite(LEDgelb, HIGH);
//		digitalWrite(LEDgruen, LOW);
//		state = 1;
//		break;
//	}
//}
//
//void sleep() {
//	if (sleepState == 1) {
//		digitalWrite(LEDrot, LOW);
//		digitalWrite(LEDgelb, LOW);
//		digitalWrite(LEDgruen, LOW);
//		sleepState++;
//	}
//	else
//	{
//		digitalWrite(LEDrot, LOW);
//		digitalWrite(LEDgelb, HIGH);
//		digitalWrite(LEDgruen, LOW);
//		sleepState--;
//	}
//}
//
//void red() {
//	digitalWrite(LEDrot, HIGH);
//	digitalWrite(LEDgelb, LOW);
//	digitalWrite(LEDgruen, LOW);
//}
//
//void green() {
//	digitalWrite(LEDrot, LOW);
//	digitalWrite(LEDgelb, LOW);
//	digitalWrite(LEDgruen, HIGH);
//}