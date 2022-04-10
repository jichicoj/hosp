public class Patient implements Comparable<Patient> {
    private String name;
    private String emergencyDescription;
    private String emergencyCode;

    /**
     * Return the patients name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Set the patients name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return patients emergency description description
     * @return
     */
    public String getEmergencyDescription() {
        return emergencyDescription;
    }

    /**
     * Set the patients emergency description description
     * @param emergencyDescription
     */
    public void setEmergencyDescription(String emergencyDescription) {
        this.emergencyDescription = emergencyDescription;
    }

    /**
     * Return patients emergency code
     * @return
     */
    public String getEmergencyCode() {
        return emergencyCode;
    }

    /**
     * Set patients emergency code
     * @param emergencyCode
     */
    public void setEmergencyCode(String emergencyCode) {
        this.emergencyCode = emergencyCode;
    }

    /**
     * Constructor
     * @param name
     * @param emergencyDescription
     * @param emergencyCode
     */
    public Patient(String name, String emergencyDescription, String emergencyCode) {
        this.name = name;
        this.emergencyDescription = emergencyDescription;
        this.emergencyCode = emergencyCode;
    }

    /**
     * Empty constructor
     */
    public Patient() {
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure {@link Integer#signum
     * signum}{@code (x.compareTo(y)) == -signum(y.compareTo(x))} for
     * all {@code x} and {@code y}.  (This implies that {@code
     * x.compareTo(y)} must throw an exception if and only if {@code
     * y.compareTo(x)} throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * {@code (x.compareTo(y) > 0 && y.compareTo(z) > 0)} implies
     * {@code x.compareTo(z) > 0}.
     *
     * <p>Finally, the implementor must ensure that {@code
     * x.compareTo(y)==0} implies that {@code signum(x.compareTo(z))
     * == signum(y.compareTo(z))}, for all {@code z}.
     *
     * @param patient the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     * @apiNote It is strongly recommended, but <i>not</i> strictly required that
     * {@code (x.compareTo(y)==0) == (x.equals(y))}.  Generally speaking, any
     * class that implements the {@code Comparable} interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     */
    @Override
    public int compareTo(Patient patient) {
        return this.emergencyCode.compareTo(patient.emergencyCode);
    }
}
