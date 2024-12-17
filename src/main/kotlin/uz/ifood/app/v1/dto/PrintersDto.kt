package uz.ifood.app.v1.dto

import java.time.Instant

/**
 * DTO for {@link uz.ifood.app.v1.entity.Printers}
 */
data class PrintersDto(
    var id: Long? = null,
    var name: String? = null,
    var createdDate: Instant? = Instant.now(),
    var updatedDate: Instant? = Instant.now()
)