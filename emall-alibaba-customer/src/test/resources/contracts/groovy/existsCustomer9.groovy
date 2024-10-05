package contracts.groovy

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("whether a customer exists by id.")
    request {
        method GET()
        url("/orm/customer/exists") {
            queryParameters {
                parameter("customerId","10009")
            }
        }
    }
    response {
        body("true")
        status 200
        headers {
            contentType(applicationJson())
        }
    }
}