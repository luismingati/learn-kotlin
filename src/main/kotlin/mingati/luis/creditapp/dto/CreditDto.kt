package mingati.luis.creditapp.dto

import mingati.luis.creditapp.entity.Credit
import mingati.luis.creditapp.entity.Customer
import java.math.BigDecimal
import java.time.LocalDate


data class CreditDto(
  val creditValue: BigDecimal,
  val dayFirstInstallment: LocalDate,
  val numberOfInstallment: Int,
  val customerId: Long, val id: Long? = null,
) {
  fun toEntity(): Credit = Credit(
    creditValue = creditValue,
    dayFirstInstallment = dayFirstInstallment,
    numberOfInstallment = numberOfInstallment,
    customer = Customer(id = customerId)
  )
}