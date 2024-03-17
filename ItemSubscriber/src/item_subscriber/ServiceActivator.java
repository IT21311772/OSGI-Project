package item_subscriber;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import item_publisher.ItemPublish;

public class ServiceActivator implements BundleActivator {

	// ServiceReference serviceReference;
	ServiceReference appointmentReference;

	public void start(BundleContext context) throws Exception {
		System.out.println("Item Management Started");
		
		// serviceReference = context.getServiceReference(ServicePublish.class.getName());
		// ServicePublish servicePublish = (ServicePublish)context.getService(serviceReference);
		// System.out.println(servicePublish.publishService());
		
		appointmentReference = context.getServiceReference(ItemPublish.class.getName());
		ItemPublish appointmentPublish = (ItemPublish)context.getService(appointmentReference);
		appointmentPublish.itemMain();
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Item Management Terminated");
		// context.ungetService(serviceReference);
		context.ungetService(appointmentReference);
	}

}

