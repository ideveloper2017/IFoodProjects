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
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "ss_table")
data class Tables(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Int?=0,

    @Column(name="name")
    val name:String,

    @Column(name="is_service")
    val isService: Int?=0,

    @ManyToOne(fetch = FetchType.LAZY,cascade = [(CascadeType.ALL)])
    @JoinColumn(name = "hall_id")
    var halls: Halls,

    override var createdDate: Instant? = Instant.now(),
    override var lastModifiedDate: Instant? = Instant.now()
) : BaseEntity<Long>(createdDate, lastModifiedDate), Serializable {

}
