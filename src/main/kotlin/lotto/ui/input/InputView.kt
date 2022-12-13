package lotto.ui.input

import camp.nextstep.edu.missionutils.Console
import lotto.model.Lotto

class InputView {

    private val inputValidations = InputValidations()

    fun readMoney(input: String): Int {
        inputValidations.checkDigit(input)
        return inputValidations.checkRemainder(input)
    }

    fun readWinningNumbers(input: String): Lotto = Lotto(inputValidations.checkLottoDigit(input))

    fun readBonusNumber(input: String): Int {
        inputValidations.checkDigit(input)
        return input.toInt()
    }

    fun readInput(): String = Console.readLine()
}