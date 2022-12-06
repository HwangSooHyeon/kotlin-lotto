package lotto.model

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(numbers.distinct().count() == numbers.size)
        require(numbers.all { it in 1..45 })
    }

    // TODO: 추가 기능 구현

    fun contains(bonusNumber: Int): Boolean {
        return true
    }
}
