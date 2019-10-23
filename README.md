# 90 Minute Pair Project -- Shipping Service 📨


This project was a quick 90-minute exercise using spring boot to create a two-microservice application. One service would interact directly with the myql database and another would be an edge service that user clients directly interacted with. More testing should be implemented in the future including true end-to-end testing instead of unit testing/ service layer mocks.

### The end goal was the following:
    - Users should be able to create tracking objects
    - Users shoud be able to retrieve created tracking objects
        
        
### Future implementations should include:
    - Testing to make sure primary keys don't already exist in the database
    - True end-to-end/integration testing of controllers using rest templates
    - Auto-population of localdate field by the backend.
