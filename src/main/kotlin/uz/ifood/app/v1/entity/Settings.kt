package uz.ifood.app.v1.entity

import uz.ifood.app.api.v1.entity.BaseEntity
import java.io.Serializable
import java.time.Instant
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name="ss_settings")
data class Settings(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = 0,

    @Column(name="my_value",nullable = false, length = 100)
    var my_value: String? = null,

    @Column(name="name",length = 100)
    var name: String? = null,

    @Column(name="is_enabled")
    var isEnabled: Int = 0,

    override var createdDate: Instant? = Instant.now(),
    override var updatedDate: Instant? = Instant.now()
) : BaseEntity<Long>(createdDate, updatedDate), Serializable {
}
