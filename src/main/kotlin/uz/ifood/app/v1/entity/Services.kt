package uz.ifood.app.v1.entity

import org.hibernate.annotations.Type
import uz.ifood.app.api.v1.entity.BaseEntity
import java.io.Serializable
import java.time.Instant
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.Size

@Entity
@Table(name = "ss_services")
data class Services(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = 0,

    @Column(name = "name", nullable = false)
    @field:Size(min = 3, max = 255)
    var name: String,

    @Column(name = "value", nullable = false)
    @field:Type(type = "int")
    val value: Int?=0,

    @Column(name = "active", nullable = false)
    var active: Int?=0,

    override var createdDate: Instant? = Instant.now(),
    override var updatedDate: Instant? = Instant.now()
) : BaseEntity<Long>(createdDate, updatedDate), Serializable {
}
