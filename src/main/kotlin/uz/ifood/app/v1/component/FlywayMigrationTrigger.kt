package uz.ifood.app.v1.component

import org.flywaydb.core.Flyway
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class FlywayMigrationTrigger(var flyway: Flyway) {

//    @Autowired(required = true)
//    lateinit var flyway: Flyway;

    @EventListener(ApplicationReadyEvent::class)
    fun runMigration() {
        flyway.migrate();
    }
}