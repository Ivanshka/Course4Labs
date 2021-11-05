object Board {
    fun foo(){
        val chessFigure = ChessFigureImpl("123", Color.BLACK, "a1")
        val chessFigure1 = ChessFigureImpl("1234", Color.WHITE, "a2")
        val chessFigure2 = ChessFigureImpl("1235", Color.BLACK, "a3")
        val chessFigure3 = ChessFigureImpl("1236", Color.WHITE, "a4")
        val chessFigure4 = ChessFigureImpl("1237", Color.BLACK, "a5")

        chessFigure.go("b3")
        chessFigure1.go("g5")
        chessFigure2.go("b1")
        chessFigure3.go("h6")
        chessFigure4.go("e2")
        chessFigure1.printState()
        chessFigure1.remove()
        chessFigure1.printState()
    }
}