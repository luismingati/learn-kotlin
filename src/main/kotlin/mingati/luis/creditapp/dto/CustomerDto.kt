package mingati.luis.creditapp.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import mingati.luis.creditapp.entity.Address
import mingati.luis.creditapp.entity.Customer
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal

data class CustomerDto(
  @field:NotEmpty(message = "Invalid input")
  val firstName: String,

  @field:NotEmpty(message = "Invalid input")
  val lastName: String,

  @field:NotEmpty(message = "Invalid input")
  @field:CPF
  val cpf: String,

  @field:NotNull
  val income: BigDecimal,

  @field:NotEmpty(message = "Invalid input")
  @field:Email(message = "Email invalid")
  val email: String,

  @field:NotEmpty(message = "Invalid input")
  val password: String,

  @field:NotEmpty(message = "Invalid input")
  val zipCode: String,

  @field: NotEmpty(message = "Invalid input")
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
