package dao

import javax.inject.{Inject, Singleton}

import model.{User, UserDefTable}
import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.JdbcProfile
import slick.jdbc.MySQLProfile.api._

@Singleton
class UserDAO @Inject()(val dbConfigProvider: DatabaseConfigProvider) {
  val dbProvider = dbConfigProvider.get[JdbcProfile]
  val users = TableQuery[UserDefTable]

  def addUser(user:User) = dbProvider.db.run(DBIO.seq(users.schema.create,users+= user))
}
