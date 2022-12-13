package lotto.model

private const val HIT_SIX = 6
private const val HIT_FIVE = 5
private const val HIT_FOUR = 4
private const val HIT_THREE = 3
private const val PREFIX = "[ERROR]"

class WinningLotto(private val winningNumbers: Lotto, private val bonusNumber: Int) {
    init {
        require(bonusNumber in 1..45) { "$PREFIX 보너스 번호 범위가 맞지 않습니다." }
        require(!winningNumbers.contain(bonusNumber)) { "$PREFIX 보너스 번호가 중복됩니다." }
    }

    fun checkRating(lotto: Lotto): Rating {
        var hit = getHitCount(lotto)
        when (hit) {
            HIT_SIX -> return Rating.FIRST
            HIT_FIVE -> return judgeSecond(lotto)
            HIT_FOUR -> return Rating.FOURTH
            HIT_THREE -> return Rating.FIFTH
        }
        return Rating.LOSE
    }

    private fun getHitCount(lotto: Lotto): Int {
        val numbers = lotto.getNumbers()
        var hit = 0
        for (number in numbers) {
            if (winningNumbers.contain(number))
                hit += 1
        }
        return hit
    }

    private fun judgeSecond(lotto: Lotto): Rating {
        if (lotto.contain(bonusNumber))
            return Rating.SECOND
        return Rating.THIRD
    }
}