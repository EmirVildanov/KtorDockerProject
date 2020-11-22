package com.example

import freemarker.cache.ClassTemplateLoader
import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.application.call
import io.ktor.features.PartialContent
import io.ktor.features.ContentNegotiation
import io.ktor.freemarker.FreeMarker
import io.ktor.gson.gson
import io.ktor.http.content.static
import io.ktor.http.content.resources
import io.ktor.response.respondText
import io.ktor.routing.routing
import io.ktor.routing.route
import io.ktor.routing.get
import java.text.DateFormat

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {

    install(PartialContent)
    install(FreeMarker) {
        templateLoader = ClassTemplateLoader(this::class.java.classLoader, "templates")
    }

    install(ContentNegotiation) {
        gson {
            setDateFormat(DateFormat.LONG)
            setPrettyPrinting()
        }
    }

    routing {
        static("/static") {
            resources("static")
        }

        route("/") {
            get {
                call.respondText("Hello!")
            }
        }
    }
}
