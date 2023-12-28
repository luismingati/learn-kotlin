package mingati.luis.creditapp.exception

class BusinessException(override val message: String?): RuntimeException(message) {
}