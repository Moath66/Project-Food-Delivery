public class Address {
    private String block;
	private String buildingName;
    private String city;
    
    public Address(String block, String buildingName, String city) {
		this.block = block;
		this.buildingName = buildingName;
		this.city = city;
	}

    public String fullAddress(){
        return block + ", " + buildingName + ", UTM, " + city;
    }
}
