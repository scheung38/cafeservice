package com.fortressgain.cafe

import com.fortressgain.cafe.model.MenuItem

trait CafeService {
  type MenuItem = String
  type Price = Double


  def standardBillFor(items: Seq[MenuItem]): Price

  def serviceCharge(items: Seq[MenuItem]): Price


}

private class DefaultCafeService extends CafeService {

  override def serviceCharge(items: Seq[MenuItem]) = {
    import com.fortressgain.cafe.util.NumOps._
    val sc = fullServiceCharge(items)
    if (sc > 20) 20
    else round2decimals(sc)
  }

  private def fullServiceCharge(items: Seq[MenuItem]): Double = {
    val standardPrice = standardBillFor(items)
    val modelItems = toModel(items)
    if (modelItems.forall(_.isDrink)) 0
    else if (modelItems.exists(_.isHotFood)) standardPrice * 0.2
    else standardPrice * 0.1
  }
  override def standardBillFor(items: Seq[MenuItem]) = {
    toModel(items).view.map(_.price).sum
  }


  private def toModel (items: Seq[MenuItem] ): Seq[model.MenuItem] = items.map (name =>
MenuItem (name) )
}


object CafeService {
  def apply(): CafeService = new DefaultCafeService
}