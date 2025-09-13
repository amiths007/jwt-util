# JWT utility

JWT utility is microservice which generate token for au.

## Example Request Body

```bash
{
    "alg": "RS256",
    "typ": "jwt",
    "aud": "my-app"
}
```

## Example Response Body

```bash
{"issuedAt":"20250913",
"expiration":1755450929975,
"accessToken":"eyJhbGciOiJSUzI1NiJ9.eyJhbGciOiJSUzI1NiIsImF1ZCI6Im15LWFwcCIsInR5cCI6Imp3dCIsImlhdCI6MTc1NTQ1MDkyNywiZXhwIjoxNzU1NDUwOTI5fQ.lyITYbzuozvZbp9kTLDjs9ZCdORiVaZWwyKhhVpJtBoBSvFgAbX4x6mVwUpVBL2flEistXmZ1YswutLfFH3QWuruHaWef5V3bfrgvHoVDy9bb_lr9uDCTRF6Y8AFcvnTTo07Q2xEbMbSr7kF5p62LrHGqOa50PPYz1HXDCRdcW_Ri-s8wLEg64KcMZP-o-TjofGcWD3Nhj4EYAuLUYzAzRVMTneixvDQEHWSn-KF1NM_UmOAsRZZgqDMlZskVbuyRXNKxwfqi1NkfZSGU6DJRSlxaSZxXoodEmq8tulws2YaJK-fYHmxGnSJ8YLLm48r8R-8xeteGDkHgvIiLYqxoQ"}
```