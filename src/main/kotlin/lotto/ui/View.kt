package lotto.ui

import lotto.model.Lotto
import lotto.model.Rating
import lotto.ui.input.InputView
import lotto.ui.output.OutputView

class View {

    private val inputView = InputView()
    private val outputView = OutputView()

    fun getMoney(): Int {
        outputView.printInputMoney()
        while (true) {
            try {
                return inputView.readMoney(inputView.readInput())
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun getWinningNumbers(): Lotto {
        outputView.printInputWinningNumbers()
        while (true) {
            try {
                return inputView.readWinningNumbers(inputView.readInput())
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun getBonusNumber(): Int {
        outputView.printInputBonusNumber()
        while (true) {
            try {
                return inputView.readBonusNumber(inputView.readInput())
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun showLottos(lottos: List<Lotto>) {
        outputView.printPurchased(lottos.count())
        for (lotto in lottos) {
            println(lotto.toString())
        }
    }

    fun showStats(rates: List<Rating>, totalStats: Double) {
        outputView.printWinningStats(rates, totalStats)
    }
}