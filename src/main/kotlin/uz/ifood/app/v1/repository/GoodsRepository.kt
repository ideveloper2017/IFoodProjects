package uz.ifood.app.v1.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.query.Procedure
import org.springframework.stereotype.Repository
import uz.ifood.app.v1.entity.Goods

@Repository
interface GoodsRepository: CrudRepository<Goods,Long> {



}