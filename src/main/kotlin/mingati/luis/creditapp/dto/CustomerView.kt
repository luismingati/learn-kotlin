package mingati.luis.creditapp.dto

import mingati.luis.creditapp.entity.Customer
import java.math.BigDecimal

data class CustomerView(
  val firstName: String,
  val lastName: String,
  val cpf: String,
  val email: String,
  val income: BigDecimal = BigDecimal.ZERO,
  val zipCode: String,
  val street: String
) {
  constructor(customer: Customer): this (
    firstName = customer.firstName,
    lastName = customer.lastName,
    cpf = customer.cpf,
    income = customer.income,
    email = customer.email,
    zipCode = customer.address.zipCode,
    street = customer.address.street
  )

}