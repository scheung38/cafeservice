package com.fortressgain.cafe.util

object NumOps {

  def round2decimals(double: Double): Double = {
    BigDecimal(double).setScale(2, BigDecimal.RoundingMode.DOWN).toDouble
  }
}
