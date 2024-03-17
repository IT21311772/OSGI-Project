package appointment_publisher;

public interface AppointmentPublish {
	public String getRole();
	public void appointmentMain();
	public boolean validate(String username, String password);
	public void displayAppointments();
	public void displayEmployees();
	public void assignEmployees();
}
