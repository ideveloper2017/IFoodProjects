package uz.ifood.app.v1.entity

import uz.ifood.app.api.v1.entity.BaseEntity
import java.io.Serializable
import java.time.Instant
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "ss_services")
data class Services(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = 0,

    @Column(name = "name", nullable = false)
    var name: String,


    override var createdDate: Instant? = Instant.now(),
    override var lastModifiedDate: Instant? = Instant.now()
) : BaseEntity<Long>(createdDate, lastModifiedDate), Serializable {
}
