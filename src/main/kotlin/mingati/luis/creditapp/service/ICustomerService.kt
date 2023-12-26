package mingati.luis.creditapp.service

import mingati.luis.creditapp.entity.Customer

interface ICustomerService {
    fun save(customer: Customer): Customer
    fun findById(id: Long): Customer
    fun delete(id: Long)
}