package uz.ifood.app.api.v1.entity

import java.io.Serializable
import java.time.Instant
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table


@Entity
@Table(name = "orders")
data class Order(
    @Column(nullable = false)
    val name: String,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    override var createdDate: Instant? = Instant.now(),
    override var lastModifiedDate: Instant? = Instant.now()
): BaseEntity<Long>(createdDate, lastModifiedDate), Serializable {

}
