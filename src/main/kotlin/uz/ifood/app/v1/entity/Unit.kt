package uz.ifood.app.v1.entity

import uz.ifood.app.api.v1.entity.BaseEntity
import java.io.Serializable
import java.time.Instant
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "ss_unit")
data class Unit(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = 0,

    @Column(name = "name")
    var name: String,

    @Column(name="status")
    var status: Boolean?=true,

    @Column(name="orderby")
    var orderby: Int?=0,

    @OneToMany(mappedBy = "unit", cascade = [CascadeType.ALL])
    val goods:List<Goods>?=mutableListOf<Goods>(),

    override var createdDate: Instant? = Instant.now(),
    override var lastModifiedDate: Instant? = Instant.now()
) : BaseEntity<Long>(createdDate, lastModifiedDate), Serializable {
}