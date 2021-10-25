
// Лабы 14 и 15: счетчик нажатий + цепочка сдвиговых регистров
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










// Лаба 13: бегущий огонек
/*
// светодиодная шкала подключена к группе пинов расположенных
// подряд. Даём понятные имена первому и последнему пинам
#define FIRST_LED_PIN 2
#define LAST_LED_PIN 11
void setup()
{
	// в шкале 10 светодиодов. Мы бы могли написать pinMode 10
	// раз: для каждого из пинов, но это бы раздуло код и
	// сделало его изменение более проблематичным.
	// Поэтому лучше воспользоваться циклом. Мы выполняем
	// pinMode для (англ. for) каждого пина (переменная pin)
	// от первого (= FIRST_LED_PIN) до последнего включительно
	// (<= LAST_LED_PIN), всякий раз продвигаясь к следующему
	// (++pin увеличивает значение pin на единицу)
	// Так все пины от 2-го по 11-й друг за другом станут выходами
	for (int pin = FIRST_LED_PIN; pin <= LAST_LED_PIN; ++pin)
		pinMode(pin, OUTPUT);
}
void loop()
{
	// получаем время в миллисекундах, прошедшее с момента
	// включения микроконтроллера
	unsigned int ms = millis();
	// нехитрой арифметикой вычисляем, какой светодиод
	// должен гореть именно сейчас. Смена будет происходить
	// каждые 120 миллисекунд. Y % X — это остаток от
	// деления Y на X; плюс, минус, скобки — как в алгебре.
	int pin = FIRST_LED_PIN + (ms / 120) % 10;
	// включаем нужный светодиод на 10 миллисекунд, затем —
	// выключаем. На следующем проходе цикла он снова включится,
	// если гореть его черёд, и мы вообще не заметим отключения
	digitalWrite(pin, HIGH);
	delay(10);
	digitalWrite(pin, LOW);
}
*/










// Лаба 11: секундомер
/*
#define FIRST_SEGMENT_PIN 2
#define SEGMENT_COUNT 7
// префикс «0b» означает, что целое число за ним записано в
// в двоичном коде. Единицами мы обозначим номера сегментов
// индикатора, которые должны быть включены для отображения
// арабской цифры. Всего цифр 10, поэтому в массиве 10 чисел.
// Нам достаточно всего байта (англ. byte, 8 бит) для хранения
// комбинации сегментов для каждой из цифр.
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
	// определяем число, которое собираемся отображать. Пусть им
	// будет номер текущей секунды, зацикленный на десятке
	int number = (millis() / 1000) % 10;
	// получаем код, в котором зашифрована арабская цифра
	int mask = numberSegments[number];
	// для каждого из 7 сегментов индикатора...
	for (int i = 0; i < SEGMENT_COUNT; ++i) {
		// ...определяем: должен ли он быть включён. Для этого
		// считываем бит (англ. read bit), соответствующий текущему
		// сегменту «i». Истина — он установлен (1), ложь — нет (0)
		boolean enableSegment = bitRead(mask, i);
		// включаем/выключаем сегмент на основе полученного значения
		digitalWrite(i + FIRST_SEGMENT_PIN, enableSegment);
	}
}
*/













// Лаба 10: автомат уличного освещения
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







// Лаба 9: метеостанция
/*
#include <math.h>
int minute = 1;
// Параметр конкретного типа термистора (из datasheet):
#define TERMIST_B 4300
#define VIN 5.0
void setup()
{
	// мы хотим передавать информацию на компьютер через USB, а
	// точнее через последовательный (англ. serial) порт.
	// Для этого необходимо начать (англ. begin) передачу, указав
	// скорость. 9600 бит в секунду — традиционная скорость.
	// Функция «begin» не является глобальной, она принадлежит
	// объекту с именем «Serial». Объекты — это «продвинутые»
	// переменные, которые обладают собственными функциями,
	// к которым обращаются через символ точки.
	Serial.begin(9600);
	// передаём заголовок нашей таблицы в текстовом виде, иначе
	// говоря печатаем строку (англ. print line). Символы «\t» —
	// это специальная последовательность, которая заменяется на
	// знак табуляции (англ. tab): 8-кратный выровненный пробел
	//Serial.println("CLEARDATA"); // очистка листа excel
	Serial.println("CLEARSHEET");
	Serial.println("LABEL,Minute,Temperature"); // заголовки столбцов
}
void loop()
{
	// вычисляем температуру в °С с помощью магической формулы.
	// Используем при этом не целые числа, а вещественные. Их ещё
	// называют числами с плавающей (англ. float) точкой. В
	// выражениях с вещественными числами обязательно нужно явно
	// указывать дробную часть у всех констант. Иначе дробная
	// часть результата будет отброшена
	float voltage = analogRead(A0) * VIN / 1024.0;
	float r1 = voltage / (VIN - voltage);
	float temperature = 1. / (1. / (TERMIST_B)*log(r1) + 1. / (25. + 273.)) - 273;
	// печатаем текущую минуту и температуру, разделяя их табом.
	// println переводит курсор на новую строку, а print — нет
	Serial.print("DATA,");//
	Serial.print(minute);
	Serial.print(",");
	Serial.println(temperature);
	delay(1000); // засыпаем на минуту
	++minute; // увеличиваем значение минуты на 1
	// откройте окно Serial Monitor в среде Arduino, оставьте на
	// сутки, скопируйте данные в Excel, чтобы построить графики
}
*/















//// Лабы 7 и 8: конченный автомат + светофор с режимами
//
//int LEDrot = 12;
//int LEDgelb = 11;
//int LEDgruen = 10;
//int cnt = 0;
//int state = 1;
//int sleepState = 1;
//
//int mode = 0;
//int incomingByte = 0; // переменная для хранения полученного байта
//
//void setup() {
//	Serial.begin(9600); // устанавливаем последовательное соединение
//	pinMode(LEDrot, OUTPUT);
//	pinMode(LEDgelb, OUTPUT);
//	pinMode(LEDgruen, OUTPUT);
//}
//
//void loop() {
//	if (Serial.available() > 0) { // если есть доступные данные
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