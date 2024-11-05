package uz.ifood.app.api.v1.entity

import java.io.Serializable
import java.time.Instant
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany
import javax.persistence.Table


@Entity
@Table(name = "roles")
data class Role(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected val id: Long,

    @Column(name="name")
    public val name: String,

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "role_permissions",
        joinColumns = [JoinColumn(name = "role_id")],
        inverseJoinColumns = [JoinColumn(name = "permission_id")]
    )
    public val permissions:Set<Permission> = HashSet(),

    @ManyToMany(mappedBy = "roles",fetch = FetchType.LAZY)
    protected val users:Set<User> =HashSet(),
    override var createdDate: Instant? = Instant.now(),
    override var updateDate: Instant? = Instant.now()
) : BaseEntity<Long>(createdDate, updateDate), Serializable {
}
