package item_publisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class ServiceActivator implements BundleActivator {
	
	// ServiceRegistration publishServiceRegistration;
	ServiceRegistration publishAppointmentRegistration;
	
	public void start(BundleContext context) throws Exception {
		System.out.println("Publisher Started");
		// ServicePublish publishService = new ServicePublishImpl();
		ItemPublish publishAppointment = new ItemService();
		
		// publishServiceRegistration = context.registerService(ServicePublish.class.getName(), publishService, null);
		publishAppointmentRegistration = context.registerService(ItemPublish.class.getName(), publishAppointment, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Publisher Terminated");
		// publishServiceRegistration.unregister();
		publishAppointmentRegistration.unregister();
	}

}
