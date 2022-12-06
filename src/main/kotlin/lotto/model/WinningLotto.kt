package lotto.model

class WinningLotto(private val winningNumbers: Lotto, private val bonusNumber: Int) {
    init {
        require(bonusNumber in 1..45)
        require(!winningNumbers.contains(bonusNumber))
    }

    fun checkRating(lotto: Lotto): Rating {
        return Rating.FIRST
    }
}