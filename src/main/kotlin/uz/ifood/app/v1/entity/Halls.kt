package uz.ifood.app.v1.entity

import uz.ifood.app.api.v1.entity.BaseEntity
import java.io.Serializable
import java.time.Instant
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "ss_hall")
data class Halls(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int?=0,

    @Column(name="name")
    var name: String,

    @OneToMany(mappedBy = "halls")
    val tables: MutableSet<Tables> = mutableSetOf(),

    override var createdDate: Instant? = Instant.now(),
    override var updateDate: Instant? = Instant.now()
) : BaseEntity<Long>(createdDate, updateDate), Serializable {
}
