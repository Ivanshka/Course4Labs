import java.util.function.IntPredicate

class ChessFigureImpl constructor(_name: String, _color: Color, _position: String?) : ChessFigure {

    private var position: String? = null;
    private var chessName: String = "";
    private var chessColor: Color = Color.WHITE;
    private var state : State = State()

    private val correctLetters : List<Char> = listOf('a','b','c','d','e','f','g','h')
    private val correctDigits : List<Char> = listOf('1','2','3','4','5','6','7','8')

    init {
        if(position?.length == 2){
            correctLetters.contains(position?.get(0))
            correctDigits.contains(position?.get(1))
        }

        chessName = _name
        chessColor = _color
    }

    constructor(_name: String, _position: String?) : this(_name, Color.BLACK, _position){
    }

    override val name: String
        get() = chessName

    override val color: Color
        get() = chessColor

    override fun bar() {
        println("Bar")
    }

    fun setPos(position: String){
        this.position = position
    }

    fun go(newPosition: String){
        if(state.state != "beaten") {
            if (newPosition.length == 2) {
                correctLetters.contains(newPosition[0])
                correctDigits.contains(newPosition[1])
            }

            position = newPosition;

            print(name)
            print(" ")
            print(position)
            print(":")
            println(newPosition)
        }
    }

    fun remove(){
        if(state.state != "beaten") {
            print(name)
            println(" was beaten")
            position = null;
            state.state = "beaten"
        }

    }

    fun printState(){
        println(state.state)
    }

    class State {
        var state : String = "Alive"
    }

    operator fun plus(other: Int): Int {
        println(other)
        return other;
    }

    fun converter (which: String): ((Double, Double) -> Double)? {
        if(which == "+")
        return  { d: Double, d1: Double ->
            d + d1
        };
        if(which == "-")
        return  { d: Double, d1: Double ->
            d - d1
        };

        return null
    }

}