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
        <th>CountryCode</th>
        <th>Language</th>
        <th>IsOfficial     </th>
        <th>Percentage</th>


    </tr>
    <c:forEach var="language" items="${countryLanguageList}">

        <tr>
            <td>${language.countryCode}</td>
            <td>${language.language}</td>
            <td>${language.isOfficial}</td>
            <td>${language.percentage}</td>


        </tr>


    </c:forEach>
</table>


</body>


</html>