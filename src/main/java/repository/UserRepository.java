package repository;

import domain.User;

public interface UserRepository extends CrudOperations<User,Long> {

    User findOneNumberPassport(Long numberPassport);

}
