package com.fortressgain.cafe

case class CafeExceptions(message: String, cause: Throwable) extends Exception(message, cause) {

  def this(message: String) = this(message, null)

  def this(cause: Throwable) = this(null, cause)
}
