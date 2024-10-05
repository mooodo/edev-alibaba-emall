package contracts.groovy

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("whether a product exists by id.")
    request {
        method GET()
        url("/orm/product/exists") {
            queryParameters {
                parameter("productId","30001")
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