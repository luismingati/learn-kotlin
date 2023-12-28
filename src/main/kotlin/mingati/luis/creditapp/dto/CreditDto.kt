package mingati.luis.creditapp.dto

import jakarta.validation.constraints.Future
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import mingati.luis.creditapp.entity.Credit
import mingati.luis.creditapp.entity.Customer
import java.math.BigDecimal
import java.time.LocalDate


data class CreditDto(
  @field:NotNull
  val creditValue: BigDecimal,

  @field:Future
  val dayFirstInstallment: LocalDate,

  @field:Min(value = 1)
  val numberOfInstallment: Int,

  @field:NotNull
  val customerId: Long,
) {
  fun toEntity(): Credit = Credit(
    creditValue = creditValue,
    dayFirstInstallment = dayFirstInstallment,
    numberOfInstallment = numberOfInstallment,
    customer = Customer(id = customerId)
  )
}