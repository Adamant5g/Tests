import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun commissionCalculation_Mastercard_WithOverLimit() {
        val cardType =  CardType.Mastercard
        val monthlyTransfer = 25_000
        val transfer = 50_000

        val result = commissionCalculation(
            cardType = cardType.toString(),
            monthlyTransfer = monthlyTransfer,
            transfer = transfer
        )

        assertEquals(1000,result)
    }

    @Test
    fun commissionCalculation_Mastercard_inLimit() {
        val cardType =  CardType.Mastercard
        val monthlyTransfer = 30_000
        val transfer = 50_000

        val result = commissionCalculation(
            cardType = cardType.toString(),
            monthlyTransfer = monthlyTransfer,
            transfer = transfer
        )

        assertEquals(300,result)
    }

    @Test
    fun commissionCalculation_Maestro_WithOverLimit() {
        val cardType =  CardType.Maestro
        val monthlyTransfer = 25_000
        val transfer = 50_000

        val result = commissionCalculation(
            cardType = cardType.toString(),
            monthlyTransfer = monthlyTransfer,
            transfer = transfer
        )

        assertEquals(1000,result)
    }

    @Test
    fun commissionCalculation_Maestro_inLimit() {
        val cardType =  CardType.Maestro
        val monthlyTransfer = 30_000
        val transfer = 50_000

        val result = commissionCalculation(
            cardType = cardType.toString(),
            monthlyTransfer = monthlyTransfer,
            transfer = transfer
        )

        assertEquals(300,result)
    }

    @Test
    fun commissionCalculation_Visa_WithOverLimit() {
        val cardType =  CardType.Visa
        val monthlyTransfer = 25_000
        val transfer = 50_000

        val result = commissionCalculation(
            cardType = cardType.toString(),
            monthlyTransfer = monthlyTransfer,
            transfer = transfer
        )

        assertEquals(300,result)
    }

    @Test
    fun commissionCalculation_Visa_MinimalCommission() {
        val cardType =  CardType.Visa
        val monthlyTransfer = 500
        val transfer = 100

        val result = commissionCalculation(
            cardType = cardType.toString(),
            monthlyTransfer = monthlyTransfer,
            transfer = transfer
        )

        assertEquals(100,result)
    }

    @Test
    fun commissionCalculation_Mir_WithOverLimit() {
        val cardType =  CardType.Mir
        val monthlyTransfer = 25_000
        val transfer = 50_000

        val result = commissionCalculation(
            cardType = cardType.toString(),
            monthlyTransfer = monthlyTransfer,
            transfer = transfer
        )

        assertEquals(300,result)
    }

    @Test
    fun commissionCalculation_Mir_MinimalCommission() {
        val cardType =  CardType.Mir
        val monthlyTransfer = 500
        val transfer = 100

        val result = commissionCalculation(
            cardType = cardType.toString(),
            monthlyTransfer = monthlyTransfer,
            transfer = transfer
        )

        assertEquals(100,result)
    }

    @Test
    fun commissionCalculation_VK_Pay_ollFree() {
        val cardType = CardType.VKPay
        val monthlyTransfer = 0
        val transfer = 100

        val result = commissionCalculation(
            cardType = cardType.toString(),
            monthlyTransfer = monthlyTransfer,
            transfer = transfer
        )

        assertEquals(100,result)
    }

}