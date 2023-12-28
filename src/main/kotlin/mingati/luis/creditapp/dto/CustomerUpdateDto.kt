package mingati.luis.creditapp.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import mingati.luis.creditapp.entity.Customer
import java.math.BigDecimal

data class CustomerUpdateDto(
  @field:NotEmpty(message = "Invalid input")
  val firstName: String,

  @field:NotEmpty(message = "Invalid input")
  val lastName: String,

  @field:NotNull(message = "Invalid number")
  val income: BigDecimal,

  @field:NotEmpty(message = "Invalid input")
  val zipCode: String,

  @field:NotEmpty(message = "Invalid input")
  val street: String
) {
  fun toEntity(customer: Customer): Customer {
    customer.firstName = firstName
    customer.lastName = lastName
    customer.income = income
    customer.address.street = street
    customer.address.zipCode = zipCode
    return customer
  }
}