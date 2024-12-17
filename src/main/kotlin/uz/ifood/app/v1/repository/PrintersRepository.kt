package uz.ifood.app.v1.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import uz.ifood.app.v1.entity.Printers

@Repository
interface PrintersRepository : CrudRepository<Printers, Long>{
}