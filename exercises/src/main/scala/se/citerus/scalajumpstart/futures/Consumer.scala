package se.citerus.scalajumpstart.futures

import java.time.LocalDate

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

class Consumer(val storage: Storage = Storage()) {

  def accumulatedValue(id: String): Future[BigDecimal] = for {
    maybeAccount <- findById(id)
    account = maybeAccount.getOrElse(Account(id, LocalDate.now, 0))
  } yield account.accumulatedValue

  // Implement in exercise 5
  def increaseAccumulatedValue(id: String, amount: BigDecimal): Future[BigDecimal] = ???


  // Implement in exercise 7
  def allAccounts(): Future[List[Account]] = Future {
    val ids = storage.ids
    val accounts = ids.map { id => storage.findById(id).orNull }
    accounts.toList
  }

  // Implement in exercise 8
  def activeAccounts(today: LocalDate): Future[List[Account]] = ???

  // Async wrappers for storage access
  def findById(id: String): Future[Option[Account]] = Future { storage.findById(id) }

  def save(account: Account): Future[Account] = Future { storage.save(account) }

  def ids: Future[Set[String]] = Future { storage.ids }

}