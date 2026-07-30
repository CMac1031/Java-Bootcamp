Lab 24 will map these ideas to Spring-WS faults—do not implement endpoints now. Cross-walk UpdateCustomer ↔ Lab 12 updateStatus briefly.

### Failure experiments
Rename/break schemaLocation temporarily
-changed `customer.xsd` to `customerwrong.xsd` and updated WSDL to match. SOAPUI shows a schema validation error on the request.
Invalid empty customerId get sample	
- Changed `<customerId>CUS-1001</customerId>` to `<customerId></customerId>` in the GetCustomer request. Returned no error, proving the XML is well formed even though the business input is invalid.
Compare Create vs Get retry safety
`GetCustomer` is safe to retry because it is a read operation and does not
change customer data. Repeating the same request should return the same customer,
assuming no separate update occurs.

`CreateCustomer` is not automatically safe to retry because repeating the same
request may attempt to create a duplicate customer. A production service should
use an idempotency key or duplicate-detection rule before clients retry creation
automatically.