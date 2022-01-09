@file:Repository("https://jcenter.bintray.com")
@file:DependsOn("org.springframework.boot:spring-boot-starter-web:2.6.0")

package myServer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.*
import java.io.*
import kotlin.io.*


@SpringBootApplication
@RestController
open class MyApp {
    
}


runApplication<MyApp>("--server.port=8000")
println("Server running on port = 8000");