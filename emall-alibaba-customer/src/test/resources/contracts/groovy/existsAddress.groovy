package contracts.groovy

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("whether an address exists by id.")
    request {
        method GET()
        url("/orm/customer/existsAddress") {
            queryParameters {
                parameter("addressId","1000100")
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