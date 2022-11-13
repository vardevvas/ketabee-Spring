package mxd.ketabee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mxd.ketabee.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long> {

}
