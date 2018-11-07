<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>

    <title>City List</title>
    City List
    <br><br>


</head>

<body>

<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>CountryCode</th>
        <th>District</th>
        <th>Population</th>


    </tr>
    <c:forEach var="city" items="${cityList}">

        <tr>
            <td>${city.id}</td>
            <td>${city.name}</td>
            <td>${city.countryCode}</td>
            <td>${city.district}</td>
            <td>${city.population}</td>

        </tr>


    </c:forEach>
</table>


</body>


</html>