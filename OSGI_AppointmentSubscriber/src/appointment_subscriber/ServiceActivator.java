package appointment_subscriber;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import appointment_publisher.AppointmentPublish;

public class ServiceActivator implements BundleActivator {

	// ServiceReference serviceReference;
	ServiceReference appointmentReference;

	public void start(BundleContext context) throws Exception {
		System.out.println("Appointmrnt Management Started");
		
		// serviceReference = context.getServiceReference(ServicePublish.class.getName());
		// ServicePublish servicePublish = (ServicePublish)context.getService(serviceReference);
		// System.out.println(servicePublish.publishService());
		
		appointmentReference = context.getServiceReference(AppointmentPublish.class.getName());
		AppointmentPublish appointmentPublish = (AppointmentPublish)context.getService(appointmentReference);
		appointmentPublish.appointmentMain();
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Appointment Management Terminated");
		// context.ungetService(serviceReference);
		context.ungetService(appointmentReference);
	}

}
