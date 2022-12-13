package lotto.model

private const val PREFIX = "[ERROR]"

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "$PREFIX 갯수가 맞지 않습니다." }
        require(numbers.distinct().count() == numbers.size) { "$PREFIX 중복이 있습니다." }
        require(numbers.all { it in 1..45 }) { "$PREFIX 범위가 맞지 않습니다." }
    }

    fun getNumbers(): List<Int> = numbers

    fun contain(number: Int): Boolean = numbers.contains(number)

    override fun toString(): String {
        return numbers.joinToString(", ", "[", "]")
    }
}
