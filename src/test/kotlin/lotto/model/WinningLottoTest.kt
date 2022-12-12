package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows

internal class WinningLottoTest {

    @Test
    fun `보너스 번호 범위 만족 여부 테스트`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = 46

        assertThrows<IllegalArgumentException> {
            WinningLotto(lotto, bonusNumber)
        }
    }

    @Test
    fun `보너스 번호 중복 여부 테스트`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = 6

        assertThrows<IllegalArgumentException> {
            WinningLotto(lotto, bonusNumber)
        }
    }

    @Test
    fun `당첨 결과 확인 테스트`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningLotto = WinningLotto(Lotto(listOf(1, 2, 3, 4, 5, 7)), 6)

        assertThat(winningLotto.checkRating(lotto)).isEqualTo(Rating.SECOND)
    }
}