<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>

    <title>Country List</title>
    Country List
    <br><br>


</head>

<body>


<table>
    <tr>
        <th>Code</th>
        <th>Name</th>
        <th>Continent</th>
        <th>SurfaceArea</th>
        <th>IndepYear</th>
        <th>Population</th>
        <th>LifeExpectancy</th>
        <th>GNP</th>
        <th>GNPOId</th>
        <th>LocalName</th>
        <th>HeadOfState</th>
        <th>Capital</th>
        <th>Code2</th>
        <th>Action</th>


    </tr>
    <c:forEach var="country" items="${countryList}">

        <c:url var="showCitiesLink" value="/country/showCitiesForCountry">

            <c:param name="code" value="${country.code}"/>

        </c:url>

        <c:url var="showLanguagesLink" value="/country/showLanguagesForCountry">

            <c:param name="code" value="${country.code}"/>

        </c:url>


        <tr>
            <td> ${country.code} </td>
            <td> ${country.name} </td>
            <td> ${country.continent} </td>
            <td> ${country.surfaceArea} </td>
            <td> ${country.indepYear} </td>
            <td> ${country.population} </td>
            <td> ${country.lifeExpectancy} </td>
            <td> ${country.gnp} </td>
            <td> ${country.gnp0Id} </td>
            <td> ${country.localName} </td>
            <td> ${country.headOfState} </td>
            <td> ${country.capital} </td>
            <td> ${country.code2} </td>
            <td>
                <a href="${showCitiesLink}"> Show cities</a>

            </td>
            <td><a href="${showLanguagesLink}"> Show languages</a></td>


        </tr>


    </c:forEach>
</table>


</body>


</html>