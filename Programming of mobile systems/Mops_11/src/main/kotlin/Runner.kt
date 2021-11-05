
import kotlin.jvm.JvmStatic


object Runner {
    @JvmStatic
    fun main(args: Array<String>) {
        val p1 = Player("1", "2", 20)
        val p2 = Player("2", "3", 30)
        val p3 = Player("3", "4", 40)
        Board.foo()

        val chessFigure3 = ChessFigureImpl("1236", Color.WHITE, "a4")
        chessFigure3.converter("+")?.invoke(Double.MIN_VALUE, Double.MIN_VALUE)
        chessFigure3.converter("-")?.invoke(Double.MIN_VALUE, Double.MIN_VALUE)
    }
}

//class A {
//    private lateinit var prop: String
//
//    fun setUp() {
//        prop = "100 + 200"
//    }
//
//    fun display() {
//        if(::prop.isInitialized) {
//            println(prop)
//        }
//    }
//}
//
//fun main(args: Array<String>) {
//    val a = A()
//    a.display()
//
//}