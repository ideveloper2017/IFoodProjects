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
@Table(name = "apps")
data class Apps(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Int?=0,

    @Column(name = "name")
    var name:String?="",

    @Column(name = "class_name")
    var className:String?="",

    @Column(name = "icon")
    var icon:String="",

    @Column(name = "description")
    var description:String,

    @Column(name="state")
    var state:Int=0,

    override var createdDate: Instant? = Instant.now(),
    override var updateDate: Instant? = Instant.now()
) : BaseEntity<Long>(createdDate, updateDate), Serializable {
}
