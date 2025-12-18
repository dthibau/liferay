package org.formation.event.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

@Component(
        property = {
                "javax.portlet.name=org_formation_event_EventPortlet",
                "mvc.command.name=saveEvent"
        },
        service = MVCActionCommand.class
)
public class SaveEventMVCActionCommand implements MVCActionCommand {

    @Override
    public boolean processAction(ActionRequest req, ActionResponse resp) {

        String title = ParamUtil.getString(req, "title");

        System.out.println("Event Title: " + title);
        if (Validator.isNull(title)) {
            SessionErrors.add(req, "title-required");
            resp.setRenderParameter("mvcPath", "/edit.jsp");
            return false;
        }

        SessionMessages.add(req, "event-saved");
        return true;
    }
}