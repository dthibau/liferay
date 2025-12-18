package org.formation.event.portlet;

import org.formation.event.constants.EventPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author dthibau
 */
@Component(
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Event",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/home.jsp",
		"javax.portlet.name=org_formation_event_EventPortlet",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class EventPortlet extends MVCPortlet {
}