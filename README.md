# java-mongodb-docker-mathisi
Component responsible for generating and managing JSON Web Tokens (JWTs) and their corresponding refresh tokens

The repository offers the following key features:

Token Generation: It generates a new JWT token and refresh token pair based on the provided user credentials or other relevant information. The JWT token contains encoded user claims and is signed using a secret key or private key. The refresh token is a unique identifier associated with the user and is used for token refreshing.

Token Storage: The repository securely stores the refresh token in a MongoDB database. It ensures the refresh token is stored in an encrypted format, protecting it from unauthorized access. The storage mechanism ensures efficient retrieval and management of refresh tokens for subsequent token refreshing operations.

Token Retrieval: It provides methods to retrieve the refresh token from the database based on user identification or other criteria. This enables the validation and refreshing of tokens during subsequent authentication requests.

Token Refresh: The repository handles the process of refreshing JWT tokens. When a user presents a valid refresh token, the repository retrieves the associated user information, verifies the token's validity, and generates a new JWT token and refresh token pair. The old refresh token is revoked and replaced with the newly generated one.

Token Revocation: In case of security concerns or user logout, the repository allows for the revocation of refresh tokens. Revoked tokens become invalid and cannot be used for token refreshing anymore. This helps enhance security and manage user access to protected resources.

The JWT Token Repository plays a crucial role in the overall authentication and authorization process by securely generating, storing, and managing JWT tokens and their associated refresh tokens. It enables secure user authentication and seamless token refreshing while leveraging the capabilities of MongoDB for efficient token storage and retrieval.

## Steps to start the project
1. git clone <REPO_URL>
2. mvn clean package
3. for accessing the swagger UI http://localhost:8080/swagger-ui/index.html
4. for accessing the swagger Doc API http://localhost:8080/v3/api-docs
5. docker-compose up
4. mongodb on 27018, API on 8080
5. docker-compose down to <stop>
