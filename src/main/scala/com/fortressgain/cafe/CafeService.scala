package com.fortressgain.cafe

import com.fortressgain.cafe.model.ItemNotSupportedException
import com.fortressgain.cafe.service.DefaultCafeService


trait CafeService {
  type MenuItem = String
  type Price = Double

  @throws[ItemNotSupportedException]("if any MenuItem is not supported")
  def standardBillFor(items: Seq[MenuItem]): Price

  @throws[ItemNotSupportedException]("if any MenuItem is not supported")
  def serviceCharge(items: Seq[MenuItem]): Price


}




object CafeService {
  def apply(): CafeService = new DefaultCafeService
}