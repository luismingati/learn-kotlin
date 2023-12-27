package mingati.luis.creditapp.controller

import mingati.luis.creditapp.dto.CreditDto
import mingati.luis.creditapp.dto.CreditView
import mingati.luis.creditapp.dto.CreditViewList
import mingati.luis.creditapp.entity.Credit
import mingati.luis.creditapp.service.impl.CreditService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.UUID
import java.util.stream.Collectors
import javax.print.DocFlavor.STRING

@RestController
@RequestMapping("/api/credits")
class CreditController(
  private val creditService: CreditService
) {
  @PostMapping
  fun saveCredit(@RequestBody creditDto: CreditDto): ResponseEntity<String> {
    val credit = this.creditService.save(creditDto.toEntity())
    return ResponseEntity.status(HttpStatus.CREATED)
      .body("Credit ${credit.creditCode} created!!")

  }

  @GetMapping
  fun findAllByCustomerId(@RequestParam(value = "customerId") customerId: Long): ResponseEntity<List<CreditViewList>> {
    val creditViewList =  creditService.findAllByCustomer(customerId).stream()
      .map{ credit: Credit -> CreditViewList(credit)}.collect(Collectors.toList())
    return  ResponseEntity.status(HttpStatus.OK).body(creditViewList)
  }

  @GetMapping("/{creditCode}")
  fun findByCreditCode(@PathVariable creditCode: UUID,
                       @RequestParam(value = "customerId") customerId: Long): ResponseEntity<CreditView> {
    val credit = creditService.findByCreditCode(customerId, creditCode)
    return ResponseEntity.status(HttpStatus.OK).body(CreditView(credit))
  }
}