package org.formation.event.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import org.formation.event.constants.EventPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.Arrays;
import java.util.List;

@Component(
        property = {
                "javax.portlet.name=org_formation_event_EventPortlet",
                "mvc.command.name=/event/list"
        },
        service = MVCRenderCommand.class
)
    public class EventListMVCRenderCommand implements MVCRenderCommand {
    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        // Liste Mockée
        List<String> events = Arrays.asList(
                "Conférence Liferay",
                "Atelier Dev",
                "Meetup Architecture"
        );

        System.out.println("Rendering Event List with " + events.size() + " events.");
        renderRequest.setAttribute("events", events);


        return "/view.jsp";
    }
}
