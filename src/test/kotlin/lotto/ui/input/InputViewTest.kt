package lotto.ui.input

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class InputViewTest {

    private val inputView = InputView()

    @ParameterizedTest
    @CsvSource(MONEY_DIGIT_EXCEPTION, REMAINDER_EXCEPTION)
    fun `구입 금액 입력 예외 처리`(input: String) {
        assertThrows<IllegalArgumentException> { inputView.readMoney(input) }
    }

    @Test
    fun `당첨 번호 입력 예외 처리`() {
        val input = WINNING_NUMBER_DIGIT_EXCEPTION
        assertThrows<IllegalArgumentException> { inputView.readWinningNumbers(input) }
    }

    @Test
    fun `보너스 번호 입력 예외 처리`() {
        val input = BONUS_NUMBER_DIGIT_EXCEPTION
        assertThrows<IllegalArgumentException> { inputView.readBonusNumber(input) }
    }

    companion object {
        private const val MONEY_DIGIT_EXCEPTION = "1234a"
        private const val WINNING_NUMBER_DIGIT_EXCEPTION = "1,2,3,4,5,a"
        private const val BONUS_NUMBER_DIGIT_EXCEPTION = "a"
        private const val REMAINDER_EXCEPTION = "14100"
    }
}