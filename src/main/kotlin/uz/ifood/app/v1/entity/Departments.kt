package uz.ifood.app.api.v1.entity

import uz.ifood.app.v1.entity.Tables
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
@Table(name = "ss_departments")
data class Departments(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = COLUMN_ID_NAME, nullable = false)
    private var id: Long? = null,
    @Column(name = "name")
    var name: String? = null,
    @Column(name = "orderby")
    var orderby: Number? = 1,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warehouse_id")
    val warehouse: Warehouse? = null,

    @OneToMany(mappedBy = "departments", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val category: List<Categories>?= mutableListOf<Categories>(),

    override var createdDate: Instant? = Instant.now(),
    override var updatedDate: Instant? = Instant.now()
) : BaseEntity<Long>(createdDate, updatedDate), Serializable {


    companion object {
        const val COLUMN_ID_NAME: String = "id"
    }


}
