<%@ page import="java.util.*" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<h1>Bienvenue sur la page d'accueil des événements</h1>
<portlet:renderURL var="listURL">
	<portlet:param name="mvcRenderCommandName" value="/event/list" />
</portlet:renderURL>
<a href="<%= listURL %>">Afficher la liste des événements</a>

