package contracts.groovy

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("load a product by id.")
    request {
        method GET()
        url("/orm/product/load") {
            queryParameters {
                parameter("productId","30001")
            }
        }
    }
    response {
        body(file('loadProduct1.json'))
        status 200
        headers {
            contentType(applicationJson())
        }
    }
}