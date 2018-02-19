//Customer.java

package obssao.ordermanagement;

public interface Customer {
}
    aspect CustomerAspect {

private String Customer.name;
private String Customer.email;
private String Customer.shippingAddress;
private String Customer.phone;

        // field corresponding to association relationship with Order (1..n)
        Order[]Customer.places=null;


	public String Customer.getName() {
		return name;
	}

	public void Customer.setName(String name) {
		this.name = name;
	}

	public String Customer.getEmail() {
		return email;
	}

	public void Customer.setEmail(String email) {
		this.email = email;
	}

	public String Customer.getShippingAddress() {
		return shippingAddress;
	}

	public void Customer.setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String Customer.getPhone() {
		return phone;
	}

	public void Customer.setPhone(String phone) {
		this.phone = phone;
	}

        }
