package src;
import java.util.*;

// Remove this comment later
//
public class User {
    
    protected HashMap<String, String> fields;
    protected Database database;

    /* GENERAL USER FUNCTIONS */

    public User() {}
    
    public User(String name) {
        database = new Database();
        fields = new HashMap<>();
        setName(name);
    }

    public String getFields() {
        StringBuilder sb = new StringBuilder();
        sb.append("\t\tName:\t" + fields.get("Name"));
        sb.append("\t\tPhone:\t" + fields.get("Phone"));
        sb.append("\t\tEmail:\t" + fields.get("Email"));
        return sb.toString();
    }

    public boolean setName(String input) {
        Iterator<User> iterator = database.contacts.keySet().iterator();
        input = validateName(input);
        while (iterator.hasNext()) {
            User tmp = iterator.next();
            if (tmp.fields.get("Name").equals(input)) {
                return false;
            }
        }
        fields.put("Name",input);
        return true;
    }

    protected String validateName(String input) {
        StringBuilder valid = new StringBuilder();
        valid.append(Character.toString(input.toUpperCase().charAt(0)));
        valid.append(input.substring(1).toLowerCase());
        return valid.toString();
    }

    public boolean setEmail(String email) {
        fields.put("Email", email);
        return true;
    }

    public boolean setPhone(String phone) {
        if (validatePhone(phone).length() != 0) {
            fields.put("Phone", phone);
            return true;
        }
        return false;
    }

    protected String validatePhone(String input) {
        StringBuffer valid = new StringBuffer();
        for (Character c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                valid.append(c);
            }
        }
        if (valid.length() != 10) return "";        
        return valid.toString();
    }

}
