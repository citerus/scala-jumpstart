package se.citerus.scalajumpstart.log

import java.time.LocalDate

import se.citerus.scalajumpstart.state.MemberId

sealed trait Event {
  def date: LocalDate
}

case class AccountStarted(date: LocalDate, id: MemberId)
  extends Event

case class PeriodStarted(date: LocalDate)
  extends Event

case class Purchase(date: LocalDate, value: BigDecimal, amountPaid: BigDecimal)
  extends Event
