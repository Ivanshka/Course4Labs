import java.util.regex.Pattern
import kotlin.jvm.JvmStatic

//FILE VARS/VALS
val integerVal : Int = 123
var integerVar : Int = 123

enum class Day(val value: Int){
    HOLIDAY(123),
    NOT_A_HOLIDAY(123);


    companion object {
        fun of(day : Int) : Day?{
            if(day == 123){
                return HOLIDAY;
            }

            return NOT_A_HOLIDAY;
        }
    }
}

object StringDemo {

    @JvmStatic
    fun main(args: Array<String>) {
        val palindrome = "Dot saw I was Tod"
        val len = palindrome.length
        val tempCharArray = CharArray(len)
        val charArray = CharArray(len)
        for (i in 0 until len) {
            tempCharArray[i] = palindrome[i]
        }
        for (j in 0 until len) {
            charArray[j] = tempCharArray[len - 1 - j]
        }
        val reversePalindrome = String(charArray)
        println(reversePalindrome)

        //DIFFERENCE BETWEEN val and var
        //integerVal = 12// isn't possible
        integerVar = 12

        // CAST
        var doubleVar : Double = integerVar.toDouble()

        //OUTPUT
        println(integerVal)
        println(integerVar)

        //READ
        val name = readLine()
        println(name)

        //FUN
        println("---FUN---")
        println("is valid " + isValid("asd@mail.com", "1231231"))
        println("is valid " + isValid(null, "1231231"))
        println("is valid " + isValid("asd@mail.com", null))

        //ENUMS
        println("---ENUMS---")
        var date : Day? = Day.of(readLine()!!.toInt())
        when(date){
            Day.HOLIDAY -> println("HOLIDAY")
            Day.NOT_A_HOLIDAY -> println("NOT A HOLIDAY")
        }

        //CALC
        println("---DO CALC---")
        println(doOperation(1,2,'+'))
        println(doOperation(4,2,'-'))
        println(doOperation(4,2,'*'))
        println(doOperation(4,2,'/'))

        //INDEX OF MAX
        println("---INDEX OF MAX---")
        println(indexOfMax(IntArray(5) { 10 * (it + 1) }))

        //COINCIDENCE
        println("---COINCIDENCE---")
        println(coincidence("Some"))
        println(coincidence("SomeSDA"))
        println(coincidence("SomeString"))

        //FACTORIAL
        println("---FACTORIAL---")
        println(factorial(5))
        println(factorialR(5))

        //IS PRIME
        println("---PRIME---")
        println(isPrime(10000))
        println(isPrime(5))
        println(isPrime(21))
        println(isPrime(13))

        //ANY
        println("---ANY---")
        println(containsIn(List(5){(it + 1)}))
        println(containsIn(List(5){(it + 5)}))

        //STREAM
        val numbers = listOf(1, 2, 3, 17)
        println(numbers.filter(::isPrime).all { it == 3 })
        println(numbers.filter(::isPrime).any { it == 3 })
        println(numbers.filter(::isPrime).forEach{println(it)})

        //MAP
        val map = mapOf("One" to 1, "Two" to 2, "Eight" to 8)
        println(map)
        val map2 = mutableMapOf<String, Int>();
        map.forEach{ map2.put(it.key, it.value * 10)}
        println(map2)
    }

    val EMAIL_ADDRESS_PATTERN = Pattern.compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
    )

    fun isValid(email: String?, password: String?) : Boolean{
        return  notNul(email)
                && notNul(password)
                && EMAIL_ADDRESS_PATTERN.matcher(email).matches()
                && password?.length!! >= 6
                && password.length <= 12
    }

    fun notNul(value: String?) = value !== null

    fun doOperation (a:Int , b:Int, operation:Char): Double {
        when(operation){
            '+' -> return (a + b).toDouble();
            '-' -> return (a - b).toDouble();
            '*' -> return (a * b).toDouble();
            '/' -> return (a / b).toDouble();
        }

        throw RuntimeException("operation is not supported")
    }

    fun indexOfMax(value: IntArray): Int? {
        if(value.isEmpty()) return null;

        return value.indexOf(value.maxOrNull()!!);
    }

    fun coincidence(value: String): Boolean? {
        if(value.isEmpty()) return false;

        return "SomeString".contains(value)
    }

    fun factorial(num: Int): Long {
        var result = 1L
        for (i in 2..num) result *= i
        return result
    }


    fun factorialR(n: Int): Double = if (n < 2) 1.0 else n * factorialR(n - 1)

    fun isPrime(n: Int) : Boolean {
        for (i in 2..n / 2) {
            // condition for nonprime number
            if (n % i == 0) {
                return false
            }
        }

        return true;
    }

    fun containsIn(collection: Collection<Int>): Boolean = collection.any { collection.contains(3)}
}