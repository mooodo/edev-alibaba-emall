package contracts.groovy

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("load some products by their id.")
    request {
        method POST()
        url("/list/product/loadForList")
        body([30005,30007])
        headers {
            contentType(applicationJson())
        }
    }
    response {
        body(file('loadProductForList4.json'))
        status 200
        headers {
            contentType(applicationJson())
        }
    }
}