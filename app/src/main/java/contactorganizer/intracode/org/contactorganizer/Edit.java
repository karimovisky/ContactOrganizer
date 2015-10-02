package contactorganizer.intracode.org.contactorganizer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Edit extends AppCompatActivity {

    private int id;
    private DatabaseHandler dbHandler;
    private Contact contact;
    private EditText edtName, edtPhone, edtEmail, edtAddress;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        // TODO: initialize data view
        edtName = (EditText) findViewById(R.id.txtName);
        edtPhone = (EditText) findViewById(R.id.txtPhone);
        edtEmail = (EditText) findViewById(R.id.txtEmail);
        edtAddress = (EditText) findViewById(R.id.txtAddress);
        dbHandler = new DatabaseHandler(getBaseContext());
        Button btnSave = (Button) findViewById(R.id.btnSave);

        // TODO: get id from Intent
        Bundle bundle = getIntent().getExtras();
        id = bundle.getInt("id");

        // TODO: get Contact from DataBase
        contact = dbHandler.getContact(id);

        // TODO: set data returned from DB to text box
        edtName.setText(contact.get_name());
        edtPhone.setText(contact.get_phone());
        edtEmail.setText(contact.get_email());
        edtAddress.setText(contact.get_address());

        // TODO: set on click listener to the button
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: update the contact data
                updateContactData(edtName.getText().toString(), edtPhone.getText().toString(), edtEmail.getText().toString(), edtAddress.getText().toString());
                //TODO: show the update method is done
                Toast.makeText(Edit.this, contact.get_name()+" updated",Toast.LENGTH_LONG).show();
                //TODO: return to the Main Activity
                Intent intent = new Intent(Edit.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private void updateContactData(String name, String phone, String email, String address) {
        //TODO: set the updated data
        contact.set_name(name);
        contact.set_phone(phone);
        contact.set_address(address);
        contact.set_email(email);
        //TODO: save the data in the database
        dbHandler.updateContact(contact);
    }

}
