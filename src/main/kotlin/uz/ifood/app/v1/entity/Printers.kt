package uz.ifood.app.v1.entity


import uz.ifood.app.api.v1.entity.BaseEntity
import java.io.Serializable
import java.time.Instant
import javax.persistence.*

@Entity
@Table(name = "printers")
data class Printers(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null,

    @Column(name = "name")
    var name: String? = null,



    override var createdDate: Instant? = Instant.now(),
    override var updatedDate: Instant? = Instant.now()
) : BaseEntity<Long>(createdDate, updatedDate), Serializable {

}
