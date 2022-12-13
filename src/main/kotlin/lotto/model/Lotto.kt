package lotto.model

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(numbers.distinct().count() == numbers.size)
        require(numbers.all { it in 1..45 })
    }

    fun getNumbers(): List<Int> = numbers

    fun contain(number: Int): Boolean = numbers.contains(number)

    override fun toString(): String {
        return numbers.joinToString(", ", "[", "]")
    }
}
