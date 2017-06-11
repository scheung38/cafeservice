package com.fortressgain.cafe

trait CafeService {
  type MenuItem = String
  type Price = Double

  def standardBillFor(items: Seq[MenuItem]): Double
}

object CafeService {
  def apply(): CafeService = new CafeService {
    override def standardBillFor(items: Seq[MenuItem]) = -1
  }
}