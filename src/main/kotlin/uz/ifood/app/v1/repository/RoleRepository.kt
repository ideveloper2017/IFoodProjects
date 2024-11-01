package uz.ifood.app.api.v1.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import uz.ifood.app.api.v1.entity.Role

@Repository
interface RoleRepository: JpaRepository<Role,Long>{
    fun findByName(@Param("name") name: String): Role
}
