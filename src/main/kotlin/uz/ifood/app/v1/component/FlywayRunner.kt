package uz.ifood.app.v1.component

import org.flywaydb.core.Flyway
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import javax.sql.DataSource

@Component
class FlywayRunner(private val dataSource: DataSource) : CommandLineRunner {

    override fun run(vararg args: String?) {
        Flyway.configure()
            .baselineOnMigrate(true)
            .baselineVersion("0.0")
            .dataSource(dataSource)
            .load()
            .migrate()
    }
}
