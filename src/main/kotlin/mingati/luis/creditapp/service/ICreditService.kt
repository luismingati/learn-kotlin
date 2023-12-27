package mingati.luis.creditapp.service

import mingati.luis.creditapp.entity.Credit
import java.util.UUID

interface ICreditService {
  fun save(credit: Credit): Credit
  fun findAllByCustomer(customerId: Long): List<Credit>
  fun findByCreditCode(customerId: Long, creditCode: UUID): Credit
}