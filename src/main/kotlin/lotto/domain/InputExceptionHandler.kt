package lotto.domain

object InputExceptionHandler {
    private const val PURCHASING_AMOUNT_EXCEPTION_MESSAGE = "[ERROR] 구입금액이 올바르지 않습니다."
    private const val WINNING_NUMBERS_EXCEPTION_MESSAGE = "[ERROR] 당첨번호가 올바르지 않습니다."
    private const val BONUS_NUMBER_EXCEPTION_MESSAGE = "[ERROR] 보너스 번호가 올바르지 않습니다."

    /**
     * 구입 금액 예외 처리
     *
     * 1. 1000으로 나누어 떨어지지 않을 때
     *
     * 2. 숫자가 아닐 때
     * */
    fun checkInputPurchasingAmount(inputPurchasingAmount: String) {
        if (!isNumberOfPurchasingAmount(inputPurchasingAmount)) {
            throw IllegalArgumentException(PURCHASING_AMOUNT_EXCEPTION_MESSAGE)
        }
        if (!hasRemainderOfPurchasingAmount(inputPurchasingAmount)) {
            throw IllegalArgumentException(PURCHASING_AMOUNT_EXCEPTION_MESSAGE)
        }
    }

    private fun hasRemainderOfPurchasingAmount(inputPurchasingAmount: String): Boolean {
        return inputPurchasingAmount.toInt() % 1000 <= 0
    }

    private fun isNumberOfPurchasingAmount(inputPurchasingAmount: String): Boolean {
        return inputPurchasingAmount.all { it.isDigit() }
    }

    /**
     * 당첨번호 예외 처리
     *
     * 1. split 시 숫자가 아닐 때
     *
     * 2. split 했을 때 요소 수가 6개가 아닐 때
     *
     * 3. 로또 범위 내 숫자가 아닐 때
     *
     * 4. 중복이 있을 때
     * */
    fun checkInputWinningNumbers(inputWinningNumbers: String) {
        val winningNumbers = inputWinningNumbers.split(",")
        if (!isNumberOfWinningNumbers(winningNumbers)) {
            throw IllegalArgumentException(WINNING_NUMBERS_EXCEPTION_MESSAGE)
        }
        if (!hasElementOfWinningNumbers(winningNumbers)
            or !isCorrectRangeOfWinningNumbers(winningNumbers)
            or !isUniqueOfWinningNumbers(winningNumbers)
        ) {
            throw IllegalArgumentException(WINNING_NUMBERS_EXCEPTION_MESSAGE)
        }
    }

    private fun isNumberOfWinningNumbers(winningNumbers: List<String>): Boolean {
        return winningNumbers
            .joinToString("")
            .all { it.isDigit() }
    }

    private fun hasElementOfWinningNumbers(winningNumbers: List<String>): Boolean {
        return winningNumbers.size == 6
    }

    private fun isCorrectRangeOfWinningNumbers(winningNumbers: List<String>): Boolean {
        return winningNumbers.all { it.toInt() in 1..45 }
    }

    private fun isUniqueOfWinningNumbers(winningNumbers: List<String>): Boolean {
        return winningNumbers.size == winningNumbers.distinct().count()
    }

    /**
     * 보너스 번호 예외처리
     *
     * 1. 숫자가 아닐 때
     *
     * 2. 로또 범위 내 숫자가 아닐 때
     *
     * 3. 당첨 번호와 중복일 때
     * */
    fun checkInputBonusNumber(winningNumbers: Lotto, bonusNumber: String) {
        if (!isNumberOfBonusNumber(bonusNumber)) {
            throw IllegalArgumentException(BONUS_NUMBER_EXCEPTION_MESSAGE)
        }
        if (!isCorrectRangeOfBonusNumber(bonusNumber)
            or !isUniqueOfBonusNumber(winningNumbers, bonusNumber)
        ) {
            throw IllegalArgumentException(BONUS_NUMBER_EXCEPTION_MESSAGE)
        }
    }

    private fun isNumberOfBonusNumber(bonusNumber: String): Boolean {
        return bonusNumber.all { it.isDigit() }
    }

    private fun isCorrectRangeOfBonusNumber(bonusNumber: String): Boolean {
        return bonusNumber.toInt() in 1..45
    }

    private fun isUniqueOfBonusNumber(winningNumbers: Lotto, bonusNumber: String): Boolean {
        return !winningNumbers.getLottoNumbers().contains(bonusNumber.toInt())
    }
}