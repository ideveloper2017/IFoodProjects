package uz.ifood.app.db

import org.hibernate.cfg.Environment
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import javax.sql.DataSource

@Component
class FireBirdDB(private val dataSource: DataSource) : CommandLineRunner {

    override fun run(vararg args: String?) {
            dataSource.connection.use{connection->{
                connection.createStatement().use {

                }
            }}
    }
}
