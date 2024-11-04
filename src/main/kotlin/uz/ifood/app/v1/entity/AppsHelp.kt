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
@Table(name = "apps_help")
data class AppsHelp(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Int?=0,

    @Column(name="str_val")
    var strVal:String,

    @Column(name="state")
    var state:Int=0,

    @Column(name="orderby")
    var orderby:Int=0,

    override var createdDate: Instant? = Instant.now(),
    override var lastModifiedDate: Instant? = Instant.now()
) : BaseEntity<Long>(createdDate, lastModifiedDate), Serializable {
}
