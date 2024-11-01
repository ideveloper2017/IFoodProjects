package uz.ifood.app.api.v1.entity

import uz.ifood.app.v1.entity.Goods
import uz.ifood.app.v1.entity.Unit
import uz.ifood.app.v1.entity.Warehouse
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
@Table(name = Categories.Companion.TABLE_NAME)
data class Categories(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = COLUMN_ID_NAME, nullable = false)
    var id: Long? = 0,

    @Column(name = "parent_id")
    var parentId: Long? = 0,

    @Column(name = "name", nullable = false)
    var name: String? = "noname",

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    var departments: Departments? = null,

    @Column(name = "color_button")
    var colorButton: String? = "#098c00",

    @Column(name = "color_text")
    var colorText: String? = "#ffffff",

    @Column(name = "text_size")
    var textSize: String? = "12",

    @Column(name = "image")
    var image: String? = "noimage.png",

    @Column(name = "orderby")
    var orderby: Int? = 0,

    @Column(name = "state")
    var state: Boolean? = true,

    @OneToMany(mappedBy = "categories", cascade = [CascadeType.ALL])
    val goods:List<Goods>?=mutableListOf<Goods>(),

    override var createdDate: Instant? = Instant.now(),
    override var lastModifiedDate: Instant? = Instant.now()
) : BaseEntity<Long>(createdDate, lastModifiedDate), Serializable {

    companion object {
        const val TABLE_NAME: String = "ss_categories"
        const val COLUMN_ID_NAME: String = "id"
    }
}
