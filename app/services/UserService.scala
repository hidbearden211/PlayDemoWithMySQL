package services

import javax.inject.{Inject, Singleton}

import dao.UserDAO
import model.User

@Singleton
class UserService @Inject()(val userDAO: UserDAO) {

  def addUser(user:User) = userDAO.addUser(user)

}
