package com.fortressgain.cafe.model


sealed trait MenuItem {
  def price: Double
}

case class ItemNotSupportedException(message: String) extends Exception(message)

object MenuItem {
  def apply(itemName: String): MenuItem = {
    itemName match {
      case "Cola" => Cola()
      case "Coffee" => Coffee()
      case "Cheese Sandwich" => CheeseSandwich()
      case "Steak Sandwich" => SteakSandwich()
      case _ => throw ItemNotSupportedException(s"item is not supported: $itemName")
    }
  }
}

case class Cola(price: Double = 0.5) extends MenuItem
case class Coffee(price: Double = 1) extends MenuItem
case class CheeseSandwich(price: Double = 2) extends MenuItem
case class SteakSandwich(price: Double = 4.5) extends MenuItem
