package mingati.luis.creditapp.controller

import jakarta.validation.Valid
import mingati.luis.creditapp.dto.CustomerDto
import mingati.luis.creditapp.dto.CustomerUpdateDto
import mingati.luis.creditapp.dto.CustomerView
import mingati.luis.creditapp.service.impl.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.http.RequestEntity.BodyBuilder
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/customers")
class CustomerController(
  private val customerService: CustomerService
) {
  @PostMapping()
  fun saveCustomer(@RequestBody @Valid customerDto: CustomerDto): ResponseEntity<String> {
    val savedCustomer = this.customerService.save(customerDto.toEntity())
    return ResponseEntity.status(HttpStatus.CREATED).body("${savedCustomer.email} saved with success!")
  }

  @GetMapping("/{id}")
  fun findById(@PathVariable id: Long): ResponseEntity<CustomerView> {
    val customer = this.customerService.findById(id)
    return ResponseEntity.status(HttpStatus.OK).body(CustomerView(customer))
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  fun deleteCustomer(@PathVariable id: Long): ResponseEntity<Void> {
    this.customerService.delete(id)
    return ResponseEntity.status(HttpStatus.OK).build()
  }

  @PatchMapping()
  fun updateCustomer(
    @RequestParam(value = "customerId") id: Long,
    @RequestBody @Valid customerUpdateDto: CustomerUpdateDto
  ): ResponseEntity<CustomerView> {
    val customer = customerService.findById(id)
    val customerToUpdate = customerUpdateDto.toEntity(customer)
    val customerUpdated = this.customerService.save(customerToUpdate)
    return ResponseEntity.status(HttpStatus.OK).body(CustomerView(customerUpdated))
  }
}