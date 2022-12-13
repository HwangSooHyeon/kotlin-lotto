package lotto.controller

import lotto.domain.LottoService
import lotto.model.Lotto
import lotto.model.WinningLotto
import lotto.ui.View

class LottoController {
    private val view = View()
    private val lottoService = LottoService()

    fun start() {
        val lottos = buy()
        result(lottos)
    }

    private fun buy(): List<Lotto> {
        val money = view.getMoney()
        val lottos = lottoService.makeLotto(money)
        view.showLottos(lottos)
        return lottos
    }

    private fun result(lottos: List<Lotto>) {
        val winningNumbers = view.getWinningNumbers()
        val bonusNumber = view.getBonusNumber()
        val winningLotto = WinningLotto(winningNumbers, bonusNumber)
        val rates = lottoService.checkRate(lottos, winningLotto)
        val stats = lottoService.calculateStats(rates, lottos.count() * 1000)
        view.showStats(rates, stats)
    }
}