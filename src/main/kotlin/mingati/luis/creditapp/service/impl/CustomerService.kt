package mingati.luis.creditapp.service.impl

import mingati.luis.creditapp.entity.Customer
import mingati.luis.creditapp.exception.BusinessException
import mingati.luis.creditapp.repository.CustomerRepository
import mingati.luis.creditapp.service.ICustomerService
import org.springframework.stereotype.Service

@Service
class CustomerService(
  private val customerRepository: CustomerRepository
) : ICustomerService {
  override fun save(customer: Customer): Customer {
    return this.customerRepository.save(customer)
  }

  override fun findById(id: Long): Customer {
    return this.customerRepository.findById(id).orElseThrow {
      throw BusinessException("ID $id not found")
    }
  }

  override fun delete(id: Long) {
    val customer = findById(id)
    customerRepository.delete(customer)
  }

}