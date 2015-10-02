package contactorganizer.intracode.org.contactorganizer;


import android.net.Uri;

/**
 * Created by Karim Omaya on 10/1/2015.
 */
public class Contact {

    private int _id;
    private String _name, _phone, _email, _address;
    private Uri _imageUri;

    public Contact(int id, String name, String phone, String email, String address, Uri imageUri){
        _id = id;
        _name = name;
        _phone = phone;
        _email = email;
        _address = address;
        _imageUri = imageUri;
    }

    public String get_name() {
        return _name;

    }

    public String get_email() {
        return _email;
    }

    public String get_phone() {
        return _phone;
    }

    public String get_address() {
        return _address;
    }

    public Uri get_imageUri() {
        return _imageUri;
    }

    public int get_id() {
        return _id;
    }
}
