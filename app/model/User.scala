package model

import slick.jdbc.MySQLProfile.api._
import slick.lifted.{Tag}


case class User(id: Long, name: String, pass: String, organiaztion: String, created: Long)

class UserDefTable(tag: Tag) extends Table[User](tag, "users") {
    def id = column[Long]("ID", O.PrimaryKey)

    def name = column[String]("name")

    def pass = column[String]("pass")

    def organization = column[String]("organization")

    def created = column[Long]("created")

    def * = (id, name, pass, organization, created).<>(User.tupled, User.unapply _)
  }
