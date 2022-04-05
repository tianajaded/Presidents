package Presidents;

public class Presidents {
    // declare variables
    private String firstName;
    private String lastName;
    private String firstDate;
    private String lastDate;
    private String month;

    /**
     * Presidents constructor with all the strings in the files
     * 
     * @param firstName
     * @param lastName
     * @param firstDate
     * @param lastDate
     */
    public Presidents(String firstName, String lastName, String firstDate, String lastDate) {
        this.firstName = firstName;
        this.firstDate = firstDate;
        this.lastDate = lastDate;
        this.lastName = lastName;
        this.month = month;
    }

    // list of methods to return their strings

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstDate() {
        return firstDate;
    }

    public String getLastDate() {
        return lastDate;
    }

    public String getMonth() {

        return month;
    }
}
