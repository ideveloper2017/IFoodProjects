package uz.ifood.app.v1.entity

import org.hibernate.annotations.Parent
import uz.ifood.app.api.v1.entity.BaseEntity
import uz.ifood.app.api.v1.entity.Categories
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
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "ss_goods")
data class Goods(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?=0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    var categories: Categories,

    @Column(name = "name")
    var name:String?="",

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unit_id")
    var unit: Unit,

    @Column(name = "price")
    var price: Long?=0,

    @Column(name="percent")
    var percent: Int?=0,

    @Column(name="price_sell")
    var sellPrice: Long?=0,

    @Column(name="state")
    var state: Boolean?=true,

    @Column(name="by_service")
    var byService: Boolean?=true,

    @Column(name="by_time")
    var byTime: Boolean?=true,

    @Column(name="play_time")
    var playTime: Long?=0,

    @Column(name="orderby")
    var orderby: Int?=0,

    @Column(name="image")
    var image: String?=null,

    override var createdDate: Instant? = Instant.now(),
    override var updatedDate: Instant? = Instant.now()
) : BaseEntity<Long>(createdDate, updatedDate), Serializable {
}
