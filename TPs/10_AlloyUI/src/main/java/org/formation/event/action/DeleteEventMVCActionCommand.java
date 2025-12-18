package org.formation.event.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.text.DateFormat;
import java.util.Date;

@Component(
        property = {
                "javax.portlet.name=org_formation_event_EventPortlet",
                "mvc.command.name=deleteEvent"
        },
        service = MVCActionCommand.class
)
public class DeleteEventMVCActionCommand implements MVCActionCommand {

    @Reference
    private org.formation.event.service.EventLocalService _eventLocalService;

    @Override
    public boolean processAction(ActionRequest req, ActionResponse resp) {
        System.out.println("Deleting Event ID: processAction called");

        long  eventId = ParamUtil.getLong(req, "eventId");

    System.out.println("Deleting Event ID: " + eventId);
        ServiceContext serviceContext =
                null;
        try {
            serviceContext = ServiceContextFactory.getInstance(
                    org.formation.event.model.Event.class.getName(),
                    req);
        } catch (PortalException e) {
            throw new RuntimeException(e);
        }



        try {
            _eventLocalService.deleteEvent(eventId,serviceContext);
        } catch (PrincipalException e) {
            throw new RuntimeException(e);
        } catch (PortalException e) {
            throw new RuntimeException(e);
        }

        SessionMessages.add(req, "event-deleted-successfully");
        return true;
    }
}