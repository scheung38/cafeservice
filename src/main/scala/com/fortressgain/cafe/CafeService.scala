package com.fortressgain.cafe

import com.fortressgain.cafe.model.MenuItem

trait CafeService {
  type MenuItem = String
  type Price = Double

  def standardBillFor(items: Seq[MenuItem]): Price


}

private class DefaultCafeService extends CafeService {
  override def standardBillFor(items: Seq[MenuItem]) = {
    items.map(name => MenuItem(name).price).sum
  }
}

object CafeService {
  def apply(): CafeService = new DefaultCafeService
}