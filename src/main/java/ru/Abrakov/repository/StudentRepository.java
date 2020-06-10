package ru.Abrakov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.Abrakov.domain.Student;

/**
 * Project TestWork
 * Created by End on июнь, 2020
 */

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Boolean existsByPassport(String passport);

}
