package com.fortressgain.cafe

import com.fortressgain.cafe.model.MenuItem

trait CafeService {
  type MenuItem = String
  type Price = Double

  def standardBillFor(items: Seq[MenuItem]): Price

  def serviceCharge(items: Seq[MenuItem]): Price

}

private class DefaultCafeService extends CafeService {

  override def standardBillFor(items: Seq[MenuItem]) = {
    toModel(items).view.map(_.price).sum
  }

  override def serviceCharge(items: Seq[MenuItem]) = -1

  private def toModel (items: Seq[MenuItems] ): Seq[model.MenuItem] = items.map (name =>
MenuItem (name) )
}


object CafeService {
  def apply(): CafeService = new DefaultCafeService
}