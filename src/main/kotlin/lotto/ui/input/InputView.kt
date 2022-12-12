package lotto.ui.input

import camp.nextstep.edu.missionutils.Console
import lotto.model.Lotto

class InputView {

    private val inputValidations = InputValidations()

    fun readMoney(input: String): Int {
        return try {
            inputValidations.checkDigit(input)
            inputValidations.checkRemainder(input)
        } catch (e: IllegalArgumentException) {
            0
        }
    }

    fun readWinningNumbers(input: String): Lotto? {
        return try {
            Lotto(inputValidations.checkLottoDigit(input))
        } catch (e: IllegalArgumentException) {
            null
        }
    }

    fun readBonusNumber(input: String): Int {
        return try {
            inputValidations.checkDigit(input)
            input.toInt()
        } catch (e: IllegalArgumentException) {
            0
        }
    }

    fun getInput(): String = Console.readLine()
}