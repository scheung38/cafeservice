package com.fortressgain.cafe

import com.fortressgain.cafe.model.ItemNotSupportedException
import org.scalatest.{Matchers, WordSpec}

class CafeServiceTest extends WordSpec with Matchers {
  private val cafeService = CafeService()

  "standard bill" should {

    "return 3.5 for input item list [Cola, Coffee, Cheese Sandwich]" in {
      cafeService.standardBillFor(Seq("Cola", "Coffee", "Cheese Sandwich")) shouldBe 3.5
    }

    "return 0 for empty input list" in {
      cafeService.standardBillFor(Seq()) shouldBe 0
    }

    "throw an exception on items not found in the menu" in {
      a[ItemNotSupportedException] should be thrownBy {
        cafeService.standardBillFor(Seq("Not existing item"))
      }
    }
  }

  "service charge" should {

    "apply no service charge is applied when all purchased items are drinks" in {
      cafeService.serviceCharge(Seq("Coffee", "Cola")) shouldBe 0
    }

    "apply a service charge of 10% to the total bill, when purchased items include any food" in {
      cafeService.serviceCharge(Seq("Coffee", "Cola", "Cheese Sandwich")) shouldBe 0.35
    }

    "apply a service charge of 20%, when purchased items include any hot food" in {
      cafeService.serviceCharge(Seq("Coffee", "Cola", "Steak Sandwich")) shouldBe 1.2
    }

    "apply a service charge of 20%, when purchased items include any hot food and any cold food" in {
      cafeService.serviceCharge(Seq("Coffee", "Cola", "Steak Sandwich", "Cheese Sandwich")) shouldBe 1.6
    }

    "apply a service charge of maximum 20 pounds " in {
      cafeService.serviceCharge((1 to 30).map(_ => "Steak Sandwich")) shouldBe 20
    }

  }


}