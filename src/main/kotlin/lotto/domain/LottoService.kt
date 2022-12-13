package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.model.Lotto
import lotto.model.Rating
import lotto.model.WinningLotto

private const val START = 1
private const val END = 45
private const val COUNT = 6

class LottoService {
    fun makeLotto(money: Int): List<Lotto> {
        val count = money / 1000
        val lottos: MutableList<Lotto> = mutableListOf()
        for (i in 0 until count) {
            lottos.add(Lotto(createNumbers()))
        }
        return lottos
    }

    fun checkRate(lottos: List<Lotto>, winningLotto: WinningLotto): List<Rating> {
        val rates: MutableList<Rating> = mutableListOf()
        for (lotto in lottos) {
            rates.add(winningLotto.checkRating(lotto))
        }
        return rates
    }

    fun calculateStats(rates: List<Rating>, money: Int): Double {
        var totalPrize = 0.0
        for (rate in rates) {
            totalPrize += rate.getPrize()
        }
        return (totalPrize / money) * 100
    }

    private fun createNumbers(): List<Int> = Randoms.pickUniqueNumbersInRange(START, END, COUNT).sorted()
}