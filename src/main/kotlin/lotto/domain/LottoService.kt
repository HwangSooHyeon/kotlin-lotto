package lotto.domain

import lotto.model.Lotto
import lotto.model.Rating
import lotto.model.WinningLotto

class LottoService {
    fun makeLotto(money: Int): List<Lotto> {
        return listOf(Lotto(listOf()))
    }

    fun winningRate(lottos: List<Lotto>, winningLotto: WinningLotto): List<Rating> {
        return listOf(Rating.FIRST)
    }
}