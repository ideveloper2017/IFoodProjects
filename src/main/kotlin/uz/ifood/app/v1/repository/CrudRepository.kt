package uz.ifood.app.v1.repository

import org.springframework.data.repository.NoRepositoryBean
import org.springframework.data.repository.Repository
import java.util.Optional

@NoRepositoryBean
interface CrudRepository<T, ID> : Repository<T, ID> {
    fun <S : T> save(entity: S): S

    fun <S : T> saveAll(entities: Iterable<S>): Iterable<S>

    fun findById(id: ID): Optional<T>

    fun existsById(id: ID): Boolean

    fun findAll(): Iterable<T>

    fun findAllById(ids: Iterable<ID>): Iterable<T>

    fun count(): Long

    fun deleteById(id: ID)

    fun delete(entity: T)

    fun deleteAllById(ids: Iterable<ID>)

    fun deleteAll(entities: Iterable<T>)

    fun deleteAll()

}