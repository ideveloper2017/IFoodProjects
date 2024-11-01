package uz.ifood.app.v1.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import uz.ifood.app.api.v1.entity.Departments

@Repository
interface DepartmentRepository: JpaRepository<Departments,Long> {

}