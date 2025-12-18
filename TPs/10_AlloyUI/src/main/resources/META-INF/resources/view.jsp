<%@ page import="java.util.*" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>



<%
	List<String> events = (List<String>)request.getAttribute("events");
	if (events == null) {
		events = Collections.emptyList();
	}
%>


<liferay-ui:search-container
		total="<%= events.size() %>"
		emptyResultsMessage="Aucun événement">

	<liferay-ui:search-container-results
			results="<%= events.subList(searchContainer.getStart(), searchContainer.getEnd() > events.size() ? events.size() : searchContainer.getEnd()) %>" />

	<liferay-ui:search-container-row
			className="java.lang.String"
			modelVar="event">

		<liferay-ui:search-container-column-text
				name="Nom"
				value="<%= event %>" />
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>
<portlet:renderURL var="editURL">
	<portlet:param name="mvcPath" value="/edit.jsp"/>
</portlet:renderURL>
<a href="${editURL}">Ajouter un événement</a>
