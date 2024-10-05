package contracts.groovy

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("load a vip by id.")
    request {
        method GET()
        url("/orm/vip/loadByCustomer") {
            queryParameters {
                parameter("customerId","10009")
            }
        }
    }
    response {
        body(file('loadVip9.json'))
        status 200
        headers {
            contentType(applicationJson())
        }
    }
}