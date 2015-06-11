
import java.io.File;
import java.util.Date;
import javax.swing.ImageIcon;

public class Contacts {

    private String Username;
    private String Name;
    private String MobileNumber;
    private String Email;
    private String City;
    private Date DOB;
    private String Gender;
    private String Category;
    File photo;
    ImageIcon icon;

    public Contacts() {
    }
    public Contacts(String Username,String Name, String MobileNumber, String Email,Date DOB, String City,  String Gender,String Category,File Photo) {
        this.Username=Username;
        this.Name = Name;
        this.MobileNumber = MobileNumber;
        this.Email = Email;
        this.City = City;
        this.DOB = DOB;
        this.Gender = Gender;
        this.Category = Category;
        this.photo=Photo;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    } 

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getMobileNumber() {
        return MobileNumber;
    }

    public void setMobileNumber(String MobileNumber) {
        this.MobileNumber = MobileNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public File getPhoto() {
        return photo;
    }

    public void setPhoto(File photo) {
        this.photo = photo;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }
    

}


