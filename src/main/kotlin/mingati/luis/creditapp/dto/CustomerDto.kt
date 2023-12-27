package mingati.luis.creditapp.dto

import mingati.luis.creditapp.entity.Address
import mingati.luis.creditapp.entity.Customer
import java.math.BigDecimal

data class CustomerDto(
  val firstName: String,
  val lastName: String,
  val cpf: String,
  val income: BigDecimal,
  val email: String,
  val password: String,
  val zipCode: String,
  val street: String
) {
  fun toEntity(): Customer = Customer(
    firstName = firstName,
    lastName = lastName,
    cpf = cpf,
    income = income,
    email = email,
    password = password,
    address = Address(
      zipCode = zipCode,
      street = street,
    )
  )
}