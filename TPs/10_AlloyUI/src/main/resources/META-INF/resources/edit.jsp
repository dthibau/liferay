<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="portlet" %>

<portlet:actionURL name="saveEvent" var="saveURL" />

<aui:form action="${saveURL}" method="post" name="fm">
    <aui:input name="title" label="Titre" />

    <aui:button-row>
        <aui:button type="submit" value="Enregistrer" />
    </aui:button-row>
</aui:form>
