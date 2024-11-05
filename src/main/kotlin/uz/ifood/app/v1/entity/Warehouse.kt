package uz.ifood.app.v1.entity


import uz.ifood.app.api.v1.entity.BaseEntity
import uz.ifood.app.api.v1.entity.Departments
import java.io.Serializable
import java.time.Instant
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "ss_warehouse")
data class Warehouse(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = 0,

    @Column(name = "name")
    var name: String? = null,

    @OneToMany(mappedBy = "warehouse", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val department: List<Departments>? = mutableListOf<Departments>(),
    override var createdDate: Instant? = Instant.now(),
    override var updateDate: Instant? = Instant.now()
) : BaseEntity<Long>(createdDate, updateDate), Serializable {
}
