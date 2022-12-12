package lotto.ui.input

private const val PREFIX = "[ERROR]"

class InputValidations {

    fun checkDigit(input: String) {
        require(input.all { it.isDigit() }) { "$PREFIX 숫자가 아닙니다." }
    }

    fun checkRemainder(input: String): Int {
        val money = input.toInt()
        require(money % 1000 == 0) { "$PREFIX 나머지가 존재합니다." }
        return money
    }

    fun checkLottoDigit(input: String): List<Int> {
        val numbers = input.split(",")
        require(numbers.joinToString().all { it.isDigit() }) { "$PREFIX 숫자가 아닙니다." }
        return numbers.map { it.toInt() }.sorted()
    }
}