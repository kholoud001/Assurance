<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Automobile Insurance Form</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/style/formStyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/style/navbar.css">



</head>
<body>
<%--NavBar--%>
<jsp:include page="/resources/layouts/navbar.jsp" />

<h1>Automobile Insurance Form</h1>

<!-- Spring Form Tag -->
<form:form action="${pageContext.request.contextPath}/automobile/submit" method="post" modelAttribute="automobile">
    <!-- Insurance Price -->
    <div class="form-group">
        <label for="price">Insurance Price:</label>
<%--        To change later--%>
        <form:input path="price" type="number" step="0.01" min="0" id="price" value="0" required="true"/>
    </div>

    <!-- Insurance Type -->
    <div class="form-group">
        <label for="type">Insurance Type:</label>
        <form:select path="type" id="type" required="true">
            <form:option value="" label="Select Insurance Type"/>
            <form:options items="${insuranceTypes}" />
        </form:select>
    </div>

    <!-- Driver Age -->
    <div class="form-group">
        <label for="driverAge">Driver Age:</label>
        <form:input path="driverAge" type="number" min="18" id="driverAge" required="true"/>
    </div>

    <!-- Vehicle Selection -->
    <div class="form-group">
        <label for="vehicle">Vehicle:</label>
        <form:select path="vehicle.id" id="vehicle" required="true">
            <form:option value="" label="Select Vehicle"/>
            <form:options items="${vehicles}" itemValue="id" itemLabel="modele" />
        </form:select>
    </div>


    <!-- Vehicle Use -->
    <div class="form-group">
        <label for="vehicleUse">Vehicle Use:</label>
        <form:input path="vehicleUse" type="text" id="vehicleUse" placeholder="e.g., Personal, Commercial" required="true"/>
    </div>

    <!-- Driving History -->
    <div class="form-group">
        <label for="drivingHistory">Driving History:</label>
        <form:textarea path="drivingHistory" id="drivingHistory" rows="4" placeholder="Briefly describe your driving history" required="true"/>
    </div>

    <!-- Submit Button -->
    <div class="form-group">
        <button type="submit" class="btn btn-primary">Submit</button>
    </div>
</form:form>
</body>
</html>
