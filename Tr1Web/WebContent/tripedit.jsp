<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${empty trl}"><jsp:forward
			page="/TripEditController?action=trinit"></jsp:forward></c:if>
	select trip
	<center>
		<label style="margin-right: 130px;" for='city5'>trip: </label>
		<form name='form1' action='TripBrowseController'>
			<select class="form-control" id='city4' name='tripn'
				style="width: 250px;">
				<option value="-1">Select trip</option>
				<c:forEach items="${trl}" var="trip">
					<option value="<c:out value="${trip.idtrip}" />"
						<c:if test="${ trip.idtrip eq tripn }"><c:out value=" selected"/><c:set var="city" value="${trip.city}" scope="session"/></c:if>>
						<c:out value="${trip}" />
					</option>
				</c:forEach>
			</select><input type="hidden" name="action" value="tslctd"> <input
				type="submit" name="submit" value="submit">
		</form>
	</center>
	<form name="f3" action="TripEditController">
		<BR>num min transit:<input type="text" name="transit"
			<c:if test="${not empty trt}"><c:out value=" value = ${trt} "/></c:if>>
		<BR>trip date:<input type="text" name="tripdate"
			<c:if test="${not empty trid}"><c:out value=" value = ${trid} "/></c:if>>dd-mm-yyyy
		<BR>hotel name:<input type="text" name="hotel"
			<c:if test="${not empty triho}"><c:out value=" value = ${triho} "/></c:if>>
		<BR>money spent:<input type="text" name="money"
			<c:if test="${not empty trm}"><c:out value=" value = ${trm}"/></c:if>>
		<BR>num days:<input type="text" name="days"
			<c:if test="${not empty trdy}"><c:out value=" value = ${trdy} "/></c:if>>
		<input type="hidden" name="action" value="updatetrip"><input
			type="hidden" name="fromto" value="createtrip"> <input
			type="hidden" name="ci" value="<c:out value="${ci}"/>"> <input
			type="hidden" name="ti" value="<c:out value="${ti}"/>"> <input
			type="hidden" name="ti" value="<c:out value="${ti}"/>">
			<input type="hidden" name="sig" value="<c:out value="${sig}"/>"><input
			type="submit" name="submit" value="submit">

	</form>

</body>
</html>